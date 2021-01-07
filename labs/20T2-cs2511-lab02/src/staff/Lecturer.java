package staff;

import java.time.LocalDate;

public class Lecturer extends StaffMember {
    String school;
    String status;

    /**
     * constructor for lecturer class
     * @param name name of the lecturer
     * @param salary salary of the lecturer
     * @param hire_date hire date of the lecturer
     * @param end_date end hire date of the lecturer
     * @param school school the lecturer belongs to
     * @param status status of the lecturer
     */
    public Lecturer(String name, float salary, LocalDate hire_date, LocalDate end_date, String school, String status) {
        super(name, salary, hire_date, end_date);
        this.school = school;
        this.status = status;
    }

    /**
     * getter method for getting the school lecturer belongs to
     * @return school the lecturer belongs to
     */
    public String getSchool() {
        return school;
    }

    /**
     * 
     * @param school school the lecturer belongs to
     */
    public void setSchool(String school) {
        this.school = school;
    }

    /**
     * 
     * @return status of the lecturer
     */
    public String getStatus() {
        return status;
    }

    /**
     * 
     * @param status status of the lecturer
     */
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object obj) {
   
        if (!super.equals(obj)) {
            return false;
        }

        Lecturer other = (Lecturer) obj;
        if(this.school.equals(other.school) && this.status.equals(other.status) ) {
            return true;
        }
        else {
            return false;
        }
         
    }

    @Override
    public String toString() {
        return super.toString() + "School: " + school + "\n" + "Status: " + status;
    }
}