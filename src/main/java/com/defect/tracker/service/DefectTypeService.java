package com.defect.tracker.service;

import com.defect.tracker.dto.DefectTypeRequest;
import com.defect.tracker.dto.DefectTypeResponse;

import java.util.List;

public interface DefectTypeService {

    public void createDefectType(DefectTypeRequest defectTypeRequest);

    public List<DefectTypeResponse> getAllDefectType();

    public DefectTypeResponse getDefectTypeBYID(Long id);

    public void deleteDefectType(Long id);
}
