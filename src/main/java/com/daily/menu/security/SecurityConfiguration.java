package com.daily.menu.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.daily.menu.repository.UserRepository;
import com.daily.menu.service.AuthenticationService;
import com.daily.menu.service.TokenService;

@SuppressWarnings("deprecation")
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	AuthenticationService authenticationService;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private UserRepository userRepository;
	
    	
	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

    //Configuration for authorization
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers(HttpMethod.POST, "/api/login").permitAll()
            .antMatchers(HttpMethod.POST, "/api/user").permitAll()
        	.anyRequest().authenticated()
        	.and().csrf().disable()
        	.cors()
        	.and()
        	.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        	// token filter configuration
        	.and().addFilterBefore(new TokenAuthenticationFilter(tokenService, userRepository), UsernamePasswordAuthenticationFilter.class);
    }
    
    
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// cria uma conta default
		auth.inMemoryAuthentication()
			.withUser("email")
			.password("password")
			.roles("ADMIN");
	}

    
//    @Bean
//    AuthenticationManager customAuthenticationManager(UserDetailsService userDetailsService, PasswordEncoder encoder) {
//        return authentication -> {
//            String username = authentication.getPrincipal() + "";
//            String password = authentication.getCredentials() + "";
//            
//            UserDetails user = userDetailsService.loadUserByUsername(username);
//            
//            if (!encoder.matches(password, user.getPassword())) {
//                throw new BadCredentialsException("Bad credentials");
//            }
//            
//            if (!user.isEnabled()) {
//                throw new DisabledException("User account is not active");
//            }
//            
//            return new UsernamePasswordAuthenticationToken(username, null, user.getAuthorities());
//        };
//    }
}
    
