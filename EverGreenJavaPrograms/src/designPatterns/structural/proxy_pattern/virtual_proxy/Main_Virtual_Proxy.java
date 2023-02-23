package structural.proxy_pattern.virtual_proxy;

public class Main_Virtual_Proxy {
	public static void main(String[] args) {
		Image img = new ImageProxy("MYImage.jpeg");
		// Image will be loaded from disk
		img.draw();
		// Image will not be loaded from disk
		img.draw();
	}
}
