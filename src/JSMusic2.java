import javax.sound.midi.*;

/**
 * JSMusic2 is a thin wrapper around the {@link JSMusic} class.  Any exceptions are printed to the console and a value of null
 * is returned to the caller.  This class also adds Javadoc comments to the methods.
 */
public class JSMusic2 {

	/**
	 * The beats per minute when playing the song.
	 */
	public static final int tempoBPM = JSMusic.tempoBPM;
	
	/**
	 * The number of ticks (change in time) for each quarter note.
	 */
	public static final int ticksPerQuarterNote = 16;
	
	/**
	 * How quickly to press the note.
	 */
	public static final int velocity = 64;

	/**
	 * Call {@link #initialize()} to create a new {@link Sequence} for playing music.
	 * @returns a {@link Sequence} for playing music. 
	 */
	public static Sequence initialize()  {
		try {
			return JSMusic.initialize();
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Creates a new music track on the first MIDI channel.
	 * 
	 * @see https://en.wikipedia.org/wiki/General_MIDI#Program_change_events for a list the instruments.
	 *
	 * @param sequence should be a {@link Sequence} returned from {@link #initialize()}.
	 * @param instrument is the instrument to play the song 1-128.
	 * @return a {@link Track} that you can add notes to with {@link #addNote(Track, int, int, int)}.
	 */
	public static Track createTrack(Sequence sequence, int instrument) {
		try {
			return JSMusic.createTrack(sequence, instrument);
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Adds a note to the track for the specified duration.
	 * 
	 * @param track should be a {@link Track} returned from {@link #createTrack(Sequence, int)}. 
	 * @param note should be the note to play.  60 is middle-C.
	 * @param startTime is the tick at which to start playing the note.
	 * @param endTime is the tick at which to stop playing the note.
	 */
	public static void addNote(Track track, int note, int startTime, int endTime) {
		try {
			JSMusic.addNote(track, note, startTime, endTime);
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
	}


	/**
	 * Plays the song specified by the sequence.  This method returns immediately and does not wait
	 * for the song to complete.  If you want to wait for the song to finish, you should call the
	 * {@link #waitForSongDone(Sequencer)} method.
	 * @param sequence is the sequence to play.
	 * @return a {@link Sequencer} object that you can use to wait for the song on.
	 */
	public static Sequencer play(Sequence sequence)  {
		try {
			return JSMusic.play(sequence);
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
			return null;
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * This method will wait for the song to finish playing before returning to the caller.
	 * 
	 * @param sequencer returned from the {@link #play(Sequence)} method.
	 */
	public static void waitForSongDone(Sequencer sequencer) {
		JSMusic.waitForSongDone(sequencer);
	}

	/**
	 * Releases any resources that might have been created while playing music.
	 * @param sequencer returned from the {@link #play(Sequence)} method.
	 */
	public static void close(Sequencer sequencer) {
		JSMusic.close(sequencer);
	}
}
