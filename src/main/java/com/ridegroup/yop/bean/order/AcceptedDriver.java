package com.ridegroup.yop.bean.order;

import java.util.List;

/**
 * carlist:
    [
     {
         driver_id;
         name;
         score;
         good_comment_rate;
         unittime_complete_count;
         is_served;
         latitude;
         longitude;
         brand;
         car_type;
         car_type_id;
         is_default;
         photo: "http://sanbox.yongche.org/media/get_image.php?media_id=***"
     }
     ],
 wait_driver_time_length;
 wait_user_time_length: 177

 driver_id: 4099101,
 name: "赵师傅",
 score: 100,
 good_comment_rate: 98,
 unittime_complete_count: 13,
 is_served: 0,
 latitude: 40.029119,
 longitude: 116.32766,
 brand: "本田雅阁",
 car_type: "舒适",
 car_type_id: 2,
 is_default: 0,
 photo: "https://i2.yongche.name/media/g2/M03/15/0D/rBEBJVjI4zCIW3y9AACGb_mdXJIAAIQdwFzPDUAAIaH503.jpg"
 */
public class AcceptedDriver {
    private List<Driver> carlist;
    private int wait_driver_time_length;
    private int wait_user_time_length;

    public List<Driver> getCarlist() {
        return carlist;
    }

    public void setCarlist(List<Driver> carlist) {
        this.carlist = carlist;
    }

    public int getWait_driver_time_length() {
        return wait_driver_time_length;
    }

    public void setWait_driver_time_length(int wait_driver_time_length) {
        this.wait_driver_time_length = wait_driver_time_length;
    }

    public int getWait_user_time_length() {
        return wait_user_time_length;
    }

    public void setWait_user_time_length(int wait_user_time_length) {
        this.wait_user_time_length = wait_user_time_length;
    }

    public static class Driver {
        private int driver_id;
        private String name;
        private int score;
        private int good_comment_rate;
        private int unittime_complete_count;
        private int is_served;
        private double latitude;
        private double longitude;
        private String brand;
        private String car_type;
        private int car_type_id;
        private int is_default;
        private String photo;

        public int getDriver_id() {
            return driver_id;
        }

        public void setDriver_id(int driver_id) {
            this.driver_id = driver_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getGood_comment_rate() {
            return good_comment_rate;
        }

        public void setGood_comment_rate(int good_comment_rate) {
            this.good_comment_rate = good_comment_rate;
        }

        public int getUnittime_complete_count() {
            return unittime_complete_count;
        }

        public void setUnittime_complete_count(int unittime_complete_count) {
            this.unittime_complete_count = unittime_complete_count;
        }

        public int getIs_served() {
            return is_served;
        }

        public void setIs_served(int is_served) {
            this.is_served = is_served;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getCar_type() {
            return car_type;
        }

        public void setCar_type(String car_type) {
            this.car_type = car_type;
        }

        public int getCar_type_id() {
            return car_type_id;
        }

        public void setCar_type_id(int car_type_id) {
            this.car_type_id = car_type_id;
        }

        public int getIs_default() {
            return is_default;
        }

        public void setIs_default(int is_default) {
            this.is_default = is_default;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }
    }
}
