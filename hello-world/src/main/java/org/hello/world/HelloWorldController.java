package org.hello.world;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloWorldController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HelloClient helloClient;

    @GetMapping("/hello-world/rest")
    @HystrixCommand(fallbackMethod = "fallback")
    public String getHelloRest() {
        return restTemplate.getForObject("http://Hello/hello/RestTemplate", String.class);
    }

    @GetMapping("/hello-world/feign")
    @HystrixCommand(fallbackMethod = "fallback")
    public String getHelloFeign() {
        return helloClient.getHello("FeignClient");
    }

    private String fallback() {
        return "Goodbye my love, goodbye!";
    }
}
