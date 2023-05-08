package com.defect.tracker.controller;

import com.defect.tracker.dto.DesignationRequest;
import com.defect.tracker.dto.DesignationResponse;
import com.defect.tracker.service.DesignationService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DesignationController {

    @Autowired
    private DesignationService designationService;

    @PostMapping("/createDesignation")
    public ResponseEntity<String> createDesignation(@RequestBody DesignationRequest designationRequest)
    {
        System.out.println(designationRequest.getName());
        if(designationRequest.getName()==null){
            System.out.println("Hiiiiiiiiiiii");
        }
        designationService.createDesignation(designationRequest);
        return new ResponseEntity<String>("Designation is created", HttpStatus.OK);
    }

    @PutMapping("/editDesignation")
    public ResponseEntity<String> editDesignation(DesignationRequest designationRequest)
    {
        designationService.createDesignation(designationRequest);
        return new ResponseEntity<String>("Designation is updated", HttpStatus.OK);
    }

    @GetMapping("/getAllDesignation")
    public ResponseEntity<List<DesignationResponse>> getAllDesignation()
    {
        List<DesignationResponse> designationResponses=designationService.getAllDesignation();
        return new ResponseEntity<List<DesignationResponse>>(designationResponses,HttpStatus.OK);
    }

    @GetMapping("/getByDesignationID/{id}")
    public ResponseEntity<DesignationResponse> getByDesignationId(@PathVariable(value = "id") Long id)
    {
        DesignationResponse designationResponse=designationService.getBYDesignationId(id);
        return new ResponseEntity<DesignationResponse>(designationResponse,HttpStatus.OK);
    }

    @DeleteMapping("/deleteDesignationById/{id}")
    public ResponseEntity<String> deleteDesignationById(@PathVariable(value = "id") Long id)
    {
        designationService.deleteDesignation(id);
        return new ResponseEntity<String>("Deleted",HttpStatus.OK);
    }
}
