package com.app.marvel.service;

import java.util.Map;

public interface HttpClientService {
    <T> T doGet(String endPoint, Map<String, String> queryParams, Class<T> responseType);
    <T, R> T doPost(String endPoint, Map<String, String> queryParams, Class<T> responseType, R requesBody);
    <T, R> T doPut(String endPoint, Map<String, String> queryParams, Class<T> responseType, R requesBody);
    <T> T doDelete(String endPoint, Map<String, String> queryParams, Class<T> responseType);
}
