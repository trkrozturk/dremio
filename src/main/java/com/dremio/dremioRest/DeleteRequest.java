package com.dremio.dremioRest;

import com.dremio.constant.UrlConstant;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

public class DeleteRequest extends RequestFactory {

    public DeleteRequest() {
        super.HTTP_METHOD = HttpMethod.DELETE;
    }

    public ResponseEntity<String> deleteCatalog(HttpHeaders headers, String id) {
        return sendRequest(UrlConstant.CATALOG.label + "/" + id, headers);
    }

    public ResponseEntity<String> deleteReflection(HttpHeaders headers, String id) {
        return sendRequest(UrlConstant.REFLECTION.label + "/" + id, headers);
    }
}
