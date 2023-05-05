package com.defect.tracker.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DefectResponse {
    private Long id;
    private String name;
    private String description;
    private String stepToRecreat;

    private String projectName;
    private String priorityName;
    private String seviarityName;
    private String defectTypeName;
    private String defectStatuName;
    private String assignToName;
    private String reporterName;
    private String releaseName;
}

