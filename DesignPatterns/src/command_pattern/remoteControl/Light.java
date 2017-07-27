package command_pattern.remoteControl;

public class Light {

	// Light on and off functions can be implemented here
	// Also we can check if light is on or off.
	boolean isLightOn = false;
	
	public void makeLightOn(){
		if(!isLightOn){
			isLightOn = true;
			System.out.println("Light is on now");
		}
	}
	
	public void makeLightOff(){
		if(isLightOn){
			isLightOn = false;
			System.out.println("Light is off now");
		}
	}
}
