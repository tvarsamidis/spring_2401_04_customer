package gr.majestic.reservations.configuration;

import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer
                .defaultContentType(MediaType.APPLICATION_JSON) // Default to JSON
                .favorPathExtension(true) // Allow clients to request format via file extension (e.g., .json, .xml)
                .mediaType("json", MediaType.APPLICATION_JSON) // JSON format
                .mediaType("xml", MediaType.APPLICATION_XML); // XML format
    }
}
