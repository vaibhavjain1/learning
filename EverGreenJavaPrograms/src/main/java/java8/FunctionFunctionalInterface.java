package java8;

import java.util.ArrayList;
import java.util.List;

public class FunctionFunctionalInterface {

    class Employee{
        String name;
        Employee(String name){
            this.name = name;
        }
    }

    List<Employee> employeeList = new ArrayList<>();

    List<String> stringList = new ArrayList<>();

    // Function to return just first letter of strings in a string list
    void function(){
            stringList.add("abc");
            stringList.add("def");
            stringList.add("ghi");

            stringList.stream().map((str) -> str.charAt(0)).forEach(System.out::println);
    }

    public static void main(String[] args) {
        FunctionFunctionalInterface obj = new FunctionFunctionalInterface();
        obj.function();
    }
}
