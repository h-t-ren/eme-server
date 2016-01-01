package com.huihuan.eme;

import java.util.Map;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@EnableAutoConfiguration
@ComponentScan
@Controller
public class EMEWebApplication extends WebMvcConfigurerAdapter {

	private static final Log logger = LogFactory.getLog(EMEWebApplication.class);
	@RequestMapping("/")
	public String home(Map<String, Object> model) {
		return "index";
	}

	@RequestMapping("/foo")
	public String foo() {
		throw new RuntimeException("Expected exception in controller");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
	}

	@Bean
	public ApplicationSecurity applicationSecurity() {
		return new ApplicationSecurity();
	}

	public static void main(String[] args) throws Exception {
		new SpringApplicationBuilder(EMEWebApplication.class).run(args);
	}

	@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
	protected static class ApplicationSecurity extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().antMatchers("/css/**","/js/**","images/**").permitAll();
			http.authorizeRequests().antMatchers("/login").permitAll().anyRequest()
			.fullyAuthenticated().and().formLogin().loginPage("/login")
			.failureUrl("/login?error").and().logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).and()
			.exceptionHandling().accessDeniedPage("/access?error");
               
			
		}

		@Override
		public void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
		}

	}

}
