package de.egatlovs.lind.components.structure.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import de.egatlovs.lind.components.structure.entity.constraint.ValidRegex;

@Entity
public class FieldDefinition {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	@Enumerated(EnumType.STRING)
	private FieldType type;
	@ValidRegex
	private String validationConstraint;

	public FieldDefinition() {
	}

	public FieldDefinition(long id, String name, FieldType type, String validationConstraint) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.validationConstraint = validationConstraint;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FieldType getType() {
		return type;
	}

	public void setType(FieldType type) {
		this.type = type;
	}

	public String getValidationConstraint() {
		return validationConstraint;
	}

	public void setValidationConstraint(String validationConstraint) {
		this.validationConstraint = validationConstraint;
	}

}
