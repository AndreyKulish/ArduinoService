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

    public String writeDataArduino(String str) {
        String dataFromArduino = new String();
        synchronized (ArduinoReader.data) {
            try {
                serialPort.getSerialPort().writeBytes(str.getBytes());
                System.out.println("Yfgbcfkb");
                ArduinoReader.data.wait();
                dataFromArduino = ArduinoReader.data.toString();
                ArduinoReader.data.setLength(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dataFromArduino;
    }

    public boolean connectArduino(){
        return serialPort.reconnectArduino();
    }

    public boolean closeArduino() {
        try {
            return serialPort.getSerialPort().closePort();
        } catch (Exception e) {
            System.out.println("Port close :" + e.getMessage());
        }
        return false;
    }
}
