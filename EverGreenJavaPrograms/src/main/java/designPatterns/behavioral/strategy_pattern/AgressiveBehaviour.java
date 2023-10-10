package strategy_pattern;

public class AgressiveBehaviour implements IBehaviour {

	@Override
	public String moveCommand() {
		System.out.println("In Agressive Class : Agressive Attack");
		return "Agressive Behaviour";
	}

}
