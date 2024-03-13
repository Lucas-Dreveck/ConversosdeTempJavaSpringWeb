package com.conversorTemp.ConversosdeTemp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConversordeTempController {
    @GetMapping("/")
    public ModelAndView conversorTemp() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("conversorTemp");
        return modelAndView;
    }

    @PostMapping("/convert")
    public String convertTemperature(
            @RequestParam("tempValue") double tempValue,
            @RequestParam("operationRoot") String operationRoot,
            @RequestParam("operationResult") String operationResult,
            Model model) {

        double result = 0;
        
        if (operationRoot.equals("C")) {
            if (operationResult.equals("F")) {
                result = (tempValue * 9/5) + 32;
            } else if (operationResult.equals("K")) {
                result = tempValue + 273.15;
            }
        } else if (operationRoot.equals("F")) {
            if (operationResult.equals("C")) {
                result = (tempValue - 32) * 5/9;
            } else if (operationResult.equals("K")) {
                result = (tempValue - 32) * 5/9 + 273.15;
            }
        } else if (operationRoot.equals("K")) {
            if (operationResult.equals("C")) {
                result = tempValue - 273.15;
            } else if (operationResult.equals("F")) {
                result = (tempValue - 273.15) * 9/5 + 32;
            }
        }
        model.addAttribute("result", result);
        return "conversorTemp";
    }
}
