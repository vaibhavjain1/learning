package java8;

import java.util.Arrays;
import java.util.function.Supplier;

// 2. Supplier - Takes nothing but gives something
public class SupplierFunctionalInterface {

    void supplier(){
        Supplier<String[]> empName = () -> new String[]{"Emp1", "Emp2"};
        Arrays.asList(empName.get()).forEach((arg) -> System.out.println(arg));
    }

    public static void main(String[] args) {
        SupplierFunctionalInterface obj = new SupplierFunctionalInterface();
        obj.supplier();
    }
}
