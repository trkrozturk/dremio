package com.dremio.dremioRest;

import com.dremio.constant.UrlConstant;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

public class GetRequest extends RequestFactory {

    public GetRequest() {
        super.HTTP_METHOD = HttpMethod.GET;
    }

    public ResponseEntity<String> getCatalog(HttpHeaders headers) {
        return sendRequest(UrlConstant.CATALOG.label, headers);
    }

    public ResponseEntity<String> getJobStatus(String jobId, HttpHeaders headers) {
        return sendRequest(UrlConstant.JOB.label + "/" + jobId, headers);
    }

    public ResponseEntity<String> getJobResults(String jobId, HttpHeaders headers) {
        return sendRequest(UrlConstant.JOB.label + "/" + jobId + "/results", headers);
    }

}
