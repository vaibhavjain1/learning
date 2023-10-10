package designPatterns.structural.adapter_pattern;

class MediaPlayer {
	
	static void playMp3(String mp3File) {
		System.out.println("Playing Mp3");
	}
}

class VlcPlayer {
	static void playMp4(String mp4File) {
		System.out.println("Playing mp4");
	}
}

class AdapterPlayer {
	
	void playFile(String fileName) {
		if(fileName.endsWith(".mp3"))
			MediaPlayer.playMp3(fileName);
		else if(fileName.endsWith(".mp4"))
			VlcPlayer.playMp4(fileName);
	}
}

public class AdapterDemo {
	public static void main(String[] args) {
		AdapterPlayer player = new AdapterPlayer();
		player.playFile("myVideo.mp4");
	}

}
