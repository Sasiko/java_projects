
public class ParticipantScores {

	private int scores[];
	private Participant participant;
	private boolean scoresAdded;

	// Constructor
	public ParticipantScores(Participant participant) {

		this.participant = participant;
		this.scores = new int[18];
		scoresAdded = false;
		for (int i = 0; i < 18; i++) {
			scores[i] = 0;
		}
		scoresAdded = false;
	}

	// This method retuns the total score
	public int getStrokes() {
		int sum = 0;
		for (int i = 0; i < 18; i++) {
			sum += scores[i];
		}
		return sum;
	}

	// This method returns the scores - handicap
	public int getRes() {
		return this.getStrokes() - this.participant.getHandicap();
	}

	// *** Getters and Setters ***
	public int[] getScores() {
		return scores;
	}

	public void setScores(int[] scores) {
		this.scores = scores;
	}

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	public boolean isScoresAdded() {
		return scoresAdded;
	}

	public void setScoresAdded(boolean scoresAdded) {
		this.scoresAdded = scoresAdded;
	}

}
