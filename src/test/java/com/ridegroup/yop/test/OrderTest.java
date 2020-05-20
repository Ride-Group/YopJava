package com.ridegroup.yop.test;

import com.ridegroup.yop.api.BaseAPI;
import com.ridegroup.yop.api.OrderAPI;
import com.ridegroup.yop.api.PriceNewAPI;
import com.ridegroup.yop.bean.BaseResult;
import com.ridegroup.yop.bean.BaseResultT;
import com.ridegroup.yop.bean.driver.DriverInfo;
import com.ridegroup.yop.bean.order.*;
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
        BaseResultT<OrderInfo> orderInfo = OrderAPI.getOrderInfo(ACCESS_TOKEN, ORDER_ID);
        assertEquals("200", orderInfo.getCode());
    }

    @Test
    public void testCreateOrder() {
        Map<String, Object> reqMap = BaseTest.getCreateOrderParamsPreOrder();
        CreateOrderResult createOrderResult = OrderAPI.createOrder(ACCESS_TOKEN, reqMap);
        assertEquals("200", createOrderResult.getCode());
    }

    @Test
    public void testGetSelectDriver() {
        String driverIds = "";
        BaseResultT<AcceptedDriver> selectDriver = OrderAPI.getSelectDriver(ACCESS_TOKEN, ORDER_ID, driverIds, BaseAPI.MAP_TYPE_MARS);
        assertEquals("400", selectDriver.getCode());
    }

    @Test
    public void testGetOrderDriverInfo() {
        BaseResultT<DriverInfo> selectDriver = OrderAPI.getOrderDriverInfo(ACCESS_TOKEN, ORDER_ID);
        assertEquals("400", selectDriver.getCode());
    }

    @Test
    public void testDecisionDriver() {
        BaseResult decisionDriver = OrderAPI.decisionDriver(ACCESS_TOKEN, ORDER_ID, DRIVER_ID, "0");
        assertEquals("400", decisionDriver.getCode());
    }

    @Test
    public void testGetOrderTrack() {
        BaseResultT<List<Position>> orderTrack = OrderAPI.getOrderTrack(ACCESS_TOKEN, ORDER_ID, BaseAPI.MAP_TYPE_MARS);
        assertEquals("400", orderTrack.getCode());
    }

    @Test
    public void testGetDriverLocation() {
        BaseResultT<Position> driverLocation = OrderAPI.getDriverLocation(ACCESS_TOKEN, "6819690328181142745", BaseAPI.MAP_TYPE_MARS);
        assertEquals("400", driverLocation.getCode());
    }

    @Test
    public void testCreateReceipt() {
        Map<String, Object> reqMap = BaseTest.getCreateReceiptParams();
        BaseResult createReceipt = OrderAPI.createReceipt(ACCESS_TOKEN, reqMap);
        assertEquals("400", createReceipt.getCode());
    }

    @Test
    public void testCancelOrder() {
        BaseResultT<CancelOrder> cancelOrder = OrderAPI.cancelOrder(ACCESS_TOKEN, ORDER_ID, BaseAPI.REASON_CHANGE_INFO_REORDER, "");
        assertEquals("200", cancelOrder.getCode());
    }

    @Test
    public void testUpdateOrder() {
        Map<String, Object> reqMap = BaseTest.getUpdateOrderParams();
        BaseResultT<UpdateOrder> updateOrder = OrderAPI.updateOrder(ACCESS_TOKEN, ORDER_ID, reqMap);
        assertEquals("500", updateOrder.getCode());
    }

    @Test
    public void testAbnormalOrder() {
        BaseResult abnormalOrder = OrderAPI.abnormalOrder(ACCESS_TOKEN, ORDER_ID, BaseAPI.ABNORMAL_MARK_CUSTOM, "空驶公里数异常");
        assertEquals("400", abnormalOrder.getCode());
    }

    @Test
    public void testGetEstimateData() {
        BaseResultT<EstimateData> estimateData = OrderAPI.getEstimateData(ACCESS_TOKEN, ORDER_ID);
        assertEquals("200", estimateData.getCode());
    }

    @Test
    public void testGetCancelOrderFee() {
        BaseResultT<CancelOrderFee> cancelOrderFee = OrderAPI.getCancelOrderFee(ACCESS_TOKEN, ORDER_ID);
        assertEquals("200", cancelOrderFee.getCode());
    }

    @Test
    public void testGetCommentTag() {
        BaseResultT<List<CommentTag>> commentTag = OrderAPI.getCommentTag(ACCESS_TOKEN);
        assertEquals("200", commentTag.getCode());
    }

    @Test
    public void testCommentOrder() {
        Map<String, Object> reqMap = BaseTest.getCommentOrderParams();
        BaseResult commentOrder = OrderAPI.commentOrder(ACCESS_TOKEN, reqMap);
        assertEquals("400", commentOrder.getCode());
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
