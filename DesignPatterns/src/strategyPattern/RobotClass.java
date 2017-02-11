package strategyPattern;

public class RobotClass implements IBehaviour{
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
	
	@Override
	public String moveCommand(){
		return "In Abstract Class : "+behaviourInterfaceObj.moveCommand();
	}
}
