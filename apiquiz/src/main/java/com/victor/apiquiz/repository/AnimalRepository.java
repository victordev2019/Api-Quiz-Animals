package com.victor.apiquiz.repository;

import com.victor.apiquiz.model.Animals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  AnimalRepository extends JpaRepository<Animals, Long> {
}
