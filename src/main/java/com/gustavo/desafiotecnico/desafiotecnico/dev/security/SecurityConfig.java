//package com.gustavo.desafiotecnico.desafiotecnico.dev.security;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter{
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//		auth.inMemoryAuthentication()
//		.withUser("admin").password(encoder.encode("123456")).roles("ADMIN")
//		.and()
//		.withUser("comun").password(encoder.encode("123456")).roles("USER");
//	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		// TODO Auto-generated method stub
//		http.csrf().disable()
//		.authorizeRequests().antMatchers(HttpMethod.GET, "**/").permitAll()
//		.antMatchers(HttpMethod.OPTIONS, "/cliente").authenticated()
//		.anyRequest().authenticated()
//		
//		.and().httpBasic()
//		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//	}
//	
//	
//}
