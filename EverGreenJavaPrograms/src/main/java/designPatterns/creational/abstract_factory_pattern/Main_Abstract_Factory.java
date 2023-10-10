package designPatterns.creational.abstract_factory_pattern;

import designPatterns.creational.abstract_factory_pattern.bank.Bank;
import designPatterns.creational.abstract_factory_pattern.loan.Loan;

public class Main_Abstract_Factory {

	public static void main(String[] args) {
		AbstractFactory bankFactory = AbstractFactoryCreator.getFactory("Bank");  
		Bank bank=bankFactory.getBank("ICICI");
		System.out.println(bank.getBankName());
		
		AbstractFactory loanFactory = AbstractFactoryCreator.getFactory("Loan");  
		Loan loan=loanFactory.getLoan("Home");
		System.out.println(loan.getLoan());
	}

}
