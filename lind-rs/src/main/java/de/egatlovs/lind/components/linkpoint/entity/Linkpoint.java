package de.egatlovs.lind.components.linkpoint.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import de.egatlovs.lind.components.linkpoint.entity.dto.FieldDTO;
import de.egatlovs.lind.components.linkpoint.entity.dto.LinkpointDTO;
import de.egatlovs.lind.components.linkpoint.entity.dto.MinimalLinkpointDTO;
import de.egatlovs.lind.components.structure.entity.Structure;

@Entity
@NamedQueries(value = {
		@NamedQuery(name = "Linkpoint.GET_BY_ID", query = "SELECT l FROM Linkpoint l WHERE l.id = :id") })
public class Linkpoint {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	@ManyToOne
	private Structure parent;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Field> fields;

	public Linkpoint() {
	}

	public Linkpoint(long id, String name, Structure parent, List<Field> fields) {
		this.id = id;
		this.name = name;
		this.parent = parent;
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

	public LinkpointDTO asDto() {
		List<FieldDTO> fieldDTOs = new ArrayList<>();
		for (Field field : fields) {
			fieldDTOs.add(field.asDto());
		}
		return new LinkpointDTO(id, name, parent.getId(), fieldDTOs);
	}

	public MinimalLinkpointDTO asMinimal() {
		return new MinimalLinkpointDTO(id, name);
	}

}
