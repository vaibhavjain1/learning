package designPatterns.structural.composite_pattern.gpt;

import java.util.ArrayList;
import java.util.List;

//Component interface
interface Employee {
 public void showDetails();
}

//Leaf class
class Developer implements Employee {
 private String name;
 private String position;

 public Developer(String name, String position) {
     this.name = name;
     this.position = position;
 }

 public void showDetails() {
     System.out.println(name + " - " + position);
 }
}

//Composite class
class Manager implements Employee {
 private String name;
 private String position;
 private List<Employee> employees;

 public Manager(String name, String position) {
     this.name = name;
     this.position = position;
     employees = new ArrayList<Employee>();
 }

 public void addEmployee(Employee employee) {
     employees.add(employee);
 }

 public void removeEmployee(Employee employee) {
     employees.remove(employee);
 }

 public void showDetails() {
     System.out.println(name + " - " + position);
     for (Employee employee : employees) {
         employee.showDetails();
     }
 }
}

//Client code
public class Composite {
 public static void main(String[] args) {
     Developer d1 = new Developer("John", "Java Developer");
     Developer d2 = new Developer("Mike", "Java Developer");

     Manager m1 = new Manager("Sarah", "IT Manager");
     m1.addEmployee(d1);
     m1.addEmployee(d2);

     Manager m2 = new Manager("David", "Development Manager");
     Developer d3 = new Developer("Lisa", "Java Developer");
     m2.addEmployee(d3);
     m2.addEmployee(m1);

     m2.showDetails();
 }
}
