package su.goodcat.spring.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.Arrays;

/**
 * Конфигурация для swagger.
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApiV1() {
        return GroupedOpenApi.builder()
                .group("public-api-v1")
                .packagesToScan("su.goodcat")
                .build();
    }

    @Bean
    public OpenAPI customOpenAPI(final Environment env) {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("basicScheme", new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic"))
                        .addSecuritySchemes("cookieAuth", new SecurityScheme().type(SecurityScheme.Type.APIKEY).in(SecurityScheme.In.COOKIE).name("JSESSIONID")))
                .info(new Info()
                        .title(env.getProperty("spring.application.name", "SpringProject"))
                        .description("Сервис обработки бизнес запросов")
                        .contact(new Contact()
                                .name("ООО Рога и копыта")
                                .email("uiyg@kjlh.com")
                                .url("http://localhost:8081"))
                )
                .security(Arrays.asList(new SecurityRequirement().addList("cookieAuth")));
    }


}

