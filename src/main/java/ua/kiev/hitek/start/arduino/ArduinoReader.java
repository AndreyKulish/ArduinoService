package ua.kiev.hitek.start.arduino;

import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;

public class ArduinoReader implements SerialPortEventListener {
    public static volatile StringBuilder data = new StringBuilder();
    private SerialPort serialPort;

    public ArduinoReader(){
    }

    public void setSerialPort(SerialPort serialPort) {
        this.serialPort = serialPort;
    }

    @Override
    public void serialEvent(SerialPortEvent event) {
        synchronized (ArduinoReader.data) {
            if (event.isRXCHAR() && event.getEventValue() > 0) {
                try {
                    Thread.sleep(1000);
                    data.append(serialPort.readString(event.getEventValue()));
                    //System.out.println("Arduino say => " + data);
                    data.notify();
                } catch (Exception ex) {
                    System.out.println("Error in receiving string from COM-port: " + ex);
                }
            }
        }
    }
}
