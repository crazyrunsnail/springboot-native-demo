package com.github.crazyrunsnail.snd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
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
