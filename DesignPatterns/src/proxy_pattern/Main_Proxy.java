package proxy_pattern;

public class Main_Proxy {
	public static void main(String[] args) {
		Image img = new ImageProxy("MYImage.jpeg");
		// Image will be loaded from disk
		img.draw();
		// Image will not be loaded from disk
		img.draw();
	}
}
