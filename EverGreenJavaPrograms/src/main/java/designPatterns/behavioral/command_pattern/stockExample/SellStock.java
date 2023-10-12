package designPatterns.behavioral.command_pattern.stockExample;

public class SellStock implements Command {

	Stock stock;

	public SellStock(Stock stock) {
		this.stock = stock;
	}
	
	@Override
	public void execute() {
		stock.SellStock();
	}

}
