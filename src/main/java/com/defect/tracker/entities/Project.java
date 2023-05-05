package com.defect.tracker.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter

public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date startDate;
    private Date endDate;
    private Long contactNumber;
    private String contactPerson;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_status_id", nullable = false)
    private ProjectStatus projectStatus;

}
