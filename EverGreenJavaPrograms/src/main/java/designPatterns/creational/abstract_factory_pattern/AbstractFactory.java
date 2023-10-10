package designPatterns.creational.abstract_factory_pattern;

import designPatterns.creational.abstract_factory_pattern.bank.Bank;
import designPatterns.creational.abstract_factory_pattern.loan.Loan;

public abstract class AbstractFactory {
	
	public abstract Bank getBank(String bank);
	public abstract Loan getLoan(String loan);
	
}