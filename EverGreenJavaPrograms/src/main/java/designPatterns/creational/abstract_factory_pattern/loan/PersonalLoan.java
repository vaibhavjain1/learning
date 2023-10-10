package designPatterns.creational.abstract_factory_pattern.loan;

public class PersonalLoan implements Loan {

	@Override
	public String getLoan() {
		return "Personal Loan";
	}

}
