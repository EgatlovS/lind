package de.egatlovs.lind.components.linkpoint.entity.dto;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Link;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import de.egatlovs.lind.components.linkpoint.entity.Field;
import de.egatlovs.lind.components.linkpoint.entity.Linkpoint;
import de.egatlovs.lind.components.structure.entity.dto.StructureDTO;

public class LinkpointDTO {

	private long id;
	private String name;
	private long structureId;
	private List<FieldDTO> fields;

	// self, structure
	@XmlJavaTypeAdapter(Link.JaxbAdapter.class)
	private List<Link> _links;

	public LinkpointDTO() {
	}

	public LinkpointDTO(long id, String name, long structureId, List<FieldDTO> fields) {
		this.id = id;
		this.name = name;
		this.structureId = structureId;
		this.fields = fields;
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

	public List<FieldDTO> getFields() {
		return fields;
	}

	public void setFields(List<FieldDTO> fields) {
		this.fields = fields;
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

	public Linkpoint asEntity(StructureDTO structureDto) {
		List<Field> fields = new ArrayList<>();
		for (FieldDTO fieldDto : this.fields) {
			fields.add(fieldDto.asEntity());
		}
		return new Linkpoint(id, name, structureDto.asEntity(), fields);
	}

}
