package de.egatlovs.lind.components.structure.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import de.egatlovs.lind.components.structure.entity.constraint.OneRole;
import de.egatlovs.lind.components.structure.entity.dto.FieldDefinitionDTO;
import de.egatlovs.lind.components.structure.entity.dto.MinimalStructureDTO;
import de.egatlovs.lind.components.structure.entity.dto.StructureDTO;

@Entity
@NamedQueries(value = { @NamedQuery(name = "Structure.GET_ALL", query = "SELECT s FROM Structure s"),
		@NamedQuery(name = "Structure.GET_BY_ID", query = "SELECT s FROM Structure s WHERE s.id = :id"),
		@NamedQuery(name = "Structure.GET_MATCHING_LINKPOINTS", query = "SELECT l FROM Linkpoint l WHERE l.parent.id = :id") })
public class Structure {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String description;
	@OneRole
	@OneToMany(cascade = CascadeType.ALL)
	private List<FieldDefinition> fieldDefinitions;

	public Structure() {
	}

	public Structure(long id, String name, String description, List<FieldDefinition> fieldDefinitions) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.fieldDefinitions = fieldDefinitions;
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

	public List<FieldDefinition> getFieldDefinitions() {
		return fieldDefinitions;
	}

	public void setFieldDefinitions(List<FieldDefinition> fieldDefinitions) {
		this.fieldDefinitions = fieldDefinitions;
	}

	public StructureDTO asDto() {
		List<FieldDefinitionDTO> definitions = new ArrayList<>();
		for (FieldDefinition fieldDefinition : fieldDefinitions) {
			definitions.add(fieldDefinition.asDto());
		}
		return new StructureDTO(id, name, description, definitions);
	}

	public MinimalStructureDTO asMinimal() {
		return new MinimalStructureDTO(id, name);
	}

}
