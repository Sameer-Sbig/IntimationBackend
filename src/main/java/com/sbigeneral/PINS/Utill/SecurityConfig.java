package com.sbigeneral.PINS.Utill;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.server.CookieSameSiteSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.session.ConcurrentSessionControlAuthenticationStrategy;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.security.web.session.SessionManagementFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.sbigeneral.PINS.Service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Lazy
	private UserDetailsService userdetailsService;
	@Autowired
	@Lazy
	private PasswordEncoder encoder;
	@Autowired
	@Lazy
	private CustomAuthenticationSuccessHandler successHandler;
	@Autowired
	@Lazy
	private CustomAuthenticationFailureHandler failureHandler;
	@Autowired
	@Lazy
	private CustomAuthenticationProvider authenticcationProvider;
	
	private final CorsFilter corsfilter;
	
	@Autowired
	public SecurityConfig(CorsFilter corsFilter) {
		this.corsfilter=corsFilter;
	}

	
	
	
	
	
	
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.headers()
//      .frameOptions().disable().and().logout().logoutUrl("/logout").invalidateHttpSession(true).clearAuthentication(true)
//				.deleteCookies("JSESSIONID").permitAll().and().csrf().disable()
//				 .addFilterBefore(corsfilter, SessionManagementFilter.class) 
//				.authorizeRequests()
//				.antMatchers("/", "/index.html", "/login", "/static/**", "/registration", "/forgetpassword",
//						"/fetchlogin", "/invalidate-session", "/logout", "/is-logged-in")
//				.permitAll().antMatchers("/changePassword").authenticated().anyRequest().authenticated().and()
//				.formLogin().loginPage("/login").successHandler(successHandler).failureHandler(failureHandler)
//				.permitAll().and().sessionManagement()
//				.maximumSessions(1).maxSessionsPreventsLogin(true).sessionRegistry(sessionRegistry()).and()
//				.sessionFixation().newSession(); // Disable
//		//http.addFilterBefore(new XFrameOptionsHeaderFilter(), UsernamePasswordAuthenticationFilter.class);																				// CSRF
//
//	}
	
	
	
//	@Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .headers()
//                .frameOptions().deny()  // Ensure this does not conflict with your filter settings
//                .and()
//            .logout()
//                .logoutUrl("/logout")
//                .invalidateHttpSession(true)
//                .clearAuthentication(true)
//                .deleteCookies("JSESSIONID")
//                .permitAll()
//                .and()
//            .csrf().disable()
//            .authorizeRequests()
//                .antMatchers("/", "/index.html", "/login", "/static/**", "/registration", "/forgetpassword",
//                             "/fetchlogin", "/invalidate-session", "/logout", "/is-logged-in")
//                .permitAll()
//                .antMatchers("/changePassword").authenticated()
//                .anyRequest().authenticated()
//                .and()
//            .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
//            .sessionManagement()
//                .maximumSessions(1)
//                .maxSessionsPreventsLogin(false);
//    }
//	 
	
	

	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout").invalidateHttpSession(true).deleteCookies("JSESSIONID").and().cors().and()
				.headers().frameOptions().sameOrigin().and().csrf().disable().authorizeRequests().and().formLogin()
				.loginPage("/login").failureHandler(failureHandler).successHandler(successHandler).permitAll().and()
				.authorizeRequests().antMatchers("/forgetpassword/**").permitAll();
				
				//http.addFilterBefore(new XFrameOptionsHeaderFilter(), UsernamePasswordAuthenticationFilter.class)
	}
//	}
	 
	 
	 
	


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticcationProvider);
	}

	@Bean
	public PasswordEncoder encode() {
		return new BCryptPasswordEncoder();
	}
	 @Bean
	    public SessionRegistry sessionRegistry() {
	        return new SessionRegistryImpl(); // Create a session registry bean
	    }
	
		
	
	
}