package ua.kiev.hitek.start.controllers;

import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.kiev.hitek.start.arduino.Arduino;

@Controller
@RequestMapping(value = "/arduino")
@RestController
public class ArduinoController {
    private Arduino arduino;
    private ApplicationContext applicationContext;
    private JSONObject jsonObj;

    public ArduinoController() {
        initNeededData();
    }

    /*@GetMapping("/close")
    public ModelAndView index() {
        Map<String, String> model = new HashMap<>();
        model.put("name", "Alexey");
        return new ModelAndView("index", model);
    }*/

    @GetMapping("/stop")
    public String stopArduino() {
        boolean flag = arduino.closeArduino();
        jsonObj.put("isCLose", flag);
        arduino.closeArduino();
        return jsonObj.toString();
    }

    @GetMapping("/write")
    public String startArduino(@RequestParam String str) {
        String dataFromArduino = arduino.writeDataArduino(str);
        jsonObj.put("dataFromArduino", dataFromArduino);
        return jsonObj.toString();
    }

    private void initNeededData() {
        applicationContext = new ClassPathXmlApplicationContext("AppConfig.xml");

        arduino = (Arduino) applicationContext.getBean("arduino");
        jsonObj = new JSONObject();
    }
}