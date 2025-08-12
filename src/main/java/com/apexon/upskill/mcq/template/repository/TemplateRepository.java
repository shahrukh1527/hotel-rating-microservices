package com.apexon.upskill.mcq.template.repository;

import com.apexon.upskill.mcq.template.entity.Template;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateRepository extends JpaRepository<Template,Integer> {
}
