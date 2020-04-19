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
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class BaseAPI {
    private static Logger logger = LoggerFactory.getLogger(BaseAPI.class);

    protected static final String BASE_URI = "https://yop.yongche.com";

    public final static String REQUEST_METHOD_GET = "GET";
    public final static String REQUEST_METHOD_POST = "POST";

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

    // 200：正确返回 400：发生错误 511:订单操作超时 512 该app_trade_no对应的订单正在被创建499 帐户异常 （详见错误码说明）
    public final static String RET_OK = "200";            //正确返回
    public final static String RET_INVALID_PARAM = "400";            //发生错误
    public final static String RET_ORDER_TIME_OUT = "511";            //订单操作超时
    public final static String RET_ORDER_CREATING = "512";            //该app_trade_no对应的订单正在被创建
    public final static String RET_ORDER_CHECK_ACCOUNT = "499";            //帐户异常 （详见错误码说明）

    protected static Header jsonHeader = new BasicHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString());
    protected static Header xmlHeader = new BasicHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_XML.toString());

    protected static final String PARAM_ACCESS_TOKEN = "access_token";

    /**
     * 只要确保你的编码输入是正确的,就可以忽略掉 UnsupportedEncodingException
     */
    public static String getUrlParams(Map<String, Object> source) {
        Iterator<String> it = source.keySet().iterator();
        StringBuilder paramStr = new StringBuilder();
        while (it.hasNext()) {
            String key = it.next();
            String value = source.get(key).toString();
            if (value.isEmpty()) {
                continue;
            }
            try {
                // URL 编码
                value = URLEncoder.encode(value, "utf-8");
            } catch (UnsupportedEncodingException e) {
                // do nothing
            }
            paramStr.append("&").append(key).append("=").append(value);
        }
        // 去掉第一个&
        return paramStr.substring(1);
    }

    public static HttpEntity getPostHttpEntity(String accessToken, Map<String, Object> reqMap) {
        HttpEntity reqEntity = null;
        try {
            List<NameValuePair> formParams = new ArrayList<NameValuePair>();
            formParams.add(new BasicNameValuePair("access_token", accessToken));

            Iterator iterator = reqMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = (Map.Entry<String, String>) iterator.next();
                formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }

            reqEntity = new UrlEncodedFormEntity(formParams, "utf-8");
        } catch (UnsupportedEncodingException e) {
            logger.error(e.toString());
        }
        return reqEntity;
    }

}
