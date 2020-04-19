package com.ridegroup.yop.api;

import com.alibaba.fastjson.TypeReference;
import com.ridegroup.yop.bean.BaseResultT;
import com.ridegroup.yop.bean.order.AcceptedDriver;
import com.ridegroup.yop.bean.order.CreateOrderResult;
import com.ridegroup.yop.bean.order.OrderInfo;
import com.ridegroup.yop.bean.order.OrderList;
import com.ridegroup.yop.client.LocalHttpClient;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Order API
 *
 * https://github.com/yongche/developer.yongche.com/wiki/order#getDriverInfo
 *
 * @author PeterZhang
 */
public class OrderAPI extends BaseAPI {
    private static Logger logger = LoggerFactory.getLogger(OrderAPI.class);
    /**
     * 获得订单列表
     *
     * @param accessToken accessToken
     * @param reqMap 请求参数
     * @return BaseResultT<OrderList>
     */
    public static BaseResultT<OrderList> getOrderList(String accessToken, Map<String, Object> reqMap) {
        String uri = BaseAPI.getUri("/v2/order", accessToken, reqMap);

        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(uri)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, new TypeReference<BaseResultT<OrderList>>(){});
    }

    /**
     * 获得单一订单信息
     *
     * @param accessToken accessToken
     * @param orderId     订单号
     * @return BaseResultT<OrderInfo>
     */
    public static BaseResultT<OrderInfo> getOrderInfo(String accessToken, String orderId) {
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI + "/v2/order/" + orderId)
                .addParameter("access_token", accessToken)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, new TypeReference<BaseResultT<OrderInfo>>(){});
    }

    /**
     * 创建订单
     *
     * @param accessToken accessToken
     * @param reqMap 请求参数
     * @return CreateOrderResult
     */
    public static CreateOrderResult createOrder(String accessToken, Map<String, Object> reqMap) {
        HttpEntity reqEntity = BaseAPI.getPostHttpEntity(accessToken, reqMap);
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(10000)
                .setConnectTimeout(3000)
                .setConnectionRequestTimeout(10000)
                .build();

        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/v2/order")
                .setEntity(reqEntity)
                .setConfig(requestConfig)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, CreateOrderResult.class);
    }

    /**
     * 获取司机列表
     * 企业帐户中设置为允许用户选司机本接口才可用
     *
     * @param accessToken accessToken
     * @param orderId 订单号
     * @param driverIds 不想获取的司机id列表
     * @param mapType 1：百度，2：火星 3-谷歌 默认值：1
     * @return BaseResultT<AcceptedDriver>
     */
    public static BaseResultT<AcceptedDriver> getSelectDriver(String accessToken, String orderId, String driverIds, String mapType) {
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI + "/v2/driver/getSelectDriver")
                .addParameter("access_token", accessToken)
                .addParameter("order_id", orderId)
                .addParameter("driver_ids", driverIds)
                .addParameter("map_type", mapType)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, new TypeReference<BaseResultT<AcceptedDriver>>(){});
    }
}
