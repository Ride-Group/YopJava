package com.ridegroup.yop.bean.toft;

import com.alibaba.fastjson.annotation.JSONField;
import com.ridegroup.yop.bean.BaseResult;

import java.util.Map;

public class AvailableService extends BaseResult {
    private Map<String, AvailableServiceObj> cityList;

    public Map<String, AvailableServiceObj> getCityList() {
        return cityList;
    }

    public void setCityList(Map<String, AvailableServiceObj> cityList) {
        this.cityList = cityList;
    }

    public static class AvailableServiceObj {
        @JSONField(name = "short")
        private String city_short;
        private String en;
        private String name;
        private int support_face_pay;
        private int is_oversea;
        private Map<String, String> product_list;
        private Map<String, Double> position;

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

        public Map<String, Double> getPosition() {
            return position;
        }

        public void setPosition(Map<String, Double> position) {
            this.position = position;
        }
    }
}
