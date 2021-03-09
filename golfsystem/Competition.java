
import java.util.ArrayList;
import java.util.Scanner;


public class Competition {

	private final int MAX_SCORE = 72;
	private final int MAX_HOLES = 18;
	private final int PAIRS[] = new int[] { 5, 3, 4, 4, 5, 4, 4, 4, 3, 5, 4, 4, 3, 4, 3, 5, 4, 4 };
	private ParticipantScores scores[];

	private ArrayList<Participant> participants;

	// The constructor initializes the participants for the competition
	public Competition(ArrayList<Participant> participants) {
		this.participants = participants;
		scores = new ParticipantScores[participants.size()];
		int counter = 0;
		for (Participant p : participants) {
			scores[counter++] = new ParticipantScores(p);
		}
	}

	// The sortByStrokes method sorts the scores based on strokes
	public void sortByStrokes() {

		// Using selection sort
		for (int i = 0; i < scores.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < scores.length; j++) {

				if (scores[j].getStrokes() < scores[minIndex].getStrokes()) {
					minIndex = j;
				}

			}

			// Swapping
			ParticipantScores temp = scores[minIndex];
			scores[minIndex] = scores[i];
			scores[i] = temp;
		}

	}

	// The sortByRes method sorts the scores based on strokes - handicap
	public void sortByRes() {

		// Using selection sort
		for (int i = 0; i < scores.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < scores.length; j++) {

				if (scores[j].getRes() < scores[minIndex].getRes()) {
					minIndex = j;
				}

			}

			// Swapping
			ParticipantScores temp = scores[minIndex];
			scores[minIndex] = scores[i];
			scores[i] = temp;
		}

	}

	// The scoresRemaining method returns true if there are still scores left to be
	// added
	public boolean scoresRemaining() {
		for (ParticipantScores ps : this.scores) {
			if (!ps.isScoresAdded()) {
				return true;
			}
		}
		return false;
	}

	// The srExists method returns true if the serial number exists, false otherwise
	public ParticipantScores srExists(int sr) {
		for (ParticipantScores ps : this.scores) {
			if (ps.getParticipant().getSerialNumber() == sr) {
				return ps;
			}
		}
		return null;
	}

	// The startCompetition method gets input for all the holes for all participants
	public void startCompetition() {

		Scanner input = new Scanner(System.in);

		boolean keepRunning = true;

		while (keepRunning) {
			// Printing the sub menu
			System.out.println("********* COMPETETION MENU ***********");
			System.out.println("1) Add scores for participant");
			System.out.println("2) Print all participants");
			System.out.println("3) Print All Scores");
			System.out.println("4) Sort Scores by total strokes");
			System.out.println("5) Sort Scores by actual result");
			System.out.println("q) Exit");
			System.out.println("\tEnter Here: ");
			String choice;
			choice = input.nextLine().trim();

			if (choice.equals("1")) {

				System.out.println("Input Serial Number: ");
				int sN = input.nextInt();
				input.nextLine(); // ignoring the end of line

				ParticipantScores thisP = srExists(sN);
				if (thisP == null) {
					System.out.println("Error! A Participant with this score does not exist. Please try again.");
				} else {
					for (int i = 0; i < this.MAX_HOLES; i++) {
						int score;
						int holeNum = i + 1;
						System.out.println(holeNum + " (" + this.PAIRS[i] + "):");
						score = input.nextInt();
						while (score < 0 || score > this.PAIRS[i]) {
							System.out.println("ERROR! The score range for this pair is 0 to " + this.PAIRS[i]);
							System.out.println("Input score: ");
							score = input.nextInt();

						}

						thisP.getScores()[i] = score;

					}
				}

			} else if (choice.equals("2")) {
				System.out.println("");
				System.out.println("****************** PARTICIPANT LIST ******************");
				System.out.println("Nr\tName\t\tHcp\tStart");
				for (Participant p : participants) {
					System.out.println(p + "\t" + p.getStartSpot());
				}
				System.out.println("");
			} else if (choice.equals("3")) {

				System.out.println("");
				System.out.println("****************** SCORES ******************");

				System.out.println("Nr | 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 | sum | res | pair");

				for (ParticipantScores ps : scores) {
					System.out.print(ps.getParticipant().getSerialNumber() + "  | ");

					for (int i = 0; i < 18; i++) {
						System.out.print(ps.getScores()[i] + " ");

						if (i >= 9 && ps.getScores()[i] < 9) {
							System.out.print(" ");
						}
					}
					int sum = ps.getStrokes();
					int res = ps.getRes();
					int par = res - sum;
					System.out.print("|  " + sum + "  |  ");
					System.out.print(res + "  |  ");
					System.out.print(par + "  |  ");

					System.out.println("");
				}
				System.out.println("");

			} else if (choice.equals("4")) {
				this.sortByStrokes();
				System.out.println("Sorted Successfully!");
			} else if (choice.equals("4")) {
				this.sortByRes();
				System.out.println("Sorted Successfully!");
			} else if (choice.equals("q")) {
				keepRunning = false;
			} else {
				System.out.println("Invalid Input! Please try again");
			}

		}

	}

}
