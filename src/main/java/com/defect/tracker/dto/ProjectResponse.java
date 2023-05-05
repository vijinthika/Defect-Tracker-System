package com.defect.tracker.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProjectResponse {
    private Long id;
    private String name;
    private Date startDate;
    private Date endDate;
    private Long contactNumber;
    private String contactPerson;
    private String projectStatusName;
}
