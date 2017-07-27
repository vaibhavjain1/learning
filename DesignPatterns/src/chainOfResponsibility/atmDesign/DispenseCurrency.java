package chainOfResponsibility.atmDesign;

public interface DispenseCurrency {
	void setNextChain(DispenseCurrency chain);
	void dispenseCurrency(int currency);
}
