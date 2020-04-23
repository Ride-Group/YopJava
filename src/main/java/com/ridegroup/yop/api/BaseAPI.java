package com.ridegroup.yop.api;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
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

    public final static String PRODUCT_TIME_RENT = "1";        // 时租-包时
    public final static String PRODUCT_DISTANCE_RENT = "2";    // 时租-包行程
    public final static String PRODUCT_DAY_RENT = "3";         // 整租-按日
    public final static String PRODUCT_WEEK_RENT = "4";        // 整租-按周
    public final static String PRODUCT_MONTH_RENT = "5";       // 整租-按月
    public final static String PRODUCT_YEAR_RENT = "6";        // 整租-按年
    public final static String PRODUCT_FROM_AIRPORT = "7";     // 定价-接机
    public final static String PRODUCT_TO_AIRPORT = "8";       // 定价-送机
    public final static String PRODUCT_MANUAL_COMMON = "9";    // 议价-通用
    public final static String PRODUCT_MANUAL_DRUNK = "10";    // 议价-酒后代驾
    public final static String PRODUCT_HALF_DAY = "11";        // 定价-半日租
    public final static String PRODUCT_FULL_DAY = "12";        // 定价-日租
    public final static String PRODUCT_HOTLINE = "13";         // 定价-热门线路
    public final static String PRODUCT_HOTLINE_ROUND = "14";   // 定价-热门线路往返
    public final static String PRODUCT_TRY_DRIVE = "15";       // 试乘试驾
    public final static String PRODUCT_HOURLY_COMBO = "16";    // 定价-包时用车
    public final static String PRODUCT_ASAP = "17";            // 随叫随到
    public final static String PRODUCT_TAXI = "18";            // 时租-出租车

    //car_type
    public final static String CAR_TYPE_MASS = "1";            // 经济车型，已不再使用，可用37
    public final static String CAR_TYPE_COMFORT = "2";         // 舒适车型
    public final static String CAR_TYPE_LIMO = "3";            // 豪华车型
    public final static String CAR_TYPE_LUXURY = "4";          // 奢华车型
    public final static String CAR_TYPE_BUSINESS = "5";        // 商务车型
    public final static String CAR_TYPE_YOUNG = "37";          // 易达
    public final static String CAR_TYPE_TAXI = "78";           // 出租车
    
    // 订单状态
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
    
    // pay status
    public final static String PAY_STATUS_NO_NEED = "0";                  //0:无需付款
    public final static String PAY_STATUS_NONE = "1";                     //1:未付款
    public final static String PAY_STATUS_PORTION = "2";                  //2:部分付款
    public final static String PAY_STATUS_OFF = "3";                      //3:已付款

    //reason
    /*59	没有信用卡无法验证
        60	没有网银无法充值
        61	变更信息重新下单
        54	车辆未在预定时间到达
        58	其它

        取消原因状态码说明

        状态码	含义	说明
        63001	无车可派
        63002	有车无人接单(无有效司机接单)
        63003	有司机接单，用户未选车，系统自动取消
        63004	有司机接单，用户未选车，客户端自动取消
        100	合作方取消*/
    public final static String REASON_NO_CARD = "59";                      //没有信用卡无法验证
    public final static String REASON_NO_UNIONPAY = "60";                  //没有网银无法充值
    public final static String REASON_CHANGE_INFO_REORDER = "61";          //变更信息重新下单
    public final static String REASON_CAR_NOT_ARRIVE = "54";               //车辆未在预定时间到达
    public final static String REASON_OTHER = "58";                        //其它

    public final static String REASON_DISPATCH_NO_DRIVER             = "63001"; //无车可派
    public final static String REASON_DISPATCH_NO_DRIVER_ACCEPT      = "63002"; //有车无人接单(无有效司机接单)
    public final static String REASON_DISPATCH_SYSTEM_CANCEL         = "63003"; //有司机接单，用户未选车，系统自动取消
    public final static String REASON_DISPATCH_APP_CANCEL            = "63004"; //有司机接单，用户未选车，客户端自动取消
    public final static String REASON_DISPATCH_DRIVER_CANCEL         = "64001"; //IVR联系乘客取消用车
    public final static String REASON_DISPATCH_UNCONTACT_CANCEL      = "64002"; //IVR联系不上乘客
    public final static String REASON_DISPATCH_CANCEL_BY_DRIVER      = "65001"; //司机自助取消订单
    public final static String REASON_DISPATCH_REDISPATCH_FAILED     = "66001"; //改派失败（客服项目改派失败直接取消订单，不生成客服工单）
    public final static String REASON_PARTNER     = "100"; //合作方取消

    /*
    * 订单异常状态
    * 异常状态说明
    状态id	含义	说明
    1	系统设置的异常
    2	客户设置的异常
    3	后台操作人员设置的异常
    -1	异常已经处理完成
    0	没有异常*/
    public final static String ABNORMAL_MARK_SYSTEM = "1";                 //1： 系统设置的异常
    public final static String ABNORMAL_MARK_CUSTOM = "2";                 //2： 客户设置的异常
    public final static String ABNORMAL_MARK_OPERATOR = "3";                 //3： 后台操作人员设置的异常
    public final static String ABNORMAL_MARK_DONE = "-1";                 //-1： 客户设置的异常
    public final static String ABNORMAL_MARK_NONE = "0";                 //0： 没有异常

    // 200：正确返回 400：发生错误 511:订单操作超时 512 该app_trade_no对应的订单正在被创建499 帐户异常 （详见错误码说明）
    // https://github.com/yongche/developer.yongche.com/wiki/errorCode
    /*错误码代码	错误信息描述	含义
        511	订单操作超时	该操作后端正在执行，请稍后重试
        512	该app_trade_no对应的订单正在被创建	用相同的app_trade_no在短时间内重复创建订单，上一个请求还没有处理完，请稍后重试
        513	该用户取消次数过多	该订单用户取消次数达到风控规则，无法创建订单
        523	司机被别人选走	选择司机的时候，司机被别人选走
        530	价格校验失败	新一口价日租、半日租价格校验
        499	帐户异常	可能是帐户被冻结等情况，请联系易到
        400	其他错误	*/
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
     *
     * @param source 参数
     * @return String
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

    /**
     * getUri
     *
     * @param path URI
     * @param accessToken accessToken
     * @param reqMap 请求参数
     * @return String
     */
    public static String getUri(String path, String accessToken, Map<String, Object> reqMap) {
        URIBuilder uri = null;
        try {
            uri = new URIBuilder(BASE_URI + path);
            List<NameValuePair> formParams = new ArrayList<NameValuePair>();
            formParams.add(new BasicNameValuePair("access_token", accessToken));

            Iterator iterator = reqMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = (Map.Entry<String, String>) iterator.next();
                formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            uri.addParameters(formParams);

            return uri.build().toString();
        } catch (URISyntaxException e) {
            logger.error(e.toString());
        }
        return BASE_URI + path;
    }

    /**
     * getPostHttpEntity
     *
     * @param accessToken accessToken
     * @param reqMap 请求参数
     * @return HttpEntity
     */
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
