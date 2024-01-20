package designPatterns.structural.flyweight_pattern.gpt;

import java.util.HashMap;

//Flyweight interface
interface Shape {
    void draw();
}

//Concrete flyweight class
class Circle implements Shape {
 private String color;
 private int x;
 private int y;
 private int radius;

 public Circle(String color) {
     this.color = color;
 }

 public void setX(int x) {
     this.x = x;
 }

 public void setY(int y) {
     this.y = y;
 }

 public void setRadius(int radius) {
     this.radius = radius;
 }

 @Override
 public void draw() {
     System.out.println("Drawing a " + color + " circle at (" + x + ", " + y + "), radius " + radius);
 }
}

//Flyweight factory class
class ShapeFactory {
 private static final HashMap<String, Shape> circleMap = new HashMap<>();

 public static Shape getCircle(String color) {
     Circle circle = (Circle)circleMap.get(color);

     if (circle == null) {
         circle = new Circle(color);
         circleMap.put(color, circle);
         System.out.println("Creating a new " + color + " circle");
     } else {
         System.out.println("Reusing existing " + color + " circle");
     }

     return circle;
 }
}

//Client code
public class Flyweight {
    private static final String[] colors = {"Red", "Green", "Blue"};

    private static String getRandomColor() {
        return colors[(int) (Math.random() * colors.length)];
    }

    private static int getRandomX() {
        return (int) (Math.random() * 100);
    }

    private static int getRandomY() {
        return (int) (Math.random() * 100);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            Circle circle = (Circle) ShapeFactory.getCircle(getRandomColor());
            circle.setX(getRandomX());
            circle.setY(getRandomY());
            circle.setRadius(100);
            circle.draw();
        }
    }
}
