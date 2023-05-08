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

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @ManyToOne
    @JoinColumn(name = "priority_id", nullable = false)
    private Priority priority;

    @ManyToOne
    @JoinColumn(name = "serviarity_id", nullable = false)
    private Seviarity seviarity;

    @ManyToOne
    @JoinColumn(name = "defectType_id", nullable = false)
    private DefectType defectType;

    @ManyToOne
    @JoinColumn(name = "defectStatus_id", nullable = false)
    private DefectStatus defectStatus;

    @ManyToOne
    @JoinColumn(name = "assign_to", nullable = false)
    private Employee assignTo;

    @ManyToOne
    @JoinColumn(name = "reporter", nullable = false)
    private Employee repoter;

    @ManyToOne
    @JoinColumn(name="release_id",nullable = false)
    private Release release;
}
