package ua.kiev.hitek.start.arduino;

import jssc.SerialPort;

public class ArduinoSerialPort {
    private SerialPort serialPort;
    private ArduinoReader arduinoReader;
    private int baudRate;
    private int dataBits;
    private int stopBits;
    private int parity;
    private String portName;

    public ArduinoSerialPort() {
    }

    // 9600, 8, 1, 0
    public ArduinoSerialPort(int baudRate, int dataBits, int stopBits, int parity, String portName, ArduinoReader arduinoReader) {
        this.baudRate = baudRate;
        this.dataBits = dataBits;
        this.stopBits = stopBits;
        this.parity = parity;
        this.portName = portName;
        this.arduinoReader = arduinoReader;
        initConnectionToArduino();
    }

    private void initConnectionToArduino() {
        try {
            serialPort = new SerialPort(portName);
            arduinoReader.setSerialPort(serialPort);

            if (!serialPort.openPort()) {
                throw new Exception("Port does not open!");
            }

            if (!serialPort.setParams(baudRate, dataBits, stopBits, parity)) {
                throw new Exception("Port params does not setted!");
            }

            serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN |
                    SerialPort.FLOWCONTROL_RTSCTS_OUT);

            serialPort.addEventListener(arduinoReader, SerialPort.MASK_RXCHAR);

            System.out.println("Arduino Started!!!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public SerialPort getSerialPort() {
        return serialPort;
    }
}
