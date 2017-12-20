package sample;


import com.fazecast.jSerialComm.SerialPort;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.io.OutputStream;
import java.net.PortUnreachableException;

public class Uart {
    private final static int BAUD_RATE = 256000;
    private final static int NUMBER_DATA_BITS = 8;
    private final static int NUMBER_STOP_BITS = 1;
    private final static int NUMBER_PARITY_BITS = 0;
    public final static boolean DEBUG = true;

    private ObservableList<SerialPort> portListString = FXCollections.observableArrayList();
    private SerialPort port;

    public Uart() {
        for (SerialPort port : SerialPort.getCommPorts()) {
            portListString.add(port);
        }
        if (DEBUG) System.out.println("end of searching uart ports");
    }

    public void setPort(SerialPort port) {
        this.port = port;
    }

    public SerialPort getPort() {
        return port;
    }

    public void send(UartData uartData) {
        OutputStream outputStream = port.getOutputStream();
        String command = uartData.getCommand();
        try {
            port.writeBytes(command.getBytes(), command.length());
            port.writeBytes(uartData.getNumBytes().getBytes(), uartData.getNumBytes().length());
            outputStream.write(uartData.getData());
            if (Integer.parseInt(uartData.getNumBytes()) == 2) outputStream.write(uartData.getData() >> 8);
            port.writeBytes("*".getBytes(), 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println(command);
    }

    public void openPortDevice() throws PortUnreachableException {
        port.openPort();
        if (!port.isOpen()) throw new PortUnreachableException();
        port.setComPortParameters(BAUD_RATE, NUMBER_DATA_BITS, NUMBER_STOP_BITS, NUMBER_PARITY_BITS);
        if (DEBUG) System.out.println("port is opened: " + port.getDescriptivePortName());
    }

    public ObservableList<SerialPort> getPortListString() {
        return portListString;
    }
}
