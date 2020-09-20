package com.ax.demo.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket swaggerSpringMvcPlugin() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)).build();
    }


//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2).groupName("API名称描述").apiInfo(apiInfo()).select()
//                .apis(RequestHandlerSelectors.basePackage(CONTROLLER_PACKAGE)).paths(PathSelectors.any()).build();
//    }


//    @Bean
//    public Docket api(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .pathMapping("/")
//                .select()
//                .paths(PathSelectors.regex("/.*"))
//                .build();
//    }
//
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder().title("API名称描述")
//                .contact(new Contact("", "", "联系人邮箱地址"))
//                .termsOfServiceUrl("http://localhost:8080/api/swagger-ui.html")
//                .version("1.0").build();
//    }
}