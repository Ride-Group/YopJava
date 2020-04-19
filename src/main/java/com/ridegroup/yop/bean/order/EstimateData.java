package com.ridegroup.yop.bean.order;

/**
 * "order_id":200129059,
 "city":"北京",
 "fixed_fee":"15.8",
 "parking_amount":"1"
 "highway_amount":     "1.00"
 "kongshi_distance":"15"
 "kongshi_distance_danjia":     "0.4"
 "kongshi_fee":     "6"
 "origin_amount":     "23.8"
 "coupon_facevalue":     "-0.2"
 "order_amount":     "24"
 "deposit":16
 "pay_amount":     "8.30"

 time_length	计费时长	单位:小时
 actual_time_length	实际行驶时长	单位:秒 注意：不是小时，因为需要精确的时间
 kilo_length	实际公里数	单位:公里
 fee_per_hour	时租单价	单位:元/小时(时租产品专用)
 time_fee	时租总费用	单位:元(时租产品专用)
 fee_per_kilo	公里单价	单位:元/公里(时租产品专用)
 kilo_fee	公里总费用	单位:元(时租产品专用)
 fixed_fee	固定价格产品服务费	单位:元(固定价格产品专用)
 extra_distance	超公里数	单位:公里
 extra_distance_danjia	超公里单价	单位:元/公里
 extra_distance_fee	超公里费	单位:元
 extra_time	超小时	单位:小时
 extra_time_danjia	超时长单价	单位:元/小时
 extra_time_fee	超小时总费用	单位:元
 parking_amount	停车费
 highway_amount	高速费
 airport_service_amount	机场服务费
 night_amount	夜间服务费费
 kongshi_distance	空驶距离	单位:公里
 kongshi_distance_danjia	空驶单价	单位:元/公里
 kongshi_fee	空驶费
 origin_amount	订单原始金额
 coupon_facevalue	优惠金额
 order_amount	应付金额
 deposit	已付金额	已废弃
 pay_amount	未付金额	已废弃
 adjust_fee	调整金额	取值可以为正，也可为负
 other_fee	其他费用金额
 other_fee_msg	其他费用描述
 actual_board_time	实际开始时间	2014-01-02 23:50:34
 actual_off_time	实际结束时间	2014-01-03 00:58:24
 actual_car_type	车辆品牌	GL8
 time_length_minute	实际计费分钟	（单位：分钟）新增
 extra_time_minute	实际超出分钟	（单位：分钟）新增
 fee_per_minute	分钟单价	（单位：元）新增

 order_id: "200134273",
 city: "北京",
 cancel_order_amount: "0",
 cancel_deposit: 0,
 cancel_pay_amount: "0.00",
 cancel_change_amount: 0
 */
public class EstimateData {
    private long order_id;
    private String city;
    private String fixed_fee;
    private String parking_amount;
    private String highway_amount;
    private String kongshi_distance;
    private String kongshi_distance_danjia;
    private String kongshi_fee;
    private String origin_amount;
    private String coupon_facevalue;
    private String order_amount;
    private int deposit;
    private String pay_amount;

    private String time_length;
    private String actual_time_length;
    private String kilo_length;
    private String fee_per_hour;
    private String time_fee;
    private String fee_per_kilo;
    private String kilo_fee;
    private String extra_distance;
    private String extra_distance_danjia;
    private String extra_distance_fee;
    private String extra_time;
    private String extra_time_danjia;
    private String extra_time_fee;
    private String airport_service_amount;
    private String night_amount;
    private String adjust_fee;
    private String other_fee;
    private String other_fee_msg;
    private String actual_board_time;
    private String actual_off_time;
    private String actual_car_type;
    private String time_length_minute;
    private String extra_time_minute;
    private String fee_per_minute;

    private String cancel_order_amount;
    private int cancel_deposit;
    private String cancel_pay_amount;
    private int cancel_change_amount;

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFixed_fee() {
        return fixed_fee;
    }

    public void setFixed_fee(String fixed_fee) {
        this.fixed_fee = fixed_fee;
    }

    public String getParking_amount() {
        return parking_amount;
    }

    public void setParking_amount(String parking_amount) {
        this.parking_amount = parking_amount;
    }

    public String getHighway_amount() {
        return highway_amount;
    }

    public void setHighway_amount(String highway_amount) {
        this.highway_amount = highway_amount;
    }

    public String getKongshi_distance() {
        return kongshi_distance;
    }

    public void setKongshi_distance(String kongshi_distance) {
        this.kongshi_distance = kongshi_distance;
    }

    public String getKongshi_distance_danjia() {
        return kongshi_distance_danjia;
    }

    public void setKongshi_distance_danjia(String kongshi_distance_danjia) {
        this.kongshi_distance_danjia = kongshi_distance_danjia;
    }

    public String getKongshi_fee() {
        return kongshi_fee;
    }

    public void setKongshi_fee(String kongshi_fee) {
        this.kongshi_fee = kongshi_fee;
    }

    public String getOrigin_amount() {
        return origin_amount;
    }

    public void setOrigin_amount(String origin_amount) {
        this.origin_amount = origin_amount;
    }

    public String getCoupon_facevalue() {
        return coupon_facevalue;
    }

    public void setCoupon_facevalue(String coupon_facevalue) {
        this.coupon_facevalue = coupon_facevalue;
    }

    public String getOrder_amount() {
        return order_amount;
    }

    public void setOrder_amount(String order_amount) {
        this.order_amount = order_amount;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public String getPay_amount() {
        return pay_amount;
    }

    public void setPay_amount(String pay_amount) {
        this.pay_amount = pay_amount;
    }

    public String getTime_length() {
        return time_length;
    }

    public void setTime_length(String time_length) {
        this.time_length = time_length;
    }

    public String getActual_time_length() {
        return actual_time_length;
    }

    public void setActual_time_length(String actual_time_length) {
        this.actual_time_length = actual_time_length;
    }

    public String getKilo_length() {
        return kilo_length;
    }

    public void setKilo_length(String kilo_length) {
        this.kilo_length = kilo_length;
    }

    public String getFee_per_hour() {
        return fee_per_hour;
    }

    public void setFee_per_hour(String fee_per_hour) {
        this.fee_per_hour = fee_per_hour;
    }

    public String getTime_fee() {
        return time_fee;
    }

    public void setTime_fee(String time_fee) {
        this.time_fee = time_fee;
    }

    public String getFee_per_kilo() {
        return fee_per_kilo;
    }

    public void setFee_per_kilo(String fee_per_kilo) {
        this.fee_per_kilo = fee_per_kilo;
    }

    public String getKilo_fee() {
        return kilo_fee;
    }

    public void setKilo_fee(String kilo_fee) {
        this.kilo_fee = kilo_fee;
    }

    public String getExtra_distance() {
        return extra_distance;
    }

    public void setExtra_distance(String extra_distance) {
        this.extra_distance = extra_distance;
    }

    public String getExtra_distance_danjia() {
        return extra_distance_danjia;
    }

    public void setExtra_distance_danjia(String extra_distance_danjia) {
        this.extra_distance_danjia = extra_distance_danjia;
    }

    public String getExtra_distance_fee() {
        return extra_distance_fee;
    }

    public void setExtra_distance_fee(String extra_distance_fee) {
        this.extra_distance_fee = extra_distance_fee;
    }

    public String getExtra_time() {
        return extra_time;
    }

    public void setExtra_time(String extra_time) {
        this.extra_time = extra_time;
    }

    public String getExtra_time_danjia() {
        return extra_time_danjia;
    }

    public void setExtra_time_danjia(String extra_time_danjia) {
        this.extra_time_danjia = extra_time_danjia;
    }

    public String getExtra_time_fee() {
        return extra_time_fee;
    }

    public void setExtra_time_fee(String extra_time_fee) {
        this.extra_time_fee = extra_time_fee;
    }

    public String getAirport_service_amount() {
        return airport_service_amount;
    }

    public void setAirport_service_amount(String airport_service_amount) {
        this.airport_service_amount = airport_service_amount;
    }

    public String getNight_amount() {
        return night_amount;
    }

    public void setNight_amount(String night_amount) {
        this.night_amount = night_amount;
    }

    public String getAdjust_fee() {
        return adjust_fee;
    }

    public void setAdjust_fee(String adjust_fee) {
        this.adjust_fee = adjust_fee;
    }

    public String getOther_fee() {
        return other_fee;
    }

    public void setOther_fee(String other_fee) {
        this.other_fee = other_fee;
    }

    public String getOther_fee_msg() {
        return other_fee_msg;
    }

    public void setOther_fee_msg(String other_fee_msg) {
        this.other_fee_msg = other_fee_msg;
    }

    public String getActual_board_time() {
        return actual_board_time;
    }

    public void setActual_board_time(String actual_board_time) {
        this.actual_board_time = actual_board_time;
    }

    public String getActual_off_time() {
        return actual_off_time;
    }

    public void setActual_off_time(String actual_off_time) {
        this.actual_off_time = actual_off_time;
    }

    public String getActual_car_type() {
        return actual_car_type;
    }

    public void setActual_car_type(String actual_car_type) {
        this.actual_car_type = actual_car_type;
    }

    public String getTime_length_minute() {
        return time_length_minute;
    }

    public void setTime_length_minute(String time_length_minute) {
        this.time_length_minute = time_length_minute;
    }

    public String getExtra_time_minute() {
        return extra_time_minute;
    }

    public void setExtra_time_minute(String extra_time_minute) {
        this.extra_time_minute = extra_time_minute;
    }

    public String getFee_per_minute() {
        return fee_per_minute;
    }

    public void setFee_per_minute(String fee_per_minute) {
        this.fee_per_minute = fee_per_minute;
    }

    public String getCancel_order_amount() {
        return cancel_order_amount;
    }

    public void setCancel_order_amount(String cancel_order_amount) {
        this.cancel_order_amount = cancel_order_amount;
    }

    public int getCancel_deposit() {
        return cancel_deposit;
    }

    public void setCancel_deposit(int cancel_deposit) {
        this.cancel_deposit = cancel_deposit;
    }

    public String getCancel_pay_amount() {
        return cancel_pay_amount;
    }

    public void setCancel_pay_amount(String cancel_pay_amount) {
        this.cancel_pay_amount = cancel_pay_amount;
    }

    public int getCancel_change_amount() {
        return cancel_change_amount;
    }

    public void setCancel_change_amount(int cancel_change_amount) {
        this.cancel_change_amount = cancel_change_amount;
    }
}
