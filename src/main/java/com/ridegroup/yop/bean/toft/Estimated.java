package com.ridegroup.yop.bean.toft;

/**
 * {
     "code":200,
     "msg":"ok",
     "result":{
         "car_type_id":"2",
         "car_type":"舒适",
         "description":"帕萨特(4人)&#38;#38;#38;#38;#38;#38;#38;#38;#60;br\/&#38;#38;#38;#38;#38;#38;#38;#38;#62;雅阁(4人)&#38;#38;#38;#38;#38;#38;#38;#38;#60;br\/&#38;#38;#38;#38;#38;#38;#38;#38;#62;凯美瑞等同级车型(4人)",
         "time_length":2377,
         "distance":13.822,
         "total_fee":177,
         "estimated_price_detail":{
             "fixed_fee":138,
             "fixed_fee_time":45,
             "fixed_fee_kilo":20,
             "time_fee":0,
             "kilo_fee":0,
             "extra_time_fee":0,
             "extra_distance_fee":0,
             "night_amount":39,
             "kongshi_fee":0,
             "airport_service_fee":0,
             "min_fee":138
         }
        }
     }
 */
public class Estimated {
    private String car_type_id;
    private String car_type;
    private String description;
    private int time_length;
    private int distance;
    private int total_fee;
    private Detail estimated_price_detail;

    public String getCar_type_id() {
        return car_type_id;
    }

    public void setCar_type_id(String car_type_id) {
        this.car_type_id = car_type_id;
    }

    public String getCar_type() {
        return car_type;
    }

    public void setCar_type(String car_type) {
        this.car_type = car_type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTime_length() {
        return time_length;
    }

    public void setTime_length(int time_length) {
        this.time_length = time_length;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(int total_fee) {
        this.total_fee = total_fee;
    }

    public Detail getEstimated_price_detail() {
        return estimated_price_detail;
    }

    public void setEstimated_price_detail(Detail estimated_price_detail) {
        this.estimated_price_detail = estimated_price_detail;
    }

    public static class Detail {
        private int fixed_fee;
        private int fixed_fee_time;
        private int fixed_fee_kilo;
        private int time_fee;
        private int kilo_fee;
        private int extra_time_fee;
        private int extra_distance_fee;
        private int night_amount;
        private int kongshi_fee;
        private int airport_service_fee;
        private int min_fee;

        public int getFixed_fee() {
            return fixed_fee;
        }

        public void setFixed_fee(int fixed_fee) {
            this.fixed_fee = fixed_fee;
        }

        public int getFixed_fee_time() {
            return fixed_fee_time;
        }

        public void setFixed_fee_time(int fixed_fee_time) {
            this.fixed_fee_time = fixed_fee_time;
        }

        public int getFixed_fee_kilo() {
            return fixed_fee_kilo;
        }

        public void setFixed_fee_kilo(int fixed_fee_kilo) {
            this.fixed_fee_kilo = fixed_fee_kilo;
        }

        public int getTime_fee() {
            return time_fee;
        }

        public void setTime_fee(int time_fee) {
            this.time_fee = time_fee;
        }

        public int getKilo_fee() {
            return kilo_fee;
        }

        public void setKilo_fee(int kilo_fee) {
            this.kilo_fee = kilo_fee;
        }

        public int getExtra_time_fee() {
            return extra_time_fee;
        }

        public void setExtra_time_fee(int extra_time_fee) {
            this.extra_time_fee = extra_time_fee;
        }

        public int getExtra_distance_fee() {
            return extra_distance_fee;
        }

        public void setExtra_distance_fee(int extra_distance_fee) {
            this.extra_distance_fee = extra_distance_fee;
        }

        public int getNight_amount() {
            return night_amount;
        }

        public void setNight_amount(int night_amount) {
            this.night_amount = night_amount;
        }

        public int getKongshi_fee() {
            return kongshi_fee;
        }

        public void setKongshi_fee(int kongshi_fee) {
            this.kongshi_fee = kongshi_fee;
        }

        public int getAirport_service_fee() {
            return airport_service_fee;
        }

        public void setAirport_service_fee(int airport_service_fee) {
            this.airport_service_fee = airport_service_fee;
        }

        public int getMin_fee() {
            return min_fee;
        }

        public void setMin_fee(int min_fee) {
            this.min_fee = min_fee;
        }
    }
}
