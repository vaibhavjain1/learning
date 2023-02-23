package designPatterns.creational.factory_pattern;

public class BankFactory {

	public Bank getBank(String bank) {
		if (bank == null) {
			return null;
		}
		if (bank.equalsIgnoreCase("AXIS")) {
			return new Axis();
		} else if (bank.equalsIgnoreCase("PNB")) {
			return new PNB();
		} else if (bank.equalsIgnoreCase("SBI")) {
			return new SBI();
		}
		return null;
	}
}
