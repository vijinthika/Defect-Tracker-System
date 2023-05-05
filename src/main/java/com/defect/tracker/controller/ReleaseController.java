package com.defect.tracker.controller;

import com.defect.tracker.dto.ReleaseRequest;
import com.defect.tracker.dto.ReleaseResponse;
import com.defect.tracker.service.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReleaseController {
    @Autowired
    private ReleaseService releaseService;

    @PostMapping("/addRelease")
    public ResponseEntity<String> addRelease(@RequestBody ReleaseRequest releaseRequest) {
        releaseService.createRelease(releaseRequest);
        return new ResponseEntity<String>("new Response is suucessfully added", HttpStatus.OK);
    }

    @PutMapping("/editRelease")
    public ResponseEntity<String> editRelease(@RequestBody ReleaseRequest releaseRequest) {
        releaseService.createRelease(releaseRequest);
        return new ResponseEntity<String>("Response is suucessfully updated", HttpStatus.OK);
    }

    @GetMapping("/getALlRelease")
    public ResponseEntity<List<ReleaseResponse>> getAllRelease() {
        List<ReleaseResponse> releaseResponses = releaseService.getAllRelease();
        return new ResponseEntity<List<ReleaseResponse>>(releaseResponses, HttpStatus.OK);

    }

    @GetMapping("/getByReleaseId/{id}")
    public ResponseEntity<ReleaseResponse> getResponseByID(@PathVariable(value = "id") Long id) {
        ReleaseResponse releaseResponse = releaseService.getReleaseResponseById(id);
        return new ResponseEntity<ReleaseResponse>(releaseResponse, HttpStatus.OK);
    }
    @DeleteMapping("/deleteReleaseById/{id}")
    public ResponseEntity<String> deleteReleaseById(@PathVariable(value = "id") Long id)
    {
        releaseService.deleteRelease(id);
        return new ResponseEntity<String>("Deleted",HttpStatus.OK);
    }

}
