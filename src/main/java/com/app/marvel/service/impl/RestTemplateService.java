package com.app.marvel.service.impl;

import com.app.marvel.exception.ApiErrorException;
import com.app.marvel.service.HttpClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Service
public class RestTemplateService implements HttpClientService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public <T> T doGet(String endPoint, Map<String, String> queryParams, Class<T> responseType) {
        String finalUrl = buildFinalUrl(endPoint, queryParams);
        HttpEntity httpEntity = new HttpEntity(getHeader());

        ResponseEntity<T> response = restTemplate.exchange(finalUrl, HttpMethod.GET, httpEntity, responseType);

        if (response.getStatusCode().value() != HttpStatus.OK.value()) {
            String message = String.format("Error consumiendo el endopoint en el backend[{} - {}], el codigo de respuesta: {}",HttpMethod.GET, endPoint ,response.getStatusCode().value() );
            throw new ApiErrorException(message);
        }
        return response.getBody();
    }

    @Override
    public <T, R> T doPost(String endPoint, Map<String, String> queryParams, Class<T> responseType, R requesBody) {
        String finalUrl = buildFinalUrl(endPoint, queryParams);
        HttpEntity httpEntity = new HttpEntity(requesBody, getHeader());

        ResponseEntity<T> response = restTemplate.exchange(finalUrl, HttpMethod.POST, httpEntity, responseType);

        if (response.getStatusCode().value() != HttpStatus.OK.value() || response.getBody() == null) {
            String message = String.format("Error consumiendo el endopoint en el backend[{} - {}], el codigo de respuesta: {}",HttpMethod.GET, endPoint ,response.getStatusCode().value() );
            throw new ApiErrorException(message);
        }
        return response.getBody();
    }

    @Override
    public <T, R> T doPut(String endPoint, Map<String, String> queryParams, Class<T> responseType, R requesBody) {
        String finalUrl = buildFinalUrl(endPoint, queryParams);
        HttpEntity httpEntity = new HttpEntity(requesBody, getHeader());

        ResponseEntity<T> response = restTemplate.exchange(finalUrl, HttpMethod.PUT, httpEntity, responseType);

        if (response.getStatusCode().value() != HttpStatus.OK.value() || response.getBody() == null) {
            String message = String.format("Error consumiendo el endopoint en el backend[{} - {}], el codigo de respuesta: {}",HttpMethod.GET, endPoint ,response.getStatusCode().value() );
            throw new ApiErrorException(message);
        }
        return response.getBody();
    }

    @Override
    public <T> T doDelete(String endPoint, Map<String, String> queryParams, Class<T> responseType) {
        String finalUrl = buildFinalUrl(endPoint, queryParams);
        HttpEntity httpEntity = new HttpEntity(getHeader());

        ResponseEntity<T> response = restTemplate.exchange(finalUrl, HttpMethod.DELETE, httpEntity, responseType);

        if (response.getStatusCode().value() != HttpStatus.OK.value()) {
            String message = String.format("Error consumiendo el endopoint en el backend[{} - {}], el codigo de respuesta: {}",HttpMethod.GET, endPoint ,response.getStatusCode().value() );
            throw new ApiErrorException(message);
        }
        return response.getBody();
    }

    private HttpHeaders getHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    private String buildFinalUrl(String endPoint, Map<String, String> queryParams) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(endPoint);
        if(builder != null){
            //con este codigo contruimos el mapa en  cadena de hash=hola?ts=100
            for (Map.Entry<String, String> paramt: queryParams.entrySet()){
                builder.queryParam(paramt.getKey(), paramt.getValue());
            }
        }

        return builder.build().toString();
    }

}
