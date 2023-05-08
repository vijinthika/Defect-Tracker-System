package com.defect.tracker.service;

import com.defect.tracker.dto.DefectStatusRequest;
import com.defect.tracker.dto.DefectStatusResponse;
import com.defect.tracker.dto.DefectTypeRequest;
import com.defect.tracker.dto.DefectTypeResponse;

import java.util.List;

public interface DefectStausService {


    public List<DefectStatusResponse> getAllDefectStatus();

    public DefectStatusResponse getDefectStatusBYID(Long id);

    public void deleteDefectStatus(Long id);

    void createDefectsStatus(DefectStatusRequest defectStatusRequest);
}
