package com.defect.tracker.service;

import com.defect.tracker.dto.SeviarityRequest;
import com.defect.tracker.dto.SeviarityResponse;
import com.defect.tracker.entities.Seviarity;
import com.defect.tracker.repository.SeviarityRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeviarityServiceImple implements SeviarityService {
    @Autowired
    private SeviarityRepository sRepo;

    @Override
    public void createSevairity(SeviarityRequest seviarityRequest) {
        Seviarity seviarity = new Seviarity();
        BeanUtils.copyProperties(seviarityRequest, seviarity);
        sRepo.save(seviarity);

    }

    @Override
    public SeviarityResponse getBySevairityID(Long id) {
        Seviarity seviarity=sRepo.findById(id).get();
        SeviarityResponse seviarityResponse=new SeviarityResponse();
        BeanUtils.copyProperties(seviarity,seviarityResponse);
        return seviarityResponse;
    }


    @Override
    public List<SeviarityResponse> getAllSeviariy() {
        List<Seviarity> seviarities = sRepo.findAll();
        List<SeviarityResponse> seviarityResponses = new ArrayList<SeviarityResponse>();
        for (Seviarity s : seviarities
        ) {
            SeviarityResponse seviarityResponse = new SeviarityResponse();
            BeanUtils.copyProperties(s, seviarityResponse);
            seviarityResponses.add(seviarityResponse);

        }
        return seviarityResponses;
    }

    @Override
    public void deleteSeviarity(Long id) {
        sRepo.deleteById(id);
    }


}
