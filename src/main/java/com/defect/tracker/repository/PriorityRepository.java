package com.defect.tracker.repository;

import com.defect.tracker.entities.Priority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriorityRepository extends JpaRepository<Priority,Long> {
}
