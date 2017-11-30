package sample;


import com.fazecast.jSerialComm.SerialPort;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Uart {
    private final static int BAUD_RATE = 256000;
    private final static int NUMBER_DATA_BITS = 8;
    private final static int NUMBER_STOP_BITS = 1;
    private final static int NUMBER_PARITY_BITS = 0;
    private final static String DEVICE_NAME = ".*CP210x.*";
    public final static boolean DEBUG = true;

    //    private OutputStream outputStream;
    private ObservableList<SerialPort> portListString = FXCollections.observableArrayList();
    private SerialPort port;

    public Uart() {
        for (SerialPort port : SerialPort.getCommPorts()) {
            portListString.add(port);
            /*if (port.getDescriptivePortName().matches(DEVICE_NAME)) {
                port.openPort();
                port.setComPortParameters(BAUD_RATE, NUMBER_DATA_BITS, NUMBER_STOP_BITS, NUMBER_PARITY_BITS);
                if (DEBUG) System.out.println("port is opened: " + port.getDescriptivePortName());
//                this.serialPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 100, 0);
                outputStream = port.getOutputStream();
                if (!port.isOpen())
                    throw new PortUnreachableException();
                this.port = port;
            }*/
        }
        if (DEBUG) System.out.println("end of searching uart ports");
    }

    public void send(UartData uartData) {
        String command = uartData.getCommand();
        port.writeBytes(command.getBytes(), command.length());
        System.out.println(command);
    }

    public ObservableList<SerialPort> getPortListString() {
        for (SerialPort port : SerialPort.getCommPorts()) {
            if (!portListString.contains(port)) portListString.add(port);
        }
        return portListString;
    }
}
