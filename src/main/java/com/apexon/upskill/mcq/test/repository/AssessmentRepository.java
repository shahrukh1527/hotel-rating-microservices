package com.apexon.upskill.mcq.test.repository;

import com.apexon.upskill.mcq.test.entity.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssessmentRepository extends JpaRepository<Assessment,Long> {
}
