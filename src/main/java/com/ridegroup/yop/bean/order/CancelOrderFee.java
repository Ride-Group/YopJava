package com.ridegroup.yop.bean.order;

public class CancelOrderFee {
    private int allow_cancel;
    private int cancel_order_amount;
    private String state;

    public int getAllow_cancel() {
        return allow_cancel;
    }

    public void setAllow_cancel(int allow_cancel) {
        this.allow_cancel = allow_cancel;
    }

    public int getCancel_order_amount() {
        return cancel_order_amount;
    }

    public void setCancel_order_amount(int cancel_order_amount) {
        this.cancel_order_amount = cancel_order_amount;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
