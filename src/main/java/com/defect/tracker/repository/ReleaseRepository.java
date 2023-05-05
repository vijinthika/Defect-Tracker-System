package com.defect.tracker.repository;

import com.defect.tracker.entities.Release;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReleaseRepository extends JpaRepository<Release,Long> {
}
