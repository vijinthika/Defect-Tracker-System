package com.defect.tracker.repository;

import com.defect.tracker.entities.Designation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesignationRepository extends JpaRepository<Designation,Long> {
}
