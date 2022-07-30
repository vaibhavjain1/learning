package creational.abstract_factory_pattern;

import creational.abstract_factory_pattern.bank.Bank;
import creational.abstract_factory_pattern.loan.CarLoan;
import creational.abstract_factory_pattern.loan.HomeLoan;
import creational.abstract_factory_pattern.loan.Loan;
import creational.abstract_factory_pattern.loan.PersonalLoan;

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
