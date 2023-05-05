package com.defect.tracker.controller;

import com.defect.tracker.dto.ProjectRequest;
import com.defect.tracker.dto.ProjectResponse;
import com.defect.tracker.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping ("/addProject")
    public ResponseEntity<String > addProject(@RequestBody ProjectRequest projectRequest)
    {
        projectService.createProject(projectRequest);
        return new ResponseEntity<String>("New Project is Added",HttpStatus.OK);
    }
    @GetMapping("/getAllProject")
    public ResponseEntity<List<ProjectResponse>> getAllProjectResponse()
    {
        List<ProjectResponse> projectResponses=projectService.getAllProject();
        return new ResponseEntity<List<ProjectResponse>>(projectResponses, HttpStatus.OK);
    }

    @GetMapping("/getProjectById/{id}")
    public ResponseEntity<ProjectResponse> getProjectByID(@PathVariable (value = "id") Long id)
    {
        ProjectResponse projectResponse=projectService.getProjectById(id);
        return new ResponseEntity<ProjectResponse>(projectResponse,HttpStatus.OK);
    }

    @PutMapping("/editProject")
    public ResponseEntity<String > editProject(@RequestBody ProjectRequest projectRequest)
    {
        projectService.createProject(projectRequest);
        return new ResponseEntity<String>("Project is updated",HttpStatus.OK);
    }

    @DeleteMapping("/deleteProjectById/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable(value = "id") Long id)
    {
        projectService.deleteProject(id);
        return new ResponseEntity<String>("Deleted",HttpStatus.OK);
    }

}
