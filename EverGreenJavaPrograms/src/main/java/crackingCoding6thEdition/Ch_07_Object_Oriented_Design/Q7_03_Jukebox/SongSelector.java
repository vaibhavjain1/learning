package crackingCoding6thEdition.Ch_07_Object_Oriented_Design.Q7_03_Jukebox;


public class SongSelector {
	private Song currentSong;
	public SongSelector(Song s) { currentSong=s; }
	public void setSong(Song s) { currentSong = s;	}
	public Song getCurrentSong() { return currentSong;	}
}

