package proxy_pattern;


public class ImageProxy implements Image{

	RealImage realImg;
	String imgName;
	public ImageProxy(String ImageName){
		this.imgName=ImageName;
	}
	
	@Override
	public void draw() {
		if(realImg==null){
			realImg = new RealImage(imgName);
		}
		System.out.println("Drawing from proxy");
		realImg.draw();
	}

}
