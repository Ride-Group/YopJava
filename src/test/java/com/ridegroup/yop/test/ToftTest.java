package com.ridegroup.yop.test;

import com.ridegroup.yop.api.PriceNewAPI;
import com.ridegroup.yop.api.ToftAPI;
import com.ridegroup.yop.bean.BaseResultT;
import com.ridegroup.yop.bean.price.PriceNew;
import com.ridegroup.yop.bean.toft.AvailableService;
import com.ridegroup.yop.bean.toft.Nightfee;
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

    @Test
    public void testGetNightfee() {
        BaseResultT<Nightfee> nightfee = ToftAPI.getNightfee(accessToken, BaseTest.city, type, carTypeId);
        assertEquals("200", nightfee.getCode());
    }
}
