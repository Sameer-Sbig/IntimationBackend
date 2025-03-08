package com.sbigeneral.Intimation.Util;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Autowired
	private UserDetailsService jwtUserDetailsService;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	@Autowired
    private ClientAgentAuthenticationProvider authenticationProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// configure AuthenticationManager so that it knows from where to load
		// user for matching credentials
		// Use BCryptPasswordEncoder
		auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable()
				// don't authenticate the getToken request
				.authorizeRequests().antMatchers("/getToken","/getPolicyDetailCustomerPortal","/getClientId","/logoutUser", "/basic/register","/util/*","/logoutpage").permitAll().
				// all other requests need to be authenticated
				anyRequest().authenticated().and().
				exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//				.sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
//                .maximumSessions(1).maxSessionsPreventsLogin(true);

		//a filter to validate the tokens with every request
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		httpSecurity.cors();
	}


	 @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins(
                            "http://localhost:4200",
                            "https://ansappsuat.sbigen.in",
                            "http://localhost:5173",
                            "http://172.18.115.105:7003/PINS",
                            "http://172.16.232.92:7002/PIN",
                            "https://commonsecure.sbigen.in/VBIM",
                            "https://secure.sbigeneral.in/VBIM"
                        )
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}


//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//	private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
//	private final UserDetailsService jwtUserDetailsService;
//	private final JwtRequestFilter jwtRequestFilter;
//	private AuthenticationManagerBuilder authManagerBuilder;
//
//	@Autowired
//	public WebSecurityConfig(
//	    @Lazy JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint,
//	    @Lazy UserDetailsService jwtUserDetailsService,
//	    @Lazy JwtRequestFilter jwtRequestFilter,
//	    AuthenticationManagerBuilder authManagerBuilder) {
//		this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
//		this.jwtUserDetailsService = jwtUserDetailsService;
//		this.jwtRequestFilter = jwtRequestFilter;
//		this.authManagerBuilder = authManagerBuilder;
//	}
//
//	
//	@PostConstruct
//	public void initAuthManager() throws Exception {
//		configureGlobal(authManagerBuilder);
//	}
//	
//	
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//	@Bean
//	@Override
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		return super.authenticationManagerBean();
//	}
//
//	@Override
//	protected void configure(HttpSecurity httpSecurity) throws Exception {
//		httpSecurity.csrf().disable()
//				.authorizeRequests().antMatchers("/getToken", "/basic/register", "/util/*", "/logoutpage").permitAll()
//				.anyRequest().authenticated().and()
//				.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
//				.and()
//				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//		httpSecurity.cors();
//	}
//}