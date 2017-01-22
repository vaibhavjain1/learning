package strategy_pattern;

public class Main_Robot {
	public static void main(String[] args) {
		System.out.println("Example 1");
		//Either You can create a new class and call object as we did for Aggressive Robot
		RobotClass aggressiverobot = new AggressiveRobot();
		System.out.println(aggressiverobot.getRobotType());
		System.out.println(aggressiverobot.move());
		
		System.out.println("\nExample 2");
		//Or you can dynamically set the class and behavior using getter and setter as we did for Defensive Robot
		RobotClass genericRobotObj = new RobotClass("Defensive Robot");
		genericRobotObj.setBehaviourInterfaceObj(new DefensiveBehaviour());
		System.out.println(genericRobotObj.getRobotType());
		System.out.println(genericRobotObj.move());
	}
}
