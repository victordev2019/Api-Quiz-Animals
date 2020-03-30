package com.victor.apiquiz.controller;

import com.victor.apiquiz.core.CustomResponse;
import com.victor.apiquiz.core.Logger;
import com.victor.apiquiz.model.Animals;
import com.victor.apiquiz.model.QuizDTO;
import com.victor.apiquiz.service.AnimalService;
import com.victor.apiquiz.service.AnimalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping(value = AnimalController._PATH)
public class AnimalController {

	final static String _PATH = "/animals";

	private AnimalService animalService;

	@Autowired
	public AnimalController(AnimalServiceImpl animalService) {
		this.animalService = animalService;
	}


	@GetMapping
	public ResponseEntity<CustomResponse<List<QuizDTO>>> findAllAnimals() {
		try {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new CustomResponse<>(this.animalService.findAllAnimals()));
		} catch (Exception e) {
			throw new ResponseStatusException(
					HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<CustomResponse<QuizDTO>> getAnimal(@PathVariable(value = "id") Long id) {

		Logger.info(Logger._PARAM, id);

		try {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new CustomResponse<>(this.animalService.getAnimal(id)));
		} catch (Exception e) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@PostMapping
	public ResponseEntity<CustomResponse<QuizDTO>> saveAnimal(@RequestBody Animals animals) {
		try {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new CustomResponse<>(this.animalService.saveAnimal(animals)));
		} catch (Exception e) {
			throw new ResponseStatusException(
					HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
}
