package edu.unicauca.SivriBackendApp.common.configuración;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Miguel Mosquera",
                        email = "mandresmosquera@gmail.com",
                        url = "https://www.linkedin.com/in/miguel-mosquera/"
                ),
                description = "Documentación OpenApi para el proyecto SIVRI de la Vicerrectoría de Investigación de la Universidad del Cauca",
                title = "Documentación OpenApi  - SIVRI",
                version = "1.0"
        ),
        servers = {
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:8080/api"
                ),
                @Server(
                        description = "PROD ENV",
                        url = "https://sivri.edu.co/api"
                )
        },
        security = {
                @SecurityRequirement(
                        name = "bearerAuth"
                )
        }
)
@SecurityScheme(
        name = "bearerAuth",
        description = "JWT auth description",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {
}
