package de.egatlovs.linkdiscoveryrs.components.linkpoint.entity;

import java.util.List;

import de.egatlovs.linkdiscoveryrs.components.structure.entity.StructureDTO;

public class LinkpointDTO {

	private long id;
	private String name;
	private StructureDTO parent;
	private List<FieldDTO> fieldDTOs;

	public LinkpointDTO() {
	}

	public LinkpointDTO(long id, String name, StructureDTO parent, List<FieldDTO> fieldDTOs) {
		this.id = id;
		this.name = name;
		this.parent = parent;
		this.fieldDTOs = fieldDTOs;
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

	public StructureDTO getParent() {
		return parent;
	}

	public void setParent(StructureDTO parent) {
		this.parent = parent;
	}

	public List<FieldDTO> getFieldDTOs() {
		return fieldDTOs;
	}

	public void setFieldDTOs(List<FieldDTO> fieldDTOs) {
		this.fieldDTOs = fieldDTOs;
	}

}
