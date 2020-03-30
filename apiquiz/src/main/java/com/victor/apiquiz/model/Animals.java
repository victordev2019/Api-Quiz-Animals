package com.victor.apiquiz.model;

import com.victor.apiquiz.core.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Animals extends AbstractEntity {

	private String name;

	@ManyToMany
	@JoinTable(name = "animal_has_condition", joinColumns =
			{@JoinColumn(name = "id_animal")}, inverseJoinColumns =
			{@JoinColumn(name = "id_condition")})
	private List<Conditions> conditions;
}
