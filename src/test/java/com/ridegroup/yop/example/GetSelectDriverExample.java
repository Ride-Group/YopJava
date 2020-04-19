package com.ridegroup.yop.example;

import com.ridegroup.yop.api.BaseAPI;
import com.ridegroup.yop.api.OrderAPI;
import com.ridegroup.yop.bean.BaseResultT;
import com.ridegroup.yop.bean.order.AcceptedDriver;
import com.ridegroup.yop.bean.order.CreateOrderResult;
import com.ridegroup.yop.test.BaseTest;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class GetSelectDriverExample {

    public static void main(String[] args) {
        GetSelectDriverExample example = new GetSelectDriverExample();
        example.testCreateOrderAndGetSelectDriver();
    }

    public void testCreateOrderAndGetSelectDriver() {
        Map<String, Object> reqMap = BaseTest.getCreateOrderParams();
        CreateOrderResult createOrderResult = OrderAPI.createOrder(BaseTest.ACCESS_TOKEN, reqMap);
        assertEquals("200", createOrderResult.getCode());

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
                    selectDriver = OrderAPI.getSelectDriver(BaseTest.ACCESS_TOKEN, orderId, driverIds, BaseAPI.MAP_TYPE_MARS);

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
