package com.ridegroup.yop.test;

import com.ridegroup.yop.api.PriceNewAPI;
import com.ridegroup.yop.bean.price.PriceNew;

public class TokenTest {
    public static void main(String[] args) {
        PriceNew priceNew = PriceNewAPI.getPrice("AAuPlpLwVpCm3blBEbiKqOyOP1W97V3PtgJQoAf3", "bj", "17");
        System.out.println(priceNew);
    }
}
