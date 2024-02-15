package designPatterns.structural.bridge_pattern.gpt;
//https://www.baeldung.com/java-bridge-pattern

public class Bridge {
    public static void main(String[] args) {
        Shape shape = new Circle(new Red());
        System.out.println(shape.draw());

        Shape shape1 = new Rectangle(new Green());
        System.out.println(shape1.draw());
    }
}

abstract class Shape {
    protected Color color;

    abstract String draw();
}

class Circle extends Shape {

    public Circle(Color color) {
        super.color = color;
    }

    @Override
    public String draw() {
        return "Drawing Circle with color: " + color.fill();
    }
}

class Rectangle extends Shape {
    public Rectangle(Color color) {
        super.color = color;
    }

    @Override
    public String draw() {
        return "Drawing Rectangle with color: " + color.fill();
    }
}

interface Color {
    String fill();
}

class Red implements Color {
    @Override
    public String fill() {
        return "Filling red color";
    }
}

class Green implements Color {

    @Override
    public String fill() {
        return "Filling Green color";
    }
}