package com.dremio.dremioRest;

import com.dremio.constant.UrlConstant;
import com.dremio.model.*;
import com.google.gson.JsonParser;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.Optional;


public class PostRequest extends RequestFactory {

    JsonParser jsonParser = new JsonParser();

    public PostRequest() {
        super.HTTP_METHOD = HttpMethod.POST;
    }

    public ResponseEntity<String> login(User user) {
        return sendRequestWithBody(UrlConstant.LOGIN.label, new HttpHeaders(), user);
    }

    public ResponseEntity<String> addSource(Source source, HttpHeaders headers) {
        return sendRequestWithBody(UrlConstant.CATALOG.label, headers, source);
    }

    public ResponseEntity<String> addSpace(Space space, HttpHeaders headers) {
        return sendRequestWithBody(UrlConstant.CATALOG.label, headers, space);
    }

    public ResponseEntity<String> addFolder(Folder folder, HttpHeaders headers) {
        return sendRequestWithBody(UrlConstant.CATALOG.label, headers, folder);
    }

    public ResponseEntity<String> addDataset(Dataset dataset, HttpHeaders headers) {
        return sendRequestWithBody(UrlConstant.CATALOG.label, headers, dataset);
    }

    public ResponseEntity<String> addReflection(Reflection reflection, HttpHeaders headers) {
        return sendRequestWithBody(UrlConstant.REFLECTION.label, headers, reflection);
    }

    public ResponseEntity<String> runSql(Sql sql, HttpHeaders headers) {
        ResponseEntity<String> responseEntity = sendRequestWithBody(UrlConstant.SQL.label, headers, sql);
        Optional<String> optionalS = Optional.ofNullable(responseEntity.getBody());
        if (optionalS.isPresent()) {
            String id = jsonParser.parse(optionalS.get()).getAsJsonObject().get("id").getAsString();
            ResponseEntity<String> jobStatus = new GetRequest().getJobStatus(id, headers);
            if (jobStatus.getBody() != null && !jobStatus.getBody().isEmpty()) {
                String jobState = jsonParser.parse(jobStatus.getBody()).getAsJsonObject().get("jobState").getAsString();
                while (!jobState.equalsIgnoreCase("FAILED") && !jobState.equalsIgnoreCase("COMPLETED")) {
                    jobStatus = new GetRequest().getJobStatus(id, headers);
                    if (jobStatus.getBody() != null && !jobStatus.getBody().isEmpty()) {
                        jobState = jsonParser.parse(jobStatus.getBody()).getAsJsonObject().get("jobState").getAsString();

                    } else return jobStatus;
                }
                if (jobState.equalsIgnoreCase("FAILED")) {
                    return jobStatus;
                }
                if (jobState.equalsIgnoreCase("COMPLETED")) {
                    return new GetRequest().getJobResults(id, headers);
                }
            }

        }
        return responseEntity;
    }
}