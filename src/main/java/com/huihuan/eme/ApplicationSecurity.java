/**
 * 
 */
package com.huihuan.eme;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;



/**
 * @author 任宏涛， ren@ecust.edu.cn
 *
 * @created 2016年1月5日 下午12:55:36
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@ImportResource(value={"classpath*:META-INF/datasource.xml","classpath*:META-INF/secu.xml"})
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {
	
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/css/**","/js/**","/images/**").permitAll();
		//http.authorizeRequests().antMatchers(HttpMethod.OPTIONS,"/**").permitAll();
		http.authorizeRequests().antMatchers("/login").permitAll().anyRequest()
		.fullyAuthenticated().and().formLogin().loginPage("/login")
		.failureUrl("/login?error").and().logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).and()
		.exceptionHandling().accessDeniedPage("/access?error");
		//http.rememberMe().key("SpringSecurityAclDemo-rmkey-BUUttZnBJCa#U=4Dwg@%5_ptCC8wHtlY").userDetailsService(jdbcUserService);

	}


}