package de.egatlovs.lind.components.structure.entity.dto;

import java.util.List;

import javax.ws.rs.core.Link;

import de.egatlovs.lind.components.structure.entity.FieldType;

public class FieldDefinitionDTO {

	private long id;
	private String name;
	private FieldType type;
	private String validationConstraint;

	// self, structure
	private List<Link> _links;

	public FieldDefinitionDTO() {
	}

	public FieldDefinitionDTO(long id, String name, FieldType type, String validationConstraint) {
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

	public List<Link> get_links() {
		return _links;
	}

	public void set_links(List<Link> _links) {
		this._links = _links;
	}

}
