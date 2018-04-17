package ua.kiev.hitek.start.arduino;

import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;

public class ArduinoReader implements SerialPortEventListener {
    private String data;
    private SerialPort serialPort;

    public ArduinoReader(){
    }

    public void setSerialPort(SerialPort serialPort) {
        this.serialPort = serialPort;
    }

    @Override
    public void serialEvent(SerialPortEvent event) {
        if (event.isRXCHAR() && event.getEventValue() > 0) {
            try {
                Thread.sleep(1000);
                data = serialPort.readString(event.getEventValue());
                System.out.println("Arduino say => " + data);
            } catch (Exception ex) {
                System.out.println("Error in receiving string from COM-port: " + ex);
            }
        }
    }
}
