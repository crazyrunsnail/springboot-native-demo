package com.github.crazyrunsnail.snd;

import com.github.crazyrunsnail.snd.model.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@MapperScan(basePackages = "com.github.crazyrunsnail.snd.mapper", sqlSessionFactoryRef = "sqlSessionFactory", sqlSessionTemplateRef = "sqlSessionTemplate")
public class SpringbootNativeDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootNativeDemoApplication.class, args);
	}

    @RestController
    public static class HelloController {
        @GetMapping("/")
        public String index() {
            return "Hello World";
        }
    }

}
