package ua.kiev.hitek.start.arduino;


import jssc.SerialPort;

public class Arduino {
    private ArduinoSerialPort serialPort;

    public Arduino() {
    }

    public Arduino(ArduinoSerialPort serialPort) {
        this.serialPort = serialPort;
    }

    public void setSerialPort(ArduinoSerialPort serialPort) {
        this.serialPort = serialPort;
    }

    public void writeDataArduino(String str) {
        try {
            serialPort.getSerialPort().writeBytes(str.getBytes());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void closeArduino() throws Exception {
        serialPort.getSerialPort().closePort();
    }
}
