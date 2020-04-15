package com.ridegroup.yop.bean.price;

import com.ridegroup.yop.bean.BaseResult;

import java.util.Map;

public class PriceNew extends BaseResult {
    private PriceObj result;

    public PriceObj getResult() {
        return result;
    }

    public void setResult(PriceObj result) {
        this.result = result;
    }

    public static class PriceObj {
        private String city;
        private String product;
        private Map<String, CarType> cartype;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getProduct() {
            return product;
        }

        public void setProduct(String product) {
            this.product = product;
        }

        public Map<String, CarType> getCartype() {
            return cartype;
        }

        public void setCartype(Map<String, CarType> cartype) {
            this.cartype = cartype;
        }
    }

    public static class CarType {
        private int car_type_id;
        private String name;
        private String brand;
        private String person_number;
        private String pic;
        private String min_time_length;
        private int min_fee;
        private int fee_per_kilometer;
        private int fee_per_minute;
        private int night_service_fee;
        private String kongshi_distance;
        private int kongshi_fee_per_kilometer;
        private int airport_service_fee;
        private String min_response_time;
        private String granularity;
        private int starting_fee;

        public int getCar_type_id() {
            return car_type_id;
        }

        public void setCar_type_id(int car_type_id) {
            this.car_type_id = car_type_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getPerson_number() {
            return person_number;
        }

        public void setPerson_number(String person_number) {
            this.person_number = person_number;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getMin_time_length() {
            return min_time_length;
        }

        public void setMin_time_length(String min_time_length) {
            this.min_time_length = min_time_length;
        }

        public int getMin_fee() {
            return min_fee;
        }

        public void setMin_fee(int min_fee) {
            this.min_fee = min_fee;
        }

        public int getFee_per_kilometer() {
            return fee_per_kilometer;
        }

        public void setFee_per_kilometer(int fee_per_kilometer) {
            this.fee_per_kilometer = fee_per_kilometer;
        }

        public int getFee_per_minute() {
            return fee_per_minute;
        }

        public void setFee_per_minute(int fee_per_minute) {
            this.fee_per_minute = fee_per_minute;
        }

        public int getNight_service_fee() {
            return night_service_fee;
        }

        public void setNight_service_fee(int night_service_fee) {
            this.night_service_fee = night_service_fee;
        }

        public String getKongshi_distance() {
            return kongshi_distance;
        }

        public void setKongshi_distance(String kongshi_distance) {
            this.kongshi_distance = kongshi_distance;
        }

        public int getKongshi_fee_per_kilometer() {
            return kongshi_fee_per_kilometer;
        }

        public void setKongshi_fee_per_kilometer(int kongshi_fee_per_kilometer) {
            this.kongshi_fee_per_kilometer = kongshi_fee_per_kilometer;
        }

        public int getAirport_service_fee() {
            return airport_service_fee;
        }

        public void setAirport_service_fee(int airport_service_fee) {
            this.airport_service_fee = airport_service_fee;
        }

        public String getMin_response_time() {
            return min_response_time;
        }

        public void setMin_response_time(String min_response_time) {
            this.min_response_time = min_response_time;
        }

        public String getGranularity() {
            return granularity;
        }

        public void setGranularity(String granularity) {
            this.granularity = granularity;
        }

        public int getStarting_fee() {
            return starting_fee;
        }

        public void setStarting_fee(int starting_fee) {
            this.starting_fee = starting_fee;
        }
    }
}
