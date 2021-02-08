package crackingCoding6thEdition.Ch_06_Math_and_Logic_Puzzles.Q6_10_Test_Strips;

public class Bottle {
	private boolean poisoned = false;
	private int id;
	
	public Bottle(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setAsPoisoned() {
		poisoned = true;
	}
	
	public boolean isPoisoned() {
		return poisoned;
	}
}
