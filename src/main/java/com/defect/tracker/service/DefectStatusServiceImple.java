package com.defect.tracker.service;

import com.defect.tracker.dto.DefectStatusRequest;
import com.defect.tracker.dto.DefectStatusResponse;
import com.defect.tracker.dto.DefectTypeRequest;
import com.defect.tracker.dto.DefectTypeResponse;
import com.defect.tracker.entities.DefectStatus;
import com.defect.tracker.repository.DefectStatusRepository;
import com.defect.tracker.repository.DefectTypeRepository;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefectStatusServiceImple implements DefectStausService {
    @Autowired
    private DefectStatusRepository defectStatusRepository;
    @Override
    public void createDefectsStatus(DefectStatusRequest defectStatusRequest) {
        DefectStatus defectStatus=new DefectStatus();
        BeanUtils.copyProperties(defectStatusRequest,defectStatus);
        defectStatusRepository.save(defectStatus);
    }

    @Override
    public List<DefectStatusResponse> getAllDefectStatus() {
        List<DefectStatusResponse> defectStatusResponses=new ArrayList<DefectStatusResponse>();
        List<DefectStatus> defectStatuses=defectStatusRepository.findAll();
        for (DefectStatus d:defectStatuses
             ) {
            DefectStatusResponse defectStatusResponse=new DefectStatusResponse();
            BeanUtils.copyProperties(d,defectStatusResponse);
            defectStatusResponses.add(defectStatusResponse);
        }
        return defectStatusResponses;
    }

    @Override
    public DefectStatusResponse getDefectStatusBYID(Long id) {
        DefectStatusResponse defectStatusResponse=new DefectStatusResponse();
        DefectStatus defectStatus=defectStatusRepository.findById(id).get();
        BeanUtils.copyProperties(defectStatus,defectStatusResponse);
        return defectStatusResponse;
    }

    @Override
    public void deleteDefectStatus(Long id) {
    defectStatusRepository.deleteById(id);
    }
}
