package com.ridegroup.yop.test;

import com.ridegroup.yop.api.PriceNewAPI;
import com.ridegroup.yop.api.ToftAPI;
import com.ridegroup.yop.bean.BaseResultT;
import com.ridegroup.yop.bean.price.PriceNew;
import com.ridegroup.yop.bean.toft.Airport;
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
        BaseResultT<Map<String, AvailableService>> availableService = ToftAPI.getAvailableService(ACCESS_TOKEN);
        assertEquals("200", availableService.getCode());
    }

    @Test
    public void testGetNightfee() {
        BaseResultT<Nightfee> nightfee = ToftAPI.getNightfee(ACCESS_TOKEN, BaseTest.CITY, TYPE, CAR_TYPE_ID);
        assertEquals("200", nightfee.getCode());
    }

    @Test
    public void testGetAirport() {
        BaseResultT<Map<String, Airport>> airport = ToftAPI.getAirport(ACCESS_TOKEN, ToftAPI.MAP_TYPE_MARS);
        assertEquals("200", airport.getCode());
    }
}
