package com.defect.tracker.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequest {
    private Long id;
    private Long code;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private Long phoneNumber;

    private Long desiginationId;

}
