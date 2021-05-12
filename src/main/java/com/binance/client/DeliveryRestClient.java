package com.binance.client;

import com.alibaba.fastjson.JSONObject;
import com.binance.client.impl.BinanceApiInternalFactory;
import com.binance.client.impl.RestApiRequest;
import com.binance.client.model.ResponseResult;
import com.binance.client.model.enums.*;
import com.binance.client.model.market.*;
import com.binance.client.model.trade.*;

import java.util.List;

/**
 * Synchronous request interface, invoking Binance RestAPI via synchronous
 * method.<br>
 * All methods in this interface will be blocked until the RestAPI response.
 * <p>
 * If the invoking failed or timeout, the
 * {@link com.binance.client.exception.BinanceApiException} will be thrown.
 */
public interface DeliveryRestClient {

    /**
     * Create the synchronous client. All interfaces defined in synchronous client
     * are implemented by synchronous mode.
     *
     * @return The instance of synchronous client.
     */
    static DeliveryRestClient create() {
        return create("", "", new RequestOptions());
    }

    /**
     * Create the synchronous client. All interfaces defined in synchronous client
     * are implemented by synchronous mode.
     *
     * @param apiKey    The public key applied from binance.
     * @param secretKey The private key applied from binance.
     * @return The instance of synchronous client.
     */
    static DeliveryRestClient create(String apiKey, String secretKey) {
        return BinanceApiInternalFactory.getInstance().createDeliveryRestClient(apiKey, secretKey, new RequestOptions());
    }

    /**
     * Create the synchronous client. All interfaces defined in synchronous client
     * are implemented by synchronous mode.
     *
     * @param apiKey    The public key applied from binance.
     * @param secretKey The private key applied from binance.
     * @param options   The request option.
     * @return The instance of synchronous client.
     */
    static DeliveryRestClient create(String apiKey, String secretKey, RequestOptions options) {
        return BinanceApiInternalFactory.getInstance().createDeliveryRestClient(apiKey, secretKey, options);
    }


    /**
     * Get mark price for a symbol.
     *
     * @return Mark price for a symbol.
     */
    List<MarkPrice> getMarkPrice(String symbol);

    /**
     * Get latest price for a symbol or symbols.
     *
     * @return Latest price for a symbol or symbols.
     */
    List<SymbolPrice> getSymbolPriceTicker(String symbol);

    /**
     * Send in a new order.
     *
     * @return Order.
     */
    Order postOrder(String symbol, OrderSide side, PositionSide positionSide, OrderType orderType,
            TimeInForce timeInForce, String quantity, String price, String reduceOnly,
            String newClientOrderId, String stopPrice, WorkingType workingType, NewOrderRespType newOrderRespType);

    /**
     * Cancel an active order.
     *
     * @return Order.
     */
    Order cancelOrder(String symbol, Long orderId, String origClientOrderId);

    /**
     * Check an order's status.
     *
     * @return Order status.
     */
    Order getOrder(String symbol, Long orderId, String origClientOrderId);

    /**
     * Get position.
     *
     * @return Position.
     */
    List<PositionRisk> getPositionRisk();

    /**
     * Start user data stream.
     *
     * @return listenKey.
     */
    String startUserDataStream();

    /**
     * Keep user data stream.
     *
     * @return null.
     */
    String keepUserDataStream(String listenKey);

    /**
     * Close user data stream.
     *
     * @return null.
     */
    String closeUserDataStream(String listenKey);

    /**
     * Open Interest Stat (MARKET DATA)
     *
     * @return Open Interest Stat.
     */

    /**
     * Change margin type (ISOLATED, CROSSED)
     * @param symbolName
     * @param marginType
     * @return
     */
    ResponseResult changeMarginType(String symbolName, String marginType);

    /**
     * Get account balances.
     *
     * @return Balances.
     */
    List<AccountBalance> getBalance();

    /**
     * Get current account information.
     *
     * @return Current account information.
     */
    AccountInformation getAccountInformation();

    /**
     * Fetch current exchange trading rules and symbol information.
     *
     * @return Current exchange trading rules and symbol information.
     */
    ExchangeInformation getExchangeInformation();
}