package ua.kiev.hitek.start.arduino;

import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;

public class ArduinoReader implements SerialPortEventListener {
    public static volatile StringBuilder data = new StringBuilder();
    private SerialPort serialPort;

    public ArduinoReader() {
    }

    public void setSerialPort(SerialPort serialPort) {
        this.serialPort = serialPort;
    }

    @Override
    public void serialEvent(SerialPortEvent event) {
        synchronized (ArduinoReader.data) {
            if (event.isRXCHAR() && event.getEventValue() > 0) {
                try {
                    String dataArd = serialPort.readString(event.getEventValue());
                    writThinker(dataArd);
                } catch (Exception ex) {
                    System.out.println("Error in receiving string from COM-port: " + ex);
                }
            }
        }
    }

    private void writThinker(String dataToThink) {
        if (dataToThink.startsWith("d1")) {
            data.append(dataToThink);
            data.notify();
        } else if (dataToThink.startsWith("d2")){
            System.out.println("This data write arduino alone for insert into database " + dataToThink);
            data.append("escape");
            data.notify();
            data.setLength(0);
        }
    }
}
