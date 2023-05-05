package com.defect.tracker.service;

import com.defect.tracker.dto.EmployeeRequest;
import com.defect.tracker.dto.EmployeeResponse;

import java.util.List;

public interface EmployeeService {
public void createEmployee(EmployeeRequest employeeRequest);

public List<EmployeeResponse> getAllEmployee();

public EmployeeResponse getByEmployeeId(Long id);

public void deleteEmployee(long id);
}
