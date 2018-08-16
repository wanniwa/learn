package 容器;

import java.util.HashMap;

public class MyHashSet {
    HashMap map;
    private static final Object PRESENT = new Object();
    int size;
    public MyHashSet() {
        map = new HashMap();
    }

    public void add(Object object) {
        map.put(object, PRESENT);
        map.size();
    }

    public static void main(String[] args) {

    }
}
