import javax.sound.midi.*;

public class SoundDemo {

	public static void main(String[] args) {
		JSMusicPlayer musicPlayer = new JSMusicPlayer(1);
		musicPlayer.addNote(JSNote.C, JSBeat.QUARTER);
		musicPlayer.addNote(JSNote.D, JSBeat.QUARTER);
		musicPlayer.addNote(JSNote.E, JSBeat.QUARTER);
		musicPlayer.addNote(JSNote.C, JSBeat.QUARTER);
		musicPlayer.addNote(JSNote.C+JSNote.Octave, JSBeat.HALF);
		musicPlayer.addNote(JSNote.C-JSNote.Octave, JSBeat.WHOLE);
		musicPlayer.play();
		musicPlayer.waitForSongDone();
		musicPlayer.close();
	}

}
