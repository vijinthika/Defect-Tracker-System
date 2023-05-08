package com.defect.tracker.controller;

import com.defect.tracker.dto.DefectStatusRequest;
import com.defect.tracker.dto.DefectStatusResponse;
import com.defect.tracker.service.DefectStausService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DefectStatusController {
    @Autowired
    private DefectStausService defectStausService;

    @PostMapping("/createDefectStatus")
    public ResponseEntity<String> createDefectStatus(@RequestBody DefectStatusRequest defectStatusRequest) {
        defectStausService.createDefectsStatus(defectStatusRequest);
        return new ResponseEntity<String>("New Defect Status is created", HttpStatus.OK);
    }

    @PutMapping("/editDefectStatus")
    public ResponseEntity<String> editDefcetstatus(@RequestBody DefectStatusRequest defectStatusRequest) {
        defectStausService.createDefectsStatus(defectStatusRequest);
        return new ResponseEntity<String>("Defect status is updated", HttpStatus.OK);

    }

    @GetMapping("/getAllDefectStatus")
    public ResponseEntity<List<DefectStatusResponse>> getALlDefectStatus() {
        List<DefectStatusResponse> defectstatusResponses = defectStausService.getAllDefectStatus();
        return new ResponseEntity<List<DefectStatusResponse>>(defectstatusResponses, HttpStatus.OK);
    }

    @GetMapping("/getByDefectStatusID/{id}")
    public ResponseEntity<DefectStatusResponse> getByDefectStatusId(@PathVariable(value = "id") Long id) {
        DefectStatusResponse defectStatusResponse = defectStausService.getDefectStatusBYID(id);
        return new ResponseEntity<DefectStatusResponse>(defectStatusResponse, HttpStatus.OK);
    }

    @DeleteMapping("deleteByDefectStatusId/{id}")
    public ResponseEntity<String> deleteDefectStatus(@PathVariable(value = "id") Long id) {
        defectStausService.deleteDefectStatus(id);
        return new ResponseEntity<String>("Defect type " + id + " is deleted", HttpStatus.OK);
    }

}
