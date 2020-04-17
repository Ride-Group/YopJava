package com.ridegroup.yop.bean.toft;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Map;

/**
 * short: "bj",
     name: "北京",
     en: "beijing",
     train:- {
         _VNP:- {
             lat: 39.870333,
             lng: 116.384835,
             name: "北京南火车站",
             terminal_list: "[]"
         },
         _BXP:- {
             lat: 39.902049,
             lng: 116.327863,
             name: "北京西火车站",
             terminal_list: "[]"
         },
         _BJP:- {
             lat: 39.909587,
             lng: 116.429851,
             name: "北京火车站",
             terminal_list: "[]"
         },
         _VAP:- {
             lat: 39.947794,
             lng: 116.361105,
             name: "北京北火车站",
             terminal_list: "[]"
         }
     }
 */
public class Train {
    @JSONField(name = "short")
    private String city_short;
    private String name;
    private String en;
    private Map<String, SubTrain> train;

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

    public Map<String, SubTrain> getTrain() {
        return train;
    }

    public void setTrain(Map<String, SubTrain> train) {
        this.train = train;
    }

    public static class SubTrain {
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
