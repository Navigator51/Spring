package su.goodcat.spring.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import su.goodcat.spring.services.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SpringSecurityConfig implements WebMvcConfigurer {

    private final UserDetailsServiceImpl userDetailsService;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.cors().and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/main").permitAll()
                .antMatchers("/admin/**", "/configuration/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/full_access/**").access("hasAnyRole('ROLE_ADMIN','ROLE_SUPER_MEGA_GALAXY_ADMIN')")
                .antMatchers("/**").authenticated()
                .and().formLogin().loginPage("/login").permitAll()
                .and().build();
    }

    @Bean //подключаем кодирование паролей
    public PasswordEncoder doCrypting() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void setUserDetailsService(AuthenticationManagerBuilder autMB) throws Exception {
        autMB.userDetailsService(userDetailsService).passwordEncoder(doCrypting());
    }
}