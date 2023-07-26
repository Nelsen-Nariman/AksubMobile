package Data;

import java.util.Random;

public class Acoustic extends Guitar{
	
	Random rand = new Random();

	public Acoustic(String guitarType) {
		super(guitarType);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void BuildGuitar() {
		int flag = rand.nextInt(2);
		
		if(flag == 0) {
			this.setGuitarSoundType("warm");
		}
		else {
			this.setGuitarSoundType("bright");
		}
		
	}
	
}
