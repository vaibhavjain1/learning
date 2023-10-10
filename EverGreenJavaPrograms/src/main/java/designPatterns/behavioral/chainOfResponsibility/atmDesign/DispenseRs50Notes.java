package designPatterns.behavioral.chainOfResponsibility.atmDesign;

public class DispenseRs50Notes implements DispenseCurrency {
	private DispenseCurrency nextChain;
	@Override
	public void setNextChain(DispenseCurrency chain) {
		this.nextChain = chain;
	}

	@Override
	public void dispenseCurrency(int currency) {
		if(currency>50){
			int notes = currency/50;
			System.out.println("50 Rs Notes: "+notes);
			currency = currency - 50 * notes;
			if(currency!=0 && nextChain!=null)
				nextChain.dispenseCurrency(currency);
		}else{
			nextChain.dispenseCurrency(currency);
		}
	}

}
