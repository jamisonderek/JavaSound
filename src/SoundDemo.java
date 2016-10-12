import javax.sound.midi.*;

public class SoundDemo {

	public static void main(String[] args) {
		JSMusicPlayer musicPlayer = new JSMusicPlayer(1);
		musicPlayer.addNote(JSNote.C, 50);
		musicPlayer.addNote(JSNote.D, 50);
		musicPlayer.addNote(JSNote.E, 50);
		musicPlayer.addNote(JSNote.C, 50);
		musicPlayer.addNote(JSNote.C+JSNote.Octave, 50);
		musicPlayer.addNote(JSNote.C-JSNote.Octave, 50);
		musicPlayer.play();
		musicPlayer.waitForSongDone();
		musicPlayer.close();
	}

}
