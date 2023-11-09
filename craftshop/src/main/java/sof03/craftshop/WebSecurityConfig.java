package sof03.craftshop;



import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import sof03.craftshop.web.UserDetailServiceImpl;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {

	@Autowired
	private UserDetailServiceImpl UserDetailService;

	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http
	    .authorizeHttpRequests( authorize -> authorize
	          .requestMatchers(antMatcher("/css/**")).permitAll() // Enable css when logged out
	          .requestMatchers(toH2Console()).permitAll()
	          .anyRequest().authenticated()
	    )
	     .csrf(csrf -> csrf
	          .ignoringRequestMatchers(toH2Console())
	     )
	     .headers(headers -> headers
	         .frameOptions(frameoptions -> frameoptions
	                  .disable())
	     )
	    .formLogin(formlogin -> formlogin
	          .defaultSuccessUrl("/shop", true)
	          .permitAll()
	     )
	    .logout(logout -> logout
	         .permitAll()
	    );
	 return http.build();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(UserDetailService).passwordEncoder(new BCryptPasswordEncoder());
	}
}
