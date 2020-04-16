package com.ridegroup.yop.bean.toft;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Map;

public class AvailableService {
    @JSONField(name = "short")
    private String city_short;
    private String en;
    private String name;
    private int support_face_pay;
    private int is_oversea;
    private Map<String, String> product_list;
    private Position position;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public static class Position {
        private double lng;
        private double lat;

        public double getLng() {
            return lng;
        }

        public void setLng(double lng) {
            this.lng = lng;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }
    }

    public String getCity_short() {
        return city_short;
    }

    public void setCity_short(String city_short) {
        this.city_short = city_short;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSupport_face_pay() {
        return support_face_pay;
    }

    public void setSupport_face_pay(int support_face_pay) {
        this.support_face_pay = support_face_pay;
    }

    public int getIs_oversea() {
        return is_oversea;
    }

    public void setIs_oversea(int is_oversea) {
        this.is_oversea = is_oversea;
    }

    public Map<String, String> getProduct_list() {
        return product_list;
    }

    public void setProduct_list(Map<String, String> product_list) {
        this.product_list = product_list;
    }
}
