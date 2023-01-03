package datn.realestate.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import datn.realestate.authenservice.CustomerDetailService;

@Configuration
@EnableWebSecurity
public class WebHandleAuthen {
	
	@Autowired
    private CustomerDetailService userDetailsService;
	
	@Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
	
	
	@SuppressWarnings("deprecation")
	@Bean
	@Order(1)
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .requestMatchers("/Admin/**").hasAnyRole("ADMIN")
    			.and()
    			.formLogin()
    			.loginPage("/cms/adminlogin").permitAll()
    			
    			.defaultSuccessUrl("/cms/dashboard")
    			.and()
    			.logout()
    			.logoutRequestMatcher(new AntPathRequestMatcher("/cms/logout"))
    			.logoutSuccessUrl("/cms/logoutpage")
    			.invalidateHttpSession(true)
    			.and()
    			.exceptionHandling().accessDeniedPage("/cms/access-denied");
        return http.build();
    }
	
	@SuppressWarnings("deprecation")
	@Bean
	@Order(1)
    public SecurityFilterChain filterChainProduct(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .requestMatchers("/myaccount").hasAnyRole("USER","ADMIN")
    			.requestMatchers("/about").permitAll()
    			.requestMatchers("/","/public/**", "/resources/**","/resources/public/**")
                .permitAll()
    			.and()
    			.formLogin()
    			.loginPage("/login").permitAll()
    			
    			.defaultSuccessUrl("/")
    			.and()
    			.logout()
    			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
    			.logoutSuccessUrl("/logoutpage")
    			.invalidateHttpSession(true)
    			.and()
    			.exceptionHandling().accessDeniedPage("/access-denied");
        return http.build();
    }
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
}
