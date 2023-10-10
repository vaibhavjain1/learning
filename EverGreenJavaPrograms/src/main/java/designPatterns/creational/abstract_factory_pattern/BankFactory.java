package designPatterns.creational.abstract_factory_pattern;

import designPatterns.creational.abstract_factory_pattern.bank.BOB;
import designPatterns.creational.abstract_factory_pattern.bank.Bank;
import designPatterns.creational.abstract_factory_pattern.bank.HDFC;
import designPatterns.creational.abstract_factory_pattern.loan.Loan;
import designPatterns.creational.abstract_factory_pattern.bank.ICICI;

public class BankFactory extends AbstractFactory {

	@Override
	public Bank getBank(String bank) {
		if (bank == null) {
			return null;
		}
		if (bank.equalsIgnoreCase("ICICI")) {
			return new ICICI();
		} else if (bank.equalsIgnoreCase("HDFC")) {
			return new HDFC();
		} else if (bank.equalsIgnoreCase("BOB")) {
			return new BOB();
		}
		return null;
	}

	@Override
	public Loan getLoan(String loan) {
		// TODO Auto-generated method stub
		return null;
	}

}
