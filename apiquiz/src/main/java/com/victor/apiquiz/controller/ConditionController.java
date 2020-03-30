package com.victor.apiquiz.controller;

import com.victor.apiquiz.core.CustomResponse;
import com.victor.apiquiz.model.ConditionDTO;
import com.victor.apiquiz.model.Conditions;
import com.victor.apiquiz.service.ConditionService;
import com.victor.apiquiz.service.ConditionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping(value = ConditionController._PATH)
public class ConditionController {

	final static String _PATH = "/condition";

	private ConditionService conditionService;

	@Autowired
	public ConditionController(ConditionServiceImpl conditionService) {
		this.conditionService = conditionService;
	}


	@PostMapping
	public ResponseEntity<CustomResponse<ConditionDTO>> saveCondition(@RequestBody Conditions conditions) {
		try {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new CustomResponse<>(this.conditionService.saveCondition(conditions)));
		} catch (Exception e) {
			throw new ResponseStatusException(
					HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
}
