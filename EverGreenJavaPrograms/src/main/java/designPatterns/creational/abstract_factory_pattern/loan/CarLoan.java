package designPatterns.creational.abstract_factory_pattern.loan;

public class CarLoan implements Loan {

	@Override
	public String getLoan() {
		return "Car Loan";
	}

}
