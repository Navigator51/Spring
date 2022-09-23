package su.goodcat.spring.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import su.goodcat.spring.services.impl.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SpringSecurityConfig implements WebMvcConfigurer {

    private final UserDetailsServiceImpl userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final SuccessLoginHandler successLoginHandler;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.cors();
        return httpSecurity
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/main", "/api/v1/**").permitAll() // доступность всем
                .antMatchers("/admin/**", "/configuration/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/full_access/**").access("hasAnyRole('ROLE_ADMIN','ROLE_SUPER_MEGA_GALAXY_ADMIN')")
                .antMatchers("/").authenticated()
                .anyRequest().permitAll()
                .and().formLogin().loginPage("/login").permitAll()
                .successHandler(successLoginHandler)
                .and().build();
    }

    @Autowired
    public void setUserDetailsService(AuthenticationManagerBuilder autMB) throws Exception {
        autMB.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }
}
