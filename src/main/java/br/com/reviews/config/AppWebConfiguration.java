package br.com.reviews.config;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.google.common.cache.CacheBuilder;

import br.com.reviews.controller.IndexController;
import br.com.reviews.dao.AppDao;
import br.com.reviews.dao.ReviewsDao;
import br.com.reviews.dao.UsuarioDao;
import br.com.reviews.model.GerenciadorDeReviews;

@EnableWebMvc
//add classes dos objetos a serem injetados
@ComponentScan(basePackageClasses = { UsuarioDao.class, IndexController.class, AppDao.class, CustomUsuarioDetailsService.class, 
										GerenciadorDeReviews.class, ReviewsDao.class })
@EnableCaching
public class AppWebConfiguration extends WebMvcConfigurerAdapter {

	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {

		final InternalResourceViewResolver resolver = new InternalResourceViewResolver();

		resolver.setPrefix("/WEB-INF/jsp/");

		resolver.setSuffix(".jsp");

		return resolver;
	}

	@Bean
	public MessageSource messageSource() {

		final ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

		messageSource.setBasename("/WEB-INF/messages");

		messageSource.setDefaultEncoding("UTF-8");

		messageSource.setCacheSeconds(10);

		return messageSource;

	}

	// metodo para habilitar uso do bootstrap css
	@Override
	public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer configurer) {

		configurer.enable();
	}
	
	@Bean // responsavel por gerenciar o cache da aplicacao
	public CacheManager cacheManager() {

		final CacheBuilder<Object, Object> builder = CacheBuilder.newBuilder().maximumSize(100) // tamanho maximo de elementos que ficaram no cache
				.expireAfterAccess(5, TimeUnit.MINUTES);// tempo ate q o cache expire, no caso seja feita uma nova consulta

		final GuavaCacheManager manager = new GuavaCacheManager();
		manager.setCacheBuilder(builder);
		return manager;
	}
	
	@Override // reponsavel por interceptar a requisicao de locale, na jsp o paramentro deve ter o mesmo nome do arquivo message
	public void addInterceptors(final InterceptorRegistry registry) {

		registry.addInterceptor(new LocaleChangeInterceptor());
	}
	
	@Bean // define que a definicao de locale ficara armezenada em um cookie no navegador do cliente
	public LocaleResolver localeResolver() {

		return new CookieLocaleResolver();
	}

}
