package com.rider.folly.json;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;

public class JsonResponseHandler implements ResponseHandler<String> {
    private static final int STATUS_CODE_OK = 200;

    private static final String ENCODING_UTF8 = "UTF-8";

    @Override
    public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {
        final StatusLine statusLine = response.getStatusLine();

        String returnVal = null;

        if (statusLine.getStatusCode() != STATUS_CODE_OK) {
            throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
        }

        if (response.getEntity() != null) {
            returnVal = EntityUtils.toString(response.getEntity(), ENCODING_UTF8);
        }

        return returnVal;
    }
}
