package ua.kiev.hitek.start.entity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "ARDUINO_DATA")
public class AduinoData {

    @Id
    @Column(name = "ID")
    private int ID;

    @Column(name = "ARDUINO_ID")
    private String ARDUINO_ID;

    @Column(name = "DATE")
    private Date DATE;

    @Column(name = "TEMPERATURE", length = 20)
    private String TEMPERATURE;

    public AduinoData(){
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getARDUINO_ID() {
        return ARDUINO_ID;
    }

    public void setARDUINO_ID(String ARDUINO_ID) {
        this.ARDUINO_ID = ARDUINO_ID;
    }

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
}
