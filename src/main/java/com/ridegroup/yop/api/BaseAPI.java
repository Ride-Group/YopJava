package com.ridegroup.yop.api;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class BaseAPI {
    private static Logger logger = LoggerFactory.getLogger(BaseAPI.class);

    protected static final String BASE_URI = "https://yop.yongche.com";

    public final static String MAP_TYPE_BAIDU = "1";
    public final static String MAP_TYPE_MARS = "2";
    public final static String MAP_TYPE_GOOGLE = "3";

    public final static String ORDER_STATUS_ALL = "all";                //所有状态

    public final static String ORDER_STATUS_DISABLED = "-1";            //无效
    public final static String ORDER_STATUS_PRECREATE = "0";            //未初始化
    public final static String ORDER_STATUS_INIT = "1";                 //等待用户付款
    public final static String ORDER_STATUS_WAITFORCAR = "2";           //等待选择车辆
    public final static String ORDER_STATUS_WAITDRIVERCONFIRM = "3";    //等待司机确认
    public final static String ORDER_STATUS_SERVICEREADY = "4";         //司机已确认
    public final static String ORDER_STATUS_ARRIVED = "5";              //司机已到达
    public final static String ORDER_STATUS_SERVICESTART = "6";         //服务开始
    public final static String ORDER_STATUS_SERVICEEND = "7";           //服务结束
    public final static String ORDER_STATUS_CANCELLED = "8";            //取消
    
    protected static Header jsonHeader = new BasicHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString());
    protected static Header xmlHeader = new BasicHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_XML.toString());

    protected static final String PARAM_ACCESS_TOKEN = "access_token";

    public static HttpEntity getHttpEntity(String accessToken, Map<String, Object> reqMap) {
        List<NameValuePair> formParams = new ArrayList<NameValuePair>();
        formParams.add(new BasicNameValuePair("access_token", accessToken));

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
        return reqEntity;
    }

}
