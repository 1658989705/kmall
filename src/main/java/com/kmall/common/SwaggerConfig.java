/**
 * ITBooking系统平台<br/>
 * com.kmall.common<br/>
 * SwaggerConfig.java<br/>
 * 创建人:jok <br/>
 * 时间：2019年7月16日-上午9:03:28 <br/>
 * 2019ITBooking公司-版权所有<br/>
 */
package com.kmall.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.Api;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * SwaggerConfig<br/>
 * 创建人:jok<br/>
 * 时间：2019年7月16日-上午9:03:28 <br/>
 * @version 1.0.0<br/>
 * 
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.kmall.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("kmall商城的接口文档")
                .description("欢迎大家,kmall制作使用java语言的springBoot构建网站开发")
                .version("1.0")
                .build();
    }
}