package org.hello.world;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("Hello")
public interface HelloClient {

    @GetMapping("/hello/{name}")
    String getHello(@PathVariable("name") String name);
}
