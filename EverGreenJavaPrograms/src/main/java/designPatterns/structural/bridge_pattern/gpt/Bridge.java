package designPatterns.structural.bridge_pattern.gpt;

// best bridge design pattern https://www.digitalocean.com/community/tutorials/bridge-design-pattern-java
//The Abstraction class
abstract class Shape {
 protected DrawAPI drawAPI;

 protected Shape(DrawAPI drawAPI) {
     this.drawAPI = drawAPI;
 }

 public abstract void draw();
}

//The Implementor interface
interface DrawAPI {
 public void drawCircle(int radius, int x, int y);
}

//The Concrete Implementor class
class RedCircle implements DrawAPI {
 public void drawCircle(int radius, int x, int y) {
     System.out.println("Drawing Circle[ color: red, radius: " + radius + ", x: " + x + ", y: " + y + "]");
 }
}

class GreenCircle implements DrawAPI {
 public void drawCircle(int radius, int x, int y) {
     System.out.println("Drawing Circle[ color: green, radius: " + radius + ", x: " + x + ", y: " + y + "]");
 }
}

//The Refined Abstraction class
class Circle extends Shape {
 private int x, y, radius;

 public Circle(int x, int y, int radius, DrawAPI drawAPI) {
     super(drawAPI);
     this.x = x;
     this.y = y;
     this.radius = radius;
 }

 public void draw() {
     drawAPI.drawCircle(radius, x, y);
 }
}

//Example usage
public class Bridge {
 public static void main(String[] args) {
     Shape redCircle = new Circle(100, 100, 10, new RedCircle());
     Shape greenCircle = new Circle(100, 100, 20, new GreenCircle());

     redCircle.draw();
     greenCircle.draw();
 }
}
