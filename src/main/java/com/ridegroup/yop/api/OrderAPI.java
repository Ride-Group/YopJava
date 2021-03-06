package com.ridegroup.yop.api;

import com.alibaba.fastjson.TypeReference;
import com.ridegroup.yop.bean.BaseResult;
import com.ridegroup.yop.bean.BaseResultT;
import com.ridegroup.yop.bean.driver.DriverInfo;
import com.ridegroup.yop.bean.order.*;
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
     * @return BaseResultT&lt;OrderList&gt;
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
     * @return BaseResultT&lt;OrderInfo&gt;
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
     * @return BaseResultT&lt;AcceptedDriver&gt;
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

    /**
     * 获取订单司机详细信息
     *
     * @param accessToken accessToken
     * @param orderId 订单号
     * @return BaseResultT&lt;DriverInfo&gt;
     */
    public static BaseResultT<DriverInfo> getOrderDriverInfo(String accessToken, String orderId) {
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI + "/v2/driver/info")
                .addParameter("access_token", accessToken)
                .addParameter("order_id", orderId)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, new TypeReference<BaseResultT<DriverInfo>>(){});
    }

    /**
     * 选择司机
     *
     * @param accessToken accessToken
     * @param orderId 订单号
     * @param driverId 司机id
     * @param thirdPartyCoupon 优惠券金额
     * @return BaseResultT&lt;DriverInfo&gt;
     */
    public static BaseResult decisionDriver(String accessToken, String orderId, String driverId, String thirdPartyCoupon) {
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/v2/driver/decisionDriver")
                .addParameter("access_token", accessToken)
                .addParameter("order_id", orderId)
                .addParameter("driver_id", driverId)
                .addParameter("third_party_coupon", thirdPartyCoupon)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, BaseResult.class);
    }

    /**
     * 订单行驶轨迹
     *
     * @param accessToken accessToken
     * @param orderId 订单号
     * @param mapType 1：百度，2：火星 3-谷歌 默认值：1
     * @return BaseResultT&lt;List&lt;Position&gt;&gt;
     */
    public static BaseResultT<List<Position>> getOrderTrack(String accessToken, String orderId, String mapType) {
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI + "/v2/driver/orderTrack")
                .addParameter("access_token", accessToken)
                .addParameter("order_id", orderId)
                .addParameter("map_type", mapType)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, new TypeReference<BaseResultT<List<Position>>>(){});
    }

    /**
     * 司机位置
     *
     * @param accessToken accessToken
     * @param orderId 订单号
     * @param mapType 1：百度，2：火星 3-谷歌 默认值：1
     * @return BaseResultT&lt;Position&gt;
     */
    public static BaseResultT<Position> getDriverLocation(String accessToken, String orderId, String mapType) {
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI + "/v2/driver/location")
                .addParameter("access_token", accessToken)
                .addParameter("order_id", orderId)
                .addParameter("map_type", mapType)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, new TypeReference<BaseResultT<Position>>(){});
    }

    /**
     * 开发票
     *
     * @param accessToken accessToken
     * @param reqMap 请求参数
     * @return BaseResultT&lt;Position&gt;
     */
    public static BaseResult createReceipt(String accessToken, Map<String, Object> reqMap) {
        HttpEntity reqEntity = BaseAPI.getPostHttpEntity(accessToken, reqMap);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/v2/receipt/create")
                .setEntity(reqEntity)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, BaseResult.class);
    }

    /**
     * 取消订单
     *
     * @param accessToken accessToken
     * @param orderId 订单号
     * @param reasonId 取消理由id
     * @param otherReason 其他理由
     * @return BaseResultT&lt;CancelOrder&gt;
     */
    public static BaseResultT<CancelOrder> cancelOrder(String accessToken, String orderId, String reasonId, String otherReason) {
        HttpUriRequest httpUriRequest = RequestBuilder.delete()
                .setUri(BASE_URI + "/v2/order/" + orderId)
                .addParameter("access_token", accessToken)
                .addParameter("order_id", orderId)
                .addParameter("reason_id", reasonId)
                .addParameter("other_reason", otherReason)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, new TypeReference<BaseResultT<CancelOrder>>(){});
    }

    /**
     * 修改订单
     *
     * @param accessToken accessToken
     * @param orderId 订单号
     * @param reqMap 请求参数
     * @return BaseResultT&lt;UpdateOrder&gt;
     */
    public static BaseResultT<UpdateOrder> updateOrder(String accessToken, String orderId, Map<String, Object> reqMap) {
        HttpEntity reqEntity = BaseAPI.getPostHttpEntity(accessToken, reqMap);
        HttpUriRequest httpUriRequest = RequestBuilder.put()
                .setUri(BASE_URI + "/v2/order/" + orderId)
                .setEntity(reqEntity)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, new TypeReference<BaseResultT<UpdateOrder>>(){});
    }

    /**
     * 异常订单接口
     *
     * @param accessToken accessToken
     * @param orderId 订单ID
     * @param abnormalMark 订单异常状态，2： 客户设置的异常
     * @param abnormalMsg 异常原因
     * @return BaseResult
     */
    public static BaseResult abnormalOrder(String accessToken, String orderId, String abnormalMark, String abnormalMsg) {
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/v2/order/abnormal/" + orderId)
                .addParameter("access_token", accessToken)
                .addParameter("abnormal_mark", abnormalMark)
                .addParameter("abnormal_msg", abnormalMsg)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, BaseResult.class);
    }

    /**
     * 获得订单计费信息
     *
     * @param accessToken accessToken
     * @param orderId 订单ID
     * @return BaseResultT&lt;EstimateData&gt;
     */
    public static BaseResultT<EstimateData> getEstimateData(String accessToken, String orderId) {
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI + "/v2/order/calculate/" + orderId)
                .addParameter("access_token", accessToken)
                .addParameter("order_id", orderId)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, new TypeReference<BaseResultT<EstimateData>>(){});
    }

    /**
     * 获得订单取消费用
     *
     * @param accessToken accessToken
     * @param orderId 订单ID
     * @return BaseResultT&lt;CancelOrderFee&gt;
     */
    public static BaseResultT<CancelOrderFee> getCancelOrderFee(String accessToken, String orderId) {
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI + "/v2/cost/penalty")
                .addParameter("access_token", accessToken)
                .addParameter("order_id", orderId)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, new TypeReference<BaseResultT<CancelOrderFee>>(){});
    }

    /**
     * 获得评价标签
     *
     * @param accessToken accessToken
     * @return BaseResultT&lt;List&lt;CommentTag&gt;&gt;
     */
    public static BaseResultT<List<CommentTag>> getCommentTag(String accessToken) {
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI + "/v2/commentTags")
                .addParameter("access_token", accessToken)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, new TypeReference<BaseResultT<List<CommentTag>>>(){});
    }

    /**
     * 评价订单
     *
     * @param accessToken accessToken
     * @param reqMap 请求参数
     * @return BaseResult
     */
    public static BaseResult commentOrder(String accessToken, Map<String, Object> reqMap) {
        HttpEntity reqEntity = BaseAPI.getPostHttpEntity(accessToken, reqMap);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/v2/comment")
                .setEntity(reqEntity)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, BaseResult.class);
    }
}
