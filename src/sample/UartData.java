package sample;


public class UartData {
    private String command;

    public void createCommand(String command, int dataByte) {
        this.command = "%" + command + dataByte + "*";
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
                '}';
    }
}
