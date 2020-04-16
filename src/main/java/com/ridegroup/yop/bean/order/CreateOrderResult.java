package com.ridegroup.yop.bean.order;

import com.ridegroup.yop.bean.BaseResult;

public class CreateOrderResult extends BaseResult {
    private CreateOrderObj result;

    public CreateOrderObj getResult() {
        return result;
    }

    public void setResult(CreateOrderObj result) {
        this.result = result;
    }

    public static class CreateOrderObj {
        private String order_id;

        public String getOrder_id() {
            return order_id;
        }

        public void setOrder_id(String order_id) {
            this.order_id = order_id;
        }
    }
}
