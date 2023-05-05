package com.defect.tracker.controller;

import com.defect.tracker.dto.DefectRequest;
import com.defect.tracker.dto.DefectResponse;
import com.defect.tracker.dto.DefectStatusResponse;
import com.defect.tracker.service.DefcetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DefectController {
    @Autowired
    private DefcetService defcetService;

    @PostMapping("/createDefect")
    public ResponseEntity<String> createDefect(@RequestBody DefectRequest defectRequest) {
        defcetService.createDefect(defectRequest);
        return new ResponseEntity<String>("New Defect is created", HttpStatus.OK);
    }

    @PutMapping("/editDefect")
    public ResponseEntity<String> editDefcet(@RequestBody DefectRequest defectRequest) {
        defcetService.createDefect(defectRequest);
        return new ResponseEntity<String>("Defect is updated", HttpStatus.OK);

    }

    @GetMapping("/getAllDefect")
    public ResponseEntity<List<DefectResponse>> getALlDefect() {
        List<DefectResponse> defectResponses = defcetService.getAllDefect();
        return new ResponseEntity<List<DefectResponse>>(defectResponses, HttpStatus.OK);
    }

    @GetMapping("/getByDefectID/{id}")
    public ResponseEntity<DefectResponse> getByDefectId(@PathVariable(value = "id") Long id) {
        DefectResponse defectResponse = defcetService.getDefectById(id);
        return new ResponseEntity<DefectResponse>(defectResponse, HttpStatus.OK);
    }

    @DeleteMapping("deleteByDefectId/{id}")
    public ResponseEntity<String> deleteDefect(@PathVariable(value = "id") Long id) {
        defcetService.deleteDefect(id);
        return new ResponseEntity<String>("Defect  " + id + " is deleted", HttpStatus.OK);
    }

}
