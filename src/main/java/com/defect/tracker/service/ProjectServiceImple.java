package com.defect.tracker.service;

import com.defect.tracker.dto.ProjectRequest;
import com.defect.tracker.dto.ProjectResponse;
import com.defect.tracker.entities.Project;
import com.defect.tracker.entities.ProjectStatus;
import com.defect.tracker.repository.ProjectRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImple implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public void createProject(ProjectRequest projectRequest) {
        Project project = new Project();
        ProjectStatus projectStatus = new ProjectStatus();
        projectStatus.setId(projectRequest.getProjectStatusId());
        project.setProjectStatus(projectStatus);
        BeanUtils.copyProperties(projectRequest, project);

        projectRepository.save(project);
    }

    @Override
    public List<ProjectResponse> getAllProject() {
        List<ProjectResponse> projectResponses = new ArrayList<ProjectResponse>();
        List<Project> projects = projectRepository.findAll();
        for (Project p : projects
        ) {
            ProjectResponse projectResponse = new ProjectResponse();
            projectResponse.setProjectStatusName(p.getProjectStatus().getName());
            BeanUtils.copyProperties(p, projectResponse);
            projectResponses.add(projectResponse);

        }
        return projectResponses;
    }

    @Override
    public ProjectResponse getProjectById(Long id) {
        ProjectResponse projectResponse = new ProjectResponse();
        Project project = projectRepository.findById(id).get();
        projectResponse.setProjectStatusName(project.getProjectStatus().getName());
        BeanUtils.copyProperties(project, projectResponse);
        return projectResponse;
    }

    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);

    }
}
