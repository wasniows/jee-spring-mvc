package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WitajController {

    @GetMapping(value = "/hello/{firstName:[a-z]+}/{lastName:[a-z]+}")
    @ResponseBody
    public String getName(@PathVariable String firstName, @PathVariable String lastName){
        return String.format("Witaj %s %s",
                firstName,
                lastName
        );
    }
}
