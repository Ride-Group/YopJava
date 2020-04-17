package com.ridegroup.yop.test;

import com.ridegroup.yop.api.BaseAPI;
import com.ridegroup.yop.api.OrderAPI;
import com.ridegroup.yop.api.PriceNewAPI;
import com.ridegroup.yop.bean.BaseResultT;
import com.ridegroup.yop.bean.order.CreateOrderResult;
import com.ridegroup.yop.bean.order.OrderInfo;
import com.ridegroup.yop.bean.order.OrderList;
import com.ridegroup.yop.bean.price.PriceNew;
import com.ridegroup.yop.bean.price.PriceNewT;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class OrderTest extends BaseTest {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testGetOrderList() {
        HashMap<String, Object> reqMap = new HashMap<>();
        /*
         * map_type
         * passenger_phone
         * status
         * page
         * limit
         * time_type 0-create_time 1-end_time
         * start_time
         * end_time
         */
        reqMap.put("map_type", BaseAPI.MAP_TYPE_MARS);
        reqMap.put("status", "all");
        reqMap.put("start_time", "2020-04-16");
        BaseResultT<OrderList> orderList = OrderAPI.getOrderList(ACCESS_TOKEN, reqMap);
        assertEquals("200", orderList.getCode());
    }

    @Test
    public void testCreateOrder() {
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

        CreateOrderResult createOrderResult = OrderAPI.createOrder(ACCESS_TOKEN, reqMap);
        assertEquals("200", createOrderResult.getCode());
    }
}
