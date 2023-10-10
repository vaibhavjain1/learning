package designPatterns.structural.facade_pattern.gpt;

//The Facade class
class Car {
 private Engine engine;
 private Transmission transmission;
 private Suspension suspension;

 public Car() {
     engine = new Engine();
     transmission = new Transmission();
     suspension = new Suspension();
 }

 public void start() {
     engine.start();
     transmission.shiftUp();
     suspension.adjust();
 }

 public void stop() {
     engine.stop();
     transmission.shiftDown();
     suspension.adjust();
 }
}

//The Subsystem classes
class Engine {
 public void start() {
     System.out.println("Engine started");
 }

 public void stop() {
     System.out.println("Engine stopped");
 }
}

class Transmission {
 public void shiftUp() {
     System.out.println("Shifted up");
 }

 public void shiftDown() {
     System.out.println("Shifted down");
 }
}

class Suspension {
 public void adjust() {
     System.out.println("Suspension adjusted");
 }
}

//Example usage
public class Facade {
 public static void main(String[] args) {
     Car car = new Car();
     car.start();
     System.out.println("Driving...");
     car.stop();
 }
}
