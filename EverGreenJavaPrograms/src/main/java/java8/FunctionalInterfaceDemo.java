package java8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        Consumer<Integer> cons = (value) -> {
            System.out.println(value);
        };
        cons.accept(2);

        Predicate<Integer> pred = (val) -> {
            return false;
        };
        System.out.println(pred.test(23));

        Function<Integer, String> func = (val) -> {
            return "Function";
        };
        System.out.println(func.apply(23));

        Supplier<String> supplier = () -> {
            return "Supplier";
        };
        System.out.println(supplier.get());
    }
}
