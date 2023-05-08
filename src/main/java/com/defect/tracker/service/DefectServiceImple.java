package com.defect.tracker.service;

import com.defect.tracker.dto.DefectRequest;
import com.defect.tracker.dto.DefectResponse;
import com.defect.tracker.entities.*;
import com.defect.tracker.repository.DefectRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefectServiceImple implements DefcetService {

    @Autowired
    private DefectRepository defectRepository;

    @Override
    public void createDefect(DefectRequest defectRequest) {
        Defect defect = new Defect();

        Project project=new Project();
        project.setId(defectRequest.getProjectId());
        defect.setProject(project);

        Priority priority = new Priority();
        priority.setId(defectRequest.getPriorityId());
        defect.setPriority(priority);

        Seviarity seviarity = new Seviarity();
        seviarity.setId(defectRequest.getSeviarityId());
        defect.setSeviarity(seviarity);

        DefectType defectType = new DefectType();
        defectType.setId(defectRequest.getDefectTypeId());
        defect.setDefectType(defectType);

        DefectStatus defectStatus = new DefectStatus();
        defectStatus.setId(defectRequest.getDefectStatusId());
        defect.setDefectStatus(defectStatus);



        Employee employee = new Employee();
        employee.setId(defectRequest.getAssignToId());
        defect.setAssignTo(employee);

        Employee employee1 = new Employee();
        employee1.setId(defectRequest.getReporterId());
        defect.setRepoter(employee1);

        Release release = new Release();
        release.setId(defectRequest.getReleaseId());
        defect.setRelease(release);

        BeanUtils.copyProperties(defectRequest, defect);
        defectRepository.save(defect);
    }

    @Override
    public List<DefectResponse> getAllDefect() {
        List<DefectResponse> defectResponses = new ArrayList<DefectResponse>();
        List<Defect> defects = defectRepository.findAll();
        for (Defect d : defects
        ) {
            DefectResponse defectResponse = new DefectResponse();
            defectResponse.setDefectTypeName(d.getDefectType().getName());
            defectResponse.setDefectStatuName(d.getDefectStatus().getName());
            defectResponse.setAssignToName(d.getAssignTo().getFirstName());
            defectResponse.setReporterName(d.getRepoter().getFirstName());
            defectResponse.setProjectName(d.getProject().getName());
            defectResponse.setPriorityName(d.getPriority().getName());
            defectResponse.setSeviarityName(d.getSeviarity().getName());
            defectResponse.setReleaseName(d.getRelease().getName());
            BeanUtils.copyProperties(d, defectResponse);
            defectResponses.add(defectResponse);
        }
        return defectResponses;
    }

    @Override
    public DefectResponse getDefectById(Long id) {
        DefectResponse defectResponse = new DefectResponse();
        Defect defect = defectRepository.findById(id).get();
        defectResponse.setDefectStatuName(defect.getDefectStatus().getName());
        defectResponse.setDefectTypeName(defect.getDefectType().getName());
        defectResponse.setProjectName(defect.getProject().getName());
        defectResponse.setReleaseName(defect.getRelease().getName());
        defectResponse.setReporterName(defect.getRepoter().getFirstName());
        defectResponse.setAssignToName(defect.getAssignTo().getFirstName());
        defectResponse.setSeviarityName(defect.getSeviarity().getName());
        defectResponse.setPriorityName(defect.getPriority().getName());
        BeanUtils.copyProperties(defect, defectResponse);
        return defectResponse;


    }

    @Override
    public void deleteDefect(Long id) {
        defectRepository.deleteById(id);
    }
}
