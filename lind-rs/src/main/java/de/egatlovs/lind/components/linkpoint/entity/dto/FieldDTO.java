package de.egatlovs.lind.components.linkpoint.entity.dto;

import java.util.List;

import javax.ws.rs.core.Link;

public class FieldDTO {

	private long id;
	private String name;
	private String value;

	// self, link, structure
	private List<Link> _links;

	public FieldDTO() {
	}

	public FieldDTO(long id, String name, String value) {
		this.id = id;
		this.name = name;
		this.value = value;
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<Link> get_links() {
		return _links;
	}

	public void set_links(List<Link> _links) {
		this._links = _links;
	}

}
