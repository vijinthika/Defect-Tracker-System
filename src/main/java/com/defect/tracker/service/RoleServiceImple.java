package com.defect.tracker.service;

import com.defect.tracker.dto.RoleRequest;
import com.defect.tracker.dto.RoleResponse;
import com.defect.tracker.entities.Role;
import com.defect.tracker.repository.RoleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImple implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void createRole(RoleRequest roleRequest) {
        Role role = new Role();
        BeanUtils.copyProperties(roleRequest, role);
        roleRepository.save(role);
    }

    @Override
    public RoleResponse getByRoleID(Long id) {
        Role role = roleRepository.findById(id).get();
        RoleResponse roleResponse = new RoleResponse();
        BeanUtils.copyProperties(role, roleResponse);
        return roleResponse;
    }

    @Override
    public List<RoleResponse> getAllRole() {
        List<Role> roles = roleRepository.findAll();
        List<RoleResponse> roleResponses = new ArrayList<RoleResponse>();
        for (Role r : roles
        ) {
            RoleResponse roleResponse = new RoleResponse();
            BeanUtils.copyProperties(r, roleResponse);
            roleResponses.add(roleResponse);

        }
        return roleResponses;
    }

    @Override
    public void deleteRoleById(Long id) {
        roleRepository.deleteById(id);
    }
}
