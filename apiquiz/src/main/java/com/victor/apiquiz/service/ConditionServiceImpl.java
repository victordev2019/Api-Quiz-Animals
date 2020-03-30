package com.victor.apiquiz.service;

import com.victor.apiquiz.model.ConditionDTO;
import com.victor.apiquiz.model.Conditions;
import com.victor.apiquiz.repository.ConditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConditionServiceImpl implements ConditionService {

	private ConditionRepository conditionRepository;

	@Autowired
	public ConditionServiceImpl(ConditionRepository conditionRepository) {
		this.conditionRepository = conditionRepository;
	}

	@Override
	public ConditionDTO saveCondition(Conditions conditions) {
		return new ConditionDTO(this.conditionRepository.save(conditions));
	}
}
