package proxy_pattern;

public class RealImage implements Image {

	String imageName;
	public RealImage(String Name){
		imageName = Name;
		loadFromDisk(Name);
	}
	
	public void loadFromDisk(String imageName){
		System.out.println("Loading "+imageName+" from disk");
	}
	
	@Override
	public void draw() {
		System.out.println("Drawing "+imageName);
	}

}
