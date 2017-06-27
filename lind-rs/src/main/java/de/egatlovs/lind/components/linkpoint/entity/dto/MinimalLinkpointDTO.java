package de.egatlovs.lind.components.linkpoint.entity.dto;

import java.util.List;

import javax.ws.rs.core.Link;

public class MinimalLinkpointDTO {

	private long id;
	private String name;

	// self, fields, structure
	private List<Link> _links;

	public MinimalLinkpointDTO() {
	}

	public MinimalLinkpointDTO(long id, String name) {
		this.id = id;
		this.name = name;
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

	public List<Link> get_links() {
		return _links;
	}

	public void set_links(List<Link> _links) {
		this._links = _links;
	}

}
