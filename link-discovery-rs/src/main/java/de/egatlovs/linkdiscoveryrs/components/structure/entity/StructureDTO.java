package de.egatlovs.linkdiscoveryrs.components.structure.entity;

import java.util.List;

import de.egatlovs.linkdiscoveryrs.components.linkpoint.entity.LinkpointDTO;

public class StructureDTO {

	private long id;
	private String name;
	private String description;
	private List<FieldDefinitionDTO> fieldDefinitionDTOs;
	private List<LinkpointDTO> linkpointDTOs;

	public StructureDTO() {
	}

	public StructureDTO(long id, String name, String description, List<FieldDefinitionDTO> fieldDefinitionDTOs,
			List<LinkpointDTO> linkpointDTOs) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.fieldDefinitionDTOs = fieldDefinitionDTOs;
		this.setLinkpointDTOs(linkpointDTOs);
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

	public List<LinkpointDTO> getLinkpointDTOs() {
		return linkpointDTOs;
	}

	public void setLinkpointDTOs(List<LinkpointDTO> linkpointDTOs) {
		this.linkpointDTOs = linkpointDTOs;
	}

}
