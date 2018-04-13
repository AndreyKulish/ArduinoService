package ua.kiev.hitek.start.arduino;


import jssc.SerialPort;

public class Arduino {
    private String portName;
    private SerialPort serialPort;
    private ArduinoReader arduinoReader;
    private String oldData;

    public Arduino() {
    }

    public String getPortName() {
        return portName;
    }

    public void startArduino(String portName) {
        try {
            if (portName.equals("")) {
                throw new Exception("Port name can't be empty!");
            }

            this.portName = portName;
            serialPort = new SerialPort(portName);
            arduinoReader = new ArduinoReader(serialPort);

            if (!serialPort.openPort()) {
                throw new Exception("Port does not open!");
            }

            boolean isParamsSet = serialPort.setParams(9600, 8, 1, 0);

            if (!isParamsSet) {
                throw new Exception("Port params does not setted!");
            }

            serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN |
                    SerialPort.FLOWCONTROL_RTSCTS_OUT);
            serialPort.addEventListener(arduinoReader, SerialPort.MASK_RXCHAR);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeDataArduino(String str) throws Exception {
        serialPort.writeBytes(str.getBytes());
    }

    public void closeArduino() throws Exception {
        serialPort.closePort();
    }
}
