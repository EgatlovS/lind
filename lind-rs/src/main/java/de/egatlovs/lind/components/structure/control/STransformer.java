package de.egatlovs.lind.components.structure.control;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;

import de.egatlovs.lind.components.structure.entity.FieldDefinition;
import de.egatlovs.lind.components.structure.entity.Structure;
import de.egatlovs.lind.components.structure.entity.dto.FieldDefinitionDTO;
import de.egatlovs.lind.components.structure.entity.dto.MinimalStructureDTO;
import de.egatlovs.lind.components.structure.entity.dto.StructureDTO;

@RequestScoped
public class STransformer {

	public StructureDTO structureDTO(Structure structure) {
		return new StructureDTO(structure.getId(), structure.getName(), structure.getDescription(),
				fieldDefinitionDTOs(structure.getFieldDefinitions()));
	}

	public Structure structure(StructureDTO structureDTO) {
		return new Structure(structureDTO.getId(), structureDTO.getName(), structureDTO.getDescription(),
				fieldDefinitions(structureDTO.getFieldDefinitions()));
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

	public MinimalStructureDTO minimalStructureDTO(Structure structure) {
		return new MinimalStructureDTO(structure.getId(), structure.getName());
	}

	public List<MinimalStructureDTO> minimalStructureDTOs(List<Structure> structures) {
		List<MinimalStructureDTO> minimalStructureDTOs = new ArrayList<>();
		for (Structure structure : structures) {
			minimalStructureDTOs.add(minimalStructureDTO(structure));
		}
		return minimalStructureDTOs;
	}

}
