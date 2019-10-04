package com.steal.bs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;


@Configuration
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter {
	
	@Autowired
	AuthenticationProvider authenticationProvider;
    
	@Override
	public void configure(WebSecurity web) throws Exception
	{
		web.ignoring().antMatchers("/favicon.ico", "/css/**", "/image/**", "/js/**","/resource/**",
				"/insert","/signup.main","/loginidchk.main","/signupempchk.main",
				"/idsearch.main","pwsearch.main");
	}
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	//http.csrf().disable();
    	http.exceptionHandling().accessDeniedPage("/accessDenied");
        http.authorizeRequests()
        .antMatchers("/","/insert","/insertres").permitAll()
        			.antMatchers("/user/**").hasAnyRole("USER","ADMIN")
                	.antMatchers("/admin/**").hasRole("ADMIN")
                	.anyRequest().authenticated()
                	.and()
                .formLogin()
                	.loginPage("/")
                	.loginProcessingUrl("/login.main")
                	.usernameParameter("main_id")
                	.passwordParameter("main_password")
                	.defaultSuccessUrl("/")
                	.permitAll()
                	.and()
                .logout()
                	.logoutUrl("/logout.main")
                	.logoutSuccessUrl("/")
                	.invalidateHttpSession(true)
                	.permitAll()
                	.and()
                .csrf()
                	.and()
                .authenticationProvider(authenticationProvider);
                
                
    }
}

