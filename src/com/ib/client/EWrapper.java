/* Copyright (C) 2013 Interactive Brokers LLC. All rights reserved.  This code is subject to the terms
 * and conditions of the IB API Non-Commercial License or the IB API Commercial License, as applicable. */

package com.ib.client;

import java.util.Set;

public interface EWrapper {
    ///////////////////////////////////////////////////////////////////////
    // Interface methods
    ///////////////////////////////////////////////////////////////////////
    /**
     * @brief Market data tick price callback.
     * Handles all price related ticks.
     * @param tickerId the request's unique identifier.
     * @param field the type of the price being received (i.e. ask price).
     * @param price the actual price.
     * @param canAutoExecute Specifies whether the price tick is available for automatic execution (1) or not (0).
     * @sa TickType, tickSize, tickString, tickEFP, tickGeneric, tickOptionComputation, tickSnapshotEnd, marketDataType, EClientSocket::reqMktData
     */
    void tickPrice(int tickerId, int field, double price, int canAutoExecute);

    /**
     * @brief Market data tick size callback.
     * Handles all size-related ticks.
     * @param tickerId the request's unique identifier.
     * @param field the type of size being received (i.e. bid size)
     * @param size the actual size.
     * @sa TickType, tickPrice, tickString, tickEFP, tickGeneric, tickOptionComputation, tickSnapshotEnd, marketDataType, EClientSocket::reqMktData
     */
    void tickSize(int tickerId, int field, int size);

    /**
     * @brief Receive's option specific market data.
     * This method is called when the market in an option or its underlier moves. TWS’s option model volatilities, prices, and deltas, along with the present value of dividends expected on that options underlier are received.
     * @param tickerId the request's unique identifier.
     * @param field Specifies the type of option computation. Pass the field value into TickType.getField(int tickType) to retrieve the field description. For example, a field value of 13 will map to modelOptComp, etc.
     *      10 = Bid
     *      11 = Ask
     *      12 = Last
     * @param impliedVolatility the implied volatility calculated by the TWS option modeler, using the specified tick type value.
     * @param delta the option delta value.
     * @param optPrice the option price.
     * @param pwDividend the present value of dividends expected on the option's underlying.
     * @param gamma the option gamma value.
     * @param vega the option vega value.
     * @param theta the option theta value.
     * @param undPrice the price of the underlying.
     * @sa TickType, tickSize, tickPrice, tickEFP, tickGeneric, tickString, tickSnapshotEnd, marketDataType, EClientSocket::reqMktData
     */
    void tickOptionComputation(int tickerId, int field, double impliedVol,
                               double delta, double optPrice, double pvDividend,
                               double gamma, double vega, double theta, double undPrice);

    /**
     * @brief Market data callback.
     * @param tickerId the request's unique identifier.
     * @param field the type of tick being received.
     * @param value
     */
	void tickGeneric(int tickerId, int tickType, double value);

    /**
     * @brief Market data callback.
     * @param tickerId the request's unique identifier.
     * @param field the type of the tick being received
     * @param value
     * @sa TickType, tickSize, tickPrice, tickEFP, tickGeneric, tickOptionComputation, tickSnapshotEnd, marketDataType, EClientSocket::reqMktData
     */
	void tickString(int tickerId, int tickType, String value);

    /**
     * @brief Exchange for Physicals.
     * @param tickerId The request's identifier.
     * @param tickType The type of tick being received.
     * @param basisPoints Annualized basis points, which is representative of the financing rate that can be directly compared to broker rates.
     * @param formattedBasisPoints Annualized basis points as a formatted string that depicts them in percentage form.
     * @param impliedFuture The implied Futures price.
     * @param holdDays The number of hold days until the lastTradeDate of the EFP.
     * @param futureLastTradeDate The expiration date of the single stock future.
     * @param dividendImpact The dividend impact upon the annualized basis points interest rate.
     * @param dividendsToLastTradeDate The dividends expected until the expiration of the single stock future.
     */
	void tickEFP(int tickerId, int tickType, double basisPoints,
                 String formattedBasisPoints, double impliedFuture, int holdDays,
                 String futureLastTradeDate, double dividendImpact, double dividendsToLastTradeDate);
    void orderStatus(int orderId, String status, double filled, double remaining,
                     double avgFillPrice, int permId, int parentId, double lastFillPrice,
                     int clientId, String whyHeld);
    void openOrder(int orderId, Contract contract, Order order, OrderState orderState);
    void openOrderEnd();
    void updateAccountValue(String key, String value, String currency, String accountName);
    void updatePortfolio(Contract contract, double position, double marketPrice, double marketValue,
                         double averageCost, double unrealizedPNL, double realizedPNL, String accountName);
    void updateAccountTime(String timeStamp);
    void accountDownloadEnd(String accountName);

    /**
     * @brief Receives next valid order id.
     * @param orderId the next order id
     * @sa EClientSocket::reqIds
     */
    void nextValidId(int orderId);
    void contractDetails(int reqId, ContractDetails contractDetails);
    void bondContractDetails(int reqId, ContractDetails contractDetails);
    void contractDetailsEnd(int reqId);
    void execDetails(int reqId, Contract contract, Execution execution);
    void execDetailsEnd(int reqId);
    void updateMktDepth(int tickerId, int position, int operation, int side, double price, int size);
    void updateMktDepthL2(int tickerId, int position, String marketMaker, int operation,
                          int side, double price, int size);
    void updateNewsBulletin(int msgId, int msgType, String message, String origExchange);
    void managedAccounts(String accountsList);
    void receiveFA(int faDataType, String xml);
    void historicalData(int reqId, String date, double open, double high, double low,
                        double close, int volume, int count, double WAP, boolean hasGaps);
    void scannerParameters(String xml);
    void scannerData(int reqId, int rank, ContractDetails contractDetails, String distance,
                     String benchmark, String projection, String legsStr);
    void scannerDataEnd(int reqId);
    void realtimeBar(int reqId, long time, double open, double high, double low, double close, long volume, double wap, int count);
    void currentTime(long time);
    void fundamentalData(int reqId, String data);
    void deltaNeutralValidation(int reqId, DeltaNeutralContract underComp);
    void tickSnapshotEnd(int reqId);
    void marketDataType(int reqId, int marketDataType);
    void commissionReport(CommissionReport commissionReport);
    void position(String account, Contract contract, double pos, double avgCost);
    void positionEnd();
    void accountSummary(int reqId, String account, String tag, String value, String currency);
    void accountSummaryEnd(int reqId);
    void verifyMessageAPI(String apiData);
    void verifyCompleted(boolean isSuccessful, String errorText);
    void verifyAndAuthMessageAPI(String apiData, String xyzChallange);
    void verifyAndAuthCompleted(boolean isSuccessful, String errorText);
    void displayGroupList(int reqId, String groups);
    void displayGroupUpdated(int reqId, String contractInfo);
    void error(Exception e);
    void error(String str);
    void error(int id, int errorCode, String errorMsg);
    void connectionClosed();
    void connectAck();
    void positionMulti(int reqId, String account, String modelCode, Contract contract, double pos, double avgCost);
    void positionMultiEnd(int reqId);
    void accountUpdateMulti(int reqId, String account, String modelCode, String key, String value, String currency);
    void accountUpdateMultiEnd(int reqId);
    void securityDefinitionOptionalParameter(int reqId, String exchange, int underlyingConId, String tradingClass, String multiplier, Set<String> expirations, Set<Double> strikes);
    void securityDefinitionOptionalParameterEnd(int reqId);
	void softDollarTiers(int reqId, SoftDollarTier[] tiers);
}

