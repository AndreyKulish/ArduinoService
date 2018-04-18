package ua.kiev.hitek.start.entity.model;

import java.util.Date;

public class ArduinoDataFromModulsDTO {

    private Date DATE;

    private String TEMPERATURE;

    private String LED_STATUS;

    public Date getDATE() {
        return DATE;
    }

    public void setDATE(Date DATE) {
        this.DATE = DATE;
    }

    public String getTEMPERATURE() {
        return TEMPERATURE;
    }

    public void setTEMPERATURE(String TEMPERATURE) {
        this.TEMPERATURE = TEMPERATURE;
    }

    public String getLED_STATUS() {
        return LED_STATUS;
    }

    public void setLED_STATUS(String LED_STATUS) {
        this.LED_STATUS = LED_STATUS;
    }
}
