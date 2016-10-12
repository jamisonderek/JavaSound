import javax.sound.midi.*;

public class SoundDemo {

	public static void main(String[] args) {
		Sequence sequence = JSMusic2.initialize();		
		Track track = JSMusic2.createTrack(sequence, 0);
		JSMusic2.addNote(track, 60, 70, 160);
		Sequencer sequencer = JSMusic2.play(sequence);
		JSMusic2.waitForSongDone(sequencer);
		JSMusic2.close(sequencer);
	}

}
