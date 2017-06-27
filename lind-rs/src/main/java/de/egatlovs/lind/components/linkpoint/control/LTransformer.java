package de.egatlovs.lind.components.linkpoint.control;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;

import de.egatlovs.lind.components.linkpoint.entity.Field;
import de.egatlovs.lind.components.linkpoint.entity.Linkpoint;
import de.egatlovs.lind.components.linkpoint.entity.dto.FieldDTO;
import de.egatlovs.lind.components.linkpoint.entity.dto.LinkpointDTO;
import de.egatlovs.lind.components.linkpoint.entity.dto.MinimalLinkpointDTO;
import de.egatlovs.lind.components.structure.entity.Structure;

@RequestScoped
public class LTransformer {

	public LinkpointDTO linkpointDTO(Linkpoint linkpoint) {
		return new LinkpointDTO(linkpoint.getId(), linkpoint.getName(), linkpoint.getParent().getId(),
				fieldDTOs(linkpoint.getFields()));
	}

	public Linkpoint linkpoint(LinkpointDTO linkpointDTO) {
		Structure structure = new Structure();
		structure.setId(linkpointDTO.getStructureId());
		return new Linkpoint(linkpointDTO.getId(), linkpointDTO.getName(), structure,
				fields(linkpointDTO.getFieldDTOs()));
	}

	public List<LinkpointDTO> linkpointDTOs(List<Linkpoint> linkpoints) {
		List<LinkpointDTO> linkpointDTOs = new ArrayList<>();
		for (Linkpoint linkpoint : linkpoints) {
			linkpointDTOs.add(linkpointDTO(linkpoint));
		}
		return linkpointDTOs;
	}

	public FieldDTO fieldDTO(Field field) {
		return new FieldDTO(field.getId(), field.getName(), field.getValue());
	}

	public Field field(FieldDTO fieldDTO) {
		return new Field(fieldDTO.getId(), fieldDTO.getName(), fieldDTO.getValue());
	}

	public List<FieldDTO> fieldDTOs(List<Field> fields) {
		List<FieldDTO> fieldDTOs = new ArrayList<>();
		for (Field field : fields) {
			fieldDTOs.add(fieldDTO(field));
		}
		return fieldDTOs;
	}

	public List<Field> fields(List<FieldDTO> fieldDTOs) {
		List<Field> fields = new ArrayList<>();
		for (FieldDTO dto : fieldDTOs) {
			fields.add(field(dto));
		}
		return fields;
	}

	public MinimalLinkpointDTO minimalLinkpointDTO(Linkpoint linkpoint) {
		return new MinimalLinkpointDTO(linkpoint.getId(), linkpoint.getName());
	}

	public List<MinimalLinkpointDTO> minimalLinkpointDTOs(List<Linkpoint> linkpoints) {
		List<MinimalLinkpointDTO> minimalLinkpointDTOs = new ArrayList<>();
		for (Linkpoint linkpoint : linkpoints) {
			minimalLinkpointDTOs.add(minimalLinkpointDTO(linkpoint));
		}
		return minimalLinkpointDTOs;
	}

}
