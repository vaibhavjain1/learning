package designPatterns.creational.abstract_factory_pattern;

import designPatterns.creational.abstract_factory_pattern.loan.Loan;
import designPatterns.creational.abstract_factory_pattern.bank.Bank;
import designPatterns.creational.abstract_factory_pattern.loan.CarLoan;
import designPatterns.creational.abstract_factory_pattern.loan.HomeLoan;
import designPatterns.creational.abstract_factory_pattern.loan.PersonalLoan;

public class LoanFactory extends AbstractFactory {

	@Override
	public Bank getBank(String bank) {
		return null;
	}

	@Override
	public Loan getLoan(String loan) {
		if (loan == null) {
			return null;
		}
		if (loan.equalsIgnoreCase("Home")) {
			return new HomeLoan();
		} else if (loan.equalsIgnoreCase("Car")) {
			return new CarLoan();
		} else if (loan.equalsIgnoreCase("Personal")) {
			return new PersonalLoan();
		}
		return null;
	}

}
