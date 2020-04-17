package com.ridegroup.yop.test;

import com.ridegroup.yop.api.PriceNewAPI;
import com.ridegroup.yop.api.ToftAPI;
import com.ridegroup.yop.bean.BaseResultT;
import com.ridegroup.yop.bean.price.PriceNew;
import com.ridegroup.yop.bean.toft.AvailableService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Map;

public class ToftTest extends BaseTest {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testGetAvailableService() {
        BaseResultT<Map<String, AvailableService>> availableService = ToftAPI.getAvailableService(accessToken);
        assertEquals("200", availableService.getCode());

    }

    public static void main(String[] args) {
        BaseResultT<Map<String, AvailableService>> availableService = ToftAPI.getAvailableService(accessToken);
        System.out.println(availableService);
    }
}
