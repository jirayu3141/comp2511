package unsw.enrolment;

public class Grade {
    private int mark;
    private String grade;


    public Grade(int mark, String grade) {
        this.mark = mark;
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public int getMark() {
        return mark;
    }
    
    public void setMark(int mark) {
        this.mark = mark;
        if (mark >= 50) {
            this.grade = "passed";
        } else {
            this.grade = "failed";
        }
    }

}


