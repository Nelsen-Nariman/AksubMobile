package Data;

public abstract class Guitar {
	private String guitarType, guitarSoundType;
	private int tone, volume, switchPosition;
	
	public Guitar(String guitarType) {
		super();
		this.guitarType = guitarType;
	}

	public String getGuitarType() {
		return guitarType;
	}

	public void setGuitarType(String guitarType) {
		this.guitarType = guitarType;
	}

	public String getGuitarSoundType() {
		return guitarSoundType;
	}

	public void setGuitarSoundType(String guitarSoundType) {
		this.guitarSoundType = guitarSoundType;
	}

	public int getTone() {
		return tone;
	}

	public void setTone(int tone) {
		this.tone = tone;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getSwitchPosition() {
		return switchPosition;
	}

	public void setSwitchPosition(int switchPosition) {
		this.switchPosition = switchPosition;
	}
	
	public abstract void BuildGuitar();
	
}
