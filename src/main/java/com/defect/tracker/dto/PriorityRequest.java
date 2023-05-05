package com.defect.tracker.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PriorityRequest {
    private Long id;
    private String name;
    private String color;
}
