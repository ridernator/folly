package com.rider.folly.operations;

import com.rider.folly.exceptions.FollyException;
import com.rider.folly.json.Folly;
import com.rider.folly.json.OperationType;
import com.rider.folly.json.enums.IncludeItem;
import com.rider.folly.json.enums.Status;
import com.rider.folly.json.enums.SubscriptionStatus;
import com.rider.folly.json.enums.Wallet;
import com.rider.folly.json.operations.ActivateApplicationSubscription;
import com.rider.folly.json.operations.CancelApplicationSubscription;
import com.rider.folly.json.operations.CreateDeveloperAppKeys;
import com.rider.folly.json.operations.GetAccountDetails;
import com.rider.folly.json.operations.GetAccountFunds;
import com.rider.folly.json.operations.GetAccountStatement;
import com.rider.folly.json.operations.GetApplicationSubscriptionHistory;
import com.rider.folly.json.operations.GetApplicationSubscriptionToken;
import com.rider.folly.json.operations.GetDeveloperAppKeys;
import com.rider.folly.json.operations.GetVendorClientId;
import com.rider.folly.json.operations.ListAccountSubscriptionTokens;
import com.rider.folly.json.operations.ListApplicationSubscriptionTokens;
import com.rider.folly.json.operations.ListCurrencyRates;
import com.rider.folly.json.operations.TransferFunds;
import com.rider.folly.json.operations.UpdateApplicationSubscription;
import com.rider.folly.json.reponses.AccountDetailsResponseResponse;
import com.rider.folly.json.reponses.ActivateApplicationSubscriptionResponse;
import com.rider.folly.json.reponses.CancelApplicationSubscriptionResponse;
import com.rider.folly.json.reponses.CreateDeveloperAppKeysResponse;
import com.rider.folly.json.reponses.GetAccountFundsResponse;
import com.rider.folly.json.reponses.GetAccountStatementResponse;
import com.rider.folly.json.reponses.GetApplicationSubscriptionHistoryResponse;
import com.rider.folly.json.reponses.GetApplicationSubscriptionTokenResponse;
import com.rider.folly.json.reponses.GetDeveloperAppKeysResponse;
import com.rider.folly.json.reponses.GetVendorClientIdResponse;
import com.rider.folly.json.reponses.ListAccountSubscriptionTokensResponse;
import com.rider.folly.json.reponses.ListApplicationSubscriptionTokensResponse;
import com.rider.folly.json.reponses.ListCurrencyRatesResponse;
import com.rider.folly.json.reponses.TransferResponseResponse;
import com.rider.folly.json.reponses.UpdateApplicationSubscriptionResponse;
import com.rider.folly.json.types.AccountDetailsResponse;
import com.rider.folly.json.types.AccountFundsResponse;
import com.rider.folly.json.types.AccountStatementReport;
import com.rider.folly.json.types.AccountSubscription;
import com.rider.folly.json.types.ApplicationSubscription;
import com.rider.folly.json.types.CurrencyRate;
import com.rider.folly.json.types.DeveloperApp;
import com.rider.folly.json.types.SubscriptionHistory;
import com.rider.folly.json.types.TimeRange;
import com.rider.folly.json.types.TransferResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ciaron Rider
 */
public class AccountOperations {
    private AccountOperations() {
        // Do nothing
    }

    /**
     * Create 2 application keys for given user; one active and the other
     * delayed
     *
     * @param appName A Display name for the application. (Required)
     * @return A map of application keys, one marked ACTIVE, and the other
     * DELAYED
     * @throws FollyException Generic exception that is thrown if this operation
     * fails for any reason.
     */
    public static DeveloperApp createDeveloperAppKeys(final String appName) throws FollyException {
        final Map<String, Object> parameters = new HashMap<>();

        parameters.put(CreateDeveloperAppKeys.PARAMETER_APP_NAME, appName);

        final CreateDeveloperAppKeysResponse response = Folly.sendRequest(CreateDeveloperAppKeys.OPERATION_NAME, OperationType.ACCOUNTS, parameters, CreateDeveloperAppKeysResponse.class);

        if (response.getError() != null) {
            throw new FollyException(response.getError());
        }

        return response.getResult();
    }

    /**
     * Get all application keys owned by the given developer/vendor
     *
     * @return A list of application keys owned by the given developer/vendor
     * @throws FollyException Generic exception that is thrown if this operation
     * fails for any reason.
     */
    public static List<DeveloperApp> getDeveloperAppKeys() throws FollyException {
        final GetDeveloperAppKeysResponse response = Folly.sendRequest(GetDeveloperAppKeys.OPERATION_NAME, OperationType.ACCOUNTS, null, GetDeveloperAppKeysResponse.class);

        if (response.getError() != null) {
            throw new FollyException(response.getError());
        }

        return response.getResult();
    }

    /**
     * Get available to bet amount. The getAccounts service will return the UK
     * wallet balance by default from either the UK or AUS Accounts API endpoint
     * if the wallet parameter is not specified
     *
     * @param wallet Name of the wallet in question. Please Note: To return the
     * the Australian Exchange wallet balance you must specify AUSTRALIAN as the
     * Wallet parameter. (Not required. May be null)
     * @return Response for retrieving available to bet
     * @throws FollyException Generic exception that is thrown if this operation
     * fails for any reason.
     */
    public static AccountFundsResponse getAccountFunds(final Wallet wallet) throws FollyException {
        if (wallet == null) {
            throw new FollyException("Parameter \"wallet\" has not been set");
        }

        final Map<String, Object> parameters = new HashMap<>();

        parameters.put(GetAccountFunds.PARAMETER_WALLET, wallet);

        final GetAccountFundsResponse response = Folly.sendRequest(GetAccountFunds.OPERATION_NAME, OperationType.ACCOUNTS, parameters, GetAccountFundsResponse.class);

        if (response.getError() != null) {
            throw new FollyException(response.getError());
        }

        return response.getResult();
    }

    /**
     * Transfer funds between the UK Exchange and Australian Exchange wallets.
     * You require funds in the Australian Exchange wallet to bet on Australian
     * markets. Please note: The transferFunds service can be requested from
     * either the UK or AUS Accounts API endpoint regardless of the direction of
     * the funds transfer.
     *
     * @param from Source wallet (Required)
     * @param to Destination wallet (Required)
     * @param amount Amount to transfer (Required)
     * @return Response for transfer funds action
     * @throws FollyException Generic exception that is thrown if this operation
     * fails for any reason.
     */
    public static TransferResponse transferFunds(final Wallet from,
                                                 final Wallet to,
                                                 final double amount) throws FollyException {
        if (from == null) {
            throw new FollyException("Parameter \"from\" has not been set");
        }

        if (to == null) {
            throw new FollyException("Parameter \"to\" has not been set");
        }

        final Map<String, Object> parameters = new HashMap<>();

        parameters.put(TransferFunds.PARAMETER_FROM, from);
        parameters.put(TransferFunds.PARAMETER_TO, to);
        parameters.put(TransferFunds.PARAMETER_AMOUNT, amount);

        final TransferResponseResponse response = Folly.sendRequest(TransferFunds.OPERATION_NAME, OperationType.ACCOUNTS, parameters, TransferResponseResponse.class);

        if (response.getError() != null) {
            throw new FollyException(response.getError());
        }

        return response.getResult();
    }

    /**
     * Returns the details relating your account, including your discount rate
     * and Betfair point balance.
     *
     * @return Response for retrieving account details.
     * @throws FollyException Generic exception that is thrown if this operation
     * fails for any reason.
     */
    public static AccountDetailsResponse getAccountDetails() throws FollyException {
        final AccountDetailsResponseResponse response = Folly.sendRequest(GetAccountDetails.OPERATION_NAME, OperationType.ACCOUNTS, null, AccountDetailsResponseResponse.class);

        if (response.getError() != null) {
            throw new FollyException(response.getError());
        }

        return response.getResult();
    }

    /**
     * Returns the vendor client id for customer account which is a unique
     * identifier for that customer. The vendor client Id can be used to obtain
     * the customers application subscription history via
     * getApplicationSubscriptionHistory. The request requires the
     * X-Authentication header only
     *
     * @return Vendor client id.
     * @throws FollyException Generic exception that is thrown if this operation
     * fails for any reason.
     */
    public static String getVendorClientId() throws FollyException {
        final GetVendorClientIdResponse response = Folly.sendRequest(GetVendorClientId.OPERATION_NAME, OperationType.ACCOUNTS, null, GetVendorClientIdResponse.class);

        if (response.getError() != null) {
            throw new FollyException(response.getError());
        }

        return response.getResult();
    }

    /**
     * String getApplicationSubscriptionToken ( int subscriptionLength ) throws
     * AccountAPINGException Used to create new subscription tokens for an
     * application. Returns the newly generated subscription token which can be
     * provided to the end user.
     *
     * Please note: A maximum number of 15,000 subscription UNACTIVATED
     * subscriptions tokens can be created at any one time. Attempts to create
     * more subscription tokens will return the error TOO_MANY_REQUESTS error
     * which will restrict creation of further tokens until existing UNACTIVATED
     * subscription tokens have been ACTIVATED or CANCELLED
     *
     * @param subscriptionLength How many days the subscription should last.
     * Open ended if value not supplied. Expiry time will be rounded up to
     * midnight on the date of expiry. (Not required. May be null)
     * @param clientReference Any client reference for this subscription token
     * request. (Not required. May be null)
     * @return Subscription token
     * @throws FollyException Generic exception that is thrown if this operation
     * fails for any reason.
     */
    public static String getApplicationSubscriptionToken(
            final Integer subscriptionLength,
            final String clientReference) throws FollyException {
        final Map<String, Object> parameters = new HashMap<>();

        parameters.put(GetApplicationSubscriptionToken.PARAMETER_SUBSCRIPTION_LENGTH, subscriptionLength);
        parameters.put(GetApplicationSubscriptionToken.PARAMETER_CLIENT_REFERENCE, clientReference);

        final GetApplicationSubscriptionTokenResponse response = Folly.sendRequest(GetApplicationSubscriptionToken.OPERATION_NAME, OperationType.ACCOUNTS, parameters, GetApplicationSubscriptionTokenResponse.class);

        if (response.getError() != null) {
            throw new FollyException(response.getError());
        }

        return response.getResult();
    }

    /**
     * Activates the customers subscription token for an application. Please
     * note: The request is made by the customers account using their session
     * token (X-Authentication header) only.
     *
     * The activation of a new subscription token can take up to 2 minutes,
     * therefore, you should ensure that this delay is handled within your
     * application. Please note: A maximum number of 15,000 subscription
     * UNACTIVATED subscriptions tokens can be created at any one time. Attempts
     * to create more subscription tokens will return the error
     * TOO_MANY_REQUESTS error which will restrict creation of further tokens
     * until existing UNACTIVATED subscription tokens have been ACTIVATED or
     * CANCELLED.
     *
     * @param subscriptionToken Subscription token for activation. (Required)
     * @return
     * @throws FollyException Generic exception that is thrown if this operation
     * fails for any reason.
     */
    public static Status activateApplicationSubscription(
            final String subscriptionToken) throws FollyException {
        if (subscriptionToken == null) {
            throw new FollyException("Parameter \"subscriptionToken\" has not been set");
        }

        final Map<String, Object> parameters = new HashMap<>();

        parameters.put(ActivateApplicationSubscription.PARAMETER_SUBSCRIPTION_TOKEN, subscriptionToken);

        final ActivateApplicationSubscriptionResponse response = Folly.sendRequest(ActivateApplicationSubscription.OPERATION_NAME, OperationType.ACCOUNTS, parameters, ActivateApplicationSubscriptionResponse.class);

        if (response.getError() != null) {
            throw new FollyException(response.getError());
        }

        return response.getResult();
    }

    /**
     * Cancel the subscription token. The customers subscription will no longer
     * be active once cancelled.
     *
     * @param subscriptionToken Subscription token to cancel (Required)
     * @return
     * @throws FollyException Generic exception that is thrown if this operation
     * fails for any reason.
     */
    public static Status cancelApplicationSubscription(
            final String subscriptionToken) throws FollyException {
        if (subscriptionToken == null) {
            throw new FollyException("Parameter \"subscriptionToken\" has not been set");
        }

        final Map<String, Object> parameters = new HashMap<>();

        parameters.put(CancelApplicationSubscription.PARAMETER_SUBSCRIPTION_TOKEN, subscriptionToken);

        final CancelApplicationSubscriptionResponse response = Folly.sendRequest(CancelApplicationSubscription.OPERATION_NAME, OperationType.ACCOUNTS, parameters, CancelApplicationSubscriptionResponse.class);

        if (response.getError() != null) {
            throw new FollyException(response.getError());
        }

        return response.getResult();
    }

    /**
     * Update an application subscription with a new expiry date.
     *
     * Please note: A subscription token created by this operation doesn't need
     * to be activated via activateApplicationSubscription as the token is
     * automatically associated with the customers vendorClientId when the
     * request is made.
     *
     * @param vendorClientId The vendor client id for which to update the
     * subscription for (Required)
     * @param subscriptionLength How many days the subscription should last.
     * Expiry time will be rounded up to midnight on the date of expiry. Any
     * change to the subscription length will override the customers existing
     * subscription. (Not required. May be null)
     * @return Subscription token
     * @throws FollyException Generic exception that is thrown if this operation
     * fails for any reason.
     */
    public static String updateApplicationSubscription(
            final String vendorClientId,
            final Integer subscriptionLength) throws FollyException {
        if (vendorClientId == null) {
            throw new FollyException("Parameter \"vendorClientId\" has not been set");
        }

        final Map<String, Object> parameters = new HashMap<>();

        parameters.put(UpdateApplicationSubscription.PARAMETER_VENDOR_CLIENT_ID, vendorClientId);
        parameters.put(UpdateApplicationSubscription.PARAMETER_SUBSCRIPTION_LENGTH, subscriptionLength);

        final UpdateApplicationSubscriptionResponse response = Folly.sendRequest(UpdateApplicationSubscription.OPERATION_NAME, OperationType.ACCOUNTS, parameters, UpdateApplicationSubscriptionResponse.class);

        if (response.getError() != null) {
            throw new FollyException(response.getError());
        }

        return response.getResult();
    }

    /**
     * Returns a list of subscription tokens for an application based on the
     * subscription status passed in the request. Returns all subscription token
     * details, including the client reference and vendor client Id associated
     * with the subscription token.
     *
     * @param subscriptionStatus Optionally filter response by Subscription
     * status of the token (Not required. May be null)
     * @return List of subscription tokens for an application
     * @throws FollyException Generic exception that is thrown if this operation
     * fails for any reason.
     */
    public static List<ApplicationSubscription> listApplicationSubscriptionTokens(
            final SubscriptionStatus subscriptionStatus) throws FollyException {
        final Map<String, Object> parameters = new HashMap<>();

        parameters.put(ListApplicationSubscriptionTokens.PARAMETER_SUBSCRIPTION_STATUS, subscriptionStatus);

        final ListApplicationSubscriptionTokensResponse response = Folly.sendRequest(ListApplicationSubscriptionTokens.OPERATION_NAME, OperationType.ACCOUNTS, parameters, ListApplicationSubscriptionTokensResponse.class);

        if (response.getError() != null) {
            throw new FollyException(response.getError());
        }

        return response.getResult();
    }

    /**
     * List of subscription tokens associated with the account
     *
     * @return List of subscription tokens associated with the account
     * @throws FollyException Generic exception that is thrown if this operation
     * fails for any reason.
     */
    public static List<AccountSubscription> listAccountSubscriptionTokens() throws FollyException {
        final ListAccountSubscriptionTokensResponse response = Folly.sendRequest(ListAccountSubscriptionTokens.OPERATION_NAME, OperationType.ACCOUNTS, null, ListAccountSubscriptionTokensResponse.class);

        if (response.getError() != null) {
            throw new FollyException(response.getError());
        }

        return response.getResult();
    }

    /**
     * Returns a list of subscriptions tokens that have been associated with the
     * customers account. This allows a vendor to identify if a customer has a
     * previous subscription to their application and the status of each
     * subscription.
     *
     * @param vendorClientId The unique customer identifier (Not required. May
     * be null)
     * @param applicationId The unique application identifier (Not required. May
     * be null)
     * @return List of subscription tokens associated with the account
     * @throws FollyException Generic exception that is thrown if this operation
     * fails for any reason.
     */
    public static List<SubscriptionHistory> getApplicationSubscriptionHistory(
            final String vendorClientId,
            final String applicationId) throws FollyException {
        final Map<String, Object> parameters = new HashMap<>();

        parameters.put(GetApplicationSubscriptionHistory.PARAMETER_VENDOR_CLIENT_ID, vendorClientId);
        parameters.put(GetApplicationSubscriptionHistory.PARAMETER_APPLICATION_ID, applicationId);

        final GetApplicationSubscriptionHistoryResponse response = Folly.sendRequest(GetApplicationSubscriptionHistory.OPERATION_NAME, OperationType.ACCOUNTS, parameters, GetApplicationSubscriptionHistoryResponse.class);

        if (response.getError() != null) {
            throw new FollyException(response.getError());
        }

        return response.getResult();
    }

    /**
     * Get account statement
     *
     * @param locale The language to be used where applicable. If not specified,
     * the customer account default is returned. (Not required. May be null)
     * @param fromRecord Specifies the first record that will be returned.
     * Records start at index zero. If not specified then it will default to 0.
     * (Not required. May be null)
     * @param recordCount Specifies the maximum number of records to be
     * returned. Note that there is a page size limit of 100. (Not required. May
     * be null)
     * @param itemDateRange Return items with an itemDate within this date
     * range. Both from and to date times are inclusive. If from is not
     * specified then the oldest available items will be in range. If to is not
     * specified then the latest items will be in range. nb. This itemDataRange
     * is currently only applied when includeItem is set to ALL or not
     * specified, else items are NOT bound by itemDate. (Not required. May be
     * null)
     * @param includeItem Which items to include, if not specified then defaults
     * to ALL. (Not required. May be null)
     * @param wallet Which wallet to return statementItems for. If unspecified
     * then the UK wallet will be selected (Not required. May be null)
     * @return List of statement items chronologically ordered plus
     * moreAvailable boolean to facilitate paging
     * @throws FollyException Generic exception that is thrown if this operation
     * fails for any reason.
     */
    public static AccountStatementReport getAccountStatement(final String locale,
                                                             final Integer fromRecord,
                                                             final Integer recordCount,
                                                             final TimeRange itemDateRange,
                                                             final IncludeItem includeItem,
                                                             final Wallet wallet) throws FollyException {
        final Map<String, Object> parameters = new HashMap<>();

        parameters.put(GetAccountStatement.PARAMETER_LOCALE, locale);
        parameters.put(GetAccountStatement.PARAMETER_FROM_RECORD, fromRecord);
        parameters.put(GetAccountStatement.PARAMETER_RECORD_COUNT, recordCount);
        parameters.put(GetAccountStatement.PARAMETER_ITEM_DATE_RANGE, itemDateRange);
        parameters.put(GetAccountStatement.PARAMETER_INCLUDE_ITEM, includeItem);
        parameters.put(GetAccountStatement.PARAMETER_WALLET, wallet);

        final GetAccountStatementResponse response = Folly.sendRequest(GetAccountStatement.OPERATION_NAME, OperationType.ACCOUNTS, parameters, GetAccountStatementResponse.class);

        if (response.getError() != null) {
            throw new FollyException(response.getError());
        }

        return response.getResult();
    }

    /**
     * Returns a list of currency rates based on given currency
     *
     * @param fromCurrency The currency from which the rates are computed.
     * Please note: GBP is currently the only based currency support (Not
     * required. May be null)
     * @return List of currency rates
     * @throws FollyException Generic exception that is thrown if this operation
     * fails for any reason.
     */
    public static List<CurrencyRate> listCurrencyRates(final String fromCurrency) throws FollyException {
        final Map<String, Object> parameters = new HashMap<>();

        parameters.put(ListCurrencyRates.PARAMETER_FROM_CURRENCY, fromCurrency);

        final ListCurrencyRatesResponse response = Folly.sendRequest(ListCurrencyRates.OPERATION_NAME, OperationType.ACCOUNTS, parameters, ListCurrencyRatesResponse.class);

        if (response.getError() != null) {
            throw new FollyException(response.getError());
        }

        return response.getResult();
    }
}
