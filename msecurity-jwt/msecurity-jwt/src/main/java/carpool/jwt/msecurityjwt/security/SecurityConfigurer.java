package carpool.jwt.msecurityjwt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import carpool.jwt.msecurityjwt.service.MyUserDetailsService;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
	@Autowired
	private MyUserDetailsService myuserDetailsService;
	
	@Autowired
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)throws Exception{
		auth.userDetailsService(myuserDetailsService);
	}
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable()
				.authorizeRequests().antMatchers("/authenticate").permitAll().
						anyRequest().authenticated().and().
						exceptionHandling().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

	}
}
