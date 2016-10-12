import javax.sound.midi.*;

public class SoundDemo {

	public static void main(String[] args) {
		JSMusicPlayer musicPlayer = new JSMusicPlayer(1);
		
		musicPlayer.addRest(JSBeat.QUARTER);
		musicPlayer.addNote(JSNote.A, JSBeat.QUARTER);
		musicPlayer.addNote(JSNote.Csharp, JSBeat.QUARTER);
		musicPlayer.addNote(JSNote.D, JSBeat.QUARTER);
		musicPlayer.addNote(JSNote.E, JSBeat.WHOLE);

		musicPlayer.addRest(JSBeat.QUARTER);
		musicPlayer.addNote(JSNote.A, JSBeat.QUARTER);
		musicPlayer.addNote(JSNote.Csharp, JSBeat.QUARTER);
		musicPlayer.addNote(JSNote.D, JSBeat.QUARTER);
		musicPlayer.addNote(JSNote.E, JSBeat.WHOLE);

		musicPlayer.addRest(JSBeat.QUARTER);
		musicPlayer.addNote(JSNote.A, JSBeat.QUARTER);
		musicPlayer.addNote(JSNote.Csharp, JSBeat.QUARTER);
		musicPlayer.addNote(JSNote.D, JSBeat.QUARTER);
		musicPlayer.addNote(JSNote.E, JSBeat.HALF);
		musicPlayer.addNote(JSNote.Csharp, JSBeat.HALF);
		musicPlayer.addNote(JSNote.A, JSBeat.HALF);
		musicPlayer.addNote(JSNote.Csharp, JSBeat.HALF);
		musicPlayer.addNote(JSNote.B, JSBeat.WHOLE);

		musicPlayer.play(240);
		musicPlayer.waitForSongDone();
		musicPlayer.close();
	}

}
