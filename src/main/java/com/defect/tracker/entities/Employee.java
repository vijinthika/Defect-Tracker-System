package com.defect.tracker.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long code;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private Long phoneNumber;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "designation_id", nullable = false)
    private Designation designation;



}
