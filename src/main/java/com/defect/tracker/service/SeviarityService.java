package com.defect.tracker.service;

import com.defect.tracker.dto.SeviarityRequest;
import com.defect.tracker.dto.SeviarityResponse;

import java.util.List;

public interface SeviarityService {
    public void createSevairity(SeviarityRequest seviarityRequest);

    public SeviarityResponse getBySevairityID(Long id);

    public List<SeviarityResponse> getAllSeviariy();

    public void deleteSeviarity(Long id);

}
