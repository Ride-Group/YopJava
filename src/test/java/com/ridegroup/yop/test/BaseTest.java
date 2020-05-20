package com.ridegroup.yop.test;

import com.ridegroup.yop.api.BaseAPI;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    //TODO
    //public final static String ACCESS_TOKEN = "AAuPlpLwVpCm3blBEbiKqOyOP1W97V3PtgJQoAf3";
    public final static String ACCESS_TOKEN = "8d19e85d4c8f32f16a4965dfe1e8f91f";

    protected final static String CITY = "bj";
    protected final static String TYPE = "17";
    protected final static String CAR_TYPE_ID = "2";

    //6816269519521542779
    /*
     * 6817338275257610495 */
    protected final static String ORDER_ID = "6816269519521542779";
    protected final static String DRIVER_ID = "4099101";
    protected final static String COMMENT_TAG_ID = "1";

    public static Map<String, Object> getCreateOrderParams() {
        HashMap<String, Object> reqMap = new HashMap<>();

        /*
         * 'city'=>'bj',
         'type' => 7,
         'aircode'=>'PEK', //接送机必填
         'car_type_id' => 2,
         'start_position' => '颐和园',
         'expect_start_latitude' => '39.955538',
         'expect_start_longitude' => '116.458637',
         'time' => '2013-04-19 11:22:33',
         'rent_time' => 2,
         'end_position' => '总部基地',
         'expect_end_latitude' => '39.911093',
         'expect_end_longitude' => '116.373055',
         'passenger_name' => 'test',
         'passenger_phone' => '111111111',
         'invoice' => 1,
         'receipt_title' => '111111111',
         'receipt_content' => '22222222',
         'address' => '3333333',
         'postcode' => '100000',
         'sms_type' => 1,       //给乘车人发短信
         'msg'=>'111111111111',
         'app_trade_no' => 'ceshi2013101401811',
         'access_token' => '***'
         */
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        calendar.set(Calendar.HOUR_OF_DAY,
                calendar.get(Calendar.HOUR_OF_DAY) + 10);
        long time = System.currentTimeMillis();

        reqMap.put("city", "bj");
        reqMap.put("type", "7");
        reqMap.put("aircode", "PEK");
        reqMap.put("car_type_id", "2");
        reqMap.put("start_position", "颐和园");
        reqMap.put("expect_start_latitude", "39.955538");
        reqMap.put("expect_start_longitude", "116.458637");
        reqMap.put("time", df.format(calendar.getTime()));
        reqMap.put("rent_time", "2");
        reqMap.put("end_position", "总部基地");
        reqMap.put("expect_end_latitude", "39.911093");
        reqMap.put("expect_end_longitude", "116.373055");
        reqMap.put("passenger_name", "test");
        reqMap.put("passenger_phone", "16811116667");
        reqMap.put("sms_type", "1");
        reqMap.put("msg", "1");
        reqMap.put("app_trade_no", "ceshi" + time);

        return reqMap;
    }

    public static Map<String, Object> getCreateOrderParamsAsap() {
        HashMap<String, Object> reqMap = new HashMap<>();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        calendar.set(Calendar.HOUR_OF_DAY,
                calendar.get(Calendar.HOUR_OF_DAY) + 10);
        long time = System.currentTimeMillis();

        reqMap.put("city", "bj");
        reqMap.put("type", "17");
        reqMap.put("aircode", "");
        reqMap.put("car_type_id", "2");
        reqMap.put("start_position", "北京市朝阳区酒仙桥街道酒仙桥东路电子城·创新产业园");
        reqMap.put("start_address", "北京市朝阳区酒仙桥街道酒仙桥东路电子城·创新产业园");
        reqMap.put("expect_start_latitude", "39.97538757324219");
        reqMap.put("expect_start_longitude", "116.49959564208984");
        reqMap.put("time", df.format(calendar.getTime()));
        reqMap.put("rent_time", "2");
        reqMap.put("end_position", "总部基地");
        reqMap.put("end_address", "总部基地");
        reqMap.put("expect_end_latitude", "39.911093");
        reqMap.put("expect_end_longitude", "116.373055");
        reqMap.put("passenger_name", "test");
        reqMap.put("passenger_phone", "16811116667");
        reqMap.put("sms_type", "1");
        reqMap.put("msg", "1");
        reqMap.put("app_trade_no", "ceshi" + time);

        return reqMap;
    }

    public static Map<String, Object> getCreateOrderParamsPreOrder() {
        HashMap<String, Object> reqMap = new HashMap<>();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        calendar.set(Calendar.HOUR_OF_DAY,
                calendar.get(Calendar.HOUR_OF_DAY) + 10);
        long time = System.currentTimeMillis();

        reqMap.put("city", "bj");
        reqMap.put("type", "1");
        reqMap.put("aircode", "");
        reqMap.put("car_type_id", "2");
        reqMap.put("start_position", "北京市朝阳区酒仙桥街道酒仙桥东路电子城·创新产业园");
        reqMap.put("start_address", "北京市朝阳区酒仙桥街道酒仙桥东路电子城·创新产业园");
        reqMap.put("expect_start_latitude", "39.97538757324219");
        reqMap.put("expect_start_longitude", "116.49959564208984");
        reqMap.put("time", df.format(calendar.getTime()));
        reqMap.put("rent_time", "2");
        reqMap.put("end_position", "总部基地");
        reqMap.put("end_address", "总部基地");
        reqMap.put("expect_end_latitude", "39.911093");
        reqMap.put("expect_end_longitude", "116.373055");
        reqMap.put("passenger_name", "test");
        reqMap.put("passenger_phone", "16811116667");
        reqMap.put("sms_type", "1");
        reqMap.put("msg", "1");
        reqMap.put("app_trade_no", "ceshi" + time);

        return reqMap;
    }

    public static Map<String, Object> getEstimatedParams(boolean hasCarType) {
        HashMap<String, Object> reqMap = new HashMap<>();

        /*
         * 'city'=>'bj',
            'type' => 7,
            'aircode'=>'PEK', //接送机必填
            'car_type_id' => 2,
            'expect_start_latitude' => '39.955538',
            'expect_start_longitude' => '116.458637',
            'expect_end_latitude' => '39.911093',
            'expect_end_longitude' => '116.373055',
            'time' => '2013-04-19 11:22:33',
            'rent_time' => 2,
            'map_type' => 2

             {start_position=北京市东城区东华门街道正义路北京市人民政府(旧址),
             map_type=2,
             rent_time=2,
             city=bj,
             expect_end_longitude=116.333305,
             expect_start_latitude=39.90469,
             time=1587536405,
             expect_end_latitude=39.927464,
             type=17,
             end_position=NS专柜,
             expect_start_longitude=116.40717}
         */
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        calendar.set(Calendar.HOUR_OF_DAY,
                calendar.get(Calendar.HOUR_OF_DAY) + 10);
        long time = System.currentTimeMillis();

        reqMap.put("city", "bj");
        reqMap.put("type", "17");
        reqMap.put("aircode", "PEK");
        if(hasCarType) {
            reqMap.put("car_type_id", "2");
        }
        reqMap.put("start_position", "颐和园");
        reqMap.put("expect_start_latitude", "39.955538");
        reqMap.put("expect_start_longitude", "116.458637");
        reqMap.put("time", df.format(calendar.getTime()));
        reqMap.put("rent_time", "2");
        reqMap.put("end_position", "总部基地");
        reqMap.put("expect_end_latitude", "39.911093");
        reqMap.put("expect_end_longitude", "116.373055");
        reqMap.put("map_type", BaseAPI.MAP_TYPE_MARS);

        return reqMap;
    }

    public static Map<String, Object> getCreateReceiptParams() {
        HashMap<String, Object> reqMap = new HashMap<>();

        /*
         * order_id		test
            receipt_title	*	发票抬头 **有限公司
            receipt_content	*	发票内容 打车费
            province		省
            city		城市
            county		区、县
            address	*	如果传了province、city、county参数，address为省、市、区县后的详细地址 如 XX路XX号。否则应该传完整地址
            postcode	*	邮政编码
            receipt_user	*	发票接收人姓名
            receipt_phone	*	发票接收人电话
            amount	*	发票金额不能小于50
         */

        reqMap.put("order_id", "");
        reqMap.put("receipt_title", "阿里巴巴");
        reqMap.put("receipt_content", "打车费");
        reqMap.put("province", "北京市");
        reqMap.put("city", "北京");
        reqMap.put("county", "朝阳区");
        reqMap.put("address", "一展空间");
        reqMap.put("postcode", "100000");
        reqMap.put("receipt_user", "测试");
        reqMap.put("receipt_phone", "16811116667");
        reqMap.put("amount", "100");

        return reqMap;
    }

    public static Map<String, Object> getUpdateOrderParams() {
        HashMap<String, Object> reqMap = new HashMap<>();

        /*
         * passenger_name	乘车人姓名	test 最大长度utf8 30
            passenger_phone	乘车人电话	111111111
            passenger_number	乘车人数
            coupon_name	优惠券标签	例'易到百度xxx优惠券'
         */

        reqMap.put("passenger_name", "乘车人");
        reqMap.put("passenger_phone", "16811116667");
        reqMap.put("passenger_number", "1");
        reqMap.put("coupon_name", "百度优惠券");

        return reqMap;
    }

    public static Map<String, Object> getCommentOrderParams() {
        HashMap<String, Object> reqMap = new HashMap<>();

        /*
         * order_id	订单号	必填
            content	评价文本内容	utf8最大300，非必填
            comment_tag_id	一个或多个标签id（逗号分割）	例如:1,3
            score	评分（１－５）	score,comment_tag_id必有其一
         */

        reqMap.put("order_id", ORDER_ID);
        reqMap.put("content", "评价");
        reqMap.put("comment_tag_id", COMMENT_TAG_ID);
        reqMap.put("score", "5");

        return reqMap;
    }
}
