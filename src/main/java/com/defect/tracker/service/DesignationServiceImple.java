package com.defect.tracker.service;

import com.defect.tracker.dto.DesignationRequest;
import com.defect.tracker.dto.DesignationResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesignationServiceImple implements DesignationService{
    @Override
    public void createDesignation(DesignationRequest designationRequest) {
        
    }

    @Override
    public List<DesignationResponse> getAllDesignation() {
        return null;
    }

    @Override
    public DesignationResponse getBYDesignationId(Long id) {
        return null;
    }

    @Override
    public void deleteDesignation(long id) {

    }
}
