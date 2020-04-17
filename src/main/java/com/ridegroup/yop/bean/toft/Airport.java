package com.ridegroup.yop.bean.toft;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Map;

/**
 * short: "bj",
     name: "北京",
     en: "beijing",
     airport:- {
         PEK:- {
             lat: 40.086024,
             lng: 116.594654,
             name: "北京首都国际机场",
             terminal_list: "[{"code":"T1","lat":40.086074,"lng":116.595102,"name":"\u5317\u4eac\u9996\u90fd\u56fd\u9645\u673a\u573aT1\u822a\u7ad9\u697c"},{"code":"T2","lat":40.084409,"lng":116.599893,"name":"\u5317\u4eac\u9996\u90fd\u56fd\u9645\u673a\u573aT2\u822a\u7ad9\u697c"},{"code":"T3","lat":40.06065,"lng":116.623258,"name":"\u5317\u4eac\u9996\u90fd\u56fd\u9645\u673a\u573aT3\u822a\u7ad9\u697c"}]"
         },
         PKX:- {
             lat: 39.519883,
             lng: 116.422776,
             name: "北京大兴国际机场",
             terminal_list: "[]"
         }
     }
 */
public class Airport {
    @JSONField(name = "short")
    private String city_short;
    private String name;
    private String en;
    private Map<String, SubAirport> airport;

    public String getCity_short() {
        return city_short;
    }

    public void setCity_short(String city_short) {
        this.city_short = city_short;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public Map<String, SubAirport> getAirport() {
        return airport;
    }

    public void setAirport(Map<String, SubAirport> airport) {
        this.airport = airport;
    }

    public static class SubAirport {
        private double lat;
        private double lng;
        private String name;
        private String terminal_list;

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public double getLng() {
            return lng;
        }

        public void setLng(double lng) {
            this.lng = lng;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTerminal_list() {
            return terminal_list;
        }

        public void setTerminal_list(String terminal_list) {
            this.terminal_list = terminal_list;
        }
    }
}
