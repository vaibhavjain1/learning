package designPatterns.behavioral.command_pattern.stockExample;

public class Main_Command {

	public static void main(String[] args) {
		
		Stock stock = new Stock();
		
		Broker broker = new Broker();
		
		BuyStock buystock = new BuyStock(stock);
		SellStock sellstock = new SellStock(stock);
		
		broker.takeCommand(buystock);
		broker.takeCommand(sellstock);
		
		broker.executeCommand();
	}

}
