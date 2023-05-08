package com.defect.tracker.controller;

import com.defect.tracker.dto.RoleRequest;
import com.defect.tracker.dto.RoleResponse;
import com.defect.tracker.entities.Role;
import com.defect.tracker.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/createRole")
    public ResponseEntity<String> createRole(@RequestBody RoleRequest roleRequest)
    {
        roleService.createRole(roleRequest);
        return new ResponseEntity<String >("New Role is created", HttpStatus.OK);
    }

    @PutMapping("/editRole")
    public ResponseEntity<String> editRole(@RequestBody RoleRequest roleRequest)
    {
        roleService.createRole(roleRequest);
        return new ResponseEntity<String >("Role is Updated", HttpStatus.OK);
    }

    @GetMapping("/getAllRole")
    public  ResponseEntity<List<RoleResponse>> getAllRole()
    {
        List<RoleResponse>roleResponses=roleService.getAllRole();
        return new ResponseEntity<List<RoleResponse>>(roleResponses,HttpStatus.OK);

    }
    @GetMapping("/getByRoleID/{id}")
    public ResponseEntity<RoleResponse> getByRoleID(@PathVariable(value = "id") Long id)
    {
        RoleResponse roleResponse=roleService.getByRoleID(id);
        return new ResponseEntity<RoleResponse>(roleResponse,HttpStatus.OK);
    }

    @DeleteMapping("/deleteByRoleId/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(value = "id") Long id)
    {
        roleService.deleteRoleById(id);
        return new ResponseEntity<String>("deleted",HttpStatus.OK);
    }

}
