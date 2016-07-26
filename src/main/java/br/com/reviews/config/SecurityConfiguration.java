package br.com.reviews.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity @Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUsuarioDetailsService usuarioDetails;

	@Override
	protected void configure(final HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.antMatchers("/app/**").hasRole("FREE")
		.antMatchers("/usuario").permitAll()
		.antMatchers("/usuario/formUsuario").permitAll()
		.antMatchers("/usuario/register").permitAll()
		.antMatchers("/").permitAll()
		.antMatchers("/resources/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/login").successForwardUrl("/index1").permitAll()
		.and()
		.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	
	
		http.logout()
			.logoutSuccessUrl("/");
		
	}

	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {

		//auth.inMemoryAuthentication().withUser("leo").password("leo").roles("LOGADO"); criando um usuario na memoria
		auth.userDetailsService(this.usuarioDetails).passwordEncoder(new BCryptPasswordEncoder());
	}

}
