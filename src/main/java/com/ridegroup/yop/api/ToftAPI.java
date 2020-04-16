package com.ridegroup.yop.api;

import com.ridegroup.yop.bean.price.PriceNew;
import com.ridegroup.yop.bean.toft.AvailableService;
import com.ridegroup.yop.client.LocalHttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * ToftAPI
 *
 * https://github.com/yongche/developer.yongche.com/wiki/service
 *
 * @author PeterZhang
 */
public class ToftAPI extends BaseAPI {
    private String accessToken;

    private static volatile ToftAPI instance = null;

    private ToftAPI(String accessToken) {
        this.accessToken = accessToken;
    }

    public static ToftAPI getInstance(String accessToken) {
        if (instance == null) {
            synchronized (ToftAPI.class) {
                if (instance == null) {
                    instance = new ToftAPI(accessToken);
                }
            }
        }
        return instance;
    }

    public PriceNew getPriceData(String city, String type) {
        return ToftAPI.getPrice(this.accessToken, city, type);
    }

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
     * 获取可用服务
     *
     * @param accessToken accessToken
     * @return AvailableService
     */
    public static Map getAvailableService(String accessToken) {
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI + "/v2/service")
                .addParameter("access_token", accessToken)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, Map.class);
    }
}
