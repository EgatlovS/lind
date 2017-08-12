package de.egatlovs.lind.components.linkpoint.control;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.enterprise.context.RequestScoped;

import de.egatlovs.lind.components.linkpoint.entity.dto.FieldDTO;
import de.egatlovs.lind.components.linkpoint.entity.dto.LinkpointDTO;
import de.egatlovs.lind.components.structure.entity.dto.FieldDefinitionDTO;
import de.egatlovs.lind.components.structure.entity.dto.StructureDTO;

@RequestScoped
public class FieldMatcher {

	public void tryToMatch(StructureDTO structureDto, LinkpointDTO linkpointDTO) throws Exception {
		List<FieldDefinitionDTO> definitions = structureDto.getFieldDefinitions();
		List<FieldDTO> fields = linkpointDTO.getFields();
		checkFieldLength(definitions, fields);
		checkUniqueNames(fields);
		checkFields(definitions, fields);
	}

	private void checkFieldLength(List<FieldDefinitionDTO> definitions, List<FieldDTO> fields) throws Exception {
		if (fields.size() != definitions.size()) {
			throw new Exception("Invalid number of Fields"); // todo throw a
																// real one
		}
	}

	private void checkUniqueNames(List<FieldDTO> fields) throws Exception {
		Set<String> names = new HashSet<>();
		for (FieldDTO field : fields) {
			if (!names.add(field.getName())) {
				throw new Exception("Duplicate Names"); // todo throw a real one
			}
		}
	}

	private void checkFields(List<FieldDefinitionDTO> definitions, List<FieldDTO> fields) throws Exception {
		for (FieldDefinitionDTO definition : definitions) {
			try {
				checkField(definition, fields);
			} catch (Exception e) {
				throw new Exception("Invalid field name or value " + definition.getName()); // todo
																	// throw a
																	// real one
			}
		}
	}

	private void checkField(FieldDefinitionDTO definition, List<FieldDTO> fields) throws Exception {
		for (FieldDTO fieldDTO : fields) {
			if (fieldDTO.getName().equals(definition.getName())
					&& !fieldDTO.getValue().matches(definition.getValidationConstraint())) {
				throw new Exception("Invalid field " + fieldDTO.getName()); // todo
																			// throw
																			// a
																			// real
																			// one
			}
		}
	}

}
