package sample;

import com.fazecast.jSerialComm.SerialPort;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.effect.Lighting;
import javafx.util.Callback;

import java.net.PortUnreachableException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {
    @FXML
    private CheckBox stReg10;
    @FXML
    private CheckBox stReg11;
    @FXML
    private CheckBox stReg12;
    @FXML
    private CheckBox stReg13;
    @FXML
    private CheckBox stReg14;
    @FXML
    private CheckBox stReg15;
    @FXML
    private CheckBox stReg16;
    @FXML
    private CheckBox stReg17;

    @FXML
    private CheckBox stReg20;
    @FXML
    private CheckBox stReg21;
    @FXML
    private CheckBox stReg22;
    @FXML
    private CheckBox stReg23;
    @FXML
    private CheckBox stReg24;
    @FXML
    private CheckBox stReg25;
    @FXML
    private CheckBox stReg26;
    @FXML
    private CheckBox stReg27;

    @FXML
    private CheckBox stReg30;
    @FXML
    private CheckBox stReg31;
    @FXML
    private CheckBox stReg32;
    @FXML
    private CheckBox stReg33;
    @FXML
    private CheckBox stReg34;
    @FXML
    private CheckBox stReg35;
    @FXML
    private CheckBox stReg36;
    @FXML
    private CheckBox stReg37;

    @FXML
    private CheckBox stReg40;
    @FXML
    private CheckBox stReg41;
    @FXML
    private CheckBox stReg42;
    @FXML
    private CheckBox stReg43;
    @FXML
    private CheckBox stReg44;
    @FXML
    private CheckBox stReg45;
    @FXML
    private CheckBox stReg46;
    @FXML
    private CheckBox stReg47;

    @FXML
    private CheckBox stReg50;
    @FXML
    private CheckBox stReg51;
    @FXML
    private CheckBox stReg52;
    @FXML
    private CheckBox stReg53;
    @FXML
    private CheckBox stReg54;
    @FXML
    private CheckBox stReg55;
    @FXML
    private CheckBox stReg56;
    @FXML
    private CheckBox stReg57;

    @FXML
    private CheckBox stReg60;
    @FXML
    private CheckBox stReg61;
    @FXML
    private CheckBox stReg62;
    @FXML
    private CheckBox stReg63;
    @FXML
    private CheckBox stReg64;
    @FXML
    private CheckBox stReg65;
    @FXML
    private CheckBox stReg66;
    @FXML
    private CheckBox stReg67;

    @FXML
    private CheckBox stReg70;
    @FXML
    private CheckBox stReg71;
    @FXML
    private CheckBox stReg72;
    @FXML
    private CheckBox stReg73;
    @FXML
    private CheckBox stReg74;
    @FXML
    private CheckBox stReg75;
    @FXML
    private CheckBox stReg76;
    @FXML
    private CheckBox stReg77;

    @FXML
    private CheckBox stReg80;
    @FXML
    private CheckBox stReg81;
    @FXML
    private CheckBox stReg82;
    @FXML
    private CheckBox stReg83;
    @FXML
    private CheckBox stReg84;
    @FXML
    private CheckBox stReg85;
    @FXML
    private CheckBox stReg86;
    @FXML
    private CheckBox stReg87;

    @FXML
    private CheckBox stReg90;
    @FXML
    private CheckBox stReg91;
    @FXML
    private CheckBox stReg92;
    @FXML
    private CheckBox stReg93;
    @FXML
    private CheckBox stReg94;
    @FXML
    private CheckBox stReg95;
    @FXML
    private CheckBox stReg96;
    @FXML
    private CheckBox stReg97;

    @FXML
    private Button regButton1;
    @FXML
    private Button regButton2;
    @FXML
    private Button regButton3;
    @FXML
    private Button regButton4;
    @FXML
    private Button regButton5;
    @FXML
    private Button regButton6;

    @FXML
    private ToggleButton connectButton;
    @FXML
    private ComboBox comboBox;
    @FXML
    private Button rescanButton;
    @FXML
    private ToggleButton onDcButton;

    private UartData uartData = new UartData();
    private Uart uart;

    @FXML
    public void initialize() {
        rescanButton.setOnAction(event -> scanAndConnectToDevice());
        onDcButton.setOnMouseEntered(event -> onDcButton.setEffect(new Lighting()));
        onDcButton.setOnMouseExited(event -> onDcButton.setEffect(null));
        EventHandler handler3 = event -> {
            ToggleButton toggleButton = (ToggleButton) event.getSource();
            int command = 0;
            if (toggleButton.isSelected()) {
                command = 0x46;
                toggleButton.setText("OFF_DCDC_RELAY");
            } else {
                command = 0x47;
                toggleButton.setText("ON_DCDC_RELAY");
            }
            uartData.createCommand(command + "0", 0x01 + "", 0);
            System.out.println(uartData);
            uart.send(uartData);
        };
        onDcButton.setOnAction(handler3);

        scanAndConnectToDevice();

        List<CheckBox> checkBoxList1 = new ArrayList<>(Arrays.asList(stReg10, stReg11, stReg12, stReg13, stReg14, stReg15, stReg16, stReg17));
        List<CheckBox> checkBoxList2 = new ArrayList<>(Arrays.asList(stReg20, stReg21, stReg22, stReg23, stReg24, stReg25, stReg26, stReg27));
        List<CheckBox> checkBoxList3 = new ArrayList<>(Arrays.asList(stReg30, stReg31, stReg32, stReg33, stReg34, stReg35, stReg36, stReg37));
        List<CheckBox> checkBoxList4 = new ArrayList<>(Arrays.asList(stReg40, stReg41, stReg42, stReg43, stReg44, stReg45, stReg46, stReg47));
        List<CheckBox> checkBoxList5 = new ArrayList<>(Arrays.asList(stReg50, stReg51, stReg52, stReg53, stReg54, stReg55, stReg56, stReg57));
        List<CheckBox> checkBoxList6 = new ArrayList<>(Arrays.asList(stReg60, stReg61, stReg62, stReg63, stReg64, stReg65, stReg66, stReg67));
        List<CheckBox> checkBoxList7 = new ArrayList<>(Arrays.asList(stReg70, stReg71, stReg72, stReg73, stReg74, stReg75, stReg76, stReg77));
        List<CheckBox> checkBoxList8 = new ArrayList<>(Arrays.asList(stReg80, stReg81, stReg82, stReg83, stReg84, stReg85, stReg86, stReg87));
        List<CheckBox> checkBoxList9 = new ArrayList<>(Arrays.asList(stReg90, stReg91, stReg92, stReg93, stReg94, stReg95, stReg96, stReg97));

        List<List<CheckBox>> checkBoxes = new ArrayList<>(Arrays.asList(checkBoxList1, checkBoxList2, checkBoxList3,
                checkBoxList4, checkBoxList5, checkBoxList6, checkBoxList7, checkBoxList8, checkBoxList9));

        EventHandler handler1 = event -> {
            Button button = (Button) event.getSource();
            int index = Integer.parseInt(String.valueOf(button.getId().charAt(button.getId().length() - 1)));
            int tempData = 0;
            for (CheckBox checkBox : checkBoxes.get(index - 1)) {
                int bit = 1 << Integer.parseInt(String.valueOf(checkBox.getId().charAt(checkBox.getId().length() - 1)));
                if (checkBox.isSelected()) {
                    tempData = tempData | bit;
                }
            }
            uartData.createCommand(0x3f + index + "0", 0x01 + "", tempData);
            System.out.println(uartData);
            uart.send(uartData);
        };
        EventHandler handler2 = event -> {
            Button button = (Button) event.getSource();
            int index = Integer.parseInt(String.valueOf(button.getId().charAt(button.getId().length() - 1)));
            int tempData = 0;
//            index++;
            if (index == 4) {
                index = 3;
            } else if (index == 6) {
                index = 7;
            }
            for (int i = 0; i < 2; i++) {
                for (CheckBox checkBox : checkBoxes.get(index + i)) {
                    int bit = 1 << Integer.parseInt(String.valueOf(checkBox.getId().charAt(checkBox.getId().length() - 1)));
                    if (checkBox.isSelected()) {
                        tempData = tempData | ((i == 0) ? bit : (bit << 8));
                    }
                }
            }
            if (index == 3) {
                index = 4;
            } else if (index == 7) {
                index = 6;
            }
            uartData.createCommand(0x3f + index + "0", 0x02 + "", tempData);
            System.out.println(uartData);
            uart.send(uartData);
        };
        regButton1.setOnAction(handler1);
        regButton2.setOnAction(handler1);
        regButton3.setOnAction(handler1);
        regButton4.setOnAction(handler2);
        regButton5.setOnAction(handler2);
        regButton6.setOnAction(handler2);
    }

    private void scanAndConnectToDevice() {
        uart = new Uart();
        comboBox.setItems(uart.getPortListString());
        comboBox.setOnAction(event -> System.out.println("combobox selected"));
        Callback cellFactory = new Callback<ListView<SerialPort>, ListCell<SerialPort>>() {
            @Override
            public ListCell<SerialPort> call(ListView<SerialPort> param) {
                return new ListCell<SerialPort>() {
                    @Override
                    protected void updateItem(SerialPort item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item == null || empty) {
                            setText(null);
                        } else {
                            setText(item.getDescriptivePortName());
                        }
                    }
                };
            }
        };
        comboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            SerialPort serialPort;
            serialPort = (SerialPort) newValue;
            uart.setPort(serialPort);
        });
        comboBox.setCellFactory(cellFactory);
        comboBox.setButtonCell((ListCell) cellFactory.call(null));
        connectButton.setOnAction(event -> {
            if (connectButton.isSelected()) {
                try {
                    uart.openPortDevice();
                    connectButton.setSelected(true);
                    connectButton.setText("disconnect");
                } catch (PortUnreachableException e) {
                    connectButton.setSelected(false);
                    connectButton.setText("connect");
                }
            } else {
                uart.getPort().closePort();
                connectButton.setText("connect");
                connectButton.setSelected(false);
                System.out.println("port was closed");
            }
        });
    }
}
