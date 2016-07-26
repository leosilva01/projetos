package br.com.reviews.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletSpringMvc extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {

		return new Class[] {AppWebConfiguration.class, JPAConfiguration.class, SecurityConfiguration.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		return new Class[] {};
	}

	@Override
	protected String[] getServletMappings() {

		return new String[] { "/" };
	}
	
	//todas as requisicoes que passarem pela serlvet vao estar com encoding utf8
	@Override
	protected Filter[] getServletFilters() {
	
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter("UTF-8");
		
		return new Filter[]{encodingFilter};
	}

}
