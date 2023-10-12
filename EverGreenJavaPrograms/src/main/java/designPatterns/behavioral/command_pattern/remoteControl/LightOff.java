package designPatterns.behavioral.command_pattern.remoteControl;

public class LightOff implements Command {

	private Light light;

	public LightOff(Light light) {
		this.light = light;
	}
	
	@Override
	public void execute() {
		light.makeLightOff();
	}

}
