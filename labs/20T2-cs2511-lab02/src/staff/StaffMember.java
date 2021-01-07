package staff;

import java.time.LocalDate;

/**
 * A staff member
 * @author Jirayu Sirivorawong
 *
 */
public class StaffMember {
   
    //attributes
    protected String name;
    protected float salary;
    protected LocalDate hire_date;
    protected LocalDate end_date;

    /**
     * constructor for the StaffMember class
     * @param name name of the staff
     * @param hire_date hire date of the staff
     * @param end_date end date of the staff
     */
    public StaffMember(String name, float salary, LocalDate hire_date, LocalDate end_date) {
        this.name = name;
        this.salary = salary;
        this.hire_date = hire_date;
        this.end_date = end_date;
    }

    /**
     * getter method to extract name of the staff
     * @return name of the staff
     */
    public String getName() {
        return name;
    }

    /**
     * setter method to set name of the staff
     * 
     * @param name name of the staff
     */
    public void setName(String name) {
        this.name = name;
     }

     /**
      * getter method to get the hire date of the staff
      * @return hire date of the staff
      */
     public LocalDate getHireDate(){
         return hire_date;
     }

     /**
      * setter method to set the hire date of the staff
      * @param hire_date hire date of the staff
      */
     public void setHireDate(LocalDate hire_date) {
         this.hire_date = hire_date;
     }

    /**
     * getter method to extract end date of the staff
     * @return end date of the staff
     */ 
     public LocalDate getEndDate(){
        return end_date;
    }

    /**
     * setter method to set the end date of the staff
     * @param hire_date the end date of the staff
     */
    public void setEndDate(LocalDate hire_date) {
        this.hire_date = end_date;
    }

    
    @Override
    public String toString() {
        return this.getClass() + "\n" + "Staff Name: " + name + "\n" + "Salary: " + salary + "\n" +
         "Hire Date: " + hire_date +"\n" + "End Date: " + end_date +"\n";
    }

    @Override
    public boolean equals(Object obj) {
   
        if(obj == null) { return false; }
        if(obj == this) { return true; }

        if(this.getClass() != obj.getClass()){
            return false;
        }

        StaffMember other = (StaffMember) obj;
        if(this.name.equals(other.name) && this.salary == other.salary && this.hire_date.equals(other.hire_date)  && this.end_date.equals(other.end_date)) {
            return true;
        } else {
            return false;
        }
         
    }
}


