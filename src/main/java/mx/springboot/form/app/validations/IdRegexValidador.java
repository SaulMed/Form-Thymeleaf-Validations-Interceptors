package mx.springboot.form.app.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IdRegexValidador implements ConstraintValidator<IdRegex, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		if(!value.matches("[A-Z]{1}[.][\\d]{3}[.][\\d]{2}[-][A-Z]")) {			
			return false;
		}
		return true;
	}
	
}
