package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

// 1. Consumer - takes input return something
public class ConsumerFunctionalInterface {

    @FunctionalInterface
    interface myFunctionalInterface {
        void doWork();
    }
    void consumerNoArgument(){
        myFunctionalInterface obj = () -> System.out.println("Consumer: No input No return");
        obj.doWork();
    }

    @FunctionalInterface
    interface myFunctionalInterfaceSingleArg {
        void doWork(String arg);
    }
    void consumerSingleArgument(String param){
        myFunctionalInterfaceSingleArg obj = (arg) -> System.out.println("Consumer: Single argument with brackets " + arg);
        obj.doWork(param);

        //for one argument we can write without parenthesis as well like arg -> ;
        myFunctionalInterfaceSingleArg obj1 = arg -> System.out.println("Consumer: Single argument without brackets " + arg);
        obj1.doWork(param);
    }

    class Employee {
        String name;
        Employee(String name){
            this.name = name;
        }
    }
    List<Employee> employeeList = new ArrayList<>();
    void consumerPrintList(){
        employeeList.add(new Employee("A"));
        employeeList.add(new Employee("B"));
        employeeList.add(new Employee("C"));

        Consumer<Employee> cons = (l) -> System.out.println(l.name);
        employeeList.forEach(cons);
    }

    List<String> stringList = new ArrayList<>();
    void consumerPrintStringList(){
        stringList.add("String1");
        stringList.add("String2");
        stringList.add("String3");
        stringList.forEach(System.out::println);
    }

    public static void main(String[] args) {
        ConsumerFunctionalInterface obj = new ConsumerFunctionalInterface();
        obj.consumerNoArgument();
        obj.consumerSingleArgument("Passed Parameter");
        obj.consumerPrintList();
        obj.consumerPrintStringList();
    }
}