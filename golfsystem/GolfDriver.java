
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*
The GolfDriver class acts as the starting point for the program.
It displays the menu and asks for appropriate input
 */
public class GolfDriver {

	// The getSortedStarts method creates a copy of participants and returns in
	// sorted form
	public static ArrayList<Participant> getSortedStarts(ArrayList<Participant> participants) {

		ArrayList<Participant> toReturn = new ArrayList<Participant>();
		for (Participant p : participants) {
			toReturn.add(p);
		}

		// Using selection sort
		for (int i = 0; i < toReturn.size() - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < toReturn.size(); j++) {

				if (toReturn.get(j).getStartSpot() < toReturn.get(minIndex).getStartSpot()) {
					minIndex = j;
				}

			}

			// Swapping
			Participant temp = toReturn.get(minIndex);
			toReturn.set(minIndex, toReturn.get(i));
			toReturn.set(i, temp);
		}
		return toReturn;

	}

	// The getSortedHcp method creates a copy of participants and returns in sorted
	// form based on handicap
	public static ArrayList<Participant> getSortedHcp(ArrayList<Participant> participants) {

		ArrayList<Participant> toReturn = new ArrayList<Participant>();
		for (Participant p : participants) {
			toReturn.add(p);
		}

		// Using selection sort
		for (int i = 0; i < toReturn.size() - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < toReturn.size(); j++) {

				if (toReturn.get(j).getHandicap() < toReturn.get(minIndex).getHandicap()) {
					minIndex = j;
				}

			}

			// Swapping
			Participant temp = toReturn.get(minIndex);
			toReturn.set(minIndex, toReturn.get(i));
			toReturn.set(i, temp);
		}
		return toReturn;

	}

	// The print menu method displays the meny on consolde
	public static void printMenu() {
		// Displaying menu
		System.out.println("******************* MENU *******************");
		System.out.println("1) Register a Participant.");
		System.out.println("2) Generate Registration List");
		System.out.println("3) Generate Participant List");
		System.out.println("4) Re-Assign random start spots");
		System.out.println("5) Start the round");
		System.out.println("q) Quit");
		System.out.println("");
		System.out.println("\tInput Your Choice: ");
	}

	public static void main(String[] args) {

		// This list of participants are able to enter a round
		ArrayList<Participant> participants = new ArrayList<Participant>();

		// The nextSerialNumber variable holds the serial number to assign to new
		// participant
		int nextSerialNumber = 1;

		boolean keepRunning = true;
		Scanner input = new Scanner(System.in);
		Random rand = new Random();

		while (keepRunning) {

			printMenu();

			String choice;
			choice = input.nextLine().trim();

			if (choice.equals("1")) {
				// User chose to register a new participant
				String name;
				int handicap;

				System.out.println("Enter Name: ");
				name = input.nextLine();
				System.out.println("Enter Handicap: ");
				handicap = input.nextInt();
				input.nextLine(); // Ignoring the end of line after input
				Participant p = new Participant(nextSerialNumber++, name, handicap);
				p.setStartSpot(rand.nextInt(18) + 1);
				participants.add(p);

			} else if (choice.equals("2")) {
				// User chose to generate registration list
				System.out.println("");
				System.out.println("****************** REGISTRATION LIST (Sorted by Handicap) ******************");
				System.out.println("Nr\tName\t\tHcp");
				for (Participant p : getSortedHcp(participants)) {
					System.out.println(p);
				}
			} else if (choice.equals("3")) {
				// User chose to generate participant list
				System.out.println("");
				System.out.println("****************** PARTICIPANT LIST (Sorted by start spot) ******************");
				System.out.println("Nr\tName\t\tHcp\tStart");
				for (Participant p : getSortedStarts(participants)) {
					System.out.println(p + "\t" + p.getStartSpot());
				}
				System.out.println("");
			} else if (choice.equals("4")) {
				// User chose to assign random start spots to players
				for (Participant p : participants) {
					p.setStartSpot(rand.nextInt(18) + 1);
				}

			} else if (choice.equals("5")) {
				// User chose to start the competition
				Competition competition = new Competition(getSortedStarts(participants));
				competition.startCompetition();
			} else if (choice.equals("q")) {
				// User chose to quit the program
				keepRunning = false;
			} else {
				// User entered invalid option so letting him know
				System.out.println("Invalid Input! Please try again.");
			}

		}

	}

}
