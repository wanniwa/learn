package 容器;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MyHashMap2 {
    LinkedList[] arr = new LinkedList[990];
    int size;

    @Override
    public boolean equals(Object o) {
       return true;
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(arr);
        result = 31 * result + size;
        return result;
    }

    public void put(Object key, Object value) {
        SxtEntry e = new SxtEntry(key, value);
        int a = key.hashCode() % arr.length;
        if (arr[a] == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(e);
            arr[a] = linkedList;
        } else {
            LinkedList list =arr[a];
            for (int i = 0; i < list.size(); i++) {
                SxtEntry sxtEntry = (SxtEntry) list.get(i);
                if (sxtEntry.key.equals(key)) {
                    sxtEntry.value = value;
                    return;
                }
            }
            arr[a].add(e);
        }
    }

    public Object get(Object key) {
        int a = key.hashCode() % arr.length;
        if (arr[a] != null) {
            LinkedList list =arr[a];
            for (int i = 0; i < list.size(); i++) {
                SxtEntry sxtEntry = (SxtEntry) list.get(i);
                if (sxtEntry.key.equals(key)) {
                    return sxtEntry.value;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        MyHashMap2 myHashMap2 = new MyHashMap2();
        myHashMap2.put("你好", 10);
        MyHashMap2 myHashMap1 = new MyHashMap2();
        myHashMap1.put("你好", 10);
        System.out.println(myHashMap1.equals(myHashMap2));
        Map map = new HashMap();
        Student student = new Student(12,"王宁");
        Student student1 = new Student(12,"王宁");
        map.put(myHashMap2,1 );
        map.put(myHashMap1,2 );
        System.out.println(map.get(myHashMap2));
    }
}
