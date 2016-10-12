public class SoundDemo {

	public static void main(String[] args) {
		SaintsSong song = new SaintsSong(JSInstrument.AcousticGrandPiano);
		song.play();
		song.close();
	}

}
