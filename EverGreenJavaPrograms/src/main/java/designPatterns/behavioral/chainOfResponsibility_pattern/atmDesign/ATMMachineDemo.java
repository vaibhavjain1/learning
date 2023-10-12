package designPatterns.behavioral.chainOfResponsibility_pattern.atmDesign;

public class ATMMachineDemo {
	
	private DispenseCurrency currObj;
	public ATMMachineDemo() {
		// Setting chain. We can set this in different class
		currObj = new DispenseRs50Notes();
		DispenseRs10Notes obj10 = new DispenseRs10Notes();
		currObj.setNextChain(obj10);
	} 
	
	public static void main(String[] args) {
		int currency = 180;
		if(currency%10!=0){
			System.out.println("Please enter currency in multiple of 10");
		}else{
			ATMMachineDemo obj = new ATMMachineDemo();
			obj.currObj.dispenseCurrency(currency);
		}
	}

}