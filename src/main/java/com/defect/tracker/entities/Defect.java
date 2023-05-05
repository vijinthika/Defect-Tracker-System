package com.defect.tracker.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Defect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String stepToRecreat;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "priority_id", nullable = false)
    private Priority priority;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "serviarity_id", nullable = false)
    private Seviarity seviarity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "defectType_id", nullable = false)
    private DefectType defectType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "defectStatus_id", nullable = false)
    private DefectStatus defectStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "assign_to", nullable = false)
    private Employee assignTo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reporter", nullable = false)
    private Employee repoter;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="release_id",nullable = false)
    private Release release;
}
