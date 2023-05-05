package com.defect.tracker.service;

import com.defect.tracker.dto.DefectTypeRequest;
import com.defect.tracker.dto.DefectTypeResponse;
import com.defect.tracker.entities.DefectType;
import com.defect.tracker.repository.DefectTypeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefectTypeServiceImple implements DefectTypeService {

    @Autowired
    private DefectTypeRepository dRepo;

    @Override
    public void createDefectType(DefectTypeRequest defectTypeRequest) {
        DefectType defectType = new DefectType();
        BeanUtils.copyProperties(defectType, defectTypeRequest);
        dRepo.save(defectType);

    }

    @Override
    public List<DefectTypeResponse> getAllDefectType() {
        List<DefectTypeResponse> defectTypeResponses = new ArrayList<DefectTypeResponse>();
        List<DefectType> defectTypes = dRepo.findAll();
        for (DefectType d : defectTypes
        ) {
            DefectTypeResponse defectTypeResponse = new DefectTypeResponse();
            BeanUtils.copyProperties(defectTypeResponse, d);
            defectTypeResponses.add(defectTypeResponse);

        }
        return defectTypeResponses;
    }

    @Override
    public DefectTypeResponse getDefectTypeBYID(Long id) {
        DefectTypeResponse defectTypeResponse = new DefectTypeResponse();
        DefectType defectType = dRepo.findById(id).get();
        BeanUtils.copyProperties(defectTypeResponse, defectType);
        return defectTypeResponse;
    }

    @Override
    public void deleteDefectType(Long id) {
        dRepo.deleteById(id);
    }
}
