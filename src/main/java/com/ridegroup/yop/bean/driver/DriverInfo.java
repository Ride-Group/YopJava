package com.ridegroup.yop.bean.driver;

/**
 * name;
 gender;
 driving_years;
 star_level;
 brand;
 vehicle_number;
 car_setup;
 unittime_complete_count：112,
 car_company_name;
 driver_company_name;
 is_default_photo;
 photo_url;
 cellphone: "16801010103"
 */
public class DriverInfo {
    private int driver_id;
    private String name;
    private int score;
    private int good_comment_rate;
    private int unittime_complete_count;
    private int is_served;
    private int latitude;
    private int longitude;
    private String brand;
    private String car_type;
    private int car_type_id;
    private int is_default;
    private String photo;

    private String gender;
    private int driving_years;
    private int star_level;
    private String vehicle_number;
    private String car_setup;
    private String car_company_name;
    private String driver_company_name;
    private int is_default_photo;
    private String photo_url;
    private String cellphone;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getDriving_years() {
        return driving_years;
    }

    public void setDriving_years(int driving_years) {
        this.driving_years = driving_years;
    }

    public int getStar_level() {
        return star_level;
    }

    public void setStar_level(int star_level) {
        this.star_level = star_level;
    }

    public String getVehicle_number() {
        return vehicle_number;
    }

    public void setVehicle_number(String vehicle_number) {
        this.vehicle_number = vehicle_number;
    }

    public String getCar_setup() {
        return car_setup;
    }

    public void setCar_setup(String car_setup) {
        this.car_setup = car_setup;
    }

    public String getCar_company_name() {
        return car_company_name;
    }

    public void setCar_company_name(String car_company_name) {
        this.car_company_name = car_company_name;
    }

    public String getDriver_company_name() {
        return driver_company_name;
    }

    public void setDriver_company_name(String driver_company_name) {
        this.driver_company_name = driver_company_name;
    }

    public int getIs_default_photo() {
        return is_default_photo;
    }

    public void setIs_default_photo(int is_default_photo) {
        this.is_default_photo = is_default_photo;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }
}
