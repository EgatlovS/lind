package de.egatlovs.lind.components.structure.entity.constraint;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import de.egatlovs.lind.components.structure.entity.FieldDefinition;
import de.egatlovs.lind.components.structure.entity.FieldType;

public class CheckOneOrder implements ConstraintValidator<OneOrder, List<FieldDefinition>> {

	@Override
	public void initialize(OneOrder constraintAnnotation) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValid(List<FieldDefinition> definitions, ConstraintValidatorContext context) {
		boolean isOrderApplied = false;
		for (FieldDefinition definition : definitions) {
			if (definition.getType().equals(FieldType.ORDER)) {
				if (isOrderApplied) { // role already existent
					return false; // break and return failure
				}
				isOrderApplied = true;
			}
		}
		return true;
	}

}
