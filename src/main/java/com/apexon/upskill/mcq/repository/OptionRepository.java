package com.apexon.upskill.mcq.repository;

import com.apexon.upskill.mcq.entity.Options;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends JpaRepository<Options,Long> {
}
