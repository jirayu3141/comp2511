package staff.test;

import staff.Lecturer;
import staff.StaffMember;
import java.time.LocalDate;

public class StaffTest {
    public static void printStaffDetails(StaffMember staff) { 
        System.out.println(staff.toString());
    }

    public static void main(String[] args) {
        System.out.println("\nCreating staff1...");
        StaffMember staff1 = new StaffMember("Peter", 100000, LocalDate.of(2014, 2, 14), LocalDate.of(2014, 2, 16));
        StaffTest.printStaffDetails(staff1);
        
        System.out.println("\nCreating lecturer1...");
        Lecturer lecturer1 = new Lecturer("Ashesh", 10000, LocalDate.of(2016, 2, 14), LocalDate.of(2016, 2, 16), "CSE", "god");
        StaffTest.printStaffDetails(lecturer1);
        
        System.out.println("\nTesting for reflective relation...");
        if (staff1.equals(staff1) && lecturer1.equals(lecturer1)) {
            System.out.println("Tests Passed");
        } else {
            System.out.println("Tests Failed");
        }
     

        StaffMember staff2 = new StaffMember("Peter", 100000, LocalDate.of(2014, 2, 14), LocalDate.of(2014, 2, 16));    //same as staff1
        StaffMember staff3 = new StaffMember("Peter", 100000, LocalDate.of(2014, 2, 14), LocalDate.of(2014, 2, 16));    //same as staff1
       
        System.out.println("\nTesting for symmetric relation (staff)...");
        if (staff1.equals(staff2) && staff1.equals(staff3) && staff2.equals(staff3)) {
            System.out.println("Tests Passed");
        } else {
            System.out.println("Tests Failed");
        }

        Lecturer lecturer2 = new Lecturer("Ashesh", 10000, LocalDate.of(2016, 2, 14), LocalDate.of(2016, 2, 16), "CSE", "god"); //same as lecturer1
        Lecturer lecturer3 = new Lecturer("Ashesh", 10000, LocalDate.of(2016, 2, 14), LocalDate.of(2016, 2, 16), "CSE", "god"); //same as lecturer1
        System.out.println("\nTesting for symmetric relation (lecturer)...");
        if(lecturer1.equals(lecturer2) && lecturer2.equals(lecturer3) && lecturer3.equals(lecturer1)) {
            System.out.println("Tests Passed");
        } else {
            System.out.println("Tests Failed");
        }
    
        System.out.println("\nTesting for non-null relation...");
        if(!staff1.equals(null) && !lecturer1.equals(null)) {
            System.out.println("Tests Passed");
        } else {
            System.out.println("Tests Failed");
        }


        System.out.println("\nOther tests...");
        System.out.println(lecturer1.equals(staff1));   //false
        System.out.println(staff1.equals(lecturer1));   //false

        Lecturer lecturer4 = new Lecturer("Peter", 100000, LocalDate.of(2014, 2, 14), LocalDate.of(2014, 2, 16), "CSE", "god"); //same as name as staff1
        StaffMember staff4 = new StaffMember("Ashesh", 10000, LocalDate.of(2016, 2, 14), LocalDate.of(2016, 2, 16)); //same name as lecturer
        System.out.println(lecturer4.equals(staff1));   //fasle
        System.out.println(staff4.equals(staff1));   //fasle
        System.out.println(staff4.equals(lecturer1));   //fasle
        System.out.println("if all print false, the test is passed!");   //fasle
    }

}