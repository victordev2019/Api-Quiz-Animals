package com.victor.apiquiz.service;

import com.victor.apiquiz.exceptions.AnimalNotFoundException;
import com.victor.apiquiz.model.Animals;
import com.victor.apiquiz.model.QuizDTO;
import com.victor.apiquiz.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalServiceImpl implements AnimalService {

	private AnimalRepository animalRepository;

	@Autowired
	public AnimalServiceImpl(AnimalRepository animalRepository) {
		this.animalRepository = animalRepository;
	}

	@Override
	public QuizDTO getAnimal(Long id) throws AnimalNotFoundException {
		return new QuizDTO(this.animalRepository.findById(id).orElseThrow(AnimalNotFoundException::new));
	}

	@Override
	public List<QuizDTO> findAllAnimals() {
		return QuizDTO.fromAnimalList(this.animalRepository.findAll());
	}

	@Override
	public QuizDTO saveAnimal(Animals animals) throws AnimalNotFoundException {
		animals = this.animalRepository.save(animals);
		return getAnimal(animals.getId());
	}

}
