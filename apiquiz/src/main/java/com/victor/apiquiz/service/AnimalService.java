package com.victor.apiquiz.service;


import com.victor.apiquiz.exceptions.AnimalNotFoundException;
import com.victor.apiquiz.model.Animals;
import com.victor.apiquiz.model.QuizDTO;

import java.util.List;

public interface AnimalService {

	QuizDTO getAnimal(Long id) throws Exception;

	List<QuizDTO> findAllAnimals() throws Exception;

	QuizDTO saveAnimal(Animals animals) throws AnimalNotFoundException;

}
