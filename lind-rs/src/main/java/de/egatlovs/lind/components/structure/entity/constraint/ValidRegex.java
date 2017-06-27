package de.egatlovs.lind.components.structure.entity.constraint;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE })
@Constraint(validatedBy = CheckValidRegex.class)
public @interface ValidRegex {

	String message() default "{de.egatlovs.lindrs.components.structure.entity.constraint.ValidRegex."
			+ "message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
