package mx.springboot.form.app.validations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = IdRegexValidador.class)
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface IdRegex {

	String message() default "Valor identificador incorrecto , por favor asegurese de que cumple con la siguiente estructura: L.111.22-L - Anotacion IdRegex";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
	
}
