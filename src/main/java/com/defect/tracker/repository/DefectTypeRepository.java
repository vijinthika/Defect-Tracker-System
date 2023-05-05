package com.defect.tracker.repository;

import com.defect.tracker.entities.DefectType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DefectTypeRepository extends JpaRepository<DefectType,Long> {
}
