package ua.kiev.hitek.start.entity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ARDUINO_INFO")
public class ArduinoInfo {

    @Id
    @Column(name = "ID")
    private int ID;

    @Column(name = "NAME", length = 100, nullable = false)
    private String NAME;

    @Column(name = "SERIAL_PORT", length = 100, nullable = false)
    private String SERIAL_PORT;

    @Column(name = "DESCRIPTION", length = 300)
    private String DESCRIPTION;

}
