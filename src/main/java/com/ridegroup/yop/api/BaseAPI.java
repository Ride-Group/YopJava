package com.ridegroup.yop.api;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.entity.ContentType;
import org.apache.http.message.BasicHeader;

public abstract class BaseAPI {
    protected static final String BASE_URI = "https://yop.yongche.com";

    public final static String MAP_TYPE_BAIDU = "1";
    public final static String MAP_TYPE_MARS = "2";
    public final static String MAP_TYPE_GOOGLE = "3";

    protected static Header jsonHeader = new BasicHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString());
    protected static Header xmlHeader = new BasicHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_XML.toString());

    protected static final String PARAM_ACCESS_TOKEN = "access_token";

}
