package command_pattern.stockExample;

import java.util.ArrayList;
import java.util.List;

public class Broker {

	private List<Command> commands = new ArrayList<Command>();
	public void takeCommand(Command command){
		commands.add(command);
	}
	
	public void executeCommand(){
		for (Command comm : commands) {
			comm.execute();
		}
	}
	
}
