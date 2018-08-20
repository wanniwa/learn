package 容器.iterator;

import 容器.排序.Utils;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("bbb");
        list.add("ccc");
        list.add("aaa");

        Set set = new HashSet();
        set.add("aaa");
        set.add("bbb");
        set.add("ccc");

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            String s = (String) iterator.next();
            iterator.remove();
            System.out.println(s);
        }
        System.out.println(Arrays.toString(set.toArray()));

        Utils.sort(list);
        System.out.println(list);
    }
}
