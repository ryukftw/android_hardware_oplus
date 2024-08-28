package android.bluetooth;

public class OplusBluetoothAdapter {

    private static OplusBluetoothAdapter sAdapter;
    
    public static OplusBluetoothAdapter getOplusBluetoothAdapter() {
        if (sAdapter == null) {
            sAdapter = new OplusBluetoothAdapter();
        }
        return sAdapter;
    }
}
