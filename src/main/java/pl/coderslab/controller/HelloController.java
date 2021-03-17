package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalTime;

@Controller
public class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/helloview")
    public String helloView(HttpServletRequest request){

        LocalTime time = LocalTime.now();
        String background = "black";
        String color = "white";
        if (time.isAfter(LocalTime.of(8,00))&&time.isBefore(LocalTime.of(22,00))){
            background = "white";
            color = "black";
        }
        request.setAttribute("background", background);
        request.setAttribute("color", color);
        return "home";
    }
}
