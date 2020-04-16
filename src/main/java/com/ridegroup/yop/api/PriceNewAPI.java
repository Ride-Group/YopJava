package com.ridegroup.yop.api;

import com.alibaba.fastjson.TypeReference;
import com.ridegroup.yop.bean.BaseResult;
import com.ridegroup.yop.bean.BaseResultT;
import com.ridegroup.yop.bean.price.PriceNew;
import com.ridegroup.yop.bean.price.PriceNewT;
import com.ridegroup.yop.client.LocalHttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;

/**
 * PriceNew API
 *
 * @author PeterZhang
 */
public class PriceNewAPI extends BaseAPI {
    /**
     * 获取价格
     *
     * @param accessToken accessToken
     * @param city        city
     * @return PriceNew
     */
    public static PriceNew getPrice(String accessToken, String city, String type) {
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI + "/v2/priceNew/" + city)
                .addParameter("access_token", accessToken)
                .addParameter("type", type)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, PriceNew.class);
    }

    /**
     * 获取价格
     *
     * @param accessToken accessToken
     * @param city        city
     * @return PriceNew
     */
    public static BaseResultT<PriceNewT> getPriceType(String accessToken, String city, String type) {
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI + "/v2/priceNew/" + city)
                .addParameter("access_token", accessToken)
                .addParameter("type", type)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, new TypeReference<BaseResultT<PriceNewT>>(){});
    }
}
