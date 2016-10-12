import javax.sound.midi.*;

public class SoundDemo {

	public static void main(String[] args) {
		Sequence sequence = JSMusic2.initialize();		
		Track track = JSMusic2.createTrack(sequence, 0);
		JSMusic2.addNote(track, JSNote.C, 70, 160);
		JSMusic2.addNote(track, JSNote.D, 170, 260);
		JSMusic2.addNote(track, JSNote.E, 270, 360);
		JSMusic2.addNote(track, JSNote.C, 370, 460);
		JSMusic2.addNote(track, JSNote.C + JSNote.Octave, 470, 560);
		JSMusic2.addNote(track, JSNote.C - JSNote.Octave, 570, 660);
		Sequencer sequencer = JSMusic2.play(sequence);
		JSMusic2.waitForSongDone(sequencer);
		JSMusic2.close(sequencer);
	}

}
