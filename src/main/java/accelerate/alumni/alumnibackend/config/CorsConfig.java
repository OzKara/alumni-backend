package accelerate.alumni.alumnibackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    private final Environment environment;

    public CorsConfig(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        String allowedOrigin = environment.getProperty("SPRING_ALLOWED_ORIGIN");

        registry.addMapping("/**")
                .allowedOrigins(allowedOrigin, "http://localhost:3000", "http://locahost:8080", "https://alumni-case-frontend.vercel.app/")
                .allowedMethods("GET", "POST", "PUT")
                .maxAge(3600);
    }
}
