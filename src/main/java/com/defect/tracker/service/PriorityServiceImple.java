package com.defect.tracker.service;

import com.defect.tracker.dto.PriorityRequest;
import com.defect.tracker.dto.PriorityResponse;
import com.defect.tracker.entities.Priority;
import com.defect.tracker.repository.PriorityRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PriorityServiceImple implements PriorityService{

    @Autowired
    private PriorityRepository pRepo;
    @Override
    public void createPriority(PriorityRequest priorityRequest) {
        Priority priority=new Priority();
        BeanUtils.copyProperties(priority,priorityRequest);
        pRepo.save(priority);
    }

    @Override
    public List<PriorityResponse> getAllPriority() {
        List<Priority> priorities=pRepo.findAll();
        List<PriorityResponse> priorityResponses=new ArrayList<PriorityResponse>();
        for (Priority p:priorities
             ) {
            PriorityResponse priorityResponse=new PriorityResponse();
            BeanUtils.copyProperties(priorityResponse,p);
            priorityResponses.add(priorityResponse);
        }
        return priorityResponses;
    }

    @Override
    public PriorityResponse getByPriorityID(Long id) {
        Priority priority=pRepo.findById(id).get();
        PriorityResponse priorityResponse=new PriorityResponse();
        BeanUtils.copyProperties(priorityResponse,priority);
        return priorityResponse;
    }

    @Override
    public void deletePriority(Long id)
    {
        pRepo.deleteById(id);
    }


}
