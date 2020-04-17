package com.ridegroup.yop.test;

import com.ridegroup.yop.api.PriceNewAPI;
import com.ridegroup.yop.bean.BaseResultT;
import com.ridegroup.yop.bean.price.PriceNew;
import com.ridegroup.yop.bean.price.PriceNewT;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class PriceTest extends BaseTest {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testPriceNew() {
        String city = "bj";
        String type = "17";
        PriceNew priceNew = PriceNewAPI.getPrice(ACCESS_TOKEN, city, type);

        BaseResultT<PriceNewT> price = PriceNewAPI.getPriceType(ACCESS_TOKEN, city, type);
        assertEquals("200", priceNew.getCode());
        assertEquals("200", price.getCode());
    }
}
