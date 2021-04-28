package com.binance.client.impl;

import com.binance.client.DeliveryRestClient;
import com.binance.client.model.enums.*;
import com.binance.client.model.market.*;
import com.binance.client.model.trade.*;

import java.util.List;

public class DeliveryRestClientImpl implements DeliveryRestClient {

    private final RestApiRequestImpl requestImpl;

    DeliveryRestClientImpl(RestApiRequestImpl requestImpl) {
        this.requestImpl = requestImpl;
    }

    @Override
    public List<MarkPrice> getMarkPrice(String symbol) {
        return RestApiInvoker.callSync(requestImpl.getDMarkPrice(symbol));
    }
    
    @Override
    public Order postOrder(String symbol, OrderSide side, PositionSide positionSide, OrderType orderType,
            TimeInForce timeInForce, String quantity, String price, String reduceOnly,
            String newClientOrderId, String stopPrice, WorkingType workingType, NewOrderRespType newOrderRespType) {
        return RestApiInvoker.callSync(requestImpl.postDOrder(symbol, side, positionSide, orderType,
                timeInForce, quantity, price, reduceOnly, 
                newClientOrderId, stopPrice, workingType,newOrderRespType));
    }
    
    @Override
    public Order cancelOrder(String symbol, Long orderId, String origClientOrderId) {
        return RestApiInvoker.callSync(requestImpl.cancelDOrder(symbol, orderId, origClientOrderId));
    }

    @Override
    public Order getOrder(String symbol, Long orderId, String origClientOrderId) {
        return RestApiInvoker.callSync(requestImpl.getDOrder(symbol, orderId, origClientOrderId));
    }

    @Override
    public List<SymbolPrice> getSymbolPriceTicker(String symbol) {
        return RestApiInvoker.callSync(requestImpl.getDSymbolPriceTicker(symbol));
    }

    @Override
    public List<PositionRisk> getPositionRisk(){
        return RestApiInvoker.callSync(requestImpl.getDPositionRisk());
    }
}
