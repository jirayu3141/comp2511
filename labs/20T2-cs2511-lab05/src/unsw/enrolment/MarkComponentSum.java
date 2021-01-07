package unsw.enrolment;

import java.util.ArrayList;

public class MarkComponentSum implements Mark {

	private String name;

	ArrayList<Mark> children = new ArrayList<Mark>();

	public MarkComponentSum(String name) {
		super();
		this.name = name;
	}

	@Override
	public int calculateMark() {
		int answer = 0;
		for (Mark m : children) {
			answer += m.calculateMark();
		}
		return answer;
	}

	@Override
	public int calculateMaxMark() {
		int answer = 0;
		for (Mark m : children) {
			answer += m.calculateMaxMark();
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
		return "ComponentSum [name=" + name + ", score=" + calculateMark() + ", maxScore=" + calculateMaxMark() + "]";
	}

}
