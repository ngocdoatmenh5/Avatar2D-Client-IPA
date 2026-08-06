package javax.microedition.rms;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class RecordStore {
    private static final Map<String, RecordStore> stores = new HashMap<String, RecordStore>();
    private String name;
    private final List<byte[]> records = new ArrayList<byte[]>();
    private boolean open = true;

    private RecordStore(String name) {
        this.name = name;
        records.add(null); // 1-based index
    }

    public static RecordStore openRecordStore(String recordStoreName, boolean createIfNecessary) throws RecordStoreException {
        synchronized (stores) {
            RecordStore rs = stores.get(recordStoreName);
            if (rs == null) {
                if (createIfNecessary) {
                    rs = new RecordStore(recordStoreName);
                    stores.put(recordStoreName, rs);
                } else {
                    throw new RecordStoreNotFoundException(recordStoreName);
                }
            }
            rs.open = true;
            return rs;
        }
    }

    public static void deleteRecordStore(String recordStoreName) throws RecordStoreException {
        synchronized (stores) {
            if (!stores.containsKey(recordStoreName)) {
                throw new RecordStoreNotFoundException(recordStoreName);
            }
            stores.remove(recordStoreName);
        }
    }

    public static String[] listRecordStores() {
        synchronized (stores) {
            if (stores.isEmpty()) return null;
            return stores.keySet().toArray(new String[0]);
        }
    }

    public void closeRecordStore() throws RecordStoreException {
        open = false;
    }

    public String getName() throws RecordStoreException {
        return name;
    }

    public int getNumRecords() throws RecordStoreException {
        return records.size() - 1;
    }

    public int getSize() throws RecordStoreException {
        int total = 0;
        for (byte[] r : records) {
            if (r != null) total += r.length;
        }
        return total;
    }

    public int getSizeAvailable() throws RecordStoreException {
        return 1024 * 1024;
    }


    public int addRecord(byte[] data, int offset, int numBytes) throws RecordStoreException {
        byte[] rec = new byte[numBytes];
        if (numBytes > 0 && data != null) {
            System.arraycopy(data, offset, rec, 0, numBytes);
        }
        records.add(rec);
        return records.size() - 1;
    }

    public void setRecord(int recordId, byte[] newData, int offset, int numBytes) throws RecordStoreException {
        if (recordId < 1 || recordId >= records.size()) throw new RecordStoreException("Invalid recordId: " + recordId);
        byte[] rec = new byte[numBytes];
        if (numBytes > 0 && newData != null) {
            System.arraycopy(newData, offset, rec, 0, numBytes);
        }
        records.set(recordId, rec);
    }

    public byte[] getRecord(int recordId) throws RecordStoreException {
        if (recordId < 1 || recordId >= records.size()) throw new RecordStoreException("Invalid recordId: " + recordId);
        return records.get(recordId);
    }

    public int getRecord(int recordId, byte[] buffer, int offset) throws RecordStoreException {
        byte[] data = getRecord(recordId);
        if (data != null && buffer != null) {
            System.arraycopy(data, 0, buffer, offset, data.length);
            return data.length;
        }
        return 0;
    }

    public int getRecordSize(int recordId) throws RecordStoreException {
        byte[] data = getRecord(recordId);
        return data != null ? data.length : 0;
    }

    public void deleteRecord(int recordId) throws RecordStoreException {
        if (recordId < 1 || recordId >= records.size()) throw new RecordStoreException("Invalid recordId: " + recordId);
        records.set(recordId, null);
    }
}
