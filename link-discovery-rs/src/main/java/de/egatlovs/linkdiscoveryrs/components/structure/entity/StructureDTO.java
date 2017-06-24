package de.egatlovs.linkdiscoveryrs.components.structure.entity;

import java.util.List;

public class StructureDTO {

	private long id;
	private String name;
	private String description;
	private List<FieldDefinitionDTO> fieldDefinitionDTOs;

	public StructureDTO() {
	}

	public StructureDTO(long id, String name, String description, List<FieldDefinitionDTO> fieldDefinitionDTOs) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.setFieldDefinitionDTOs(fieldDefinitionDTOs);
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<FieldDefinitionDTO> getFieldDefinitionDTOs() {
		return fieldDefinitionDTOs;
	}

	public void setFieldDefinitionDTOs(List<FieldDefinitionDTO> fieldDefinitionDTOs) {
		this.fieldDefinitionDTOs = fieldDefinitionDTOs;
	}

}
