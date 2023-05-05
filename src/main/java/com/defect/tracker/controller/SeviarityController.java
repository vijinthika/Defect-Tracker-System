package com.defect.tracker.controller;

import com.defect.tracker.dto.SeviarityRequest;
import com.defect.tracker.dto.SeviarityResponse;
import com.defect.tracker.service.SeviarityServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SeviarityController {
    @Autowired
    private SeviarityServiceImple seviarityServiceImple;

    @PostMapping("/addSeviarity")
    public ResponseEntity<String> addSeviarity(@RequestBody SeviarityRequest seviarityRequest) {
        seviarityServiceImple.createSevairity(seviarityRequest);
        return new ResponseEntity<String>("New Seviarity is succesfully added", HttpStatus.OK);
    }

    @PutMapping("/editSeviarity")
    public ResponseEntity<String> updateSeviarity(@RequestBody SeviarityRequest seviarityRequest) {
        seviarityServiceImple.createSevairity(seviarityRequest);
        return new ResponseEntity<String>("Seviarity id" + seviarityRequest.getId() + "is updated", HttpStatus.OK);
    }

    @GetMapping("/getAllSeviarity")
    public ResponseEntity<List<SeviarityResponse>> getAllSeviarity() {
        List<SeviarityResponse> seviarityResponses = seviarityServiceImple.getAllSeviariy();
        return new ResponseEntity<List<SeviarityResponse>>(seviarityResponses, HttpStatus.OK);
    }

    @GetMapping("/getByID/{id}")
    public ResponseEntity<SeviarityResponse> getBySevarityId(@PathVariable(value = "id") Long id) {
        SeviarityResponse seviarityResponse = seviarityServiceImple.getBySevairityID(id);
        return new ResponseEntity<SeviarityResponse>(seviarityResponse, HttpStatus.OK);
    }

    @DeleteMapping("/DeleteByID/{id}")
    public ResponseEntity<String> deleteSeviarityById(@PathVariable(value = "id") Long id) {
        seviarityServiceImple.deleteSeviarity(id);
        return new ResponseEntity<String>("Seviarity id " + id + "is deleted", HttpStatus.OK);
    }

}
