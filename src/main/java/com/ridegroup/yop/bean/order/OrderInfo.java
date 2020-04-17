package com.ridegroup.yop.bean.order;

/**
 * "order_id":6816269519521542779,
 "type":7,
 "city":"北京",
 "create_time":1587036418,
 "car_type_id":2,
 "car_type":"舒适",
 "expect_start_time":1587072416,
 "time_length":2280,
 "passenger_name":"test",
 "passenger_phone":"16811116667",
 "total_amount":0,
 "start_position":"颐和园",
 "start_address":"",
 "end_position":"总部基地",
 "end_address":"",
 "flight_number":"",
 "msg":"",
 "status":8,
 "driver_phone":"",
 "vehicle_number":"",
 "driver_name":"",
 "start_time":1587072416,
 "end_time":1587036551,
 "system_distance":0,
 "pay_amount":0,
 "pay_status":3,
 "start_latitude":39.949861543834,
 "start_longitude":116.45203701793,
 "end_latitude":39.905157339217,
 "end_longitude":116.36653850808,
 "car_brand":""


 order_id: "6816269519521542779",
 type: "7",
 city: "北京",
 create_time: "1587036418",
 car_type_id: "2",
 car_type: "舒适",
 expect_start_time: "1587072416",
 time_length: "2280",
 passenger_name: "test",
 passenger_number: 1,
 passenger_phone: "16811116667",
 total_amount: "0.00",
 start_position: "颐和园",
 start_address: "",
 end_position: "总部基地",
 end_address: "",
 start_longitude: "",
 start_latitude: "",
 end_longitude: "",
 end_latitude: "",
 flight_number: "",
 msg: "",
 status: "8",
 driver_id: "",
 driver_phone: "",
 vehicle_number: "",
 driver_name: "",
 color: "颜色未知",
 en_color: "unknow",
 reason_id: "63003",
 is_confirm: 0,
 confirm_time: 0,
 car_brand: "",
 car_en_brand: "",
 balance_status: 0,
 regulatepan_reason: "",
 insure_company: "",
 insure_number: ""
 */
public class OrderInfo {
    private Long order_id;
    private int type;
    private String city;
    private int create_time;
    private int car_type_id;
    private String car_type;
    private int expect_start_time;
    private int time_length;
    private String passenger_name;
    private int passenger_number;
    private String passenger_phone;
    private String total_amount;
    private String start_position;
    private String start_address;
    private String end_position;
    private String end_address;
    private String flight_number;
    private String msg;
    private int status;
    private String driver_phone;
    private String vehicle_number;
    private String driver_name;
    private String car_brand;
    private int start_time;
    private int end_time;
    private int system_distance;
    private int pay_amount;
    private int pay_status;
    private double start_latitude;
    private double start_longitude;
    private double end_latitude;
    private double end_longitude;
    private String driver_id;
    private String color;
    private String en_color;
    private String reason_id;
    private int is_confirm;
    private int confirm_time;
    private String car_en_brand;
    private int balance_status;
    private String regulatepan_reason;
    private String insure_company;
    private String insure_number;

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCreate_time() {
        return create_time;
    }

    public void setCreate_time(int create_time) {
        this.create_time = create_time;
    }

    public int getCar_type_id() {
        return car_type_id;
    }

    public void setCar_type_id(int car_type_id) {
        this.car_type_id = car_type_id;
    }

    public String getCar_type() {
        return car_type;
    }

    public void setCar_type(String car_type) {
        this.car_type = car_type;
    }

    public int getExpect_start_time() {
        return expect_start_time;
    }

    public void setExpect_start_time(int expect_start_time) {
        this.expect_start_time = expect_start_time;
    }

    public int getTime_length() {
        return time_length;
    }

    public void setTime_length(int time_length) {
        this.time_length = time_length;
    }

    public String getPassenger_name() {
        return passenger_name;
    }

    public void setPassenger_name(String passenger_name) {
        this.passenger_name = passenger_name;
    }

    public int getPassenger_number() {
        return passenger_number;
    }

    public void setPassenger_number(int passenger_number) {
        this.passenger_number = passenger_number;
    }

    public String getPassenger_phone() {
        return passenger_phone;
    }

    public void setPassenger_phone(String passenger_phone) {
        this.passenger_phone = passenger_phone;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    public String getStart_position() {
        return start_position;
    }

    public void setStart_position(String start_position) {
        this.start_position = start_position;
    }

    public String getStart_address() {
        return start_address;
    }

    public void setStart_address(String start_address) {
        this.start_address = start_address;
    }

    public String getEnd_position() {
        return end_position;
    }

    public void setEnd_position(String end_position) {
        this.end_position = end_position;
    }

    public String getEnd_address() {
        return end_address;
    }

    public void setEnd_address(String end_address) {
        this.end_address = end_address;
    }

    public String getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(String flight_number) {
        this.flight_number = flight_number;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDriver_phone() {
        return driver_phone;
    }

    public void setDriver_phone(String driver_phone) {
        this.driver_phone = driver_phone;
    }

    public String getVehicle_number() {
        return vehicle_number;
    }

    public void setVehicle_number(String vehicle_number) {
        this.vehicle_number = vehicle_number;
    }

    public String getDriver_name() {
        return driver_name;
    }

    public void setDriver_name(String driver_name) {
        this.driver_name = driver_name;
    }

    public String getCar_brand() {
        return car_brand;
    }

    public void setCar_brand(String car_brand) {
        this.car_brand = car_brand;
    }

    public int getStart_time() {
        return start_time;
    }

    public void setStart_time(int start_time) {
        this.start_time = start_time;
    }

    public int getEnd_time() {
        return end_time;
    }

    public void setEnd_time(int end_time) {
        this.end_time = end_time;
    }

    public int getSystem_distance() {
        return system_distance;
    }

    public void setSystem_distance(int system_distance) {
        this.system_distance = system_distance;
    }

    public int getPay_amount() {
        return pay_amount;
    }

    public void setPay_amount(int pay_amount) {
        this.pay_amount = pay_amount;
    }

    public int getPay_status() {
        return pay_status;
    }

    public void setPay_status(int pay_status) {
        this.pay_status = pay_status;
    }

    public double getStart_latitude() {
        return start_latitude;
    }

    public void setStart_latitude(double start_latitude) {
        this.start_latitude = start_latitude;
    }

    public double getStart_longitude() {
        return start_longitude;
    }

    public void setStart_longitude(double start_longitude) {
        this.start_longitude = start_longitude;
    }

    public double getEnd_latitude() {
        return end_latitude;
    }

    public void setEnd_latitude(double end_latitude) {
        this.end_latitude = end_latitude;
    }

    public double getEnd_longitude() {
        return end_longitude;
    }

    public void setEnd_longitude(double end_longitude) {
        this.end_longitude = end_longitude;
    }

    public String getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(String driver_id) {
        this.driver_id = driver_id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEn_color() {
        return en_color;
    }

    public void setEn_color(String en_color) {
        this.en_color = en_color;
    }

    public String getReason_id() {
        return reason_id;
    }

    public void setReason_id(String reason_id) {
        this.reason_id = reason_id;
    }

    public int getIs_confirm() {
        return is_confirm;
    }

    public void setIs_confirm(int is_confirm) {
        this.is_confirm = is_confirm;
    }

    public int getConfirm_time() {
        return confirm_time;
    }

    public void setConfirm_time(int confirm_time) {
        this.confirm_time = confirm_time;
    }

    public String getCar_en_brand() {
        return car_en_brand;
    }

    public void setCar_en_brand(String car_en_brand) {
        this.car_en_brand = car_en_brand;
    }

    public int getBalance_status() {
        return balance_status;
    }

    public void setBalance_status(int balance_status) {
        this.balance_status = balance_status;
    }

    public String getRegulatepan_reason() {
        return regulatepan_reason;
    }

    public void setRegulatepan_reason(String regulatepan_reason) {
        this.regulatepan_reason = regulatepan_reason;
    }

    public String getInsure_company() {
        return insure_company;
    }

    public void setInsure_company(String insure_company) {
        this.insure_company = insure_company;
    }

    public String getInsure_number() {
        return insure_number;
    }

    public void setInsure_number(String insure_number) {
        this.insure_number = insure_number;
    }
}
