package br.com.reviews.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.reviews.model.Usuario;

public class UsuarioValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {

		return Usuario.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		ValidationUtils.rejectIfEmpty(errors, "nome", "field.required");

		ValidationUtils.rejectIfEmpty(errors, "email", "field.required");

		ValidationUtils.rejectIfEmpty(errors, "login", "field.required");

		ValidationUtils.rejectIfEmpty(errors, "senha", "field.required");

	}
}
