package unsw.enrolment.test;

import java.time.DayOfWeek;
import java.time.LocalTime;

import unsw.enrolment.Course;
import unsw.enrolment.CourseOffering;
import unsw.enrolment.Enrolment;
import unsw.enrolment.Lecture;
import unsw.enrolment.Session;
import unsw.enrolment.Student;
import unsw.enrolment.Tutorial;

public class EnrolmentTest {

    public static void main(String[] args) {

        // Create courses
        Course comp1511 = new Course("COMP1511", "Programming Fundamentals");
        Course comp1531 = new Course("COMP1531", "Software Engineering Fundamentals");
        comp1531.addPrereq(comp1511);
        Course comp2521 = new Course("COMP2521", "Data Structures and Algorithms");
        comp2521.addPrereq(comp1511);

        System.out.println(comp1511.getOffering());
 
        CourseOffering comp1511Offering = new CourseOffering(comp1511, "19T1");
        CourseOffering comp1531Offering = new CourseOffering(comp1531, "19T1");
        CourseOffering comp2521Offering = new CourseOffering(comp2521, "19T2");

        // TODO Create some sessions for the courses
        Tutorial tut1_1511 = new Tutorial("Quad 1000", DayOfWeek.THURSDAY, LocalTime.of(9, 00), LocalTime.of(10, 00), "Matt");
        Lecture lec1_1511 = new Lecture("Matthew", DayOfWeek.MONDAY, LocalTime.of(10,00), LocalTime.of(11, 00), "Ashesh");
        comp1511Offering.addSession(tut1_1511);
        comp1511Offering.addSession(lec1_1511);
        // TODO Create a student
        Student peter = new Student("z5125805", "Peter");    //to be enrolled in 1511
        Student peter2 = new Student("z5125807", "Peter2");    //to be enrolled in 1511
        
        Student adam = new Student("z5125806", "Adam");    //to be enrolled in 1531
        // Student john = new Student("z5125807");
        // Student josh = new Student("z5125808");

        // TODO Enrol the student in COMP1511 for T1 (this should succeed)
        comp1511Offering.addEnrolments(new Enrolment(comp1511Offering, peter));
        System.out.println(comp1511Offering.getEnrolment());
        
        // TODO Enrol the student in COMP1531 for T1 (this should fail as they
        // have not met the prereq)
        comp1531Offering.addEnrolments(new Enrolment(comp1531Offering, adam));
        //comp1531Offering.printStudent();
        // TODO Give the student a passing grade for COMP1511
        Enrolment adam_1511_enrolment = new Enrolment(comp1511Offering, adam);
        comp1511Offering.addEnrolments(adam_1511_enrolment);
        adam_1511_enrolment.setGrade(51);
        Enrolment adam_enrollment = new Enrolment(comp1531Offering, adam);
        comp1531Offering.addEnrolments(adam_enrollment);

        // TODO Enrol the student in 2521 (this should succeed as they have met
        // the prereqs)
        comp2521Offering.addEnrolments(new Enrolment(comp2521Offering, adam));

        //try adding peter into 2521 (this should fail)
        comp2521Offering.addEnrolments(new Enrolment(comp2521Offering, peter));

    }
}
