package com.uzunalov.i18nlocalization.config;

import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(
                        new Components()
                                .addParameters("Accept-Language",
                                        new Parameter()
                                                .in(ParameterIn.HEADER.toString())
                                                .name("Accept-Language")
                                                .description("Language preference (e.g., en, fr, de)")
                                                .schema(new StringSchema())
                                                .example("en"))
                )
                .info(new Info()
                        .title("Sample Localization API")
                        .version("1.0")
                        .description(
                                "This is the API documentation for Sample Localization API.")
                        .contact(new Contact()
                                .name("Hasan Uzunalov")
                                .email("uzunalovhasan@gmail.com")));
    }
}
