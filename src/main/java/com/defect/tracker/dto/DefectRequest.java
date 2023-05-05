package com.defect.tracker.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class DefectRequest {
    private Long id;
    private String name;
    private String description;
    private String stepToRecreat;
    private Long projectId;
    private Long priorityId;
    private Long seviarityId;
    private Long defectTypeId;
    private long defectStatusId;
    private long assignToId;
    private long reporterId;
    private Long releaseId;
}
