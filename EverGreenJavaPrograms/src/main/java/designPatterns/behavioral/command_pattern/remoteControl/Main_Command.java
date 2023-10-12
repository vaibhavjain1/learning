package designPatterns.behavioral.command_pattern.remoteControl;

public class Main_Command {

	public static void main(String[] args) {
		Light light = new Light();
		RemoteControl remote = new RemoteControl();
		Command on = new LightOn(light);
		Command off = new LightOff(light);
		remote.setCommand(on);
		remote.executeCommand();
		remote.setCommand(off);
		remote.executeCommand();
	}

}
