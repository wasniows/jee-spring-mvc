package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Controller
public class FreeTimeController {

    @GetMapping(value = "/freetime", produces = "text/plain; charset=UTF-8")
    @ResponseBody
    public String freeTime(){
        LocalDateTime now = LocalDateTime.now();
        if (isWeekend(now.toLocalDate())){
            return "Mam wolne";
        }else if (isWorkingHours(now.toLocalTime())){
            return "Pracuje, nie przeszkadzać !";
        }else {
            return "Po pracy";
        }
    }
    private boolean isWeekend(LocalDate date){
        return date.getDayOfWeek()== DayOfWeek.SATURDAY || date.getDayOfWeek()==DayOfWeek.SUNDAY;
    }
    private boolean isWorkingHours(LocalTime time){
        return time.isAfter(LocalTime.of(9,0)) && time.isBefore(LocalTime.of(17,0));
    }
}
