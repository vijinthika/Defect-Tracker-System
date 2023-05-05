package com.defect.tracker.repository;

import com.defect.tracker.entities.Defect;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DefectRepository extends JpaRepository<Defect,Long> {
}
