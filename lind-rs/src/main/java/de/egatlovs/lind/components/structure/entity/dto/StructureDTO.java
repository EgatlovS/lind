package de.egatlovs.lind.components.structure.entity.dto;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Link;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public class StructureDTO {

	private long id;
	private String name;
	private String description;
	private List<FieldDefinitionDTO> fieldDefinitions;

	// self, linkpoints
	@XmlJavaTypeAdapter(Link.JaxbAdapter.class)
	private List<Link> _links;

	public StructureDTO() {
	}

	public StructureDTO(long id, String name, String description, List<FieldDefinitionDTO> fieldDefinitions) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.fieldDefinitions = fieldDefinitions;
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

	public List<FieldDefinitionDTO> getFieldDefinitions() {
		return fieldDefinitions;
	}

	public void setFieldDefinitionDTOs(List<FieldDefinitionDTO> fieldDefinitions) {
		this.fieldDefinitions = fieldDefinitions;
	}

	public List<Link> get_links() {
		if (_links == null) {
			_links = new ArrayList<>();
		}
		return _links;
	}

	public void set_links(List<Link> _links) {
		this._links = _links;
	}

}
