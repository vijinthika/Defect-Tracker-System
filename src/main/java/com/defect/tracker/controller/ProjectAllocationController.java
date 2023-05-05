package com.defect.tracker.controller;

import com.defect.tracker.dto.DesignationRequest;
import com.defect.tracker.dto.DesignationResponse;
import com.defect.tracker.dto.ProjectAllocationRequest;
import com.defect.tracker.dto.ProjectAllocationResponse;
import com.defect.tracker.service.ProjectAllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectAllocationController {
    @Autowired
    private ProjectAllocationService projectAllocationService;

    @PostMapping("/createProjectAllocation")
    public ResponseEntity<String > createProjectAllocation(ProjectAllocationRequest projectAllocationRequest)
    {
        projectAllocationService.createProjectAllocation(projectAllocationRequest);
        return new ResponseEntity<String>("Project ALlocation is created", HttpStatus.OK);
    }

    @PutMapping("/editProjectAllocation")
    public ResponseEntity<String> editProjectAllocation(ProjectAllocationRequest projectAllocationRequest)
    {
        projectAllocationService.createProjectAllocation(projectAllocationRequest);
        return new ResponseEntity<String>("Project ALlocation is updated", HttpStatus.OK);
    }

    @GetMapping("/getAllProjectAllocation")
    public ResponseEntity<List<ProjectAllocationResponse>> getAllProjectAllocation()
    {
        List<ProjectAllocationResponse> projectAllocationResponses=projectAllocationService.getAllProjectALlocation();
        return new ResponseEntity<List<ProjectAllocationResponse>>(projectAllocationResponses,HttpStatus.OK);
    }

    @GetMapping("/getByProjectAllocationId/{id}")
    public ResponseEntity<ProjectAllocationResponse> getByProjectAllocationById(@PathVariable(value = "id") Long id)
    {
        ProjectAllocationResponse projectAllocationResponse=projectAllocationService.getProjectAllocationById(id);
        return new ResponseEntity<ProjectAllocationResponse>(projectAllocationResponse,HttpStatus.OK);
    }

    @DeleteMapping("/deleteProjectAllocationById/{id}")
    public ResponseEntity<String> deleteProjectAllocationById(@PathVariable(value = "id") Long id)
    {
        projectAllocationService.deleteProjectAllocationById(id);
        return new ResponseEntity<String>("Deleted",HttpStatus.OK);
    }
}
