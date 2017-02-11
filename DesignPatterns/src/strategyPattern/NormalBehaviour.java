package strategyPattern;

public class NormalBehaviour implements IBehaviour {

	@Override
	public String moveCommand() {
		System.out.println("In Normal Class : No Action.Ignoranse");
		return "Normal Behaviour";
	}

}
