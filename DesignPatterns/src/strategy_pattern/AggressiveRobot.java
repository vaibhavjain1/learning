package strategy_pattern;

public class AggressiveRobot extends RobotClass {
	//Assign By default behavior for Aggressive Robot
	public AggressiveRobot() {
		super("Aggressive Robot");
		behaviourInterfaceObj = new AgressiveBehaviour();
	}

}
