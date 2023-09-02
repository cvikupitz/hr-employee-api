package com.company.hr.config;

import com.company.hr.constants.ApplicationConstants;
import com.company.hr.constants.SpringDocConstants;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityScheme.In;
import io.swagger.v3.oas.models.security.SecurityScheme.Type;
import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(servers = {
    @Server(url = "/")
})
public class SpringDocConfig {

  @Bean
  public OpenAPI registerOpenAPI() {

    // Security components used for injecting authorization header from Swagger UI
    Components components = new Components()
        .addSecuritySchemes(ApplicationConstants.HEADER_AUTHORIZATION_KEY, new SecurityScheme()
                .type(Type.APIKEY)
                .in(In.HEADER)
                .name(ApplicationConstants.HEADER_AUTHORIZATION_KEY));
    SecurityRequirement securityRequirement =
        new SecurityRequirement().addList(ApplicationConstants.HEADER_AUTHORIZATION_KEY);
    // Basic information to display on page
    Info info = new Info()
        .title(SpringDocConstants.APP_NAME)
        .version(SpringDocConstants.VERSION);

    // Registers the OpenAPI object to generate Swagger page
    return new OpenAPI()
        .components(components)
        .security(Collections.singletonList(securityRequirement))
        .info(info);
  }
}