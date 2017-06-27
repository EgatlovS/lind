package de.egatlovs.lind.components.structure.entity.constraint;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckValidRegex implements ConstraintValidator<ValidRegex, String> {

	@Override
	public void initialize(ValidRegex constraintAnnotation) {

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		try {
			Pattern.compile(value);
			return true;
		} catch (PatternSyntaxException e) {
			return false;
		}
	}

}
