package su.goodcat.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/registry").setViewName("registry");
    }

    //подключаем кодирование паролей
    @Bean
    public PasswordEncoder enableCrypting() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public HiddenHttpMethodFilter enableHiddenMethodsForThymeleafForms() {
        return new HiddenHttpMethodFilter();
    }
}
