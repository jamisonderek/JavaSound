import javax.sound.midi.*;

public class SoundDemo {

	public static void main(String[] args) throws Exception {
		Sequence sequence = new Sequence(Sequence.PPQ, 16);
		
		Track track = sequence.createTrack();
		
		ShortMessage shortMessage = new ShortMessage();
		shortMessage.setMessage(ShortMessage.PROGRAM_CHANGE, 0, 0, 0);
		MidiEvent event = new MidiEvent(shortMessage, 0); 
		track.add(event);
		
		ShortMessage onShortMessage = new ShortMessage();
		onShortMessage.setMessage(ShortMessage.NOTE_ON, 0, 60, 64);
		MidiEvent eventOn = new MidiEvent(onShortMessage, 70);
		track.add(eventOn);

		ShortMessage offShortMessage = new ShortMessage();
		offShortMessage.setMessage(ShortMessage.NOTE_OFF, 0, 60, 64);
		MidiEvent eventOff = new MidiEvent(offShortMessage, 160);
		track.add(eventOff);
		
		Sequencer sequencer = MidiSystem.getSequencer();
		Synthesizer synthesizer = MidiSystem.getSynthesizer();
		sequencer.open();
		synthesizer.open();
		sequencer.getTransmitter().setReceiver(synthesizer.getReceiver());	
		sequencer.setSequence(sequence);
		sequencer.setTempoInBPM(120);
		sequencer.start();

		for (int i=0;sequencer.isRunning();i++) {
			Thread.sleep(100+i%2);
		}
		
		sequencer.close();
		

	}

}
