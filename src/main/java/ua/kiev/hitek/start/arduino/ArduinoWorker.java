package ua.kiev.hitek.start.arduino;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import ua.kiev.hitek.start.entity.model.ArduinoDataFromModulsDTO;
import ua.kiev.hitek.start.entity.model.ArduinoInfoDTO;

public class ArduinoWorker {
    private String command;
    private JSONObject jsonObj;
    private ArduinoInfoDTO arduinoInfoDTO;

    public String parser(String command){
        switch (command){
            case "get" :
                break;
            default:
                break;
        }
        return "";
    }

    private String getInfoFromArduino(){
        arduinoInfoDTO = new ArduinoInfoDTO();

        return returnJsonArduinoInfo(arduinoInfoDTO);
    }

    private String returnJsonArduinoInfo(ArduinoInfoDTO arduinoInfoDTO){
        try {
            return new ObjectMapper().writeValueAsString(arduinoInfoDTO);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }
}
