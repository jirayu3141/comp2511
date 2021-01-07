package unsw.enrolment;
import java.util.ArrayList;
import java.util.List;

public class CourseOffering {

    private Course course;
    private List<Course> prereq;
    private String term;
    private List<Session> sessions;
    private List<Enrolment> enrolments;

    public CourseOffering(Course course, String term) {
        this.course = course;
        this.term = term;
        this.sessions = new ArrayList<>();
        this.enrolments = new ArrayList<>();
        this.course.addOffering(this);
        this.prereq = course.getPrereqs();
    }

    public void addSession(Session session) {
        sessions.add(session);
    }

    public Course getCourse() {
        return course;
    }

    public String getTerm() {
        return term;
    }

    //added later
    public List<Enrolment> getEnrolment() {
        return enrolments;
    }

    public void addEnrolments(Enrolment enrolment) {
        //check that the student has passing grade for each prereqs
        Student student = enrolment.getStudent();
        
        // if (prereq.size() > 0) {
        //     course.printPrereqs();
        // }

        if (checkPassPrereq(student, course)) {    
            this.enrolments.add(enrolment); // add enrolment to the course offering
            student.addEnrolment(enrolment);    // add enrolment to the student
            System.out.println("Enrolment of " + student.getName() + " into " + this.getCourse().getCourseCode() + " successful!");
        } else {
            System.out.println(student.getName() + " does not meet prereq requirement");
        }
    }

    public void printStudent() {
        System.out.print("Student in " + course.getCourseCode() + " " + term + ": ");
        for(Enrolment x: enrolments) {
            System.out.print(x.getStudent().getZID() + ", ");
        }
        System.out.println();
    }

    private boolean checkPassPrereq(Student student, Course course) {
        // if prereq is not empty
        if (this.prereq.isEmpty()) {return true;}
        
        // check if student have the pre req coruses
        List<Enrolment> stuTakenCourse = student.getEnrolment(); // student's taken subject    
        for (Course x: prereq) {
                //check if student passed that course
                for(Enrolment y: stuTakenCourse) {
                    if(y.getCourse().getCourseCode().equals(x.getCourseCode())) {
                        if(y.getGrade().equals("passed")) {return true;}
                    }
                }

            }
        
        return false;
    }
}