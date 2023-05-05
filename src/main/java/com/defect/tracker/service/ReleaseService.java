package com.defect.tracker.service;

import com.defect.tracker.dto.ReleaseRequest;
import com.defect.tracker.dto.ReleaseResponse;

import java.util.List;

public interface ReleaseService {
    public void createRelease(ReleaseRequest releaseRequest);

    public List<ReleaseResponse> getAllRelease();

    public ReleaseResponse getReleaseResponseById(Long id);

    public void deleteRelease(Long id);

}
