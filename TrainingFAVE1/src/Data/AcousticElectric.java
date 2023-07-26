package Data;

public class AcousticElectric extends Guitar{

	public AcousticElectric(String guitarType) {
		super(guitarType);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void BuildGuitar() {
		// TODO Auto-generated method stub
		this.setGuitarSoundType("crunch");
		this.setTone(0);
		this.setVolume(0);
	}
	
}
