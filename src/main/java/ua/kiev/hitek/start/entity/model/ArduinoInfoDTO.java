package ua.kiev.hitek.start.entity.model;


public class ArduinoInfoDTO {

    private int ID;

    private String NAME;

    private String SERIAL_PORT;

    private String DESCRIPTION;

    private ArduinoDataFromModulsDTO arduinoDataFromModulsDTO;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getSERIAL_PORT() {
        return SERIAL_PORT;
    }

    public void setSERIAL_PORT(String SERIAL_PORT) {
        this.SERIAL_PORT = SERIAL_PORT;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public ArduinoDataFromModulsDTO getArduinoDataFromModulsDTO() {
        return arduinoDataFromModulsDTO;
    }

    public void setArduinoDataFromModulsDTO(ArduinoDataFromModulsDTO arduinoDataFromModulsDTO) {
        this.arduinoDataFromModulsDTO = arduinoDataFromModulsDTO;
    }
}
