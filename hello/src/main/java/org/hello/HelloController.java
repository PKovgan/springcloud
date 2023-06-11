package org.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private boolean enabled = true;

    @GetMapping("/hello/{name}")
    public String getHello(@PathVariable String name) {
        enabled = !enabled;
        if (! enabled) {
            throw new RuntimeException("Not enabled");
        }
        return "Hello " + name + "!";
    }
}