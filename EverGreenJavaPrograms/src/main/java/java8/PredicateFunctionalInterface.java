package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//3. Predicate functional interface take an argument and returns boolean
//Mostly used in filter
public class PredicateFunctionalInterface {

    class Employee {
        String name;
        Employee(String name){
            this.name = name;
        }
    }
    List<Employee> employeeList = new ArrayList<>();

    void predicate(){
        employeeList.add(new Employee("Abhinav"));
        employeeList.add(new Employee("Vaibhav"));
        employeeList.add(new Employee("Ashish"));
        Predicate<Employee> obj = (emp) -> {
            if (emp.name.startsWith("A"))
                return true;
            else
                return false;
        };
        employeeList.stream().filter(obj).forEach((a) -> System.out.println(a.name));
    }

    public static void main(String[] args) {
        PredicateFunctionalInterface obj = new PredicateFunctionalInterface();
        obj.predicate();
    }
}
