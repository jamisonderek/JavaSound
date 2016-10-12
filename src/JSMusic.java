import javax.sound.midi.*;

public class JSMusic {

	public static final int tempoBPM = 120;
	public static final int ticksPerQuarterNote = 16;
	public static final int velocity = 64;

	
	public static Sequence initialize() throws InvalidMidiDataException {
		// PPQ means that the sequence is tempo based timing in ticks-per-quarter note.
		Sequence sequence = new Sequence(Sequence.PPQ, ticksPerQuarterNote);
		return sequence;
	}
	
	public static Track createTrack(Sequence sequence, int instrument) throws InvalidMidiDataException  {
		Track track = sequence.createTrack();
		ShortMessage shortMessage = new ShortMessage();
		// https://en.wikipedia.org/wiki/General_MIDI#Program_change_events lists the instruments.
		shortMessage.setMessage(ShortMessage.PROGRAM_CHANGE, 0, instrument, 0);
		MidiEvent event = new MidiEvent(shortMessage, 0); 
		track.add(event);
		return track;
	}
	
	public static void addNote(Track track, int note, int startTime, int endTime) throws InvalidMidiDataException {
		ShortMessage onShortMessage = new ShortMessage();
		onShortMessage.setMessage(ShortMessage.NOTE_ON, 0, note, velocity);
		MidiEvent eventOn = new MidiEvent(onShortMessage, startTime); 
		track.add(eventOn);
		ShortMessage offShortMessage = new ShortMessage();
		offShortMessage.setMessage(ShortMessage.NOTE_OFF, 0, note, velocity);
		MidiEvent eventOff = new MidiEvent(offShortMessage, endTime);
		track.add(eventOff);
		System.out.println("Note: "+note+"\tstart: "+startTime+"\tend:"+endTime);
	}

	public static Sequencer play(Sequence sequence) throws InvalidMidiDataException, MidiUnavailableException {
		Sequencer sequencer = MidiSystem.getSequencer();
		Synthesizer synthesizer = MidiSystem.getSynthesizer();
		sequencer.open();
		synthesizer.open();
		sequencer.getTransmitter().setReceiver(synthesizer.getReceiver());	
		sequencer.setSequence(sequence);
		sequencer.setTempoInBPM(tempoBPM);
		sequencer.start();		
		return sequencer;
	}
	
	public static void waitForSongDone(Sequencer sequencer) {
		for (int i=0;sequencer.isRunning();i++) {
			// We just want to wait about 100ms.
			waitForMilliseconds(100+i%2);
		}
	}

	public static void waitForMilliseconds(int duration) {
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
		}		
	}
	
	public static void close(Sequencer sequencer) {
		sequencer.close();
	}
}
