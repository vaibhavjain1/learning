package designPatterns.behavioral.chainOfResponsibility.atmDesign;

public class DispenseRs10Notes implements DispenseCurrency {
	private DispenseCurrency nextChain;
	@Override
	public void setNextChain(DispenseCurrency chain) {
		this.nextChain = chain;
	}

	@Override
	public void dispenseCurrency(int currency) {
		if(currency>10){
			int notes = currency/10;
			System.out.println("10 Rs Notes: "+notes);
			currency = currency - 10 * notes;
			if(currency!=0 && nextChain!=null)
				nextChain.dispenseCurrency(currency);
		}else{
			nextChain.dispenseCurrency(currency);
		}
	}

}
