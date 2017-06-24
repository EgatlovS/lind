package de.egatlovs.linkdiscoveryrs.components.linkpoint.entity;

import java.util.List;

import de.egatlovs.linkdiscoveryrs.components.structure.entity.Structure;

public class Linkpoint {

	private long id;
	private String name;
	private Structure parent;
	private List<Field> fields;

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

	public Structure getParent() {
		return parent;
	}

	public void setParent(Structure parent) {
		this.parent = parent;
	}

	public List<Field> getFields() {
		return fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

}
