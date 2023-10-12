package designPatterns.behavioral.chainOfResponsibility_pattern.atmDesign;

public interface DispenseCurrency {
	void setNextChain(DispenseCurrency chain);
	void dispenseCurrency(int currency);
}
