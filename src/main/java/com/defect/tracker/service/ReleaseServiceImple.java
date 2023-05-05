package com.defect.tracker.service;

import com.defect.tracker.dto.ReleaseRequest;
import com.defect.tracker.dto.ReleaseResponse;
import com.defect.tracker.entities.Release;
import com.defect.tracker.repository.ReleaseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReleaseServiceImple implements ReleaseService {
    @Autowired
    private ReleaseRepository releaseRepository;

    @Override
    public void createRelease(ReleaseRequest releaseRequest) {
        Release release = new Release();
        BeanUtils.copyProperties(releaseRequest, release);
        releaseRepository.save(release);

    }

    @Override
    public List<ReleaseResponse> getAllRelease() {
        List<Release> releases = releaseRepository.findAll();
        List<ReleaseResponse> releaseResponses = new ArrayList<ReleaseResponse>();
        for (Release r : releases
        ) {
            ReleaseResponse releaseResponse = new ReleaseResponse();
            BeanUtils.copyProperties(r, releaseResponse);
            releaseResponses.add(releaseResponse);
        }
        return releaseResponses;
    }

    @Override
    public ReleaseResponse getReleaseResponseById(Long id) {

        ReleaseResponse releaseResponse = new ReleaseResponse();
        Release release = releaseRepository.findById(id).get();
        BeanUtils.copyProperties(release, releaseResponse);
        return releaseResponse;
    }

    @Override
    public void deleteRelease(Long id) {
        releaseRepository.deleteById(id);
    }
}
