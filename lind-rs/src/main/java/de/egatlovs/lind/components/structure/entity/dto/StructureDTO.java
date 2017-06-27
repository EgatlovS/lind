package de.egatlovs.lind.components.structure.entity.dto;

import java.util.List;

import javax.ws.rs.core.Link;

public class StructureDTO {

	private long id;
	private String name;
	private String description;
	private List<FieldDefinitionDTO> fieldDefinitionDTOs;

	// self, linkpoints
	private List<Link> _links;

	public StructureDTO() {
	}

	public StructureDTO(long id, String name, String description, List<FieldDefinitionDTO> fieldDefinitionDTOs) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.fieldDefinitionDTOs = fieldDefinitionDTOs;
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

	public List<Link> get_links() {
		return _links;
	}

	public void set_links(List<Link> _links) {
		this._links = _links;
	}

}
