package command_pattern;

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
