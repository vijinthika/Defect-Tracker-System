package com.defect.tracker.controller;

import com.defect.tracker.dto.ProjectStatusRequest;
import com.defect.tracker.dto.ProjectStatusResponse;
import com.defect.tracker.service.ProjectStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectStatusController {

    @Autowired
    private ProjectStatusService projectStatusService;

    @PostMapping("/addProjectStatus")
    public ResponseEntity<String> addProjectStatus(@RequestBody ProjectStatusRequest projectStatusRequest) {
        projectStatusService.createProjectStatus(projectStatusRequest);
        return new ResponseEntity<String>("New ProjectStatus is Added", HttpStatus.OK);
    }

    @PutMapping("/editProjectStatus")
    public ResponseEntity<String> editProjectStatus(@RequestBody ProjectStatusRequest projectStatusRequest) {
        projectStatusService.createProjectStatus(projectStatusRequest);
        return new ResponseEntity<String>("ProjectStatus is Updated", HttpStatus.OK);
    }

    @GetMapping("/getAllProjectStatus")
    public ResponseEntity<List<ProjectStatusResponse>> getALlProjectStatus() {
        List<ProjectStatusResponse> projectStatusResponses = projectStatusService.getAllProjectStatus();
        return new ResponseEntity<List<ProjectStatusResponse>>(projectStatusResponses, HttpStatus.OK);
    }

    @GetMapping("/getProjectStatusById/{id}")
    public ResponseEntity<ProjectStatusResponse> getProjectStatusById(@PathVariable(value = "id") Long id) {
        ProjectStatusResponse projectStatusResponse = projectStatusService.getProjectStatusById(id);
        return new ResponseEntity<ProjectStatusResponse>(projectStatusResponse, HttpStatus.OK);
    }
    @DeleteMapping("/deleteProjectStatusById/{id}")
    public ResponseEntity<String> deleteProjectStatusById(@PathVariable(value = "id") Long id)
    {
        projectStatusService.deleteProjectStatusById(id);
        return new ResponseEntity<String>("Deleted",HttpStatus.OK);
    }

}
