package mx.springboot.form.app.validations;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import mx.springboot.form.app.models.Game;

@Component
public class GameValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Game.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Game game = (Game) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "NotEmpty.game.title");
				
//		if(!game.getId().matches("[A-Z]{1}[.][\\d]{3}[.][\\d]{2}[-][A-Z]")) {
//			errors.rejectValue("id", "Pattern.game.id");
//		}
		
	}

}
