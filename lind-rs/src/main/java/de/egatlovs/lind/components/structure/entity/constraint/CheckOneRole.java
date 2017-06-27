package de.egatlovs.lind.components.structure.entity.constraint;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import de.egatlovs.lind.components.structure.entity.FieldDefinition;
import de.egatlovs.lind.components.structure.entity.FieldType;

public class CheckOneRole implements ConstraintValidator<OneRole, List<FieldDefinition>> {

	@Override
	public void initialize(OneRole constraintAnnotation) {
	}

	@Override
	public boolean isValid(List<FieldDefinition> definitions, ConstraintValidatorContext context) {
		boolean isRoleApplied = false;
		for (FieldDefinition definition : definitions) {
			if (definition.getType().equals(FieldType.ROLES)) {
				if (isRoleApplied) { // role already existent
					return false; // break and return failure
				}
				isRoleApplied = true;
			}
		}
		return true;
	}
}
