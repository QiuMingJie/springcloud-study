package com.qiumingjie.springcloudswagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author QiuMingJie
 * @date 2020-03-31 20:22
 * @description
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                // api扫包
                .apis(RequestHandlerSelectors.basePackage("com.qiumingjie.springcloudswagger.controller")).paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("每特教育|蚂蚁课堂 微服务电商系统").description("每特教育|蚂蚁课堂 Java分布式&微服务培训")
                .termsOfServiceUrl("http://www.itmayiedu.com")
                // .contact(contact)
                .version("1.0").build();
    }

}
