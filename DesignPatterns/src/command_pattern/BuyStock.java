package command_pattern;

public class BuyStock implements Command {

	Stock stock;

	public BuyStock(Stock stock) {
		this.stock = stock;
	}
	
	@Override
	public void execute() {
		stock.BuyStock();
	}

}
