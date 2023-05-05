package com.defect.tracker.service;

import com.defect.tracker.dto.DesignationRequest;
import com.defect.tracker.dto.DesignationResponse;

import java.util.List;

public interface DesignationService {
    public void createDesignation(DesignationRequest designationRequest);

    public List<DesignationResponse> getAllDesignation();

    public DesignationResponse getBYDesignationId(Long id);
    public void deleteDesignation(long id);

}
