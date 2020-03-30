package com.victor.apiquiz.repository;

import com.victor.apiquiz.model.Conditions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConditionRepository extends JpaRepository<Conditions, Long> {
}
