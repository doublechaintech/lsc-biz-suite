package com.terapico.uccaf;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchAutoConfiguration;
import org.springframework.boot.autoconfigure.elasticsearch.rest.RestClientAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.quartz.QuartzAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
		ElasticsearchAutoConfiguration.class, 
		RestClientAutoConfiguration.class,
		QuartzAutoConfiguration.class
})
//Spring boot will try to autoconfigure elasticsearch which will internally use elastic 6 RestHighLevelClient(org.elasticsearch.client.RestClientBuilder builder) to create the elastic client. If you want to connect to an older version of elasticsearch please exclude elasticsearch autoconfiguration.

//@EnableAutoConfiguration(exclude={ElasticsearchAutoConfiguration.class, RestClientAutoConfiguration.class})
public class SpringBootStarter {
    @Bean
    public ServletRegistrationBean<UCInvocationServlet> servletRegistrationBean() {
        return new ServletRegistrationBean<UCInvocationServlet>(new UCInvocationServlet(), "/secUserManager/*");
        // ServletName默认值为首字母小写，即myServlet
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStarter.class, args);
    }
}

