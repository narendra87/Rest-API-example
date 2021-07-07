package com.example.springrestapi.config;

import com.sun.xml.bind.v2.schemagen.xmlschema.Appinfo;
import io.swagger.models.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//Configuration
//Enable Swagger
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    //Bean -Docket
    //Swagger 2
    //All the paths
    //All the api's
public static final Contact DEFAULT_CONTACT = new Contact();
public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Api documentation",
        "Api Documentation","1.0","urn:tos","DEFAULT_CONTACT",
        "Apache 2.0","http://www.apache.org/licenses/LICENSES-2.0");

@Bean
    public Docket api(){
    return new Docket(DocumentationType.SWAGGER_2);
}

}
