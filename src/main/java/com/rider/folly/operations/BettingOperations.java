package com.rider.folly.operations;

import com.rider.folly.exceptions.FollyException;
import com.rider.folly.json.Folly;
import com.rider.folly.json.OperationType;
import com.rider.folly.json.enums.BetStatus;
import com.rider.folly.json.enums.CurrencyParameter;
import com.rider.folly.json.enums.GroupBy;
import com.rider.folly.json.enums.MarketProjection;
import com.rider.folly.json.enums.MarketSort;
import com.rider.folly.json.enums.MatchProjection;
import com.rider.folly.json.enums.OrderBy;
import com.rider.folly.json.enums.OrderProjection;
import com.rider.folly.json.enums.Side;
import com.rider.folly.json.enums.SortDir;
import com.rider.folly.json.enums.TimeGranularity;
import com.rider.folly.json.operations.CancelOrders;
import com.rider.folly.json.operations.ListClearedOrders;
import com.rider.folly.json.operations.ListCompetitions;
import com.rider.folly.json.operations.ListCountries;
import com.rider.folly.json.operations.ListCurrentOrders;
import com.rider.folly.json.operations.ListEventTypes;
import com.rider.folly.json.operations.ListEvents;
import com.rider.folly.json.operations.ListMarketBook;
import com.rider.folly.json.operations.ListMarketCatalogue;
import com.rider.folly.json.operations.ListMarketProfitAndLoss;
import com.rider.folly.json.operations.ListMarketTypes;
import com.rider.folly.json.operations.ListTimeRanges;
import com.rider.folly.json.operations.ListVenues;
import com.rider.folly.json.operations.PlaceOrders;
import com.rider.folly.json.operations.ReplaceOrders;
import com.rider.folly.json.operations.UpdateOrders;
import com.rider.folly.json.reponses.CancelOrdersResponse;
import com.rider.folly.json.reponses.ListClearedOrdersResponse;
import com.rider.folly.json.reponses.ListCompetitionsResponse;
import com.rider.folly.json.reponses.ListCountriesResponse;
import com.rider.folly.json.reponses.ListCurrentOrdersResponse;
import com.rider.folly.json.reponses.ListEventTypesResponse;
import com.rider.folly.json.reponses.ListEventsResponse;
import com.rider.folly.json.reponses.ListMarketBookResponse;
import com.rider.folly.json.reponses.ListMarketCatalogueResponse;
import com.rider.folly.json.reponses.ListMarketProfitAndLossResponse;
import com.rider.folly.json.reponses.ListMarketTypesResponse;
import com.rider.folly.json.reponses.ListTimeRangesResponse;
import com.rider.folly.json.reponses.ListVenuesResponse;
import com.rider.folly.json.reponses.PlaceOrdersResponse;
import com.rider.folly.json.reponses.ReplaceOrdersResponse;
import com.rider.folly.json.reponses.UpdateOrdersResponse;
import com.rider.folly.json.types.CancelExecutionReport;
import com.rider.folly.json.types.CancelInstruction;
import com.rider.folly.json.types.ClearedOrderSummaryReport;
import com.rider.folly.json.types.CompetitionResult;
import com.rider.folly.json.types.CountryCodeResult;
import com.rider.folly.json.types.CurrentOrderSummaryReport;
import com.rider.folly.json.types.EventResult;
import com.rider.folly.json.types.EventTypeResult;
import com.rider.folly.json.types.MarketBook;
import com.rider.folly.json.types.MarketCatalogue;
import com.rider.folly.json.types.MarketFilter;
import com.rider.folly.json.types.MarketProfitAndLoss;
import com.rider.folly.json.types.MarketTypeResult;
import com.rider.folly.json.types.PlaceExecutionReport;
import com.rider.folly.json.types.PlaceInstruction;
import com.rider.folly.json.types.PriceProjection;
import com.rider.folly.json.types.ReplaceExecutionReport;
import com.rider.folly.json.types.ReplaceInstruction;
import com.rider.folly.json.types.RunnerId;
import com.rider.folly.json.types.TimeRange;
import com.rider.folly.json.types.TimeRangeResult;
import com.rider.folly.json.types.UpdateExecutionReport;
import com.rider.folly.json.types.UpdateInstruction;
import com.rider.folly.json.types.VenueResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Ciaron Rider
 */
public class BettingOperations {
    private static final MarketFilter emptyMarketFilter = new MarketFilter();

    private BettingOperations() {
        // Do nothing
    }

    /**
     * Returns a list of Event Types (i.e. Sports) associated with the markets
     * selected by the MarketFilter.
     *
     * @param filter The filter to select desired markets. All markets that
     * match the criteria in the filter are selected. (Not required. May be
     * null)
     * @param locale The language used for the response. If not specified, the
     * default is returned. (Not required. May be null)
     * @return output data
     * @throws FollyException Generic exception that is thrown if this operation
     * fails for any reason.
     */
    public static List<EventTypeResult> listEventTypes(final MarketFilter filter,
                                                       final String locale) throws FollyException {
        final Map<String, Object> parameters = new HashMap<>();

        if (filter == null) {
            parameters.put(ListEventTypes.PARAMETER_FILTER, emptyMarketFilter);
        } else {
            parameters.put(ListEventTypes.PARAMETER_FILTER, filter);
        }

        parameters.put(ListEventTypes.PARAMETER_LOCALE, locale);

        final ListEventTypesResponse response = Folly.sendRequest(ListEventTypes.OPERATION_NAME, OperationType.BETTING, parameters, ListEventTypesResponse.class);

        if (response.getError() != null) {
            throw new FollyException(response.getError());
        }

        return response.getResult();
    }

    /**
     * Returns a list of Competitions (i.e., World Cup 2013) associated with the
     * markets selected by the MarketFilter. Currently only Football markets
     * have an associated competition.
     *
     * @param filter The filter to select desired markets. All markets that
     * match the criteria in the filter are selected. (Not required. May be
     * null)
     * @param locale The language used for the response. If not specified, the
     * default is returned. (Not required. May be null)
     * @return output data
     * @throws FollyException Generic exception that is thrown if this operation
     * fails for any reason.
     */
    public static List<CompetitionResult> listCompetitions(
            final MarketFilter filter,
            final String locale) throws FollyException {
        final Map<String, Object> parameters = new HashMap<>();

        if (filter == null) {
            parameters.put(ListCompetitions.PARAMETER_FILTER, emptyMarketFilter);
        } else {
            parameters.put(ListCompetitions.PARAMETER_FILTER, filter);
        }

        parameters.put(ListCompetitions.PARAMETER_LOCALE, locale);

        final ListCompetitionsResponse response = Folly.sendRequest(ListCompetitions.OPERATION_NAME, OperationType.BETTING, parameters, ListCompetitionsResponse.class);

        if (response.getError() != null) {
            throw new FollyException(response.getError());
        }

        return response.getResult();
    }

    /**
     * Returns a list of time ranges in the granularity specified in the request
     * (i.e. 3PM to 4PM, Aug 14th to Aug 15th) associated with the markets
     * selected by the MarketFilter.
     *
     * @param filter The filter to select desired markets. All markets that
     * match the criteria in the filter are selected. (Not required. May be
     * null)
     * @param granularity The granularity of time periods that correspond to
     * markets selected by the market filter. (Required)
     * @return output data
     * @throws FollyException Generic exception that is thrown if this operation
     * fails for any reason.
     */
    public static List<TimeRangeResult> listTimeRanges(final MarketFilter filter,
                                                       final TimeGranularity granularity) throws FollyException {
        final Map<String, Object> parameters = new HashMap<>();

        if (filter == null) {
            parameters.put(ListTimeRanges.PARAMETER_FILTER, emptyMarketFilter);
        } else {
            parameters.put(ListTimeRanges.PARAMETER_FILTER, filter);
        }

        parameters.put(ListTimeRanges.PARAMETER_GRANULARITY, granularity);

        final ListTimeRangesResponse response = Folly.sendRequest(ListTimeRanges.OPERATION_NAME, OperationType.BETTING, parameters, ListTimeRangesResponse.class);

        if (response.getError() != null) {
            throw new FollyException(response.getError());
        }

        return response.getResult();
    }

    /**
     * Returns a list of Events (i.e, Reading vs. Man United) associated with
     * the markets selected by the MarketFilter.
     *
     * @param filter The filter to select desired markets. All markets that
     * match the criteria in the filter are selected. (Not required. May be
     * null)
     * @param locale The language used for the response. If not specified, the
     * default is returned. (Not required. May be null)
     * @return output data
     * @throws FollyException Generic exception that is thrown if this operation
     * fails for any reason.
     */
    public static List<EventResult> listEvents(final MarketFilter filter,
                                               final String locale) throws FollyException {
        final Map<String, Object> parameters = new HashMap<>();

        if (filter == null) {
            parameters.put(ListEvents.PARAMETER_FILTER, emptyMarketFilter);
        } else {
            parameters.put(ListEvents.PARAMETER_FILTER, filter);
        }

        parameters.put(ListEvents.PARAMETER_LOCALE, locale);

        final ListEventsResponse response = Folly.sendRequest(ListEvents.OPERATION_NAME, OperationType.BETTING, parameters, ListEventsResponse.class);

        if (response.getError() != null) {
            throw new FollyException(response.getError());
        }

        return response.getResult();
    }

    /**
     * Returns a list of market types (i.e. MATCH_ODDS, NEXT_GOAL) associated
     * with the markets selected by the MarketFilter. The market types are
     * always the same, regardless of locale.
     *
     * @param filter The filter to select desired markets. All markets that
     * match the criteria in the filter are selected. (Not required. May be
     * null)
     * @param locale The language used for the response. If not specified, the
     * default is returned. (Not required. May be null)
     * @return output data
     * @throws FollyException Generic exception that is thrown if this operation
     * fails for any reason.
     */
    public static List<MarketTypeResult> listMarketTypes(
            final MarketFilter filter,
            final String locale) throws FollyException {
        final Map<String, Object> parameters = new HashMap<>();

        if (filter == null) {
            parameters.put(ListMarketTypes.PARAMETER_FILTER, emptyMarketFilter);
        } else {
            parameters.put(ListMarketTypes.PARAMETER_FILTER, filter);
        }

        parameters.put(ListMarketTypes.PARAMETER_LOCALE, locale);

        final ListMarketTypesResponse response = Folly.sendRequest(ListMarketTypes.OPERATION_NAME, OperationType.BETTING, parameters, ListMarketTypesResponse.class);

        if (response.getError() != null) {
            throw new FollyException(response.getError());
        }

        return response.getResult();
    }

    /**
     * Returns a list of Countries associated with the markets selected by the
     * MarketFilter.
     *
     * @param filter The filter to select desired markets. All markets that
     * match the criteria in the filter are selected. (Not required. May be
     * null)
     * @param locale The language used for the response. If not specified, the
     * default is returned. (Not required. May be null)
     * @return output data
     * @throws FollyException Generic exception that is thrown if this operation
     * fails for any reason.
     */
    public static List<CountryCodeResult> listCountries(
            final MarketFilter filter,
            final String locale) throws FollyException {
        final Map<String, Object> parameters = new HashMap<>();

        if (filter == null) {
            parameters.put(ListCountries.PARAMETER_FILTER, emptyMarketFilter);
        } else {
            parameters.put(ListCountries.PARAMETER_FILTER, filter);
        }

        parameters.put(ListCountries.PARAMETER_LOCALE, locale);

        final ListCountriesResponse response = Folly.sendRequest(ListCountries.OPERATION_NAME, OperationType.BETTING, parameters, ListCountriesResponse.class);

        if (response.getError() != null) {
            throw new FollyException(response.getError());
        }

        return response.getResult();
    }

    /**
     * Returns a list of Venues (i.e. Cheltenham, Ascot) associated with the
     * markets selected by the MarketFilter. Currently, only Horse Racing
     * markets are associated with a Venue.
     *
     * @param filter The filter to select desired markets. All markets that
     * match the criteria in the filter are selected. (Not required. May be
     * null)
     * @param locale The language used for the response. If not specified, the
     * default is returned. (Not required. May be null)
     * @return output data
     * @throws FollyException Generic exception that is thrown if this operation
     * fails for any reason.
     */
    public static List<VenueResult> listVenues(final MarketFilter filter,
                                               final String locale) throws FollyException {
        final Map<String, Object> parameters = new HashMap<>();

        if (filter == null) {
            parameters.put(ListVenues.PARAMETER_FILTER, emptyMarketFilter);
        } else {
            parameters.put(ListVenues.PARAMETER_FILTER, filter);
        }

        parameters.put(ListVenues.PARAMETER_LOCALE, locale);

        final ListVenuesResponse response = Folly.sendRequest(ListVenues.OPERATION_NAME, OperationType.BETTING, parameters, ListVenuesResponse.class);

        if (response.getError() != null) {
            throw new FollyException(response.getError());
        }

        return response.getResult();
    }

    /**
     * Returns a list of information about published (ACTIVE/SUSPENDED) markets
     * that does not change (or changes very rarely). You use
     * listMarketCatalogue to retrieve the name of the market, the names of
     * selections and other information about markets. Market Data Request
     * Limits apply to requests made to listMarketCatalogue.
     *
     * Please note: listMarketCatalogue does not return markets that are CLOSED.
     *
     * @param filter The filter to select desired markets. All markets that
     * match the criteria in the filter are selected. (Not required. May be
     * null)
     * @param marketProjection The type and amount of data returned about the
     * market (Not required. May be null)
     * @param sort The order of the results. Will default to RANK if not passed.
     * RANK is an assigned priority that is determined by our Market Operations
     * team in our back-end system. A result's overall rank is derived from the
     * ranking given to the flowing attributes for the result. EventType,
     * Competition, StartTime, MarketType, MarketId. For example, EventType is
     * ranked by the most popular sports types and marketTypes are ranked in the
     * following order: ODDS ASIAN LINE RANGE If all other dimensions of the
     * result are equal, then the results are ranked in MarketId order. (Not
     * required. May be null)
     * @param maxResults Limit on the total number of results returned, must be
     * greater than 0 and less than or equal to 1000. Defaults to 100 (Not
     * required. May be null)
     * @param locale The language used for the response. If not specified, the
     * default is returned. (Not required. May be null)
     * @return output data
     * @throws FollyException Generic exception that is thrown if this operation
     * fails for any reason.
     */
    public static List<MarketCatalogue> listMarketCatalogue(
            final MarketFilter filter,
            final Set<MarketProjection> marketProjection,
            final MarketSort sort,
            final Integer maxResults,
            final String locale) throws FollyException {
        final Map<String, Object> parameters = new HashMap<>();

        if (filter == null) {
            parameters.put(ListMarketCatalogue.PARAMETER_FILTER, emptyMarketFilter);
        } else {
            parameters.put(ListMarketCatalogue.PARAMETER_FILTER, filter);
        }

        parameters.put(ListMarketCatalogue.PARAMETER_MARKET_PROJECTION, marketProjection);
        parameters.put(ListMarketCatalogue.PARAMETER_SORT, sort);

        if (maxResults == null) {
            parameters.put(ListMarketCatalogue.PARAMETER_MAX_RESULTS, 100);
        } else {
            parameters.put(ListMarketCatalogue.PARAMETER_MAX_RESULTS, maxResults);
        }

        parameters.put(ListMarketCatalogue.PARAMETER_LOCALE, locale);

        final ListMarketCatalogueResponse response = Folly.sendRequest(ListMarketCatalogue.OPERATION_NAME, OperationType.BETTING, parameters, ListMarketCatalogueResponse.class);

        if (response.getError() != null) {
            throw new FollyException(response.getError());
        }

        return response.getResult();
    }

    /**
     * Returns a list of dynamic data about markets. Dynamic data includes
     * prices, the status of the market, the status of selections, the traded
     * volume, and the status of any orders you have placed in the market.
     *
     * Please note: Separate requests should be made for ACTIVE & CLOSED
     * markets. Request that include both ACTIVE & CLOSED markets will only
     * return those markets that are ACTIVE.
     *
     *
     * Market Data Request Limits apply to requests made to listMarketBook that
     * include price or order projections.
     *
     * Calls to listMarketBook should be made up to a maximum of 5 times per
     * second to a single marketId. Best Practice Customers seeking to use
     * listMarketBook to obtain price, volume, unmatched (EXECUTABLE) orders and
     * matched position in a single operation should provide an
     * OrderProjectionof “EXECUTABLE” in their listMarketBook request and
     * receive all unmatched (EXECUTABLE) orders and the aggregated matched
     * volume from all orders irrespective of whether they are partially or
     * fully matched. The level of matched volume aggregation (MatchProjection)
     * requested should be ROLLED_UP_BY_AVG_PRICE or ROLLED_UP_BY_PRICE, the
     * former being preferred. This provides a single call in which you can
     * track prices, traded volume, unmatched orders and your evolving matched
     * position with a reasonably fixed, minimally sized response.
     *
     * @param marketIds One or more market ids. The number of markets returned
     * depends on the amount of data you request via the price projection.
     * (Required)
     * @param priceProjection The projection of price data you want to receive
     * in the response. (Not required. May be null)
     * @param orderProjection The orders you want to receive in the response.
     * (Not required. May be null)
     * @param matchProjection If you ask for orders, specifies the
     * representation of matches. (Not required. May be null)
     * @param currencyCode A Betfair standard currency code. If not specified,
     * the default currency code is used. (Not required. May be null)
     * @param locale The language used for the response. If not specified, the
     * default is returned. (Not required. May be null)
     * @return output data
     * @throws FollyException Generic exception that is thrown if this operation
     * fails for any reason.
     */
    public static List<MarketBook> listMarketBook(final List<String> marketIds,
                                                  final PriceProjection priceProjection,
                                                  final OrderProjection orderProjection,
                                                  final MatchProjection matchProjection,
                                                  final CurrencyParameter currencyCode,
                                                  final String locale) throws FollyException {
        if (marketIds == null) {
            throw new FollyException("Parameter \"marketIds\" has not been set");
        }

        final Map<String, Object> parameters = new HashMap<>();

        parameters.put(ListMarketBook.PARAMETER_MARKET_IDS, marketIds);
        parameters.put(ListMarketBook.PARAMETER_PRICE_PROJECTION, priceProjection);
        parameters.put(ListMarketBook.PARAMETER_ORDER_PROJECTION, orderProjection);
        parameters.put(ListMarketBook.PARAMETER_MATCH_PROJECTION, matchProjection);
        parameters.put(ListMarketBook.PARAMETER_CURRENCY_CODE, currencyCode);
        parameters.put(ListMarketBook.PARAMETER_LOCALE, locale);

        final ListMarketBookResponse response = Folly.sendRequest(ListMarketBook.OPERATION_NAME, OperationType.BETTING, parameters, ListMarketBookResponse.class);

        if (response.getError() != null) {
            throw new FollyException(response.getError());
        }

        return response.getResult();
    }

    /**
     * Returns a list of dynamic data about markets. Dynamic data includes
     * prices, the status of the market, the status of selections, the traded
     * volume, and the status of any orders you have placed in the market.
     *
     * Please note: Separate requests should be made for ACTIVE & CLOSED
     * markets. Request that include both ACTIVE & CLOSED markets will only
     * return those markets that are ACTIVE.
     *
     *
     * Market Data Request Limits apply to requests made to listMarketBook that
     * include price or order projections.
     *
     * Calls to listMarketBook should be made up to a maximum of 5 times per
     * second to a single marketId. Best Practice Customers seeking to use
     * listMarketBook to obtain price, volume, unmatched (EXECUTABLE) orders and
     * matched position in a single operation should provide an
     * OrderProjectionof “EXECUTABLE” in their listMarketBook request and
     * receive all unmatched (EXECUTABLE) orders and the aggregated matched
     * volume from all orders irrespective of whether they are partially or
     * fully matched. The level of matched volume aggregation (MatchProjection)
     * requested should be ROLLED_UP_BY_AVG_PRICE or ROLLED_UP_BY_PRICE, the
     * former being preferred. This provides a single call in which you can
     * track prices, traded volume, unmatched orders and your evolving matched
     * position with a reasonably fixed, minimally sized response.
     *
     * @param marketId The marketId to look up (Required)
     * @param priceProjection The projection of price data you want to receive
     * in the response. (Not required. May be null)
     * @param orderProjection The orders you want to receive in the response.
     * (Not required. May be null)
     * @param matchProjection If you ask for orders, specifies the
     * representation of matches. (Not required. May be null)
     * @param currencyCode A Betfair standard currency code. If not specified,
     * the default currency code is used. (Not required. May be null)
     * @param locale The language used for the response. If not specified, the
     * default is returned. (Not required. May be null)
     * @return output data
     * @throws FollyException Generic exception that is thrown if this operation
     * fails for any reason.
     */
    public static List<MarketBook> listMarketBook(final String marketId,
                                                  final PriceProjection priceProjection,
                                                  final OrderProjection orderProjection,
                                                  final MatchProjection matchProjection,
                                                  final CurrencyParameter currencyCode,
                                                  final String locale) throws FollyException {
        if (marketId == null) {
            throw new FollyException("Parameter \"marketId\" has not been set");
        }

        final List<String> marketIds = new ArrayList<>();
        marketIds.add(marketId);

        return listMarketBook(marketIds, priceProjection, orderProjection, matchProjection, currencyCode, locale);
    }

    /**
     * Retrieve profit and loss for a given list of markets. The values are
     * calculated using matched bets and optionally settled bets. Only odds
     * (MarketBettingType = ODDS) markets are implemented, markets of other
     * types are silently ignored.
     *
     * Please note: Market Data Request Limits apply to requests made to
     * listMarketProfitAndLoss
     *
     * @param marketIds List of markets to calculate profit and loss (Required)
     * @param includeSettledBets Option to include settled bets (partially
     * settled markets only). Defaults to false if not specified. (Not required.
     * May be null)
     * @param includeBspBets Option to include BSP bets. Defaults to false if
     * not specified. (Not required. May be null)
     * @param netOfCommission Option to return profit and loss net of users
     * current commission rate for this market including any special tariffs.
     * Defaults to false if not specified. (Not required. May be null)
     * @return
     * @throws FollyException Generic exception that is thrown if this operation
     * fails for any reason.
     */
    public static List<MarketProfitAndLoss> listMarketProfitAndLoss(
            final Set<String> marketIds,
            final Boolean includeSettledBets,
            final Boolean includeBspBets,
            final Boolean netOfCommission) throws FollyException {
        if (marketIds == null) {
            throw new FollyException("Parameter \"marketIds\" has not been set");
        }

        final Map<String, Object> parameters = new HashMap<>();

        parameters.put(ListMarketProfitAndLoss.PARAMETER_MARKET_IDS, marketIds);
        parameters.put(ListMarketProfitAndLoss.PARAMETER_INCLUDE_SETTLED_BETS, includeSettledBets);
        parameters.put(ListMarketProfitAndLoss.PARAMETER_INCLUDE_BSP_BETS, includeBspBets);
        parameters.put(ListMarketProfitAndLoss.PARAMETER_NET_OF_COMMISSION, netOfCommission);

        final ListMarketProfitAndLossResponse response = Folly.sendRequest(ListMarketProfitAndLoss.OPERATION_NAME, OperationType.BETTING, parameters, ListMarketProfitAndLossResponse.class);

        if (response.getError() != null) {
            throw new FollyException(response.getError());
        }

        return response.getResult();
    }

    /**
     * Retrieve profit and loss for a given list of markets. The values are
     * calculated using matched bets and optionally settled bets. Only odds
     * (MarketBettingType = ODDS) markets are implemented, markets of other
     * types are silently ignored.
     *
     * Please note: Market Data Request Limits apply to requests made to
     * listMarketProfitAndLoss
     *
     * @param marketIds List of markets to calculate profit and loss (Required)
     * @param includeSettledBets Option to include settled bets (partially
     * settled markets only). Defaults to false if not specified. (Not required.
     * May be null)
     * @param includeBspBets Option to include BSP bets. Defaults to false if
     * not specified. (Not required. May be null)
     * @param netOfCommission Option to return profit and loss net of users
     * current commission rate for this market including any special tariffs.
     * Defaults to false if not specified. (Not required. May be null)
     * @return
     * @throws FollyException Generic exception that is thrown if this operation
     * fails for any reason.
     */
    public static List<MarketProfitAndLoss> listMarketProfitAndLoss(
            final String marketId,
            final Boolean includeSettledBets,
            final Boolean includeBspBets,
            final Boolean netOfCommission) throws FollyException {
        if (marketId == null) {
            throw new FollyException("Parameter \"marketId\" has not been set");
        }

        final Set<String> marketIds = new HashSet<>();
        marketIds.add(marketId);

        return listMarketProfitAndLoss(marketIds, includeSettledBets, includeBspBets, netOfCommission);
    }

    /**
     * Returns a list of your current orders. Optionally you can filter and sort
     * your current orders using the various parameters, setting none of the
     * parameters will return all of your current orders up to a maximum of 1000
     * bets, ordered BY_BET and sorted EARLIEST_TO_LATEST. To retrieve more than
     * 1000 orders, you need to make use of the fromRecord and recordCount
     * parameters.
     *
     * Best Practice To efficiently track new bet matches from a specific time,
     * customers should use a combination of the dateRange, orderBy
     * "BY_MATCH_TIME" and orderProjection “ALL” to filter fully/partially
     * matched orders from the list of returned bets. The response will then
     * filter out any bet records that have no matched date and provide a list
     * of betIds in the order which they are fully/partially matched from the
     * date and time specified in the dateRange field.
     *
     * @param betIds Optionally restricts the results to the specified bet IDs.
     * A maximum of 250 betId's, or a combination of 250 betId's & marketId's
     * are permitted. (Not required. May be null)
     * @param marketIds Optionally restricts the results to the specified market
     * IDs. A maximum of 250 marketId's, or a combination of 250 marketId's &
     * betId's are permitted. (Not required. May be null)
     * @param orderProjection Optionally restricts the results to the specified
     * order status. (Not required. May be null)
     * @param dateRange Optionally restricts the results to be from/to the
     * specified date, these dates are contextual to the orders being returned
     * and therefore the dates used to filter on will change to placed, matched,
     * voided or settled dates depending on the orderBy. This date is inclusive,
     * i.e. if an order was placed on exactly this date (to the millisecond)
     * then it will be included in the results. If the from is later than the
     * to, no results will be returned. (Not required. May be null)
     * @param orderBy Specifies how the results will be ordered. If no value is
     * passed in, it defaults to BY_BET. Also acts as a filter such that only
     * orders with a valid value in the field being ordered by will be returned
     * (i.e. BY_VOID_TIME returns only voided orders, BY_SETTLED_TIME (applies
     * to partially settled markets) returns only settled orders and
     * BY_MATCH_TIME returns only orders with a matched date (voided, settled,
     * matched orders)). Note that specifying an orderBy parameter defines the
     * context of the date filter applied by the dateRange parameter (placed,
     * matched, voided or settled date) - see the dateRange parameter
     * description (above) for more information. See also the OrderBy type
     * definition. (Not required. May be null)
     * @param sortDir Specifies the direction the results will be sorted in. If
     * no value is passed in, it defaults to EARLIEST_TO_LATEST. (Not required.
     * May be null)
     * @param fromRecord Specifies the first record that will be returned.
     * Records start at index zero, not at index one. (Not required. May be
     * null)
     * @param recordCount Specifies how many records will be returned from the
     * index position 'fromRecord'. Note that there is a page size limit of
     * 1000. A value of zero indicates that you would like all records
     * (including and from 'fromRecord') up to the limit. (Not required. May be
     * null)
     * @return
     * @throws FollyException Generic exception that is thrown if this operation
     * fails for any reason.
     */
    public static CurrentOrderSummaryReport listCurrentOrders(
            final Set<String> betIds,
            final Set<String> marketIds,
            final OrderProjection orderProjection,
            final TimeRange dateRange,
            final OrderBy orderBy,
            final SortDir sortDir,
            final Integer fromRecord,
            final Integer recordCount) throws FollyException {
        final Map<String, Object> parameters = new HashMap<>();

        parameters.put(ListCurrentOrders.PARAMETER_BET_IDS, betIds);
        parameters.put(ListCurrentOrders.PARAMETER_MARKET_IDS, marketIds);
        parameters.put(ListCurrentOrders.PARAMETER_ORDER_PROJECTION, orderProjection);
        parameters.put(ListCurrentOrders.PARAMETER_DATE_RANGE, dateRange);
        parameters.put(ListCurrentOrders.PARAMETER_ORDER_BY, orderBy);
        parameters.put(ListCurrentOrders.PARAMETER_SORT_DIR, sortDir);

        if (fromRecord == null) {
            parameters.put(ListCurrentOrders.PARAMETER_FROM_RECORD, 0);
        } else {
            parameters.put(ListCurrentOrders.PARAMETER_FROM_RECORD, fromRecord);
        }

        if (recordCount == null) {
            parameters.put(ListCurrentOrders.PARAMETER_RECORD_COUNT, 0);
        } else {
            parameters.put(ListCurrentOrders.PARAMETER_RECORD_COUNT, recordCount);
        }

        final ListCurrentOrdersResponse response = Folly.sendRequest(ListCurrentOrders.OPERATION_NAME, OperationType.BETTING, parameters, ListCurrentOrdersResponse.class);

        if (response.getError() != null) {
            throw new FollyException(response.getError());
        }

        return response.getResult();
    }

    /**
     * Returns a list of settled bets based on the bet status, ordered by
     * settled date. To retrieve more than 1000 records, you need to make use of
     * the fromRecord and recordCount parameters. By default the service will
     * return all available data for the last 90 days (see Best Practice note
     * below). The fields available at each roll-up are available here
     *
     * @param betStatus Restricts the results to the specified status (Required)
     * @param eventTypeIds Optionally restricts the results to the specified
     * Event Type IDs. (Not required. May be null)
     * @param eventIds Optionally restricts the results to the specified Event
     * IDs. (Not required. May be null)
     * @param marketIds Optionally restricts the results to the specified market
     * IDs. (Not required. May be null)
     * @param runnerIds Optionally restricts the results to the specified
     * Runners.
     * @param betIds Optionally restricts the results to the specified bet IDs.
     * (Not required. May be null)
     * @param side Optionally restricts the results to the specified side. (Not
     * required. May be null)
     * @param settledDateRange Optionally restricts the results to be from/to
     * the specified settled date. This date is inclusive, i.e. if an order was
     * cleared on exactly this date (to the millisecond) then it will be
     * included in the results. If the from is later than the to, no results
     * will be returned. (Not required. May be null)
     * @param groupBy How to aggregate the lines, if not supplied then the
     * lowest level is returned, i.e. bet by bet This is only applicable to
     * SETTLED BetStatus. (Not required. May be null)
     * @param includeItemDescription If true then an ItemDescription object is
     * included in the response (Not required. May be null)
     * @param locale The language used for the itemDescription. If not
     * specified, the customer account default is returned. (Not required. May
     * be null)
     * @param fromRecord Specifies the first record that will be returned.
     * Records start at index zero. (Not required. May be null)
     * @param recordCount Specifies how many records will be returned, from the
     * index position 'fromRecord'. Note that there is a page size limit of
     * 1000. A value of zero indicates that you would like all records
     * (including and from 'fromRecord') up to the limit. (Not required. May be
     * null)
     * @return
     * @throws FollyException Generic exception that is thrown if this operation
     * fails for any reason.
     */
    public static ClearedOrderSummaryReport listClearedOrders(
            final BetStatus betStatus,
            final Set<String> eventTypeIds,
            final Set<String> eventIds,
            final Set<String> marketIds,
            final Set<RunnerId> runnerIds,
            final Set<String> betIds,
            final Side side,
            final TimeRange settledDateRange,
            final GroupBy groupBy,
            final Boolean includeItemDescription,
            final String locale,
            final Integer fromRecord,
            final Integer recordCount) throws FollyException {
        final Map<String, Object> parameters = new HashMap<>();

        parameters.put(ListClearedOrders.PARAMETER_BET_STATUS, betStatus);
        parameters.put(ListClearedOrders.PARAMETER_EVENT_TYPE_IDS, eventTypeIds);
        parameters.put(ListClearedOrders.PARAMETER_EVENT_IDS, eventIds);
        parameters.put(ListClearedOrders.PARAMETER_MARKET_IDS, marketIds);
        parameters.put(ListClearedOrders.PARAMETER_RUNNER_IDS, runnerIds);
        parameters.put(ListClearedOrders.PARAMETER_BET_IDS, betIds);
        parameters.put(ListClearedOrders.PARAMETER_SIDE, side);
        parameters.put(ListClearedOrders.PARAMETER_SETTLED_DATE_RANGE, settledDateRange);
        parameters.put(ListClearedOrders.PARAMETER_GROUP_BY, groupBy);
        parameters.put(ListClearedOrders.PARAMETER_INCLUDE_ITEM_DESCRIPTION, includeItemDescription);
        parameters.put(ListClearedOrders.PARAMETER_LOCALE, locale);

        if (fromRecord == null) {
            parameters.put(ListClearedOrders.PARAMETER_FROM_RECORD, 0);
        } else {
            parameters.put(ListClearedOrders.PARAMETER_FROM_RECORD, fromRecord);
        }

        if (recordCount == null) {
            parameters.put(ListClearedOrders.PARAMETER_RECORD_COUNT, 0);
        } else {
            parameters.put(ListClearedOrders.PARAMETER_RECORD_COUNT, recordCount);
        }

        final ListClearedOrdersResponse response = Folly.sendRequest(ListClearedOrders.OPERATION_NAME, OperationType.BETTING, parameters, ListClearedOrdersResponse.class);

        if (response.getError() != null) {
            throw new FollyException(response.getError());
        }

        return response.getResult();
    }

    /**
     * Place new orders into market. This operation is atomic in that all orders
     * will be placed or none will be placed. Please note that additional bet
     * sizing rules apply to bets placed into the Italian Exchange.
     *
     * @param marketId The market id these orders are to be placed on (Required)
     * @param instructions The number of place instructions. The limit of place
     * instructions per request is 200 for the UK/AUS Exchange and 50 for the
     * Italian Exchange. (Required)
     * @param customerRef Optional parameter allowing the client to pass a
     * unique string (up to 32 chars) that is used to de-dupe mistaken
     * re-submissions. CustomerRef can contain: upper/lower chars, digits, chars
     * : - . _ + * : ; ~ only. Please note: There is a time window associated
     * with the de-duplication of duplicate submissions which is 60 seconds.
     * (Not required. May be null)
     * @return
     * @throws FollyException Generic exception that is thrown if this operation
     * fails for any reason.
     */
    public static PlaceExecutionReport placeOrders(final String marketId,
                                                   final List<PlaceInstruction> instructions,
                                                   final String customerRef) throws FollyException {
        if (marketId == null) {
            throw new FollyException("Parameter \"marketId\" has not been set");
        }

        if (instructions == null) {
            throw new FollyException("Parameter \"instructions\" has not been set");
        }

        final Map<String, Object> parameters = new HashMap<>();

        parameters.put(PlaceOrders.PARAMETER_MARKET_ID, marketId);
        parameters.put(PlaceOrders.PARAMETER_INSTRUCTIONS, instructions);
        parameters.put(PlaceOrders.PARAMETER_CUSTOMER_REF, customerRef);

        final PlaceOrdersResponse response = Folly.sendRequest(PlaceOrders.OPERATION_NAME, OperationType.BETTING, parameters, PlaceOrdersResponse.class);

        if (response.getError() != null) {
            throw new FollyException(response.getError());
        }

        return response.getResult();
    }

    /**
     * Place new orders into market. This operation is atomic in that all orders
     * will be placed or none will be placed. Please note that additional bet
     * sizing rules apply to bets placed into the Italian Exchange.
     *
     * @param marketId The market id these orders are to be placed on (Required)
     * @param instruction The Place Instruction. (Required)
     * @param customerRef Optional parameter allowing the client to pass a
     * unique string (up to 32 chars) that is used to de-dupe mistaken
     * re-submissions. CustomerRef can contain: upper/lower chars, digits, chars
     * : - . _ + * : ; ~ only. Please note: There is a time window associated
     * with the de-duplication of duplicate submissions which is 60 seconds.
     * (Not required. May be null)
     * @return
     * @throws FollyException Generic exception that is thrown if this operation
     * fails for any reason.
     */
    public static PlaceExecutionReport placeOrder(final String marketId,
                                                  final PlaceInstruction instruction,
                                                  final String customerRef) throws FollyException {
        if (marketId == null) {
            throw new FollyException("Parameter \"marketId\" has not been set");
        }

        if (instruction == null) {
            throw new FollyException("Parameter \"instruction\" has not been set");
        }

        final List<PlaceInstruction> instructions = new ArrayList<>();
        instructions.add(instruction);

        return placeOrders(marketId, instructions, customerRef);
    }

    /**
     * Cancel all bets OR cancel all bets on a market OR fully or partially
     * cancel particular orders on a market. Only LIMIT orders can be cancelled
     * or partially cancelled once placed.
     *
     * @param marketId If marketId and betId aren't supplied all bets are
     * cancelled (Required)
     * @param instructions All instructions need to be on the same market. If
     * not supplied all bets on the market (if market id is passed) are fully
     * cancelled. The limit of cancel instructions per request is 60 (Required)
     * @param customerRef Optional parameter allowing the client to pass a
     * unique string (up to 32 chars) that is used to de-dupe mistaken
     * re-submissions. (Not required. May be null)
     * @return
     * @throws FollyException Generic exception that is thrown if this operation
     * fails for any reason.
     */
    public static CancelExecutionReport cancelOrders(final String marketId,
                                                     final List<CancelInstruction> instructions,
                                                     final String customerRef) throws FollyException {
        if (marketId == null) {
            throw new FollyException("Parameter \"marketId\" has not been set");
        }

        if (instructions == null) {
            throw new FollyException("Parameter \"instructions\" has not been set");
        }

        final Map<String, Object> parameters = new HashMap<>();

        parameters.put(CancelOrders.PARAMETER_MARKET_ID, marketId);
        parameters.put(CancelOrders.PARAMETER_INSTRUCTIONS, instructions);
        parameters.put(CancelOrders.PARAMETER_CUSTOMER_REF, customerRef);

        final CancelOrdersResponse response = Folly.sendRequest(CancelOrders.OPERATION_NAME, OperationType.BETTING, parameters, CancelOrdersResponse.class);

        if (response.getError() != null) {
            throw new FollyException(response.getError());
        }

        return response.getResult();
    }

    /**
     * Cancel all bets OR cancel all bets on a market OR fully or partially
     * cancel particular orders on a market. Only LIMIT orders can be cancelled
     * or partially cancelled once placed.
     *
     * @param marketId If marketId and betId aren't supplied all bets are
     * cancelled (Required)
     * @param instruction Cancel instruction (Required)
     * @param customerRef Optional parameter allowing the client to pass a
     * unique string (up to 32 chars) that is used to de-dupe mistaken
     * re-submissions. (Not required. May be null)
     * @return
     * @throws FollyException Generic exception that is thrown if this operation
     * fails for any reason.
     */
    public static CancelExecutionReport cancelOrder(final String marketId,
                                                    final CancelInstruction instruction,
                                                    final String customerRef) throws FollyException {
        if (marketId == null) {
            throw new FollyException("Parameter \"marketId\" has not been set");
        }

        if (instruction == null) {
            throw new FollyException("Parameter \"instruction\" has not been set");
        }

        final List<CancelInstruction> instructions = new ArrayList<>();
        instructions.add(instruction);

        return cancelOrders(marketId, instructions, customerRef);
    }

    /**
     * This operation is logically a bulk cancel followed by a bulk place. The
     * cancel is completed first then the new orders are placed. The new orders
     * will be placed atomically in that they will all be placed or none will be
     * placed. In the case where the new orders cannot be placed the
     * cancellations will not be rolled back. See ReplaceInstruction.
     *
     * @param marketId The market id these orders are to be placed on (Required)
     * @param instructions The number of replace instructions. The limit of
     * replace instructions per request is 60. (Required)
     * @param customerRef Optional parameter allowing the client to pass a
     * unique string (up to 32 chars) that is used to de-dupe mistaken
     * re-submissions. (Not required. May be null)
     * @return
     * @throws FollyException Generic exception that is thrown if this operation
     * fails for any reason.
     */
    public static ReplaceExecutionReport replaceOrders(final String marketId,
                                                       final List<ReplaceInstruction> instructions,
                                                       final String customerRef) throws FollyException {
        if (marketId == null) {
            throw new FollyException("Parameter \"marketId\" has not been set");
        }

        if (instructions == null) {
            throw new FollyException("Parameter \"instructions\" has not been set");
        }

        final Map<String, Object> parameters = new HashMap<>();

        parameters.put(ReplaceOrders.PARAMETER_MARKET_ID, marketId);
        parameters.put(ReplaceOrders.PARAMETER_INSTRUCTIONS, instructions);
        parameters.put(ReplaceOrders.PARAMETER_CUSTOMER_REF, customerRef);

        final ReplaceOrdersResponse response = Folly.sendRequest(ReplaceOrders.OPERATION_NAME, OperationType.BETTING, parameters, ReplaceOrdersResponse.class);

        if (response.getError() != null) {
            throw new FollyException(response.getError());
        }

        return response.getResult();
    }

    /**
     * This operation is logically a bulk cancel followed by a bulk place. The
     * cancel is completed first then the new orders are placed. The new orders
     * will be placed atomically in that they will all be placed or none will be
     * placed. In the case where the new orders cannot be placed the
     * cancellations will not be rolled back. See ReplaceInstruction.
     *
     * @param marketId The market id these orders are to be placed on (Required)
     * @param instruction The replace instruction. (Required)
     * @param customerRef Optional parameter allowing the client to pass a
     * unique string (up to 32 chars) that is used to de-dupe mistaken
     * re-submissions. (Not required. May be null)
     * @return
     * @throws FollyException Generic exception that is thrown if this operation
     * fails for any reason.
     */
    public static ReplaceExecutionReport replaceOrder(final String marketId,
                                                      final ReplaceInstruction instruction,
                                                      final String customerRef) throws FollyException {
        if (marketId == null) {
            throw new FollyException("Parameter \"marketId\" has not been set");
        }

        if (instruction == null) {
            throw new FollyException("Parameter \"instruction\" has not been set");
        }

        final List<ReplaceInstruction> instructions = new ArrayList<>();
        instructions.add(instruction);

        return replaceOrders(marketId, instructions, customerRef);
    }

    /**
     * Update non-exposure changing fields
     *
     * @param marketId The market id these orders are to be placed on (Required)
     * @param instructions The number of update instructions. The limit of
     * update instructions per request is 60 (Required)
     * @param customerRef Optional parameter allowing the client to pass a
     * unique string (up to 32 chars) that is used to de-dupe mistaken
     * re-submissions. (Not required. May be null)
     * @return
     * @throws FollyException Generic exception that is thrown if this operation
     * fails for any reason.
     */
    public static UpdateExecutionReport updateOrders(final String marketId,
                                                     final List<UpdateInstruction> instructions,
                                                     final String customerRef) throws FollyException {
        if (marketId == null) {
            throw new FollyException("Parameter \"marketId\" has not been set");
        }

        if (instructions == null) {
            throw new FollyException("Parameter \"instructions\" has not been set");
        }

        final Map<String, Object> parameters = new HashMap<>();

        parameters.put(UpdateOrders.PARAMETER_MARKET_ID, marketId);
        parameters.put(UpdateOrders.PARAMETER_INSTRUCTIONS, instructions);
        parameters.put(UpdateOrders.PARAMETER_CUSTOMER_REF, customerRef);

        final UpdateOrdersResponse response = Folly.sendRequest(UpdateOrders.OPERATION_NAME, OperationType.BETTING, parameters, UpdateOrdersResponse.class);

        if (response.getError() != null) {
            throw new FollyException(response.getError());
        }

        return response.getResult();
    }

    /**
     * Update non-exposure changing fields
     *
     * @param marketId The market id these orders are to be placed on (Required)
     * @param instruction The update instruction (Required)
     * @param customerRef Optional parameter allowing the client to pass a
     * unique string (up to 32 chars) that is used to de-dupe mistaken
     * re-submissions. (Not required. May be null)
     * @return
     * @throws FollyException Generic exception that is thrown if this operation
     * fails for any reason.
     */
    public static UpdateExecutionReport updateOrder(final String marketId,
                                                    final UpdateInstruction instruction,
                                                    final String customerRef) throws FollyException {
        if (marketId == null) {
            throw new FollyException("Parameter \"marketId\" has not been set");
        }

        if (instruction == null) {
            throw new FollyException("Parameter \"instruction\" has not been set");
        }

        final List<UpdateInstruction> instructions = new ArrayList<>();
        instructions.add(instruction);

        return updateOrders(marketId, instructions, customerRef);
    }
}
