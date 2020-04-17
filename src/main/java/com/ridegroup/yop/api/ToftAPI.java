package com.ridegroup.yop.api;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.ridegroup.yop.bean.BaseResultT;
import com.ridegroup.yop.bean.price.PriceNew;
import com.ridegroup.yop.bean.toft.*;
import com.ridegroup.yop.client.LocalHttpClient;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * ToftAPI
 *
 * https://github.com/yongche/developer.yongche.com/wiki/service
 *
 * @author PeterZhang
 */
public class ToftAPI extends BaseAPI {
    private static Logger logger = LoggerFactory.getLogger(ToftAPI.class);

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

    public PriceNew getPriceData(String city, String type, String airCode) {
        return ToftAPI.getPrice(this.accessToken, city, type, airCode);
    }

    /**
     * 获取价格
     *
     * @param accessToken accessToken
     * @param city        城市
     * @param type        产品类型
     * @param airCode     机场三字码，接送机必传
     * @return PriceNew
     */
    public static PriceNew getPrice(String accessToken, String city, String type, String airCode) {
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI + "/v2/priceNew/" + city)
                .addParameter("access_token", accessToken)
                .addParameter("type", type)
                .addParameter("aircode", airCode)
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

    /**
     * 获得机场信息
     *
     * @param accessToken accessToken
     * @param mapType     地图类型 1-百度 2-火星 3-谷歌 默认 1-百度
     * @return Map<String, BaseResultT<Airport>>
     */
    public static BaseResultT<Map<String, Airport>> getAirport(String accessToken, String mapType) {
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI + "/v2/airport")
                .addParameter("access_token", accessToken)
                .addParameter("map_type", mapType)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, new TypeReference<BaseResultT<Map<String, Airport>>>(){});
    }

    /**
     * 获得火车站信息
     *
     * @param accessToken accessToken
     * @param mapType     地图类型 1-百度 2-火星 3-谷歌 默认 1-百度
     * @return Map<String, BaseResultT<Train>>
     */
    public static BaseResultT<Map<String, Train>> getTrain(String accessToken, String mapType) {
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI + "/v2/train")
                .addParameter("access_token", accessToken)
                .addParameter("map_type", mapType)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, new TypeReference<BaseResultT<Map<String, Train>>>(){});
    }

    /**
     * 预估费用
     *
     * @param accessToken accessToken
     * @param reqMap      输入参数
     * @return BaseResultT<Estimated>
     * @exception IllegalArgumentException 参数错误
     */
    public static BaseResultT<Estimated> estimatedOne(String accessToken, Map<String, Object> reqMap) throws IllegalArgumentException {
        List<NameValuePair> formParams = new ArrayList<NameValuePair>();
        formParams.add(new BasicNameValuePair("access_token", accessToken));

        if(!reqMap.containsKey("car_type_id")) {
            throw new IllegalArgumentException("has no car_type_id param");
        }
        Iterator iterator = reqMap.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry<String, String>) iterator.next();
            formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }

        HttpEntity reqEntity = null;
        try {
            reqEntity = new UrlEncodedFormEntity(formParams, "utf-8");
        } catch(UnsupportedEncodingException e) {
            logger.error(e.toString());
        }
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/v2/cost/estimated")
                .setEntity(reqEntity)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, new TypeReference<BaseResultT<Estimated>>(){});
    }

    /**
     * 预估费用
     *
     * @param accessToken accessToken
     * @param reqMap      输入参数
     * @return BaseResultT<List<Estimated>>
     */
    public static BaseResultT<List<Estimated>> estimatedAll(String accessToken, Map<String, Object> reqMap) {
        List<NameValuePair> formParams = new ArrayList<NameValuePair>();
        formParams.add(new BasicNameValuePair("access_token", accessToken));

        Iterator iterator = reqMap.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry<String, String>) iterator.next();
            if(entry.getKey().equals("car_type_id")) {
                continue;//car_type_id影响返回结果
            }
            formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }

        HttpEntity reqEntity = null;
        try {
            reqEntity = new UrlEncodedFormEntity(formParams, "utf-8");
        } catch(UnsupportedEncodingException e) {
            logger.error(e.toString());
        }
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/v2/cost/estimated")
                .setEntity(reqEntity)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, new TypeReference<BaseResultT<List<Estimated>>>(){});
    }
}
