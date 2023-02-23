package creational.abstract_factory_pattern.loan;

public class HomeLoan implements Loan {

	@Override
	public String getLoan() {
		return "Home Loan";
	}

}
