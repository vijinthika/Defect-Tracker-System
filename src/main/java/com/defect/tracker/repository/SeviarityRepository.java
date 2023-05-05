package com.defect.tracker.repository;


import com.defect.tracker.entities.Seviarity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeviarityRepository extends JpaRepository<Seviarity,Long> {
}
