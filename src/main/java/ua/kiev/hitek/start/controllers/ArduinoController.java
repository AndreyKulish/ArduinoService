package ua.kiev.hitek.start.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/arduino")
public class ArduinoController {

    @GetMapping("/")
    public ModelAndView index() {
        Map<String, String> model = new HashMap<>();
        model.put("name", "Alexey");
        return new ModelAndView("index", model);
    }

    @GetMapping("/start")
    public ModelAndView startArduino() {
        Map<String, String> model = new HashMap<>();
        model.put("name", "Alexey");
        return new ModelAndView("index", model);
    }
}