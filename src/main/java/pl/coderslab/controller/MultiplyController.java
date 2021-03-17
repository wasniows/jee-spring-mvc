package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MultiplyController {

    @RequestMapping("/multiply")
    private String multiplyRequestParam(@RequestParam(defaultValue = "10")
                                                int size,
                                        HttpServletRequest request) {
        request.setAttribute("sizeX", size);
        request.setAttribute("sizeY", size);
        return "multiply";
    }

    @GetMapping("/multiply/{rows:\\d+}/{cols:\\d+}")
    public String getParams(@PathVariable Integer rows, @PathVariable Integer cols, Model model) {
        model.addAttribute("sizeX", rows);
        model.addAttribute("sizeY", cols);
        return "multiply";
    }
}
