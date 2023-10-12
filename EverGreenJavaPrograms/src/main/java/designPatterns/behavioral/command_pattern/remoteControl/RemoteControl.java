package designPatterns.behavioral.command_pattern.remoteControl;

public class RemoteControl{

	Command comm;
	public void setCommand(Command comm){
		this.comm = comm;
	}
	
	public void executeCommand(){
		comm.execute();
	}
}
