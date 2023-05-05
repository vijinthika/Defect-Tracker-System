package com.defect.tracker.service;

import com.defect.tracker.dto.PriorityRequest;
import com.defect.tracker.dto.PriorityResponse;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PriorityService {
    public void createPriority(@RequestBody PriorityRequest priorityRequest);
    public List<PriorityResponse> getAllPriority();

    public PriorityResponse getByPriorityID(Long id);

    public void deletePriority(Long id);
}
