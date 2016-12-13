package samples.testbed;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import samples.testbed.advisor.FAMethodSamples;
import samples.testbed.contracts.ContractSamples;
import samples.testbed.orders.AvailableAlgoParams;
import samples.testbed.orders.OrderSamples;
import samples.testbed.scanner.ScannerSubscriptionSamples;

import com.ib.client.Contract;
import com.ib.client.EClientSocket;
import com.ib.client.EReader;
import com.ib.client.EReaderSignal;
import com.ib.client.ExecutionFilter;
import com.ib.client.Order;
import com.ib.client.Types.FADataType;
import com.ib.controller.AccountSummaryTag;

public class Testbed {

    public static void main(String[] args) throws InterruptedException {

        EWrapperImpl wrapper = new EWrapperImpl();
        final EClientSocket m_client = wrapper.getClient();
        final EReaderSignal m_signal = wrapper.getSignal();
        //! [connect]
        m_client.eConnect("127.0.0.1", 7497, 0);
        //! [connect]
        //! [EReader]
        final EReader reader = new EReader(m_client, m_signal);
        reader.start();
        new Thread() {
            public void run() {
                while (m_client.isConnected()) {
                    m_signal.waitForSignal();
                    try {
//						System.out.println("reader.processMsgs(): START!");
                        reader.processMsgs();
//						System.out.println("reader.processMsgs(): OVER!");
                    } catch (Exception e) {
                        System.out.println("Exception: " + e.getMessage());
                    }
                }
            }
        }.start();
        //! [EReader]
        Thread.sleep(1000);

//        MySQLTest(m_client);

        //! [faordergrouppctchange]
//        Order faOrderGroupPC = OrderSamples.MarketOrder("BUY", 300);
//        // You should not specify any order quantity for PctChange allocation method
//        faOrderGroupPC.faGroup("IBTest");
//        faOrderGroupPC.faMethod("PctChange");
//        faOrderGroupPC.faPercentage("50");
//        m_client.placeOrder(1024, ContractSamples.YOUYIKUStock(), faOrderGroupPC);
        //! [faordergrouppctchange]

//        Order faOrderOneAccount = OrderSamples.MarketOrder("BUY", 200);
//        // Specify the Account Number directly
//        faOrderOneAccount.account("DU525700");
//        m_client.placeOrder(1111, ContractSamples.YOUYIKUStock(), faOrderOneAccount);

//        Order faOrderGroupEQ = OrderSamples.LimitOrder("BUY", 300, 184);
//        faOrderGroupEQ.faGroup("Group_Equal");
//        faOrderGroupEQ.faMethod("EqualQuantity");
//        m_client.placeOrder(1003, ContractSamples.TencentStock(), faOrderGroupEQ);
//        m_client.placeOrder(1001, ContractSamples.YOUYIKUStock(), faOrderGroupEQ);
//        m_client.placeOrder(1001, ContractSamples.YOUYIKUStock(), OrderSamples.Discretionary("SELL", 300, 27.30, 0.5));

//        Order faOrderEQ = OrderSamples.LimitOrder("SELL", 300, 27.10);
//        faOrderEQ.account("DU525698");
//        m_client.placeOrder(6605, ContractSamples.YOUYIKUStock(), faOrderGroupEQ);

        // 6288
//        Order faYouYiKuOrder = OrderSamples.LimitOrder("SELL", 300, 28.45);
//        faYouYiKuOrder.account("DU525700");
//        m_client.placeOrder(3135, ContractSamples.YOUYIKUStock(), faYouYiKuOrder);

        // cancel 6288
//        m_client.cancelOrder(1127);

        // VOW
//        Order faOrderOneAccount = OrderSamples.MarketOrder("BUY", 600);
////        // Specify the Account Number directly
//        faOrderOneAccount.account("DU525698");
//        m_client.placeOrder(6606, ContractSamples.VOWStock(), faOrderOneAccount);

//        Order faOrderOneAccount = OrderSamples.LimitOrder("SELL", 300, 130.111);
//        faOrderOneAccount.account("DU525698");
//        m_client.placeOrder(6607, ContractSamples.VOWStock(), faOrderOneAccount);

//        m_client.reqCurrentTime();
//        System.out.println("serverVersion = " + m_client.serverVersion());
//        System.out.println("TwsConnectionTime = " + m_client.TwsConnectionTime());

        // Call this function to calculate volatility for a supplied option price and underlying price
//        m_client.calculateImpliedVolatility(1286, ContractSamples.OptionAtBOX(), 5, 85);

        // Call this function to calculate option price and greek values for a supplied volatility and underlying price
//        m_client.calculateOptionPrice(1287, ContractSamples.OptionAtBOX(), 0.22, 85);

//        m_client.reqMarketDataType(1);
//        m_client.reqMktData(1289, ContractSamples.Commodity(), "", false, null);

        // Call the exerciseOptions() method to exercise options. Failed!
//        m_client.exerciseOptions(1298, ContractSamples.OptionWithTradingClass(), 1, 1, "DU525701", 1);

//        m_client.reqGlobalCancel();

        // reqMktDepth and cancelMktDepth
//        marketDepthOperations(m_client, wrapper.getCurrentOrderId());

        //--------------------------------------------------------------------
//		orderOperations(m_client, wrapper.getCurrentOrderId());
//		contractOperations(m_client, wrapper.getCurrentOrderId());
//        contractNewsFeed(m_client, wrapper.getCurrentOrderId());
//        hedgeSample(m_client, 4635);
        //testAlgoSamples(m_client, wrapper.getCurrentOrderId());
        //bracketSample(m_client, wrapper.getCurrentOrderId());
//        bulletins(m_client);
        //reutersFundamentals(m_client);
//        marketDataType(m_client);
//        historicalDataRequests(m_client);
//        realTimeBars(m_client);
//        accountOperations(m_client);

//        /*** Subscribing to an account's information. Only one at a time! ***/
//        Thread.sleep(2000);
//        m_client.reqAccountUpdates(true, "DU525700");

//        m_client.reqExecutions(1300, new ExecutionFilter());

//        Thread.sleep(2000);
//        m_client.reqAccountSummary(1004, "Group_Equal", "$LEDGER");
//        Thread.sleep(2000);
//        m_client.reqAccountSummary(1012, "All", "$LEDGER:EUR");
//        Thread.sleep(2000);
//        m_client.reqAccountSummary(1013, "All", "$LEDGER:ALL");

        /*** Requesting managed accounts***/
//        m_client.reqManagedAccts();

        /*** Requesting accounts' summary ***/
//        Thread.sleep(2000);
//        m_client.reqAccountSummary(wrapper.getCurrentOrderId(), "All", "AccountType,NetLiquidation,BuyingPower");
//        Thread.sleep(2000);
//        m_client.reqAccountSummary(1011, "All", "AccountType,NetLiquidation,TotalCashValue,SettledCash,AccruedCash,BuyingPower,EquityWithLoanValue,PreviousEquityWithLoanValue,GrossPositionValue,ReqTEquity,ReqTMargin,SMA,InitMarginReq,MaintMarginReq,AvailableFunds,ExcessLiquidity,Cushion,FullInitMarginReq,FullMaintMarginReq,FullAvailableFunds,FullExcessLiquidity,LookAheadNextChange,LookAheadInitMarginReq ,LookAheadMaintMarginReq,LookAheadAvailableFunds,LookAheadExcessLiquidity,HighestSeverity,DayTradesRemaining,Leverage");
//        m_client.cancelAccountSummary(1011);

//        financialAdvisorOperations(m_client);

        /*** Requesting all accounts' positions. ***/
//        m_client.reqPositions();
//        Thread.sleep(5000);
//        m_client.cancelPositions();

        Thread.sleep(20000);
        m_client.eDisconnect();
    }

    private static void MySQLTest(EClientSocket m_client) {
        // 驱动程序名
        String driver = "com.mysql.jdbc.Driver";
        // URL指向要访问的数据库名mysql
        String url = "jdbc:mysql://127.0.0.1:3306/mysql?characterEncoding=utf-8&useSSL=false";
        // MySQL配置时的用户名
        String user = "root";
        // MySQL配置时的密码
        String password = "fansen@1992";

        try {
            // 加载驱动程序
            Class.forName(driver);
            // 连接数据库
            Connection conn = DriverManager.getConnection(url, user, password);
            if (!conn.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            // statement用来执行SQL语句
            Statement statement = conn.createStatement();

//            // 更新数据库
//            // 要执行的SQL语句
//            String sql = "update ibtest set id=1009, quantity=300, secType ='STK', currency='HKD'," +
//                    " exchange='SEHK', symbol='6288', action='SELL', orderType='MKT', account='DU525700', status='233' WHERE 1";
//            // 结果集
//            System.out.println("executeUpdate = " + statement.executeUpdate(sql));

            // 要执行的SQL语句
            String sql = "select * from ibtest";
            // 结果集
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                String action = resultSet.getString("action");
                String orderType = resultSet.getString("orderType");
                String account = resultSet.getString("account");
                int id = resultSet.getInt("id");
                int quantity = resultSet.getInt("quantity");
                String symbol = resultSet.getString("symbol");
                String secType = resultSet.getString("secType");
                String currency = resultSet.getString("currency");
                String exchange = resultSet.getString("exchange");

                // 输出结果
                System.out.println(action + "\t" + orderType + "\t" + id + "\t" + quantity + "\t" + symbol + "\t" + secType + "\t" + currency + "\t" + exchange);

                // 参考，VOW
//                Order faOrderOneAccount = OrderSamples.MarketOrder("BUY", 600);
//                faOrderOneAccount.account("DU525698");
//                m_client.placeOrder(6606, ContractSamples.VOWStock(), faOrderOneAccount);

//        Order faOrderGroupEQ = OrderSamples.LimitOrder("BUY", 300, 184);
//        faOrderGroupEQ.faGroup("Group_Equal");
//        faOrderGroupEQ.faMethod("EqualQuantity");
//        m_client.placeOrder(1003, ContractSamples.TencentStock(), faOrderGroupEQ);

                // MySQL Test
                Order MySQLTestOrder = new Order();
                MySQLTestOrder.action(action);
                MySQLTestOrder.orderType(orderType);
                MySQLTestOrder.totalQuantity(quantity);
//                MySQLTestOrder.account(account);
                MySQLTestOrder.faGroup("Group_Equal");
                MySQLTestOrder.faMethod("EqualQuantity");
                MySQLTestOrder.lmtPrice(184);

                Contract VOWContract = new Contract();
                VOWContract.symbol(symbol);
                VOWContract.secType(secType);
                VOWContract.currency(currency);
                VOWContract.exchange(exchange);
                m_client.placeOrder(id, VOWContract, MySQLTestOrder);
            }

            resultSet.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void orderOperations(EClientSocket client, int nextOrderId) throws InterruptedException {

        /*** Requesting the next valid id ***/
        //The parameter is always ignored.
        client.reqIds(-1);

        //Thread.sleep(1000);
        /*** Requesting all open orders ***/
        client.reqAllOpenOrders();
        //Thread.sleep(1000);
        /*** Taking over orders to be submitted via TWS ***/
        client.reqAutoOpenOrders(true);
        //Thread.sleep(1000);
        /*** Requesting this API client's orders ***/
        client.reqOpenOrders();

        /*** Placing/modifying an order - remember to ALWAYS increment the nextValidId after placing an order so it can be used for the next one! ***/
        //! [order_submission]
        client.placeOrder(nextOrderId++, ContractSamples.USStock(), OrderSamples.LimitOrder("SELL", 1, 50));
        //! [order_submission]

        //! [faorderoneaccount]
        Order faOrderOneAccount = OrderSamples.MarketOrder("BUY", 100);
        // Specify the Account Number directly
        faOrderOneAccount.account("DU119915");
        client.placeOrder(nextOrderId++, ContractSamples.USStock(), faOrderOneAccount);
        //! [faorderoneaccount]

        //! [faordergroupequalquantity]
        Order faOrderGroupEQ = OrderSamples.LimitOrder("SELL", 200, 2000);
        faOrderGroupEQ.faGroup("Group_Equal_Quantity");
        faOrderGroupEQ.faMethod("EqualQuantity");
        client.placeOrder(nextOrderId++, ContractSamples.USStock(), faOrderGroupEQ);
        //! [faordergroupequalquantity]

        //! [faordergrouppctchange]
        Order faOrderGroupPC = OrderSamples.MarketOrder("BUY", 200);
        // You should not specify any order quantity for PctChange allocation method
        faOrderGroupPC.faGroup("Pct_Change");
        faOrderGroupPC.faMethod("PctChange");
        faOrderGroupPC.faPercentage("100");
        client.placeOrder(nextOrderId++, ContractSamples.EurGbpFx(), faOrderGroupPC);
        //! [faordergrouppctchange]

        //! [faorderprofile]
        Order faOrderProfile = OrderSamples.LimitOrder("BUY", 200, 100);
        faOrderProfile.faProfile("Percent_60_40");
        client.placeOrder(nextOrderId++, ContractSamples.EuropeanStock(), faOrderProfile);
        //! [faorderprofile]

        //client.placeOrder(nextOrderId++, ContractSamples.USStock(), OrderSamples.PeggedToMarket("BUY", 10, 0.01));
        //client.placeOrder(nextOrderId++, ContractSamples.EurGbpFx(), OrderSamples.MarketOrder("BUY", 10));
        //client.placeOrder(nextOrderId++, ContractSamples.USStock(), OrderSamples.Discretionary("SELL", 1, 45, 0.5));

        //! [reqexecutions]
        client.reqExecutions(10001, new ExecutionFilter());
        //! [reqexecutions]

        Thread.sleep(10000);
    }

    private static void OcaSample(EClientSocket client, int nextOrderId) {

        //OCA order
        //! [ocasubmit]
        List<Order> OcaOrders = new ArrayList<Order>();
        OcaOrders.add(OrderSamples.LimitOrder("BUY", 1, 10));
        OcaOrders.add(OrderSamples.LimitOrder("BUY", 1, 11));
        OcaOrders.add(OrderSamples.LimitOrder("BUY", 1, 12));
        OcaOrders = OrderSamples.OneCancelsAll("TestOCA_" + nextOrderId, OcaOrders, 2);
        for (Order o : OcaOrders) {

            client.placeOrder(nextOrderId++, ContractSamples.USStock(), o);
        }
        //! [ocasubmit]

    }

    private static void tickDataOperations(EClientSocket client) throws InterruptedException {

        /*** Requesting real time market data ***/
        //Thread.sleep(1000);
        //! [reqmktdata]
        client.reqMktData(1001, ContractSamples.StockComboContract(), "", false, null);
        //! [reqmktdata]

        //! [reqmktdata_snapshot]
        client.reqMktData(1003, ContractSamples.FutureComboContract(), "", true, null);
        //! [reqmktdata_snapshot]

        //! [reqmktdata_genticks]
        //Requesting RTVolume (Time & Sales), shortable and Fundamental Ratios generic ticks
        client.reqMktData(1004, ContractSamples.USStock(), "233,236,258", false, null);
        //! [reqmktdata_genticks]
        //! [reqmktdata_contractnews]
        client.reqMktData(1005, ContractSamples.USStock(), "mdoff,292:BZ", false, null);
        client.reqMktData(1006, ContractSamples.USStock(), "mdoff,292:BT", false, null);
        client.reqMktData(1007, ContractSamples.USStock(), "mdoff,292:FLY", false, null);
        client.reqMktData(1008, ContractSamples.USStock(), "mdoff,292:MT", false, null);
        //! [reqmktdata_contractnews]
        //! [reqmktdata_broadtapenews]
        client.reqMktData(1009, ContractSamples.BTbroadtapeNewsFeed(), "mdoff,292", false, null);
        client.reqMktData(1010, ContractSamples.BZbroadtapeNewsFeed(), "mdoff,292", false, null);
        client.reqMktData(1011, ContractSamples.FLYbroadtapeNewsFeed(), "mdoff,292", false, null);
        client.reqMktData(1012, ContractSamples.MTbroadtapeNewsFeed(), "mdoff,292", false, null);
        //! [reqmktdata_broadtapenews]
        //! [reqoptiondatagenticks]
        //Requesting data for an option contract will return the greek values
        client.reqMktData(1002, ContractSamples.OptionWithLocalSymbol(), "", false, null);
        //! [reqoptiondatagenticks]

        Thread.sleep(10000);
        //! [cancelmktdata]
        client.cancelMktData(1001);
        client.cancelMktData(1002);
        client.cancelMktData(1003);
        //! [cancelmktdata]

    }

    private static void historicalDataRequests(EClientSocket client) throws InterruptedException {

        /*** Requesting historical data ***/
        //! [reqhistoricaldata]
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -6);
        SimpleDateFormat form = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        String formatted = form.format(cal.getTime());
        client.reqHistoricalData(2003, ContractSamples.Commodity(), formatted, "1 M", "1 day", "MIDPOINT", 1, 1, null);
//        client.reqHistoricalData(2002, ContractSamples.EuropeanStock(), formatted, "10 D", "1 min", "TRADES", 1, 1, null);
        Thread.sleep(4000);
        /*** Canceling historical data requests ***/
        client.cancelHistoricalData(2003);
//        client.cancelHistoricalData(2002);
        //! [reqhistoricaldata]

    }

    private static void realTimeBars(EClientSocket client) throws InterruptedException {

        /*** Requesting real time bars ***/
        //! [reqrealtimebars]
        client.reqRealTimeBars(3001, ContractSamples.Commodity(), 5, "MIDPOINT", true, null);
        //! [reqrealtimebars]
        Thread.sleep(5000);
        /*** Canceling real time bars ***/
        //! [cancelrealtimebars]
        client.cancelRealTimeBars(3001);
        //! [cancelrealtimebars]

    }

    private static void marketDepthOperations(EClientSocket client, int nextOrderId) throws InterruptedException {

        /*** Requesting the Deep Book ***/
        //! [reqmarketdepth]
        client.reqMktDepth(nextOrderId, ContractSamples.Commodity(), 10, null);
        //! [reqmarketdepth]
        Thread.sleep(2000);
        /*** Canceling the Deep Book request ***/
        //! [cancelmktdepth]
        client.cancelMktDepth(nextOrderId);
        //! [cancelmktdepth]
    }

    private static void accountOperations(EClientSocket client) throws InterruptedException {

        //client.reqAccountUpdatesMulti(9002, null, "EUstocks", true);
        //! [reqpositionsmulti]
        client.reqPositionsMulti(9003, "DU74649", "EUstocks");
        //! [reqpositionsmulti]
        Thread.sleep(10000);

        /*** Requesting managed accounts***/
        //! [reqmanagedaccts]
        client.reqManagedAccts();
        //! [reqmanagedaccts]
        /*** Requesting accounts' summary ***/
        Thread.sleep(2000);
        //! [reqaaccountsummary]
        client.reqAccountSummary(9001, "All", "AccountType,NetLiquidation,TotalCashValue,SettledCash,AccruedCash,BuyingPower,EquityWithLoanValue,PreviousEquityWithLoanValue,GrossPositionValue,ReqTEquity,ReqTMargin,SMA,InitMarginReq,MaintMarginReq,AvailableFunds,ExcessLiquidity,Cushion,FullInitMarginReq,FullMaintMarginReq,FullAvailableFunds,FullExcessLiquidity,LookAheadNextChange,LookAheadInitMarginReq ,LookAheadMaintMarginReq,LookAheadAvailableFunds,LookAheadExcessLiquidity,HighestSeverity,DayTradesRemaining,Leverage");
        //! [reqaaccountsummary]

        //! [reqaaccountsummaryledger]
        client.reqAccountSummary(9002, "All", "$LEDGER");
        //! [reqaaccountsummaryledger]
        Thread.sleep(2000);
        //! [reqaaccountsummaryledgercurrency]
        client.reqAccountSummary(9003, "All", "$LEDGER:EUR");
        //! [reqaaccountsummaryledgercurrency]
        Thread.sleep(2000);
        //! [reqaaccountsummaryledgerall]
        client.reqAccountSummary(9004, "All", "$LEDGER:ALL");
        //! [reqaaccountsummaryledgerall]

        //! [cancelaaccountsummary]
        client.cancelAccountSummary(9001);
        client.cancelAccountSummary(9002);
        client.cancelAccountSummary(9003);
        client.cancelAccountSummary(9004);
        //! [cancelaaccountsummary]

        /*** Subscribing to an account's information. Only one at a time! ***/
        Thread.sleep(2000);
        //! [reqaaccountupdates]
        client.reqAccountUpdates(true, "U150462");
        //! [reqaaccountupdates]
        Thread.sleep(2000);
        //! [cancelaaccountupdates]
        client.reqAccountUpdates(false, "U150462");
        //! [cancelaaccountupdates]

        //! [reqaaccountupdatesmulti]
        client.reqAccountUpdatesMulti(9002, "U150462", "EUstocks", true);
        //! [reqaaccountupdatesmulti]
        Thread.sleep(2000);
        /*** Requesting all accounts' positions. ***/
        //! [reqpositions]
        client.reqPositions();
        //! [reqpositions]
        Thread.sleep(2000);
        //! [cancelpositions]
        client.cancelPositions();
        //! [cancelpositions]
    }

    private static void conditionSamples(EClientSocket client, int nextOrderId) {

        //! [order_conditioning_activate]
        Order mkt = OrderSamples.MarketOrder("BUY", 100);
        //Order will become active if conditioning criteria is met
        mkt.conditionsCancelOrder(true);
        mkt.conditions().add(OrderSamples.PriceCondition(208813720, "SMART", 600, false, false));
        mkt.conditions().add(OrderSamples.ExecutionCondition("EUR.USD", "CASH", "IDEALPRO", true));
        mkt.conditions().add(OrderSamples.MarginCondition(30, true, false));
        mkt.conditions().add(OrderSamples.PercentageChangeCondition(15.0, 208813720, "SMART", true, true));
        mkt.conditions().add(OrderSamples.TimeCondition("20160118 23:59:59", true, false));
        mkt.conditions().add(OrderSamples.VolumeCondition(208813720, "SMART", false, 100, true));
        client.placeOrder(nextOrderId++, ContractSamples.EuropeanStock(), mkt);
        //! [order_conditioning_activate]

        //Conditions can make the order active or cancel it. Only LMT orders can be conditionally canceled.
        //! [order_conditioning_cancel]
        Order lmt = OrderSamples.LimitOrder("BUY", 100, 20);
        //The active order will be cancelled if conditioning criteria is met
        lmt.conditionsCancelOrder(true);
        lmt.conditions().add(OrderSamples.PriceCondition(208813720, "SMART", 600, false, false));
        client.placeOrder(nextOrderId++, ContractSamples.EuropeanStock(), lmt);
        //! [order_conditioning_cancel]

    }

    private static void contractOperations(EClientSocket client, int nextOrderId) {

        //! [reqcontractdetails]
        client.reqContractDetails(nextOrderId++, ContractSamples.OptionForQuery());
        //! [reqcontractdetails]

    }

    private static void contractNewsFeed(EClientSocket client, int nextOrderId) {
        //! [reqcontractdetailsnews]
        client.reqContractDetails(nextOrderId++, ContractSamples.YOUYIKUStock());
        //! [reqcontractdetailsnews]
    }

    private static void hedgeSample(EClientSocket client, int nextOrderId) throws InterruptedException {

        //F Hedge order
        //! [hedgesubmit]
        //Parent order on a contract which currency differs from your base currency
        Order parent = OrderSamples.LimitOrder("BUY", 100, 10);
        parent.orderId(nextOrderId++);
        //Hedge on the currency conversion
        Order hedge = OrderSamples.MarketFHedge(parent.orderId(), "BUY");
        //Place the parent first...
        client.placeOrder(parent.orderId(), ContractSamples.EuropeanStock(), parent);
        //Then the hedge order
        client.placeOrder(nextOrderId++, ContractSamples.EurGbpFx(), hedge);
        //! [hedgesubmit]

    }

    private static void testAlgoSamples(EClientSocket client, int nextOrderId) throws InterruptedException {

        //! [algo_base_order]
        Order baseOrder = OrderSamples.LimitOrder("BUY", 1000, 1);
        //! [algo_base_order]

        //! [arrivalpx]
        AvailableAlgoParams.FillArrivalPriceParams(baseOrder, 0.1, "Aggressive", "09:00:00 CET", "16:00:00 CET", true, true);
        client.placeOrder(nextOrderId++, ContractSamples.USStockAtSmart(), baseOrder);
        //! [arrivalpx]

        Thread.sleep(500);

        //! [darkice]
        AvailableAlgoParams.FillDarkIceParams(baseOrder, 10, "09:00:00 CET", "16:00:00 CET", true);
        client.placeOrder(nextOrderId++, ContractSamples.USStockAtSmart(), baseOrder);
        //! [darkice]

        Thread.sleep(500);

        //! [ad]
        AvailableAlgoParams.FillAccumulateDistributeParams(baseOrder, 10, 60, true, true, 1, true, true, "09:00:00 CET", "16:00:00 CET");
        client.placeOrder(nextOrderId++, ContractSamples.USStockAtSmart(), baseOrder);
        //! [ad]

        Thread.sleep(500);

        //! [twap]
        AvailableAlgoParams.FillTwapParams(baseOrder, "Marketable", "09:00:00 CET", "16:00:00 CET", true);
        client.placeOrder(nextOrderId++, ContractSamples.USStockAtSmart(), baseOrder);
        //! [twap]

        Thread.sleep(500);

        //! [vwap]
        AvailableAlgoParams.FillVwapParams(baseOrder, 0.2, "09:00:00 CET", "16:00:00 CET", true, true);
        client.placeOrder(nextOrderId++, ContractSamples.USStockAtSmart(), baseOrder);
        //! [vwap]

        Thread.sleep(500);

        //! [balanceimpactrisk]
        AvailableAlgoParams.FillBalanceImpactRiskParams(baseOrder, 0.1, "Aggressive", true);
        client.placeOrder(nextOrderId++, ContractSamples.USOptionContract(), baseOrder);
        //! [balanceimpactrisk]

        Thread.sleep(500);

        //! [minimpact]
        AvailableAlgoParams.FillMinImpactParams(baseOrder, 0.3);
        client.placeOrder(nextOrderId++, ContractSamples.USOptionContract(), baseOrder);
        //! [minimpact]

        //! [adaptive]
        AvailableAlgoParams.FillAdaptiveParams(baseOrder, "Normal");
        client.placeOrder(nextOrderId++, ContractSamples.USStockAtSmart(), baseOrder);
        //! [adaptive]

    }

    private static void bracketSample(EClientSocket client, int nextOrderId) throws InterruptedException {

        //BRACKET ORDER
        //! [bracketsubmit]
        List<Order> bracket = OrderSamples.BracketOrder(nextOrderId++, "BUY", 100, 30, 40, 20);
        for (Order o : bracket) {
            client.placeOrder(o.orderId(), ContractSamples.EuropeanStock(), o);
        }
        //! [bracketsubmit]

    }

    private static void bulletins(EClientSocket client) throws InterruptedException {

        //! [reqnewsbulletins]
        client.reqNewsBulletins(true);
        //! [reqnewsbulletins]

        Thread.sleep(2000);

        //! [cancelnewsbulletins]
        client.cancelNewsBulletins();
        //! [cancelnewsbulletins]

    }

    private static void reutersFundamentals(EClientSocket client) throws InterruptedException {

        //! [reqfundamentaldata]
        client.reqFundamentalData(8001, ContractSamples.USStock(), "ReportsFinSummary");
        //! [reqfundamentaldata]

        Thread.sleep(2000);

        //! [fundamentalexamples]
        client.reqFundamentalData(8002, ContractSamples.USStock(), "ReportSnapshot"); //for company overview
        client.reqFundamentalData(8003, ContractSamples.USStock(), "ReportRatios"); //for financial ratios
        client.reqFundamentalData(8004, ContractSamples.USStock(), "ReportsFinStatements"); //for financial statements
        client.reqFundamentalData(8005, ContractSamples.USStock(), "RESC"); //for analyst estimates
        client.reqFundamentalData(8006, ContractSamples.USStock(), "CalendarReport"); //for company calendar
        //! [fundamentalexamples]

        //! [cancelfundamentaldata]
        client.cancelFundamentalData(8001);
        //! [cancelfundamentaldata]

    }

    private static void marketScanners(EClientSocket client) throws InterruptedException {

        /*** Requesting all available parameters which can be used to build a scanner request ***/
        //! [reqscannerparameters]
        client.reqScannerParameters();
        //! [reqscannerparameters]
        Thread.sleep(2000);

        /*** Triggering a scanner subscription ***/
        //! [reqscannersubscription]
        client.reqScannerSubscription(7001, ScannerSubscriptionSamples.HighOptVolumePCRatioUSIndexes(), null);
        //! [reqscannersubscription]

        Thread.sleep(2000);
        /*** Canceling the scanner subscription ***/
        //! [cancelscannersubscription]
        client.cancelScannerSubscription(7001);
        //! [cancelscannersubscription]

    }

    private static void financialAdvisorOperations(EClientSocket client) {
        /*** Requesting FA information ***/
        System.out.println("FADataType.ALIASES!");
        client.requestFA(FADataType.ALIASES.ordinal());
        System.out.println("FADataType.GROUPS!");
        client.requestFA(FADataType.GROUPS.ordinal());
        System.out.println("FADataType.PROFILES!");
        client.requestFA(FADataType.PROFILES.ordinal());

        /*** Replacing FA information - Fill in with the appropriate XML string. ***/
//        client.replaceFA(FADataType.GROUPS.ordinal(), FAMethodSamples.FaOneGroup);
        client.replaceFA(FADataType.GROUPS.ordinal(), FAMethodSamples.FaTwoGroups);
//        client.replaceFA(FADataType.PROFILES.ordinal(), FAMethodSamples.FaOneProfile);
        client.replaceFA(FADataType.PROFILES.ordinal(), FAMethodSamples.FaTwoProfiles);
    }

    private static void testDisplayGroups(EClientSocket client) throws InterruptedException {

        //! [querydisplaygroups]
        client.queryDisplayGroups(9001);
        //! [querydisplaygroups]

        Thread.sleep(500);

        //! [subscribetogroupevents]
        client.subscribeToGroupEvents(9002, 1);
        //! [subscribetogroupevents]

        Thread.sleep(500);

        //! [updatedisplaygroup]
        client.updateDisplayGroup(9002, "8314@SMART");
        //! [updatedisplaygroup]

        Thread.sleep(500);

        //! [subscribefromgroupevents]
        client.unsubscribeFromGroupEvents(9002);
        //! [subscribefromgroupevents]

    }

    private static void marketDataType(EClientSocket client) {

        //! [reqmarketdatatype]
        /*** Switch to live (1) frozen (2) delayed (3) or delayed frozen (4)***/
        client.reqMarketDataType(2);
        //! [reqmarketdatatype]

    }

    private static void optionsOperations(EClientSocket client) {

        //! [reqsecdefoptparams]
        client.reqSecDefOptParams(0, "IBM", "", "STK", 8314);
        //! [reqsecdefoptparams]

        //! [calculateimpliedvolatility]
        client.calculateImpliedVolatility(5001, ContractSamples.OptionAtBOX(), 5, 85);
        //! [calculateimpliedvolatility]

        //** Canceling implied volatility ***
        client.cancelCalculateImpliedVolatility(5001);

        //! [calculateoptionprice]
        client.calculateOptionPrice(5002, ContractSamples.OptionAtBOX(), 0.22, 85);
        //! [calculateoptionprice]

        //** Canceling option's price calculation ***
        client.cancelCalculateOptionPrice(5002);

        //! [exercise_options]
        //** Exercising options ***
        client.exerciseOptions(5003, ContractSamples.OptionWithTradingClass(), 1, 1, "", 1);
        //! [exercise_options]
    }

}
