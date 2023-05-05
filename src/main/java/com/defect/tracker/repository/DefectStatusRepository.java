package com.defect.tracker.repository;

import com.defect.tracker.entities.DefectStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DefectStatusRepository extends JpaRepository<DefectStatus,Long> {
}
