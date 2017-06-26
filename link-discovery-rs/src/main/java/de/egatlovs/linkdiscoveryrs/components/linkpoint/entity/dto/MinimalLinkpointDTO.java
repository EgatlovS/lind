package de.egatlovs.linkdiscoveryrs.components.linkpoint.entity.dto;

public class MinimalLinkpointDTO {

	private long id;
	private String name;
	private long structureId;

	public MinimalLinkpointDTO() {
	}

	public MinimalLinkpointDTO(long id, String name, long structureId) {
		this.id = id;
		this.name = name;
		this.structureId = structureId;
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

	public long getStructureId() {
		return structureId;
	}

	public void setStructureId(long structureId) {
		this.structureId = structureId;
	}

}
