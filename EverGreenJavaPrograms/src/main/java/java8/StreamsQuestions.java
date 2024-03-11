package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsQuestions {

    List<Employee> employeeList = new ArrayList<>();

    class Employee {
        String name;

        int age;

        int salary;

        String gender;
        Employee(String name){
            this.name = name;
        }

        String getName(){
            return name;
        }

        int getAge(){
            return age;
        }

        int getSalary(){
            return salary;
        }

        String getGender(){
            return gender;
        }
    }

    StreamsQuestions(){
        employeeList.add(new Employee("Abhinav"));
        employeeList.add(new Employee("Vaibhav"));
        employeeList.add(new Employee("Ashish"));
    }

    //Find employees name starting with alphabet A using stream API
    void employeeNameStartingwithA(){
        employeeList.stream().filter(emp -> emp.name.startsWith("A")).forEach(emp -> System.out.println(emp.name));

        // if we want to store in a list
        List<Employee> newList = employeeList.stream().filter(emp -> emp.name.startsWith("A")).collect(Collectors.toList());
    }

    //Merge two Employee ArrayList and sort by age in using java8 stream API
    void mergeListsAndSortByAge(){
        List<Employee> list1 = new ArrayList<>(); // Your first list
        List<Employee> list2 = new ArrayList<>(); // Your second list

        List<Employee> mergedAndSorted = Stream.concat(list1.stream(), list2.stream())
                .sorted(Comparator.comparingInt(Employee::getAge))
                .collect(Collectors.toList());
    }

    //Find even numbers from ArrayList and find the sum of all numbers using Java 8 stream API
    void evenNumberSum(){
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        int sum = integerList.stream()
                .filter((in) -> in%2==0)
                        .mapToInt(Integer::intValue)
                                .sum();
        System.out.println(sum);
    }

    //Sort employee byname and salary
    void sortBynameAndSalary(){
        List<Employee> sortedEmployees = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary))
                .collect(Collectors.toList());
    }

    //Sort Employee based on gender and age is above 30
    void sortbyGenderAgeabove30(){
        List<Employee> sortedEmployees = employeeList.stream()
                .filter(e -> e.getAge() > 30)
                .sorted(Comparator.comparing(Employee::getGender))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        StreamsQuestions obj = new StreamsQuestions();
        obj.evenNumberSum();
    }
}
