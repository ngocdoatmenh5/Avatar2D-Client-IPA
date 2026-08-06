package javax.microedition.rms;

import main.lib.RmsStore;

public final class RecordStore {
    private final RmsStore store;

    private RecordStore(RmsStore store) {
        this.store = store;
    }

    public static RecordStore openRecordStore(String recordStoreName, boolean createIfNecessary) {
        return new RecordStore(RmsStore.openRecordStore(recordStoreName, createIfNecessary));
    }

    public int getNumRecords() {
        return store.getNumRecords();
    }

    public void addRecord(byte[] data, int offset, int length) {
        store.addRecord(data, offset, length);
    }

    public void setRecord(int recordId, byte[] data, int offset, int length) {
        store.setRecord(recordId, data, offset, length);
    }

    public byte[] getRecord(int recordId) {
        return store.getRecord(recordId);
    }

    public void closeRecordStore() {
        store.closeRecordStore();
    }

    public int getSizeAvailable() {
        return store.getSizeAvailable();
    }

    public int getSize() {
        return store.getSize();
    }

    public static void deleteRecordStore(String recordStoreName) {
        RmsStore.deleteRecordStore(recordStoreName);
    }

    public static String[] listRecordStores() {
        return RmsStore.listRecordStores();
    }
}
