import javax.sound.midi.*;

public class SoundDemo {

	public static void main(String[] args) throws Exception {
		Sequence sequence = JSMusic.initialize();		
		Track track = JSMusic.createTrack(sequence, 0);
		JSMusic.addNote(track, 60, 70, 160);
		Sequencer sequencer = JSMusic.play(sequence);
		JSMusic.waitForSongDone(sequencer);
		JSMusic.close(sequencer);
	}

}
