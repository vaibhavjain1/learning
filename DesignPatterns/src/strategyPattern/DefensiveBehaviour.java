package strategyPattern;

public class DefensiveBehaviour implements IBehaviour {

	@Override
	public String moveCommand() {
		System.out.println("In Defensive Class : Defensive Attack");
		return "Defensive Behaviour";
	}

}
