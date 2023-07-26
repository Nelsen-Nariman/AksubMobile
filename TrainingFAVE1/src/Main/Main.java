package Main;

import java.util.ArrayList;
import java.util.Scanner;

import Data.Acoustic;
import Data.AcousticElectric;
import Data.Electric;
import Data.Guitar;


public class Main {
	Scanner input = new Scanner(System.in);
	ArrayList<Guitar> listGuitars = new ArrayList<Guitar>();
	
	int pilih = 0;
	
	public Main(){
		do {
			menu();
			
			switch (pilih) {
			case 1:
				BuildGuitar();
				break;
				
			case 2:
				DisplayGuitar();
				break;
			}
		} while ((pilih<=0 && pilih>3) || pilih!=3);
	}
	
	public void menu() {
		System.out.println("1. Build Guitar");
		System.out.println("2. Display List of Guitar");
		System.out.println("3. Exit");
		System.out.print("Choose menu[1..3]: ");
		pilih = input.nextInt();input.nextLine();
	}
	
	public void BuildGuitar() {
		int pilih2 = 0;
		System.out.println("1. Acoustic");
		System.out.println("2. Electric");
		System.out.println("3. Acoustic Electric");
		System.out.print("Input guitar type[1..3]: ");
		pilih2 = input.nextInt(); input.nextLine();
		
		switch (pilih2) {
		case 1:
			BuildAcoustic();
			break;
		case 2:
			BuildElectric();
			break;
		case 3:
			BuildAcousticElectric();
			break;
		}
	}
	
	public void DisplayGuitar() {
		System.out.println("[GuitarType] - [GuitarSoundType] - [Tone] - [Volume] - [SwitchPosition]");
		for(int i=0; i<listGuitars.size(); i++) {
			if(listGuitars.get(i).getGuitarType().equals("Acoustic Guitar")) {
				System.out.println(listGuitars.get(i).getGuitarType() + " - " + listGuitars.get(i).getGuitarSoundType());
			}
			else if(listGuitars.get(i).getGuitarType().equals("Electric Guitar")) {
				System.out.println(listGuitars.get(i).getGuitarType() + " - " + listGuitars.get(i).getGuitarSoundType() + " - " + listGuitars.get(i).getTone() + " - "
						+ listGuitars.get(i).getVolume() + " - " + listGuitars.get(i).getSwitchPosition());
			}
			else if(listGuitars.get(i).getGuitarType().equals("Acoustic Electric Guitar")) {
				System.out.println(listGuitars.get(i).getGuitarType() + " - " + listGuitars.get(i).getGuitarSoundType() + " - " + listGuitars.get(i).getTone() + " - "
						+ listGuitars.get(i).getVolume() + " - " + listGuitars.get(i).getSwitchPosition());
			}
		}
	}
	
	public void BuildAcoustic() {
		Acoustic acoustics = new Acoustic("Acoustic Guitar");
		acoustics.BuildGuitar();
		listGuitars.add(acoustics);
	}
	
	public void BuildElectric() {
		int switchPosition = 0, tone = 0, volume = 0;
		System.out.print("Input switch position: ");
		switchPosition = input.nextInt(); input.nextLine();
		
		System.out.print("Input tone: ");
		tone = input.nextInt(); input.nextLine();
		
		System.out.print("Input volume: ");
		volume = input.nextInt(); input.nextLine();
		
		Electric electrics = new Electric("Electric Guitar", tone, volume, switchPosition);
		electrics.BuildGuitar();
		listGuitars.add(electrics);
	}
	
	public void BuildAcousticElectric() {
		AcousticElectric acousticElectrics = new AcousticElectric("Acoustic Electric Guitar");
		acousticElectrics.BuildGuitar();
		listGuitars.add(acousticElectrics);
	}

	public static void main(String[] args) {
		new Main();

	}

}
