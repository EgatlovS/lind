package de.egatlovs.linkdiscoveryrs.components.linkpoint.control;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.enterprise.context.RequestScoped;

import de.egatlovs.linkdiscoveryrs.components.linkpoint.entity.FieldDTO;
import de.egatlovs.linkdiscoveryrs.components.linkpoint.entity.LinkpointDTO;
import de.egatlovs.linkdiscoveryrs.components.structure.entity.FieldDefinition;
import de.egatlovs.linkdiscoveryrs.components.structure.entity.Structure;

@RequestScoped
public class LinkpointValidation {

	public boolean isValid(Structure structure, LinkpointDTO linkpointDTO) {
		List<FieldDefinition> definitions = structure.getFieldDefinitions();
		List<FieldDTO> fields = linkpointDTO.getFieldDTOs();
		if (!checkFieldLength(definitions, fields) || //
				!checkUniqueNames(fields) || //
				!checkFields(definitions, fields)) {
			return false;
		}
		return true;
	}

	private boolean checkFieldLength(List<FieldDefinition> definitions, List<FieldDTO> fields) {
		if (fields.size() != definitions.size()) {
			return false;
		}
		return true;
	}

	private boolean checkUniqueNames(List<FieldDTO> fields) {
		Set<String> names = new HashSet<>();
		for (FieldDTO field : fields) {
			if (!names.add(field.getName())) {
				return false;
			}
		}
		return true;
	}

	private boolean checkFields(List<FieldDefinition> definitions, List<FieldDTO> fields) {
		for (FieldDefinition definition : definitions) {
			if (!checkField(definition, fields)) {
				return false;
			}
		}
		return true;
	}

	private boolean checkField(FieldDefinition definition, List<FieldDTO> fields) {
		for (FieldDTO fieldDTO : fields) {
			if (fieldDTO.getName().equals(definition.getName())
					&& fieldDTO.getValue().matches(definition.getValidationConstraint())) {
				return true;
			}
		}
		return false;
	}

}
