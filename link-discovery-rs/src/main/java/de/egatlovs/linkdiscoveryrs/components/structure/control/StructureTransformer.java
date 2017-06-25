package de.egatlovs.linkdiscoveryrs.components.structure.control;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;

import de.egatlovs.linkdiscoveryrs.components.structure.entity.FieldDefinition;
import de.egatlovs.linkdiscoveryrs.components.structure.entity.FieldDefinitionDTO;
import de.egatlovs.linkdiscoveryrs.components.structure.entity.Structure;
import de.egatlovs.linkdiscoveryrs.components.structure.entity.StructureDTO;

@RequestScoped
public class StructureTransformer {

	public StructureDTO structureDTO(Structure structure) {
		return new StructureDTO(structure.getId(), structure.getName(), structure.getDescription(),
				fieldDefinitionDTOs(structure.getFieldDefinitions()));
	}

	public Structure structure(StructureDTO structureDTO) {
		return new Structure(structureDTO.getId(), structureDTO.getName(), structureDTO.getDescription(),
				fieldDefinitions(structureDTO.getFieldDefinitionDTOs()));
	}

	public List<StructureDTO> structureDTOs(List<Structure> structures) {
		List<StructureDTO> dtos = new ArrayList<>();
		for (Structure structure : structures) {
			dtos.add(structureDTO((structure)));
		}
		return dtos;
	}

	public List<Structure> structures(List<StructureDTO> structuresDTOs) {
		List<Structure> structures = new ArrayList<>();
		for (StructureDTO dto : structuresDTOs) {
			structures.add(structure(dto));
		}
		return structures;
	}

	public FieldDefinitionDTO fieldDefinitionDTO(FieldDefinition fieldDefinition) {
		return new FieldDefinitionDTO(fieldDefinition.getId(), fieldDefinition.getName(), fieldDefinition.getType(),
				fieldDefinition.getValidationConstraint());
	}

	public FieldDefinition fieldDefinition(FieldDefinitionDTO fieldDefinitionDTO) {
		return new FieldDefinition(fieldDefinitionDTO.getId(), fieldDefinitionDTO.getName(),
				fieldDefinitionDTO.getType(), fieldDefinitionDTO.getValidationConstraint());
	}

	public List<FieldDefinitionDTO> fieldDefinitionDTOs(List<FieldDefinition> fieldDefinitions) {
		List<FieldDefinitionDTO> dtos = new ArrayList<>();
		for (FieldDefinition fieldDefinition : fieldDefinitions) {
			dtos.add(fieldDefinitionDTO((fieldDefinition)));
		}
		return dtos;
	}

	public List<FieldDefinition> fieldDefinitions(List<FieldDefinitionDTO> fieldDefinitionDTOs) {
		List<FieldDefinition> fieldDefinitions = new ArrayList<>();
		for (FieldDefinitionDTO dto : fieldDefinitionDTOs) {
			fieldDefinitions.add(fieldDefinition(dto));
		}
		return fieldDefinitions;
	}

}
