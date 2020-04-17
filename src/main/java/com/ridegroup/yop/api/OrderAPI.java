package com.ridegroup.yop.api;

import com.alibaba.fastjson.TypeReference;
import com.ridegroup.yop.bean.BaseResultT;
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
        URIBuilder uri = null;
        try {
            uri = new URIBuilder(BASE_URI + "/v2/order");
            List<NameValuePair> formParams = new ArrayList<NameValuePair>();
            formParams.add(new BasicNameValuePair("access_token", accessToken));

            Iterator iterator = reqMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = (Map.Entry<String, String>) iterator.next();
                formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            uri.addParameters(formParams);

            HttpUriRequest httpUriRequest = RequestBuilder.get()
                    .setUri(uri.build())
                    .build();
            return LocalHttpClient.executeJsonResult(httpUriRequest, new TypeReference<BaseResultT<OrderList>>(){});
        } catch (URISyntaxException e) {
            logger.error(e.toString());
        }
        return null;
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
}
