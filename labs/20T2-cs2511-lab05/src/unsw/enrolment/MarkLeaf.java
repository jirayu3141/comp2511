package unsw.enrolment;

public class MarkLeaf implements Mark {

	private String name;
	private int score;
	private int maxScore;

	public MarkLeaf(String name, int score, int maxScore) {
		super();
		this.name = name;
		this.maxScore = maxScore;
		if (score > maxScore) {
			this.score = maxScore;
		} else {
			this.score = score;
		}
	}

	@Override
	public int calculateMark() {
		return this.getScore();
	}

	@Override
	public boolean add(Mark child) {
		return false;
	}

	@Override
	public boolean remove(Mark child) {
		return false;
	}

	@Override
	public int calculateMaxMark() {
		return this.getMaxScore();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @return the maxScore
	 */
	public int getMaxScore() {
		return maxScore;
	}

	/**
	 * @param maxScore the maxScore to set
	 */
	public void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}

	@Override
	public String toString() {
		return "MarkLeaf [name=" + name + ", score=" + score + ", maxScore=" + maxScore + "]";
	}

}
