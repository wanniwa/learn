package 容器;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Test1 {
    public static void main(String[] args) throws ParseException {
        Employee e = new Employee(193,"搞起3",3000,"项目部","2007-10");
        Employee e1 = new Employee(192,"搞起2",3000,"教学部","2007-10");
        Employee e2 = new Employee(191,"搞起1",3000,"骆驼","2019-10");
        List<Employee> list = new ArrayList<Employee>();
        list.add(e);
        list.add(e1);
        list.add(e2);
        printEmpName(list);
    }
    public static void printEmpName(List<Employee> list){
        for (Employee aList : list) {
            System.out.println(aList.getName());
        }
    }
}
