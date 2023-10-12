package designPatterns.behavioral.command_pattern.remoteControl;

public class LightOn implements Command {

	private Light light;

	public LightOn(Light light) {
		this.light = light;
	}
	
	@Override
	public void execute() {
		light.makeLightOn();
	}

}
