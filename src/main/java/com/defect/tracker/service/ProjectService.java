package com.defect.tracker.service;

import com.defect.tracker.dto.ProjectRequest;
import com.defect.tracker.dto.ProjectResponse;
import com.defect.tracker.entities.Project;

import java.util.List;

public interface ProjectService {
    public void createProject(ProjectRequest projectRequest);

    public List<ProjectResponse> getAllProject();
    public ProjectResponse getProjectById(Long id);

    public void deleteProject(Long id);

}
