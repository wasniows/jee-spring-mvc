package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Controller
@SessionAttributes("loginStart")
public class SessionController {

    @GetMapping("/session")
    @ResponseBody
    public String checkAttribute(HttpSession session, Model model){
        Object start = session.getAttribute("loginStart");
        if (start == null){
            start = LocalDateTime.now();
            model.addAttribute("loginStart", start);
        }
        return start.toString();
    }
}