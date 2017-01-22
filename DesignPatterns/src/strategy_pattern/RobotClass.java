package strategy_pattern;

public class RobotClass {
	IBehaviour behaviourInterfaceObj;
	String robotType;
	
	public RobotClass(String robotType) {
		this.robotType = robotType;
	}
	
	public IBehaviour getBehaviourInterfaceObj() {
		return behaviourInterfaceObj;
	}

	public void setBehaviourInterfaceObj(IBehaviour behaviourInterfaceObj) {
		this.behaviourInterfaceObj = behaviourInterfaceObj;
	}

	public String getRobotType() {
		return robotType;
	}

	public void setRobotType(String robotType) {
		this.robotType = robotType;
	}
	
	public String move(){
		return "In Abstract Class : "+behaviourInterfaceObj.moveCommand();
	}
}
