package InMemoryDB;

import java.util.HashMap;
import java.util.Map;

class Record {
    private Map<String, Object> data;

    public Record(Map<String, Object> data) {
        this.data = new HashMap<>(data);
    }

    public Map<String, Object> getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Record{" + "data=" + data + '}';
    }
}
