package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;

/**
 * @author wanniwa
 * @date 2018/7/30 16:27
 */
public class MyArrayList {
    /**
     * The value is used for character storage.
     */
    Object[] value;

    /**
     * The count is the number of characters used.
     */
    int size;

    public MyArrayList()  {
       this(10);
    }

    public MyArrayList(int size) {
        if (size<0) {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    size);
        }
        value = new Object[size];
    }

    public void add(Object obj) {
        value[size] = obj;
        size++;
        if (size >= value.length) {
            //装不下扩容
            int newCapacity = value.length * 2;
           Object[] newList= new Object[newCapacity];
           //System.arraycopy();
            for (int i = 0; i < value.length; i++) {
                newList[i] = value[i];
            }
           value = newList;
        }
    }

    public Object get(int index) {
        rangeCheck(index);
        return value[index];
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int indexOf(Object obj){
        if(obj==null){
            for (int i = 0 ;i<size;i++){
                if (value[i]==null) {
                     return i;
                }
            }
        }else {
            for (int i = 0; i < size; i++) {
                if (obj.equals(value[i])) {
                     return i;
                }
            }
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size-1; i >= 0; i--)
                if (value[i]==null)
                    return i;
        } else {
            for (int i = size-1; i >= 0; i--)
                if (o.equals(value[i]))
                    return i;
        }
        return -1;
    }

    public Object[] toArray(){
        return  Arrays.copyOf(value,size);
    }

    private void rangeCheck(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }
    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }
    public Object set(int index,Object obj) {
        rangeCheck(index);
        Object old = value[index];
        value[index] = obj;
        return old;
    }

    public static void main(String[] args) throws Exception {
        MyArrayList list = new MyArrayList(2);
        list.add("1");
        list.add(null);
        list.add("3");
        list.add("4");
        list.add("2");
        list.add("6");

        System.out.println(Arrays.toString(list.toArray()));
    }

}
