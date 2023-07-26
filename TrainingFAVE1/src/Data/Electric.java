package Data;

public class Electric extends Guitar{

	public Electric(String guitarType, int tone, int volume, int switchPosition) {
		super(guitarType);
		this.setTone(tone);
		this.setVolume(volume);
		this.setSwitchPosition(switchPosition);
	}

	@Override
	public void BuildGuitar() {
		
		if(this.getSwitchPosition() == 1) {
			this.setGuitarSoundType("Funk");
		}
		else if(this.getSwitchPosition() == 2) {
			this.setGuitarSoundType("Jazz");
		}
		else if(this.getSwitchPosition() == 3) {
			this.setGuitarSoundType("Blues");
		}
		else {
			this.setGuitarSoundType("Rock");
		}
	}

}
