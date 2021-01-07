package unsw.enrolment;

import java.util.ArrayList;

public class MarkComponentAvg implements Mark {

	private String name;
	private int maxScore;

	ArrayList<Mark> children = new ArrayList<Mark>();

	public MarkComponentAvg(String name) {
		super();
		this.name = name;
	}


	@Override
	public int calculateMark() {
		int answer = 0;
		for (Mark m : children) {
			answer += m.calculateMark();
		}
		// Average of composing elements
		if (children.size() > 0) {
			answer /= children.size();
		}
		return answer;
	}

	@Override
	public int calculateMaxMark() {
		int answer = 0;
		for (Mark m : children) {
			answer += m.calculateMaxMark();
		}
		// Average of composing elements
		if (children.size() > 0) {
			answer /= children.size();
		}
		return answer;
	}

	@Override
	public boolean add(Mark child) {
		children.add(child);
		return true;
	}

	@Override
	public boolean remove(Mark child) {
		children.remove(child);
		return true;
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

	/**
	 * @return the children
	 */
	public ArrayList<Mark> getChildren() {
		return children;
	}

	/**
	 * @param children the children to set
	 */
	public void setChildren(ArrayList<Mark> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "ComponentAvg [name=" + name + ", score=" + calculateMark() + ", maxScore=" + calculateMaxMark() + "]";
	}

}
