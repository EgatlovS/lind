package de.egatlovs.linkdiscoveryrs.components.structure.entity;

public class FieldDefinition {

	private long id;
	private String name;
	private FieldType type;
	private String validationConstraint;

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
