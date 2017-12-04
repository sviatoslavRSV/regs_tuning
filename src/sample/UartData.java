package sample;


public class UartData {
    private String command;
    private int data;
    private String numBytes;

    public void createCommand(String command,String numBytes, int dataByte) {
        this.command = "%" + command;
        this.numBytes = numBytes;
        this.data = dataByte;
    }

    public String getNumBytes() {
        return numBytes;
    }

    public void setNumBytes(String numBytes) {
        this.numBytes = numBytes;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    @Override
    public String toString() {
        return "UartData{" +
                "command='" + command + '\'' +
                ", data=" + data +
                ", numBytes=" + numBytes +
                '}';
    }
}
