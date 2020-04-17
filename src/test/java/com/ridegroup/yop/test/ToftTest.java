package com.ridegroup.yop.test;

import com.ridegroup.yop.api.PriceNewAPI;
import com.ridegroup.yop.api.ToftAPI;
import com.ridegroup.yop.bean.BaseResultT;
import com.ridegroup.yop.bean.price.PriceNew;
import com.ridegroup.yop.bean.toft.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.List;
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

    @Test
    public void testGetTrain() {
        BaseResultT<Map<String, Train>> train = ToftAPI.getTrain(ACCESS_TOKEN, ToftAPI.MAP_TYPE_MARS);
        assertEquals("200", train.getCode());
    }

    @Test
    public void testEstimatedOne() {
        //{"code":200,"msg":"ok","result":{"car_type_id":"2","car_type":"舒适","description":"帕萨特(4人)&#38;#38;#38;#38;#38;#38;#38;#38;#60;br\/&#38;#38;#38;#38;#38;#38;#38;#38;#62;雅阁(4人)&#38;#38;#38;#38;#38;#38;#38;#38;#60;br\/&#38;#38;#38;#38;#38;#38;#38;#38;#62;凯美瑞等同级车型(4人)","time_length":2377,"distance":13.822,"total_fee":177,"estimated_price_detail":{"fixed_fee":138,"fixed_fee_time":45,"fixed_fee_kilo":20,"time_fee":0,"kilo_fee":0,"extra_time_fee":0,"extra_distance_fee":0,"night_amount":39,"kongshi_fee":0,"airport_service_fee":0,"min_fee":138}}}
        BaseResultT<Estimated> estimated = ToftAPI.estimatedOne(ACCESS_TOKEN, BaseTest.getEstimatedParams(true));
        assertEquals("200", estimated.getCode());
    }

    @Test
    public void testEstimatedAll() {
        BaseResultT<List<Estimated>> estimated = ToftAPI.estimatedAll(ACCESS_TOKEN, BaseTest.getEstimatedParams(false));
        assertEquals("200", estimated.getCode());
    }

    @Test
    public void testGetNearbyCarCount() {
        String lat = "39.955538";
        String lng = "116.458637";
        BaseResultT<NearbyCarCount> nearbyCarCount = ToftAPI.getNearbyCarCount(ACCESS_TOKEN, lat, lng);
        assertEquals("200", nearbyCarCount.getCode());
    }
}
