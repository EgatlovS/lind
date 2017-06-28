package de.egatlovs.lind.components.structure.entity.dto;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Link;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public class MinimalStructureDTO {

	private long id;
	private String name;

	// self
	@XmlJavaTypeAdapter(Link.JaxbAdapter.class)
	private List<Link> _links;

	public MinimalStructureDTO() {
	}

	public MinimalStructureDTO(long id, String name) {
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
		if (_links == null) {
			_links = new ArrayList<>();
		}
		return _links;
	}

	public void set_links(List<Link> _links) {
		this._links = _links;
	}

}
