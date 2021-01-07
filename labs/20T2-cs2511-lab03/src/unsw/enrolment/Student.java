package unsw.enrolment;
import java.util.ArrayList;
import java.util.List;

public class Student {

    private String zid;
    private String name;
    private List<Enrolment> enrolments;

	public Student(String zid, String name) {
        this.zid = zid;
        this.name = name;
        enrolments = new ArrayList<>();
    }

	public String getZID() {
		return zid;
    }

    //added later
    public List<Enrolment> getEnrolment() {
        return enrolments;
    }

    public void addEnrolment(Enrolment enrolment) {
        enrolments.add(enrolment);
    }

    public String getName() {
        return name;
    }
}