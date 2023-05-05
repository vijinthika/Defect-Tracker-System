package com.defect.tracker.service;

import com.defect.tracker.dto.ProjectAllocationRequest;
import com.defect.tracker.dto.ProjectAllocationResponse;
import com.defect.tracker.dto.ProjectResponse;

import java.util.List;

public interface ProjectAllocationService {
    public void createProjectAllocation(ProjectAllocationRequest projectAllocationRequest);

    public List<ProjectAllocationResponse> getAllProjectALlocation();
    public ProjectAllocationResponse getProjectAllocationById(Long id);

    public void deleteProjectAllocationById(Long id);
}
