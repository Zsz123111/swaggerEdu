package com.itbaizhan.swaggerdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static com.google.common.base.Predicates.not;
import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.RequestHandlerSelectors.withMethodAnnotation;

/**
 * swagger注解类
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket getDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(swaggerDemoApiInfo())//放你的下面的私有方法
                .select()//固定格式
                .apis(RequestHandlerSelectors.basePackage("com.itbaizhan.swaggerdemo.controller"))//配置扫描包
                .apis(not(withMethodAnnotation(NotIncludeSwagger.class)))//断言，配置自定义注解
                .paths(or(PathSelectors.regex("/people/.*"),PathSelectors.regex("/person/.*")))//定义了匹配路径才会生成文档
//                .paths(PathSelectors.any())//表示匹配任意路径,一般不用，默认都扫描
                .build();//固定格式
    }

    private ApiInfo swaggerDemoApiInfo(){
        return new ApiInfoBuilder()//应该看得懂。。。
                .contact(new Contact("张仕钊","http://localhost:8080/index.html","111@163.com"))
                .title("这里是大标题")
                .description("写你的描述就好")
                .version("1.0.0")
                .build();//固定格式
    }
}
