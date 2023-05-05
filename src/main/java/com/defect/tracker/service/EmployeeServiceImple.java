package com.defect.tracker.service;

import com.defect.tracker.dto.EmployeeRequest;
import com.defect.tracker.dto.EmployeeResponse;
import com.defect.tracker.entities.Designation;
import com.defect.tracker.entities.Employee;
import com.defect.tracker.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImple implements EmployeeService {
    @Autowired
    private EmployeeRepository eRepo;

    @Override
    public void createEmployee(EmployeeRequest employeeRequest) {
        Designation designation = new Designation();
        designation.setId(employeeRequest.getDesiginationId());
        Employee employee = new Employee();
        employee.setDesignation(designation);

        BeanUtils.copyProperties(employeeRequest, employee);

        eRepo.save(employee);
    }

    @Override
    public List<EmployeeResponse> getAllEmployee() {
        List<Employee> employees = eRepo.findAll();
        List<EmployeeResponse> employeeResponses = new ArrayList<EmployeeResponse>();
        for (Employee e : employees
        ) {
            EmployeeResponse employeeResponse = new EmployeeResponse();
            employeeResponse.setDesiginationName(e.getDesignation().getName());

            BeanUtils.copyProperties(e, employeeResponse);
            employeeResponses.add(employeeResponse);
        }
        return employeeResponses;
    }

    @Override
    public EmployeeResponse getByEmployeeId(Long id) {
        Employee employee = eRepo.findById(id).get();
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setDesiginationName(employee.getDesignation().getName());

        BeanUtils.copyProperties(employeeResponse, employee);
        return employeeResponse;
    }

    @Override
    public void deleteEmployee(long id) {
        eRepo.deleteById(id);
    }


}
