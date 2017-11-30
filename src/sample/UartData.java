package sample;


import java.util.Arrays;

public class UartData {
    private byte[] dataArray;

    public UartData() {
        this.dataArray = new byte[7];
    }

    public byte[] getDataArray() {
        return dataArray;
    }

    public void setDataArray(byte[] dataArray) {
        this.dataArray = dataArray;
    }

    @Override
    public String toString() {
        return "UartData{" +
                "dataArray=" + Arrays.toString(dataArray) +
                '}';
    }
}
