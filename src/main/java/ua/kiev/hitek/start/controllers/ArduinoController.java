package ua.kiev.hitek.start.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.kiev.hitek.start.arduino.Arduino;
import ua.kiev.hitek.start.entity.model.ArduinoDataFromModulsDTO;

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
        jsonObj = new JSONObject();
        boolean flag = arduino.closeArduino();
        jsonObj.put("isCLose", flag);
        arduino.closeArduino();
        return jsonObj.toString();
    }

    @GetMapping("/connect")
    public String connectArduino() {
        jsonObj = new JSONObject();
        boolean isStart = arduino.connectArduino();
        jsonObj.put("isStart", isStart);
        return jsonObj.toString();
    }

    @GetMapping("/test")
    public String testArduino() {
        try {
            return new ObjectMapper().writeValueAsString(new ArduinoDataFromModulsDTO());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "wtf when /test";
    }

    @GetMapping("/write")
    public String startArduino(@RequestParam String str) {
        try {
            jsonObj = new JSONObject();
            String dataFromArduino = arduino.writeDataArduino(str);
            jsonObj.put("dataFromArduino", dataFromArduino);
            return jsonObj.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "wtf when /write";
    }

    private void initNeededData() {
        applicationContext = new ClassPathXmlApplicationContext("AppConfig.xml");

        arduino = (Arduino) applicationContext.getBean("arduino");
    }
}