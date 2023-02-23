package designPatterns.creational.factory_pattern;

public class Main_Factory {

	public static void main(String[] args) {
		BankFactory bankFactory = new BankFactory();
		
		Bank bank1 = bankFactory.getBank("SBI");
		System.out.println(bank1.getBankName());
		
		Bank bank2 = bankFactory.getBank("AXIS");
		System.out.println(bank2.getBankName());
		
		Bank bank3 = bankFactory.getBank("PNB");
		System.out.println(bank3.getBankName());
		
	    // if you have many object of the same base type and you manipulate them mostly as abstract objects,
	    // then you need a factory. Your code should have a lot of code like the following, reconsider it.
	    if (bank3 instanceof SBI)
	    		((SBI)bank3).getBankName();		
	}
}
