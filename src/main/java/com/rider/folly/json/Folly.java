package com.rider.folly.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.rider.folly.exceptions.FollyException;
import com.rider.folly.json.enums.KeepAliveStatus;
import com.rider.folly.json.enums.LoginStatus;
import com.rider.folly.json.reponses.KeepAliveResponse;
import com.rider.folly.json.reponses.LoginResponse;
import com.rider.folly.json.reponses.Response;
import com.rider.folly.utils.Funds;
import com.rider.folly.utils.SessionMaintainer;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class Folly {

    private static final String HTTP_HEADER_X_APPLICATION = "X-Application";

    private static final String HTTP_HEADER_X_AUTHENTICATION = "X-Authentication";

    private static final String HTTP_HEADER_ACCEPT = "Accept";

    private static final String HTTP_HEADER_ACCEPT_JSON = "application/json";

    private static final String HTTP_HEADER_CONTENT_TYPE = "Content-Type";

    private static final String HTTP_HEADER_URL_ENCODED_CONTENT_TYPE = "application/x-www-form-urlencoded";

    private static final int TIMEOUT = 10000;

    private static final Lock mutex = new ReentrantLock();

    private static final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(Date.class, new ISO8601DateTypeAdapter())
            .create();

    private static final RequestConfig requestConfig = RequestConfig
            .custom()
            .setConnectTimeout(TIMEOUT)
            .setSocketTimeout(TIMEOUT)
            .build();

    private static final JsonResponseHandler responseHandler = new JsonResponseHandler();

    private static final HttpClient httpClient = HttpClientBuilder.create().build();

    private static final HttpPost httpPost = new HttpPost();

    private static LoginResponse loginResponse;

    private static KeepAliveResponse keepAliveResponse;

    private static SessionMaintainer sessionMaintainer;

    private static String username = "not set";

    private static String password = "not set";

    public static void init(final String applicationKey,
                            final String username,
                            final String password) {
        try {
            mutex.lock();

            Folly.username = username;
            Folly.password = password;

            httpPost.setConfig(requestConfig);
            httpPost.setHeader(HTTP_HEADER_ACCEPT, HTTP_HEADER_ACCEPT_JSON);
            httpPost.setHeader(HTTP_HEADER_CONTENT_TYPE, HTTP_HEADER_URL_ENCODED_CONTENT_TYPE);
            httpPost.setHeader(HTTP_HEADER_X_APPLICATION, applicationKey);
        } finally {
            mutex.unlock();
        }

        synchronized (SessionMaintainer.class) {
            if (sessionMaintainer == null) {
                sessionMaintainer = new SessionMaintainer();
            }

            Funds.start();
        }
    }

    public static void setSessionToken(final String sessionToken) {
        try {
            mutex.lock();

            httpPost.setHeader(HTTP_HEADER_X_AUTHENTICATION, sessionToken);
        } finally {
            mutex.unlock();
        }
    }

    private Folly() {
        // Do nothing
    }

    public static <T extends Response> T sendRequest(final String operation,
                                                     final OperationType operationType,
                                                     final Map<String, Object> parameters,
                                                     final Class<T> responseClass) throws FollyException {
        final Request request = new Request(operationType, operation, parameters);

        try {
            mutex.lock();

            httpPost.setURI(new URI(operationType.getAddress()));
            httpPost.setEntity(new StringEntity(gson.toJson(request)));

            //System.out.println("Out : " + gson.toJson(request));String responseString = httpClient.execute(httpPost, responseHandler);Response response = (Response) gson.fromJson(responseString, responseClass);System.out.println("In  : " + gson.toJson(response));return (T)response;
            return gson.fromJson(httpClient.execute(httpPost, responseHandler), responseClass);
        } catch (final URISyntaxException | IOException | JsonSyntaxException exception) {
            throw new FollyException("Error sending request (" + exception.getClass().getSimpleName() + ") : \"" + exception.getMessage() + '\"');
        } finally {
            mutex.unlock();
        }
    }

    public static void login() throws FollyException {
        try {
            mutex.lock();

            httpPost.setURI(new URI(OperationType.LOGIN.getAddress()));
            httpPost.setEntity(new StringEntity("username=" + username + "&password=" + password));

            loginResponse = gson.fromJson(httpClient.execute(httpPost, responseHandler), LoginResponse.class);

            if (loginResponse.getStatus().equals(LoginStatus.SUCCESS)) {
                setSessionToken(loginResponse.getSessionToken());
            } else {
                throw new FollyException("Error logging in : \"" + loginResponse.getError() + "\"");
            }
        } catch (final URISyntaxException | IOException | JsonSyntaxException exception) {
            throw new FollyException("Error logging in (" + exception.getClass().getSimpleName() + ") : \"" + exception.getMessage() + '\"');
        } finally {
            mutex.unlock();
        }
    }

    public static void keepAlive() throws FollyException {
        try {
            mutex.lock();

            httpPost.setURI(new URI(OperationType.KEEP_ALIVE.getAddress()));
            httpPost.setEntity(new StringEntity(""));
            
            keepAliveResponse = gson.fromJson(httpClient.execute(httpPost, responseHandler), KeepAliveResponse.class);

            if (keepAliveResponse.getStatus().equals(KeepAliveStatus.SUCCESS)) {
                setSessionToken(keepAliveResponse.getSessionToken());
            } else {
                throw new FollyException("Error sending keep alive : \"" + keepAliveResponse.getError() + "\"");
            }
        } catch (final URISyntaxException | IOException | JsonSyntaxException exception) {
            throw new FollyException("Error sending keep alive (" + exception.getClass().getSimpleName() + ") : \"" + exception.getMessage() + '\"');
        } finally {
            mutex.unlock();
        }
    }
}
