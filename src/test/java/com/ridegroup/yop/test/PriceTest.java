package com.ridegroup.yop.test;

import com.ridegroup.yop.api.PriceNewAPI;
import com.ridegroup.yop.bean.BaseResultT;
import com.ridegroup.yop.bean.price.PriceNew;
import com.ridegroup.yop.bean.price.PriceNewT;

public class PriceTest {
    public static void main(String[] args) {
        String accessToken = "AAuPlpLwVpCm3blBEbiKqOyOP1W97V3PtgJQoAf3";
        String city = "bj";
        String type = "17";
        PriceNew priceNew = PriceNewAPI.getPrice(accessToken, city, type);
        System.out.println(priceNew);

        BaseResultT<PriceNewT> price = PriceNewAPI.getPriceType(accessToken, city, type);
        System.out.println(price);
    }
}
