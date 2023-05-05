package com.defect.tracker.service;

import com.defect.tracker.dto.ProjectStatusRequest;
import com.defect.tracker.dto.ProjectStatusResponse;
import com.defect.tracker.entities.ProjectStatus;
import com.defect.tracker.repository.ProjectStatusRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectStatusServiceImple implements ProjectStatusService{

    @Autowired
    private ProjectStatusRepository projectStatusRepository;
    @Override
    public void createProjectStatus(ProjectStatusRequest projectStatusService) {
        ProjectStatus projectStatus=new ProjectStatus();
        BeanUtils.copyProperties(projectStatusService,projectStatus);
        projectStatusRepository.save(projectStatus);

    }

    @Override
    public List<ProjectStatusResponse> getAllProjectStatus() {
        List<ProjectStatusResponse> projectStatusResponses=new ArrayList<ProjectStatusResponse>();
        List<ProjectStatus> projectStatuses=projectStatusRepository.findAll();
        for (ProjectStatus p:projectStatuses
             ) {
            ProjectStatusResponse projectStatusResponse=new ProjectStatusResponse();
            BeanUtils.copyProperties(p,projectStatusResponse);
            projectStatusResponses.add(projectStatusResponse);
        }
        return projectStatusResponses;
    }

    @Override
    public ProjectStatusResponse getProjectStatusById(Long id) {
        ProjectStatusResponse projectStatusResponse=new ProjectStatusResponse();
        ProjectStatus projectStatus=projectStatusRepository.findById(id).get();
        BeanUtils.copyProperties(projectStatus,projectStatusResponse);
        return projectStatusResponse;
    }

    @Override
    public void deleteProjectStatusById(Long id) {
    projectStatusRepository.deleteById(id);
    }
}
