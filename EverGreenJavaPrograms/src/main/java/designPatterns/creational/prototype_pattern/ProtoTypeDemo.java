package designPatterns.creational.prototype_pattern;

/*
    1. Use the Prototype pattern when creating objects is more expensive or complex than copying existing ones.
    2. If object creation involves significant resources, such as database or network calls, and you have a similar object available, cloning can be more efficient.
    3. Use the Prototype pattern when your system needs to support a variety of objects with slight variations.
    4. Instead of creating multiple classes for each variation, you can create prototypes and clone them with modifications.

 */

import java.util.*;

interface Shape{

    void draw();
    Shape clone();

    void setColor(String color);
    default void performHeavyDatabaseOperation() {
        System.out.println("Performing Heavy database operation");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // Do nothing
        }
    }
}

class Circle implements Shape{
    String color;

    Circle(String color, boolean isCloning){
        if(!isCloning) performHeavyDatabaseOperation();
        this.color = color;
    }

    @Override
    public Shape clone() {
        return new Circle(this.color, true);
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Circle of Color: " + color);
    }
}

class Square implements Shape{
    String color;

    Square(String color, boolean isCloning){
        if(!isCloning) performHeavyDatabaseOperation();
        this.color = color;
    }

    @Override
    public Shape clone() {
        return new Square(this.color, true);
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Square of Color: " + color);
    }
}


class PrototypeRegistry {
    private Map<String, Shape> prototypes = new HashMap<>();

    public PrototypeRegistry() {
        prototypes.put("Circle", new Circle("White", false));
        prototypes.put("Square", new Square("White", false));
    }

    public Shape getProtoType(String shape, String color){
        Shape ret =  prototypes.get(shape).clone();
        ret.setColor(color);
        return ret;
    }
}

public class ProtoTypeDemo {
    public static void main(String[] args) {
        PrototypeRegistry registry = new PrototypeRegistry();
        Shape shape = registry.getProtoType("Square", "Green");
        shape.draw();
    }
}
