package br.com.reviews.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.reviews.model.App;

public class AppValidation implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {

		return App.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		ValidationUtils.rejectIfEmpty(errors, "nome", "field.required");

		ValidationUtils.rejectIfEmpty(errors, "link", "field.required");
		
	}
}
