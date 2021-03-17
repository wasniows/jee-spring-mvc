package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.Random;

@Controller
public class RandomController {

    Random random = new Random();
    @RequestMapping("/showRandom")
    @ResponseBody
    public String random(){
        return "wylosowano " + random.nextInt(100);
    }
}
