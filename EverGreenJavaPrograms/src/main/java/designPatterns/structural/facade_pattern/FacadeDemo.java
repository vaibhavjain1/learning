package designPatterns.structural.facade_pattern;

class GetFruits{
	static void getFruits() {
		System.out.println("Getting Fresh Fruits");
	}
}

class MakeJuice{
	static void makeJuice() {
		System.out.println("Making Juice from fruits");
	}
}

class Garnishing{
	static void addGarnishing() {
		System.out.println("Adding Garnishing over juice");
	}
}

class FacadeGetJuice {
	static void getFreshJuice() {
		GetFruits.getFruits();
		MakeJuice.makeJuice();
		Garnishing.addGarnishing();
	}
}

public class FacadeDemo {

	public static void main(String[] args) {
		FacadeGetJuice.getFreshJuice();
	}
}
