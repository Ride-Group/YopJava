package com.ridegroup.yop.bean.order;

import java.util.List;

public class OrderList {
    private List<OrderInfo> list;
    private int count;

    public List<OrderInfo> getList() {
        return list;
    }

    public void setList(List<OrderInfo> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
