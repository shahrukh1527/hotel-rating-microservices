package com.apexon.upskill.template.repository;

import com.apexon.upskill.template.entity.Template;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateRepository extends JpaRepository<Template,Integer> {
}
