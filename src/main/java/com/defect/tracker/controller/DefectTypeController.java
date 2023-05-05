package com.defect.tracker.controller;

import com.defect.tracker.dto.DefectTypeRequest;
import com.defect.tracker.dto.DefectTypeResponse;
import com.defect.tracker.service.DefectTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DefectTypeController {

    @Autowired
    private DefectTypeService defectTypeService;

    @PostMapping("/createDefectType")
    public ResponseEntity<String> createDefectType(@RequestBody DefectTypeRequest defectTypeRequest) {
        defectTypeService.createDefectType(defectTypeRequest);
        return new ResponseEntity<String>("New Defect is created", HttpStatus.OK);
    }

    @PutMapping("/editDefectType")
    public ResponseEntity<String> editDefcetType(@RequestBody DefectTypeRequest defectTypeRequest) {
        defectTypeService.createDefectType(defectTypeRequest);
        return new ResponseEntity<String>("Defect is created updated", HttpStatus.OK);
    }

    @GetMapping("/getAllDefectType")
    public ResponseEntity<List<DefectTypeResponse>> getALlDefectType() {
        List<DefectTypeResponse> defectTypeResponses = defectTypeService.getAllDefectType();
        return new ResponseEntity<List<DefectTypeResponse>>(defectTypeResponses, HttpStatus.OK);
    }

    @GetMapping("/getByDefectTypeId/{id}")
    public ResponseEntity<DefectTypeResponse> getByDefectId(@PathVariable(value = "id") Long id) {
        DefectTypeResponse defectTypeResponse = defectTypeService.getDefectTypeBYID(id);
        return new ResponseEntity<DefectTypeResponse>(defectTypeResponse, HttpStatus.OK);
    }

    @DeleteMapping("deleteDefectTypeById/{id}")
    public ResponseEntity<String> deleteDefectType(@PathVariable(value = "id") Long id) {
        defectTypeService.deleteDefectType(id);
        return new ResponseEntity<String>("Defect type " + id + " is deleted", HttpStatus.OK);
    }


}