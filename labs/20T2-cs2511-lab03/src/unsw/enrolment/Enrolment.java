package unsw.enrolment;

public class Enrolment {

    private CourseOffering offering;
    private Grade grade;
    private Student student;

    public Enrolment(CourseOffering offering, Student student) {
        this.offering = offering;
        this.student = student;
        this.grade = new Grade(0, "not_released");
    }

    public Course getCourse() {
        return offering.getCourse();
    }

    public String getTerm() {
        return offering.getTerm();
    }

    //added later
    public Student getStudent() {
        return student;
    }

    public String getGrade() {
        return grade.getGrade();
    }

    public void setGrade(int mark) {
        grade.setMark(mark);
    }


}
