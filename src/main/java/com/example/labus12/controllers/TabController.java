package com.example.labus12.controllers;
import com.example.labus12.beans.Logic;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TabController {
    private final Logic logic=new Logic();


    @PostMapping("/tabulate")
    public String tabulate(@RequestParam double begin, @RequestParam double end, @RequestParam double step, Model model){
        logic.operation(begin,end,step);
        model.addAttribute("points",logic.getPoints());
        model.addAttribute("maxYNumber",logic.findMaxY());
        model.addAttribute("maxYIndex",logic.findMaxYIndex());
        model.addAttribute("maxNumber",logic.findMaxX());
        model.addAttribute("minYNumber",logic.findMinY());
        model.addAttribute("minYIndex",logic.findMinYIndex());
        model.addAttribute("minNumber",logic.findMinX());
        model.addAttribute("sum",logic.sum());
        model.addAttribute("average",logic.average());

        return "tabulate";
    }

}
