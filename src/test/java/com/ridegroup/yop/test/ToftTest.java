package com.ridegroup.yop.test;

import com.ridegroup.yop.api.PriceNewAPI;
import com.ridegroup.yop.api.ToftAPI;
import com.ridegroup.yop.bean.price.PriceNew;
import com.ridegroup.yop.bean.toft.AvailableService;

import java.util.Map;

public class ToftTest {
    public static void main(String[] args) {
        //AvailableService availableService = ToftAPI.getAvailableService("AAuPlpLwVpCm3blBEbiKqOyOP1W97V3PtgJQoAf3");
        Map availableService = ToftAPI.getAvailableService("AAuPlpLwVpCm3blBEbiKqOyOP1W97V3PtgJQoAf3");
        System.out.println(availableService);
    }
}
