package de.egatlovs.lind.components.linkpoint.entity.dto;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Link;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public class LinkpointDTO {

	private long id;
	private String name;
	private long structureId;
	private List<FieldDTO> fieldDTOs;

	// self, structure
	@XmlJavaTypeAdapter(Link.JaxbAdapter.class)
	private List<Link> _links;

	public LinkpointDTO() {
	}

	public LinkpointDTO(long id, String name, long structureId, List<FieldDTO> fieldDTOs) {
		this.id = id;
		this.name = name;
		this.structureId = structureId;
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

	public List<FieldDTO> getFieldDTOs() {
		return fieldDTOs;
	}

	public void setFieldDTOs(List<FieldDTO> fieldDTOs) {
		this.fieldDTOs = fieldDTOs;
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

	public long getStructureId() {
		return structureId;
	}

	public void setStructureId(long structureId) {
		this.structureId = structureId;
	}

}
