
/*
Tentamen_HT20_enmpan-1
Användarnamn: enmpan-1
The Participant class holds the data related to a single participant in the competition
*/
public class Participant {

	private int serialNumber;
	private String name;
	private int handicap;
	private int startSpot;

	public Participant(int serialNumber, String name, int handicap) {
		this.serialNumber = serialNumber;
		this.name = name;
		this.handicap = handicap;

	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHandicap() {
		return handicap;
	}

	public void setHandicap(int handicap) {
		this.handicap = handicap;
	}

	public int getStartSpot() {
		return startSpot;
	}

	public void setStartSpot(int startSpot) {
		this.startSpot = startSpot;
	}

	@Override
	public String toString() {
		String str = this.serialNumber + "\t" + this.name;
		for (int i = name.length(); i < 12; i++) {
			str += " ";
		}
		return str + "\t" + this.handicap;
	}

}
