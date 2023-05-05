package com.defect.tracker.service;

import com.defect.tracker.dto.ProjectStatusRequest;
import com.defect.tracker.dto.ProjectStatusResponse;

import java.util.List;

public interface ProjectStatusService {

    public void createProjectStatus(ProjectStatusRequest projectStatusService);

    public List<ProjectStatusResponse> getAllProjectStatus();

    public ProjectStatusResponse getProjectStatusById(Long id);

    public void deleteProjectStatusById(Long id);

}
