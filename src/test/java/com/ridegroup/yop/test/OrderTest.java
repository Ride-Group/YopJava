package com.ridegroup.yop.test;

import com.ridegroup.yop.api.BaseAPI;
import com.ridegroup.yop.api.OrderAPI;
import com.ridegroup.yop.api.PriceNewAPI;
import com.ridegroup.yop.bean.BaseResultT;
import com.ridegroup.yop.bean.order.AcceptedDriver;
import com.ridegroup.yop.bean.order.CreateOrderResult;
import com.ridegroup.yop.bean.order.OrderInfo;
import com.ridegroup.yop.bean.order.OrderList;
import com.ridegroup.yop.bean.price.PriceNew;
import com.ridegroup.yop.bean.price.PriceNewT;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;

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
    public void testGetOrderInfo() {
        String orderId = "6816269519521542779";
        BaseResultT<OrderInfo> orderInfo = OrderAPI.getOrderInfo(ACCESS_TOKEN, orderId);
        assertEquals("200", orderInfo.getCode());
    }

    @Test
    public void testCreateOrder() {
        Map<String, Object> reqMap = BaseTest.getCreateOrderParams();
        CreateOrderResult createOrderResult = OrderAPI.createOrder(ACCESS_TOKEN, reqMap);
        assertEquals("200", createOrderResult.getCode());
    }

    @Test
    public void testGetSelectDriver() {
        String orderId = "6816269519521542779";
        String driverIds = "";
        BaseResultT<AcceptedDriver> selectDriver = OrderAPI.getSelectDriver(ACCESS_TOKEN, orderId, driverIds, BaseAPI.MAP_TYPE_MARS);
        assertEquals("400", selectDriver.getCode());
    }

    @Test
    public void testCreateOrderAndGetSelectDriver() {
        Map<String, Object> reqMap = BaseTest.getCreateOrderParams();
        CreateOrderResult createOrderResult = OrderAPI.createOrder(ACCESS_TOKEN, reqMap);

        String orderId = createOrderResult.getResult().getOrder_id();
        String driverIds = "";
        RunnerTestCreateOrderAndGetSelectDriver runner = new RunnerTestCreateOrderAndGetSelectDriver();
        runner.setOrderId(orderId);
        runner.setDriverIds(driverIds);
        Thread thread = new Thread(runner);
        thread.start();
    }

    class RunnerTestCreateOrderAndGetSelectDriver implements Runnable {
        private String orderId;
        private String driverIds;

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getDriverIds() {
            return driverIds;
        }

        public void setDriverIds(String driverIds) {
            this.driverIds = driverIds;
        }

        @Override
        public void run() {
            try {
                BaseResultT<AcceptedDriver> selectDriver = null;

                while(true) {
                    selectDriver = OrderAPI.getSelectDriver(ACCESS_TOKEN, orderId, driverIds, BaseAPI.MAP_TYPE_MARS);

                    assertEquals("200", selectDriver.getCode());
                    if(selectDriver.getResult().getCarlist().size() > 0) {
                        break;
                    }
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
