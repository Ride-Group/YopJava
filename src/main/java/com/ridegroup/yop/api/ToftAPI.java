package com.ridegroup.yop.api;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.ridegroup.yop.bean.BaseResultT;
import com.ridegroup.yop.bean.price.PriceNew;
import com.ridegroup.yop.bean.toft.AvailableService;
import com.ridegroup.yop.bean.toft.Nightfee;
import com.ridegroup.yop.client.LocalHttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;

import java.util.HashMap;
import java.util.Iterator;
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
     * @param city        城市
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
     * @return BaseResultT<Map<String, AvailableService>>
     */
    public static BaseResultT<Map<String, AvailableService>> getAvailableService(String accessToken) {
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI + "/v2/service")
                .addParameter("access_token", accessToken)
                .build();
        Map availableService = LocalHttpClient.executeJsonResult(httpUriRequest, Map.class);
        BaseResultT<Map<String, AvailableService>> result = new BaseResultT<>();

        Iterator<Map.Entry<String, Object>> it = availableService.entrySet().iterator();
        Map<String, AvailableService> cityList = new HashMap<>();
        result.setResult(cityList);
        while (it.hasNext()) {
            Map.Entry<String, Object> entry = it.next();
            if(entry.getKey().equals("code")) {
                result.setCode(entry.getValue().toString());
            } else if(entry.getKey().equals("msg")) {
                result.setMsg(entry.getValue().toString());
            } else {
                Map<String, Object> cityData = (Map<String, Object>) entry.getValue();
                if(cityData.get("product_list") instanceof JSONArray) {
                    continue;
                }
                AvailableService data = new AvailableService();
                data.setCity_short(cityData.get("short").toString());
                data.setEn(cityData.get("en").toString());
                data.setName(cityData.get("name").toString());
                data.setSupport_face_pay(Integer.parseInt(cityData.get("support_face_pay").toString()));
                data.setIs_oversea(Integer.parseInt(cityData.get("is_oversea").toString()));
                Map<String, String> pl = new HashMap<>();
                data.setProduct_list(pl);
                JSONObject jo = (JSONObject)cityData.get("product_list");
                for (Map.Entry entryPl : jo.entrySet()) {
                    pl.put(entryPl.getKey().toString(), entryPl.getValue().toString());
                }
                AvailableService.Position pos = new AvailableService.Position();
                JSONObject pjo = (JSONObject)cityData.get("position");
                pos.setLng(Double.valueOf(pjo.get("lng").toString()));
                pos.setLat(Double.valueOf(pjo.get("lat").toString()));
                data.setPosition(pos);
                cityList.put(entry.getKey(), data);
            }
        }
        return result;
    }

    /**
     * 获得夜间服务费
     *
     * @param accessToken accessToken
     * @param city        城市
     * @param type        产品类型
     * @param carTypeId   车型id
     * @return BaseResultT<Nightfee>
     */
    public static BaseResultT<Nightfee> getNightfee(String accessToken, String city, String type, String carTypeId) {
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI + "/v2/nightfee")
                .addParameter("access_token", accessToken)
                .addParameter("city", city)
                .addParameter("type", type)
                .addParameter("car_type_id", carTypeId)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, new TypeReference<BaseResultT<Nightfee>>(){});
    }
}
