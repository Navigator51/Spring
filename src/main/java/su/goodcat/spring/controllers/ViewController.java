package su.goodcat.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/registry")
    public String getRegistryPage() {
        return "registry";
    }
}
