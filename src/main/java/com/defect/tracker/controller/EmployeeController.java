package com.defect.tracker.controller;

import com.defect.tracker.dto.EmployeeRequest;
import com.defect.tracker.dto.EmployeeResponse;
import com.defect.tracker.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping("/addEmployee")
    public ResponseEntity<String> addEmployee(@RequestBody EmployeeRequest employeeRequest)
    {
        employeeService.createEmployee(employeeRequest);
        return new ResponseEntity<String>("New employee"+employeeRequest.getId()+"with name"+employeeRequest.getFirstName()+"is succefully Addedd",HttpStatus.OK);
    }

    @PutMapping("/editEmployee")
    public ResponseEntity<String> editEmployee(@RequestBody EmployeeRequest employeeRequest)
    {
        employeeService.createEmployee(employeeRequest);
        return new ResponseEntity<String>("employee id"+employeeRequest.getId()+"is successfully edited",HttpStatus.OK);
    }

    @GetMapping("/getALlEmployee")
    public ResponseEntity<List<EmployeeResponse>> getAllEmployee()
    {
        List<EmployeeResponse> employeeResponses=employeeService.getAllEmployee();
        return new ResponseEntity<List<EmployeeResponse>>(employeeResponses, HttpStatus.OK);
    }



    @GetMapping("/getById/{id}")
    public ResponseEntity<EmployeeResponse> getByEmployeeID(@PathVariable(value = "id") Long id)
    {
        EmployeeResponse employeeResponse=employeeService.getByEmployeeId(id);
        return new ResponseEntity<EmployeeResponse>(employeeResponse,HttpStatus.OK);
    }



    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<String> deleteByID(@PathVariable(value = "id") Long id)
    {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String >("employee id"+id+"is succesfully delted",HttpStatus.OK);
    }
}
