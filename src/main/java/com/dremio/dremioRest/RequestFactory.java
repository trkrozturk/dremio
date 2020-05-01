package com.dremio.dremioRest;

import com.dremio.model.BaseModel;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

@Configurable
public abstract class RequestFactory {

    private String URL = System.getProperties().get("dremioUrl").toString();
    protected HttpMethod HTTP_METHOD;
    RestTemplate restTemplate = new RestTemplate();

    ResponseEntity<String> sendRequestWithBody(String path, HttpHeaders headers, BaseModel clazz) {
        return restTemplate.exchange(URL + path, HTTP_METHOD, getHttpHeadersWithBody(clazz, headers), String.class);
    }

    ResponseEntity<String> sendRequest(String path, HttpHeaders headers) {
        return restTemplate.exchange(URL + path, HTTP_METHOD, getHttpHeaders(headers), String.class);
    }

    private HttpEntity<BaseModel> getHttpHeaders(HttpHeaders headers) {

        HttpHeaders dremioHeader = new HttpHeaders();
        dremioHeader.set("Authorization", headers.get("Authorization").get(0));
        dremioHeader.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(dremioHeader);
    }

    private HttpEntity<BaseModel> getHttpHeadersWithBody(BaseModel clazz, HttpHeaders headers) {

        HttpHeaders dremioHeader = new HttpHeaders();
        dremioHeader.set("Authorization", headers.get("Authorization") != null ? headers.get("Authorization").get(0) : "null");
        dremioHeader.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(clazz, dremioHeader);
    }
}
