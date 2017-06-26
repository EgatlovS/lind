package de.egatlovs.linkdiscoveryrs.components.linkpoint.control;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import de.egatlovs.linkdiscoveryrs.components.linkpoint.entity.Field;
import de.egatlovs.linkdiscoveryrs.components.linkpoint.entity.Linkpoint;
import de.egatlovs.linkdiscoveryrs.components.linkpoint.entity.dto.FieldDTO;
import de.egatlovs.linkdiscoveryrs.components.linkpoint.entity.dto.LinkpointDTO;
import de.egatlovs.linkdiscoveryrs.components.linkpoint.entity.dto.MinimalLinkpointDTO;
import de.egatlovs.linkdiscoveryrs.components.structure.control.StructureTransformer;

@RequestScoped
public class LinkpointTransformer {

	@Inject
	private StructureTransformer bumblebee;

	public LinkpointDTO linkpointDTO(Linkpoint linkpoint) {
		return new LinkpointDTO(linkpoint.getId(), linkpoint.getName(), bumblebee.structureDTO(linkpoint.getParent()),
				fieldDTOs(linkpoint.getFields()));
	}

	public Linkpoint linkpoint(LinkpointDTO linkpointDTO) {
		return new Linkpoint(linkpointDTO.getId(), linkpointDTO.getName(),
				bumblebee.structure(linkpointDTO.getParent()), fields(linkpointDTO.getFieldDTOs()));
	}

	public List<LinkpointDTO> linkpointDTOs(List<Linkpoint> linkpoints) {
		List<LinkpointDTO> linkpointDTOs = new ArrayList<>();
		for (Linkpoint linkpoint : linkpoints) {
			linkpointDTOs.add(linkpointDTO(linkpoint));
		}
		return linkpointDTOs;
	}

	public List<Linkpoint> linkpoints(List<LinkpointDTO> linkpointDTOs) {
		List<Linkpoint> linkpoints = new ArrayList<>();
		for (LinkpointDTO dto : linkpointDTOs) {
			linkpoints.add(linkpoint(dto));
		}
		return linkpoints;
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
		return new MinimalLinkpointDTO(linkpoint.getId(), linkpoint.getName(), linkpoint.getParent().getId());
	}

	public List<MinimalLinkpointDTO> minimalLinkpointDTOs(List<Linkpoint> linkpoints) {
		List<MinimalLinkpointDTO> minimalLinkpointDTOs = new ArrayList<>();
		for (Linkpoint linkpoint : linkpoints) {
			minimalLinkpointDTOs.add(minimalLinkpointDTO(linkpoint));
		}
		return minimalLinkpointDTOs;
	}

}
