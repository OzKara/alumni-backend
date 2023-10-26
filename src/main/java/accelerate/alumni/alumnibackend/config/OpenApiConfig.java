package accelerate.alumni.alumnibackend.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Alumni API",
                version = "1.0",
                description = "Case project: Alumni",
                license = @License(name = "MIT © 2023 hashirraja, HennningS, lucastrann, OzKara")

        ),
        security = {@SecurityRequirement(name = "bearer-key")},  // This refers to the SecurityScheme defined below
        tags = {
                @Tag(name = "Users", description = "All endpoints related to users"),
                @Tag(name = "Posts", description = "All endpoints related to posts"),
                @Tag(name = "Events", description = "All endpoints related to events"),
                @Tag(name = "Replies", description = "All endpoints related to replies"),
                @Tag(name = "Group", description = "All endpoints related to groups"),
                @Tag(name = "Get", description = "All get endpoints"),
                @Tag(name = "Post", description = "All post endpoints"),
                @Tag(name = "Put", description = "All put endpoints"),
                @Tag(name = "Delete", description = "All delete endpoints")
        }
)
@Configuration
public class OpenApiConfig {
        @Bean
        public OpenAPI customOpenAPI() {
                return new OpenAPI()
                        .components(new Components()
                                .addSecuritySchemes("bearer-key",  // This key is referred in the @OpenAPIDefinition above
                                        new SecurityScheme()
                                                .type(SecurityScheme.Type.HTTP)
                                                .scheme("bearer")
                                                .bearerFormat("JWT")));
        }
}
