package com.ridegroup.yop.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import com.alibaba.fastjson.TypeReference;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ridegroup.yop.Version;

public class LocalHttpClient {

    private static final Logger logger = LoggerFactory.getLogger(LocalHttpClient.class);

    private static int timeout = 8000;

    private static int retryExecutionCount = 2;

    protected static CloseableHttpClient httpClient = HttpClientFactory.createHttpClient(100, 10, timeout, retryExecutionCount);

    private static Map<String, CloseableHttpClient> httpClient_mchKeyStore = new ConcurrentHashMap<String, CloseableHttpClient>();

    private static ResultErrorHandler resultErrorHandler;

    protected static final Header userAgentHeader = new BasicHeader(HttpHeaders.USER_AGENT, "yop-java sdk java v" + Version.VERSION);

    /**
     * @param timeout timeout
     * @since 2.7.0
     */
    public static void setTimeout(int timeout) {
        LocalHttpClient.timeout = timeout;
    }

    /**
     * @param retryExecutionCount retryExecutionCount
     * @since 2.7.0
     */
    public static void setRetryExecutionCount(int retryExecutionCount) {
        LocalHttpClient.retryExecutionCount = retryExecutionCount;
    }

    /**
     * @param resultErrorHandler 数据返回错误处理
     * @since 2.8.3
     */
    public static void setResultErrorHandler(ResultErrorHandler resultErrorHandler) {
        LocalHttpClient.resultErrorHandler = resultErrorHandler;
    }

    /**
     * @param maxTotal    maxTotal
     * @param maxPerRoute maxPerRoute
     */
    public static void init(int maxTotal, int maxPerRoute) {
        try {
            httpClient.close();
        } catch (IOException e) {
            logger.error("init error", e);
        }
        httpClient = HttpClientFactory.createHttpClient(maxTotal, maxPerRoute, timeout, retryExecutionCount);
    }

    /**
     * 初始化   MCH HttpClient KeyStore
     *
     * @param mch_id           mch_id
     * @param keyStoreFilePath keyStoreFilePath
     */
    public static void initMchKeyStore(String mch_id, String keyStoreFilePath) {
        try {
            initMchKeyStore(mch_id, new FileInputStream(new File(keyStoreFilePath)));
        } catch (FileNotFoundException e) {
            logger.error("init error", e);
        }
    }

    /**
     * 初始化   MCH HttpClient KeyStore
     *
     * @param mch_id      mch_id
     * @param inputStream p12 文件流
     * @since 2.8.7
     */
    public static void initMchKeyStore(String mch_id, InputStream inputStream) {
        try {
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            keyStore.load(inputStream, mch_id.toCharArray());
            inputStream.close();
            CloseableHttpClient httpClient = HttpClientFactory.createKeyMaterialHttpClient(keyStore, mch_id, timeout, retryExecutionCount);
            httpClient_mchKeyStore.put(mch_id, httpClient);
        } catch (Exception e) {
            logger.error("init mch error", e);
        }
    }


    public static CloseableHttpResponse execute(HttpUriRequest request) {
        loggerRequest(request);
        userAgent(request);
        try {
            return httpClient.execute(request, HttpClientContext.create());
        } catch (Exception e) {
            logger.error("execute error", e);
        }
        return null;
    }

    public static <T> T execute(HttpUriRequest request, ResponseHandler<T> responseHandler) {
        String uriId = loggerRequest(request);
        userAgent(request);
        if (responseHandler instanceof LocalResponseHandler) {
            LocalResponseHandler lrh = (LocalResponseHandler) responseHandler;
            lrh.setUriId(uriId);
        }
        try {
            T t = httpClient.execute(request, responseHandler, HttpClientContext.create());
            if (resultErrorHandler != null) {
                resultErrorHandler.doHandle(uriId, request, t);
            }
            return t;
        } catch (Exception e) {
            logger.error("execute error", e);
        }
        return null;
    }


    /**
     * 数据返回自动JSON对象解析
     *
     * @param request request
     * @param clazz   clazz
     * @param <T>     T
     * @return result
     */
    public static <T> T executeJsonResult(HttpUriRequest request, Class<T> clazz) {
        return execute(request, JsonResponseHandler.createResponseHandler(clazz));
    }

    public static <T> T executeJsonResult(HttpUriRequest request, TypeReference<T> type) {
        return execute(request, JsonResponseHandler.createResponseHandler(type));
    }

    public static <T> T keyStoreExecute(String mch_id, HttpUriRequest request, ResponseHandler<T> responseHandler) {
        String uriId = loggerRequest(request);
        userAgent(request);
        if (responseHandler instanceof LocalResponseHandler) {
            LocalResponseHandler lrh = (LocalResponseHandler) responseHandler;
            lrh.setUriId(uriId);
        }
        try {
            T t = httpClient_mchKeyStore.get(mch_id).execute(request, responseHandler, HttpClientContext.create());
            if (resultErrorHandler != null) {
                resultErrorHandler.doHandle(uriId, request, t);
            }
            return t;
        } catch (Exception e) {
            logger.error("execute error", e);
        }
        return null;
    }

    /**
     * 日志记录
     *
     * @param request request
     * @return log request id
     */
    private static String loggerRequest(HttpUriRequest request) {
        String id = UUID.randomUUID().toString();
        if (logger.isInfoEnabled() || logger.isDebugEnabled()) {
            if (request instanceof HttpEntityEnclosingRequestBase) {
                HttpEntityEnclosingRequestBase request_base = (HttpEntityEnclosingRequestBase) request;
                HttpEntity entity = request_base.getEntity();
                String content = null;
                //MULTIPART_FORM_DATA 请求类型判断
                if (entity.getContentType().toString().indexOf(ContentType.MULTIPART_FORM_DATA.getMimeType()) == -1) {
                    try {
                        content = EntityUtils.toString(entity);
                    } catch (Exception e) {
                        logger.error("logger content data get error", e);
                    }
                }
                logger.info("URI[{}] {} {} ContentLength:{} Content:{}",
                        id,
                        request.getURI().toString(),
                        entity.getContentType(),
                        entity.getContentLength(),
                        content == null ? "multipart_form_data" : content);
            } else {
                logger.info("URI[{}] {}", id, request.getURI().toString());
            }
        }
        return id;
    }

    private static void userAgent(HttpUriRequest httpUriRequest) {
        httpUriRequest.addHeader(userAgentHeader);
    }
}
