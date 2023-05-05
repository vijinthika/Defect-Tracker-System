package com.defect.tracker.service;

import com.defect.tracker.dto.ProjectAllocationRequest;
import com.defect.tracker.dto.ProjectAllocationResponse;
import com.defect.tracker.dto.ProjectRequest;
import com.defect.tracker.dto.ProjectResponse;
import com.defect.tracker.entities.*;
import com.defect.tracker.repository.ProjectAllocationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectAllocationServiceImple implements ProjectAllocationService {
    @Autowired
    private ProjectAllocationRepository projectAllocationRepository;


    @Override
    public void createProjectAllocation(ProjectAllocationRequest projectAllocationRequest) {
        ProjectAllocation projectAllocation=new ProjectAllocation();
        Project project=new Project();
        project.setId(projectAllocationRequest.getProjectId());
        projectAllocation.setProject(project);

        Employee employee=new Employee();
        employee.setId(projectAllocationRequest.getEmployeeId());
        projectAllocation.setEmployee(employee);

        Role role=new Role();
        role.setId(projectAllocationRequest.getRoleId());

        BeanUtils.copyProperties(projectAllocationRequest,projectAllocation);

        projectAllocationRepository.save(projectAllocation);
    }

    @Override
    public List<ProjectAllocationResponse> getAllProjectALlocation() {
        List<ProjectAllocationResponse> projectAllocationResponses=new ArrayList<ProjectAllocationResponse>();
        List<ProjectAllocation> projectAllocations=projectAllocationRepository.findAll();
        for (ProjectAllocation p:projectAllocations
             ) {
            ProjectAllocationResponse projectAllocationResponse=new ProjectAllocationResponse();
            projectAllocationResponse.setProjectName(p.getProject().getName());
            projectAllocationResponse.setEmployeeName(p.getEmployee().getFirstName());
            projectAllocationResponse.setRoleName(p.getRole().getName());
            BeanUtils.copyProperties(projectAllocationResponse,p);
            projectAllocationResponses.add(projectAllocationResponse);

        }
        return projectAllocationResponses;
    }

    @Override
    public ProjectAllocationResponse getProjectAllocationById(Long id) {
        ProjectAllocationResponse projectAllocationResponse=new ProjectAllocationResponse();
        ProjectAllocation projectAllocation=projectAllocationRepository.findById(id).get();
        projectAllocationResponse.setProjectName((projectAllocation.getProject().getName()));
        projectAllocationResponse.setRoleName(projectAllocation.getRole().getName());
        projectAllocationResponse.setEmployeeName(projectAllocation.getEmployee().getFirstName());
        BeanUtils.copyProperties(projectAllocationResponse,projectAllocation);
        return projectAllocationResponse;
    }

    @Override
    public void deleteProjectAllocationById(Long id) {
        projectAllocationRepository.deleteById(id);
    }
}
