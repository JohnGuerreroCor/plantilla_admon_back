package com.usco.edu.auth;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		//AGREGAR RUTAS DE PERMISO TANTO DEL FRONT EJEMPLO LÍNEA 39 SE AGRGAN LOS ARCHIVOS MULTIMEDIA DEL FRONT PARA PODERLOS VISUALIZAR UNA VEZ COMPILADOS Y DESPLEGADOS
		http.authorizeRequests().antMatchers("/api").permitAll()
		.antMatchers("/login").permitAll()
		.antMatchers("/uaa").permitAll()
		.antMatchers("/token").permitAll()	
		.antMatchers("/obtenerFoto/{codigo}").permitAll()
		.antMatchers("/archivos/{per_codigo}/{uaa}/{usuario}").permitAll()
		.antMatchers("/archivos/{usuario}/{uaa}").permitAll()
		.antMatchers("/resources/**").permitAll()
		.antMatchers("/logo").permitAll()
		.antMatchers("/assets/**").permitAll()
		.antMatchers("/**.png").permitAll()
		.antMatchers("/**.js").permitAll()
		.antMatchers("/**.css").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/").permitAll()
		.and().cors().configurationSource(corsConfigurationSource());
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowedOrigins(Arrays.asList("*"));
		//PETICIONES PERMITIDAS DENTRO DEL APLICATIVO
		config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		config.setAllowCredentials(true);
		config.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);
		return source;
	}
	
	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter(){
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}


	
}
