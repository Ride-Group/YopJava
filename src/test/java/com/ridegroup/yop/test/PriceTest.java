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
        PriceNew priceNew = PriceNewAPI.getPrice(accessToken, city, type);

        BaseResultT<PriceNewT> price = PriceNewAPI.getPriceType(accessToken, city, type);
        assertEquals("200", priceNew.getCode());
        assertEquals("200", price.getCode());
    }

    public static void main(String[] args) {
        String city = "bj";
        String type = "17";
        PriceNew priceNew = PriceNewAPI.getPrice(accessToken, city, type);
        System.out.println(priceNew);

        BaseResultT<PriceNewT> price = PriceNewAPI.getPriceType(accessToken, city, type);
        System.out.println(price);
    }
}
