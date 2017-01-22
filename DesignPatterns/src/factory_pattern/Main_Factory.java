package factory_pattern;

public class Main_Factory {

	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();

	      //get an object of Circle and call its draw method.
	      Shape shape1 = shapeFactory.getShape("TRIANGLE");

	      //call draw method of Circle
	      shape1.draw();

	      //get an object of Rectangle and call its draw method.
	      Shape shape2 = shapeFactory.getShape("RECTANGLE");

	      //call draw method of Rectangle
	      shape2.draw();

	      //get an object of Square and call its draw method.
	      Shape shape3 = shapeFactory.getShape("SQUARE");

	      //call draw method of circle
	      shape3.draw();
	      
	      
	      // if you have many object of the same base type and you manipulate them mostly as abstract objects,
	      // then you need a factory. Your code should have a lot of code like the following, reconsider it.
	      if (shape3 instanceof Square)
	    		((Square)shape3).draw();
	      
	}

}
