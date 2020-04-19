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
        private int name;
        private int score;
        private int good_comment_rate;
        private int unittime_complete_count;
        private int is_served;
        private int latitude;
        private int longitude;
        private int brand;
        private int car_type;
        private int car_type_id;
        private int is_default;
        private int photo;

        public int getDriver_id() {
            return driver_id;
        }

        public void setDriver_id(int driver_id) {
            this.driver_id = driver_id;
        }

        public int getName() {
            return name;
        }

        public void setName(int name) {
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

        public int getLatitude() {
            return latitude;
        }

        public void setLatitude(int latitude) {
            this.latitude = latitude;
        }

        public int getLongitude() {
            return longitude;
        }

        public void setLongitude(int longitude) {
            this.longitude = longitude;
        }

        public int getBrand() {
            return brand;
        }

        public void setBrand(int brand) {
            this.brand = brand;
        }

        public int getCar_type() {
            return car_type;
        }

        public void setCar_type(int car_type) {
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

        public int getPhoto() {
            return photo;
        }

        public void setPhoto(int photo) {
            this.photo = photo;
        }
    }
}
