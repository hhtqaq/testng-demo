package com.ecjtu.hht.testngdemo.api;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;

/**
 * 在项目启动之后  模拟发送http请求
 *
 * @author hht
 * @date 2019/9/7 14:03
 */
public class StudentApi {
    public static final String BASE_URL = "http://localhost:8080";
    public static HttpClient client;


    /**
     * 获取get请求的http状态
     *
     * @param url
     * @return
     */
    public static int getStudentStatus(String url) {
        HttpUriRequest method = new HttpGet(BASE_URL + url);
        client = new DefaultHttpClient();
        int statusCode = 0;
        HttpResponse response = null;
        try {
            response = client.execute(method);
            //heep请求响应状态码
            statusCode = response.getStatusLine().getStatusCode();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            method.abort();
        }
        return statusCode;
    }
}
