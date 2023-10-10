package designPatterns.creational.factory_pattern.gpt;

interface Product {
    void display();
}

class ConcreteProductA implements Product {
    public void display() {
        System.out.println("This is Concrete Product A");
    }
}

class ConcreteProductB implements Product {
    public void display() {
        System.out.println("This is Concrete Product B");
    }
}

class ProductFactory {
    public Product createProduct(String productType) {
        if (productType.equals("A")) {
            return new ConcreteProductA();
        } else if (productType.equals("B")) {
            return new ConcreteProductB();
        } else {
            throw new IllegalArgumentException("Invalid product type.");
        }
    }
}

public class Factory {
    public static void main(String[] args) {
        ProductFactory factory = new ProductFactory();
        Product productA = factory.createProduct("A");
        Product productB = factory.createProduct("B");
        
        productA.display();
        productB.display();
    }
}