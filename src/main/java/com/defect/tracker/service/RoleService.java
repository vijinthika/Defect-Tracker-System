package com.defect.tracker.service;

import com.defect.tracker.dto.RoleRequest;
import com.defect.tracker.dto.RoleResponse;

import java.util.List;

public interface RoleService {

    public void createRole(RoleRequest roleRequest);

    public RoleResponse getByRoleID(Long id);

    public List<RoleResponse> getAllRole();

    public void deleteRoleById(Long id);

}
