package com.ridegroup.yop.test;

import com.ridegroup.yop.api.PriceNewAPI;
import com.ridegroup.yop.api.ToftAPI;
import com.ridegroup.yop.bean.BaseResultT;
import com.ridegroup.yop.bean.price.PriceNew;
import com.ridegroup.yop.bean.toft.AvailableService;

import java.util.Map;

public class ToftTest {
    public static void main(String[] args) {
        String accessToken = "AAuPlpLwVpCm3blBEbiKqOyOP1W97V3PtgJQoAf3";

        BaseResultT<Map<String, AvailableService>> availableService = ToftAPI.getAvailableService(accessToken);
        System.out.println(availableService);
    }
}
