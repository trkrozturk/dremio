package com.dremio.applicationRest;

import com.dremio.dremioRest.DeleteRequest;
import com.dremio.dremioRest.GetRequest;
import com.dremio.dremioRest.PostRequest;
import com.dremio.model.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @PostMapping("/login")
    ResponseEntity<String> login(@RequestBody User user) {
        return new PostRequest().login(user);
    }

    @PostMapping("/source")
    ResponseEntity<String> addSource(@RequestBody Source source, @RequestHeader HttpHeaders headers) {
        return new PostRequest().addSource(source, headers);
    }

    @PostMapping("/space")
    ResponseEntity<String> addSpace(@RequestBody Space space, @RequestHeader HttpHeaders headers) {
        return new PostRequest().addSpace(space, headers);
    }

    @PostMapping("/folder")
    ResponseEntity<String> addFolder(@RequestBody Folder folder, @RequestHeader HttpHeaders headers) {
        return new PostRequest().addFolder(folder, headers);
    }

    @PostMapping("/dataset")
    ResponseEntity<String> addDataset(@RequestBody Dataset dataset, @RequestHeader HttpHeaders headers) {
        return new PostRequest().addDataset(dataset, headers);
    }

    @PostMapping("/reflection")
    ResponseEntity<String> addReflection(@RequestBody Reflection reflection, @RequestHeader HttpHeaders headers) {
        return new PostRequest().addReflection(reflection, headers);
    }

    @GetMapping("/catalog")
    ResponseEntity<String> fetchCatalog(@RequestHeader HttpHeaders headers) {
        return new GetRequest().getCatalog(headers);
    }

    @DeleteMapping("/catalog/{id}")
    ResponseEntity<String> deleteCatalog(@RequestHeader HttpHeaders headers, @PathVariable String id) {
        return new DeleteRequest().deleteCatalog(headers, id);
    }

    @DeleteMapping("/reflection/{id}")
    ResponseEntity<String> deleteReflection(@RequestHeader HttpHeaders headers, @PathVariable String id) {
        return new DeleteRequest().deleteReflection(headers, id);
    }

    @PostMapping("/sql")
    ResponseEntity<String> runSql(@RequestBody Sql sql, @RequestHeader HttpHeaders headers) {
        return new PostRequest().runSql(sql, headers);
    }
}
