package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@Controller
public class FormController {

    @RequestMapping(path ="/form", method = RequestMethod.GET)
    public String form(){
        return "form.jsp";
    }

    @RequestMapping(path = "/form", method = RequestMethod.POST)
    @ResponseBody
    private String getParam(HttpServletRequest request){
        String paramName = request.getParameter("paramName");
        String paramDate = request.getParameter("paramDate");
        return LocalDate.parse(paramDate) + " " + paramName;
    }


}
