package com.sandra.springbootswagger.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 */
@Configuration
@EnableSwagger2  // 开启swagger2
public class SwaggerConfig {

    @Bean
    public Docket docket1() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }

    @Bean
    public Docket docket2() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }

    @Bean
    public Docket docket3() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
    }


    /**
     * 配置swagger Docket bean实例
     *
     * @param environment
     * @return
     */
    @Bean
    public Docket docket(Environment environment) {

        // return new Docket(DocumentationType.SWAGGER_2);

        // 设置要显示的swagger环境
        Profiles profiles = Profiles.of("dev", "test");

        // 通过environment.acceptsProfiles(profiles)判断是否处在自己设定的环境中
        boolean flag = environment.acceptsProfiles(profiles);
        System.out.println(flag);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                // 配置API文档分组
                .groupName("sandra")
                .select()
                // RequestHandlerSelectors 配置要扫描的接口的方式
                // basePackage：指定要扫描的包
                .apis(RequestHandlerSelectors.basePackage("com.sandra.springbootswagger"))
                // paths()：过滤什么路径
                .paths(PathSelectors.ant("/sandra/**"))
                .build();
    }

    /**
     * 配置swagger信息
     *
     * @return
     */
    private ApiInfo apiInfo() {

        // 作者信息
        Contact contact = new Contact("sandra", "https://github.com/", "123@163.com");

        // 从源码中获知的
        return new ApiInfo(
                "sandra swagger API doc",
                "my description",
                "1.0",
                "https://github.com/",
                 contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                 new ArrayList<VendorExtension>());
    }
}
