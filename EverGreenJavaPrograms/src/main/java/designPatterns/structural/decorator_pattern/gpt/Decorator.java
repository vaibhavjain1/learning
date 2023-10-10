package designPatterns.structural.decorator_pattern.gpt;

//The Component interface
interface Pizza {
 public String getDescription();
 public double getCost();
}

//The Concrete Component implementation
class PlainPizza implements Pizza {
 public String getDescription() {
     return "Thin crust pizza";
 }

 public double getCost() {
     return 4.00;
 }
}

//The Decorator abstract class
abstract class ToppingDecorator implements Pizza {
 protected Pizza pizza;

 public ToppingDecorator(Pizza pizza) {
     this.pizza = pizza;
 }

 public String getDescription() {
     return pizza.getDescription();
 }

 public double getCost() {
     return pizza.getCost();
 }
}

//The Concrete Decorator implementations
class Cheese extends ToppingDecorator {
 public Cheese(Pizza pizza) {
     super(pizza);
 }

 public String getDescription() {
     return pizza.getDescription() + ", cheese";
 }

 public double getCost() {
     return pizza.getCost() + 1.00;
 }
}

class Pepperoni extends ToppingDecorator {
 public Pepperoni(Pizza pizza) {
     super(pizza);
 }

 public String getDescription() {
     return pizza.getDescription() + ", pepperoni";
 }

 public double getCost() {
     return pizza.getCost() + 1.50;
 }
}

//Example usage
public class Decorator {
 public static void main(String[] args) {
     Pizza pizza = new PlainPizza();
     System.out.println("Description: " + pizza.getDescription());
     System.out.println("Cost: $" + pizza.getCost());

     pizza = new Cheese(pizza);
     System.out.println("Description: " + pizza.getDescription());
     System.out.println("Cost: $" + pizza.getCost());

     pizza = new Pepperoni(pizza);
     System.out.println("Description: " + pizza.getDescription());
     System.out.println("Cost: $" + pizza.getCost());
 }
}
