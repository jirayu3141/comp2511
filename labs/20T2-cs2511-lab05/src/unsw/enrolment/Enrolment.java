package unsw.enrolment;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Enrolment extends Observable {

	private CourseOffering offering;
	private Grade grade;
	private Student student;
	private List<Session> sessions;
	private Mark totalMark = null;
	private Mark pracMark = null;
	private Mark examMark = null;

	public Enrolment(CourseOffering offering, Student student, Session... sessions) {
		this.offering = offering;
		this.student = student;
		this.grade = null; // Student has not completed course yet.
		student.addEnrolment(this);
		offering.addEnrolment(this);
		this.sessions = new ArrayList<>();
		for (Session session : sessions) {
			this.sessions.add(session);
		}
	}

	public Course getCourse() {
		return offering.getCourse();
	}

	public String getTerm() {
		return offering.getTerm();
	}

	public boolean hasPassed() {
		return grade != null && grade.isPassing();
	}

	public void assignGrade() {
		System.out.println(totalMark.calculateMark());
		System.out.println(totalMark.calculateMaxMark());
		grade = new Grade((int) (totalMark.calculateMark() / (double) totalMark.calculateMaxMark() * 100.0));
	}

	public String getStudentID() {
		return student.getZID();
	}

	public Mark getTotalMark() {
		return totalMark;
	}

	public void setTotalMark(Mark mark) {
		this.totalMark = mark;
		setChanged();
		notifyObservers(mark);
	}

	public void setExamMark(Mark mark) {
		this.examMark = mark;
		this.totalMark.add(mark);
		setChanged();
		notifyObservers(mark);
	}

	public void setPracMark(Mark mark) {
		this.pracMark = mark;
		this.totalMark.add(mark);
		setChanged();
		notifyObservers(mark);
	}

	public void addAssignment(Mark prac, Mark toAdd) {
		prac.add(toAdd);
		setChanged();
		notifyObservers(toAdd);
	}

	public void addMileStone(Mark assignment, Mark milestone) {
		assignment.add(milestone);
		setChanged();
		notifyObservers(milestone);
	}

	public Mark getPracMark() {
		return pracMark;
	}

	public Mark getExamMark() {
		return examMark;
	}

}
