package 容器;

public class MyHashMap1 {
    SxtEntry[] arr = new SxtEntry[990];
    int size;

    public void put(Object key, Object value) {
        for (int i = 0; i < size; i++) {
            if (arr[i].key.equals(key)) {
                arr[i].value =value;
                return;
            }
        }
        SxtEntry e = new SxtEntry(key, value);
        arr[size++] = e;
    }

    public Object get(Object key) {
        for (int i = 0; i < size; i++) {
            if (arr[i].key.equals(key)) {
                return arr[i].value;
            }
        }
        return null;
    }


    public boolean containKey(Object key){
        for (int i = 0; i < size; i++) {
            if (arr[i].key.equals(key)) {
                return true;
            }
        }
        return false;
    }
    public boolean containValue(Object value){
        for (int i = 0; i < size; i++) {
            if (arr[i].value.equals(value)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}

class SxtEntry {
    Object key;
    Object value;

    public SxtEntry(Object key, Object value) {
        super();
        this.key = key;
        this.value = value;
    }
}
