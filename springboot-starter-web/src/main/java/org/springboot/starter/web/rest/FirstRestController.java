package org.springboot.starter.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */

@RestController
public class FirstRestController {

    @Autowired
    private WelcomeService welcomeService;

    @GetMapping
    public String hello(){
        return "hello RestController..";
    }

    @GetMapping("/welcome")
    public String welcomeMapping(){
        return welcomeService.getMessage();
    }




}

/**
 * If this is moved to some other package.
 * @ComponentScan to be added with the package details in SpringBootApplication.
 *
 */
@Component
class WelcomeService{

    public String getMessage(){
        return "Message message from Service, Is it refreshing....";
    }
}
