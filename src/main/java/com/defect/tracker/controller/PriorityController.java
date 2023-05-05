package com.defect.tracker.controller;

import com.defect.tracker.dto.PriorityRequest;
import com.defect.tracker.dto.PriorityResponse;
import com.defect.tracker.repository.PriorityRepository;
import com.defect.tracker.service.PriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PriorityController {
    @Autowired
    private PriorityService priorityService;
    @PostMapping("/createPriority")
    public ResponseEntity<String> createPriority(@RequestBody PriorityRequest priorityRequest)
    {
        priorityService.createPriority(priorityRequest);
        return new ResponseEntity<String>("succesfully addedd", HttpStatus.OK);
    }

    @PutMapping("/editPriority")
    public ResponseEntity<String > editPriority(@RequestBody PriorityRequest priorityRequest)
    {
        priorityService.createPriority(priorityRequest);
        return new ResponseEntity<String>("the priority id"+priorityRequest.getId()+"is succefully edited",HttpStatus.OK);
    }

    @GetMapping("/deletePriority/{id}")
    public ResponseEntity<PriorityResponse> getByPriorityID(@PathVariable(value = "id") Long id)
    {
       PriorityResponse priorityResponse= priorityService.getByPriorityID(id);
       return new ResponseEntity<PriorityResponse>(priorityResponse,HttpStatus.OK);
    }

    @GetMapping("/getAllPriority")
    public ResponseEntity<List<PriorityResponse>> getAllPriority()
    {
        List<PriorityResponse> priorityResponses=priorityService.getAllPriority();
        return new ResponseEntity<List<PriorityResponse>>(priorityResponses,HttpStatus.OK);
    }

    @DeleteMapping("/deletePriority/{id}")
    public ResponseEntity<String> deletePriority(@PathVariable(value = "id") Long id)
    {
        priorityService.deletePriority(id);
        return new ResponseEntity<String>("priority id"+id+"is deleted",HttpStatus.OK);
    }


}

