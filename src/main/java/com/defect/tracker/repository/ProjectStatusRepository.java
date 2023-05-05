package com.defect.tracker.repository;

import com.defect.tracker.entities.ProjectStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectStatusRepository extends JpaRepository <ProjectStatus,Long>{
}
