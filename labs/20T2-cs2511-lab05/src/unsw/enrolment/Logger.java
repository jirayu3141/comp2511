package unsw.enrolment;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Observable;
import java.util.Observer;
import java.util.Date;

public class Logger implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (o instanceof Enrolment) {
			Enrolment enrol = (Enrolment) o;
			Mark mark = (Mark) arg;
			writeToFile(enrol, mark);
		} else {
			System.out.println("Not Enrolment");
		}
	}

	private void writeToFile(Enrolment e, Mark m) {
		StringBuilder filename = new StringBuilder();
		filename.append(e.getCourse().getCourseCode());
		filename.append("-");
		filename.append(e.getTerm());
		filename.append("-");
		filename.append(e.getStudentID());
		filename.append(".txt");
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		try {
			FileWriter fw = new FileWriter(filename.toString(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw);
			out.print(formatter.format(date) + "\t");
			out.println(m.toString());
			out.close();

		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
