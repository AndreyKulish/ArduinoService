package ua.kiev.hitek.start.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.kiev.hitek.start.arduino.Arduino;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Controller
@RequestMapping(value = "/arduino")
public class ArduinoController {
    Arduino arduino;

    public ArduinoController(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("AppConfig.xml");
        arduino = (Arduino) applicationContext.getBean("arduino");
    }

    @GetMapping("/")
    public ModelAndView index() {
        Map<String, String> model = new HashMap<>();
        model.put("name", "Alexey");
        return new ModelAndView("index", model);
    }

    @GetMapping("/start")
    public ModelAndView startArduino(@RequestParam String str) throws  Exception{
        Map<String, String> model = new HashMap<>();

        arduino.writeDataArduino(str);

        model.put("name", str);
        return new ModelAndView("index", model);
    }
}