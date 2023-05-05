package com.defect.tracker.service;

import com.defect.tracker.dto.DefectRequest;
import com.defect.tracker.dto.DefectResponse;

import java.util.List;

public interface DefcetService {

    public void createDefect(DefectRequest defectRequest);

    public List<DefectResponse> getAllDefect();

    public DefectResponse getDefectById(Long id);

    public void deleteDefect(Long id);
}
