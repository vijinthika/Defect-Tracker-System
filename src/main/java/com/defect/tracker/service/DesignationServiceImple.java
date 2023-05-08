package com.defect.tracker.service;

import com.defect.tracker.dto.DesignationRequest;
import com.defect.tracker.dto.DesignationResponse;
import com.defect.tracker.entities.Designation;
import com.defect.tracker.repository.DesignationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DesignationServiceImple implements DesignationService {

    @Autowired
    private DesignationRepository designationRepository;

    @Override
    public void createDesignation(DesignationRequest designationRequest) {
        //System.out.println("hello");
        //System.out.println(designationRequest.getName());
        Designation designation = new Designation();
        BeanUtils.copyProperties(designationRequest, designation);
        //designation.setId(designationRequest.getId());
        //designation.setName(designationRequest.getName());
        designationRepository.save(designation);
    }

    @Override
    public List<DesignationResponse> getAllDesignation() {
        List<DesignationResponse> designationResponses = new ArrayList<DesignationResponse>();
        List<Designation> designations = designationRepository.findAll();
        for (Designation designation : designations) {
            DesignationResponse designationResponse = new DesignationResponse();
            BeanUtils.copyProperties(designation, designationResponse);
            designationResponses.add(designationResponse);
        }
        return designationResponses;
    }

    @Override
    public DesignationResponse getBYDesignationId(Long id) {
        Designation designation = designationRepository.findById(id).get();
        DesignationResponse designationResponse = new DesignationResponse();
        BeanUtils.copyProperties(designation, designationResponse);
        return designationResponse;
    }

    @Override
    public void deleteDesignation(long id) {
        designationRepository.deleteById(id);
    }
}
