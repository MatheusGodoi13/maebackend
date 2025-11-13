package Trabalho.BuscarRemedios;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // Em produção, substitua pelo IP do seu app
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }
}