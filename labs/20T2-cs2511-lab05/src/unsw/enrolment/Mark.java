package unsw.enrolment;

public interface Mark {

	public int calculateMark();

	public int calculateMaxMark();

	public boolean add(Mark child);

	public boolean remove(Mark child);

}
