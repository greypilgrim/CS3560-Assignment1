import java.util.ArrayList;

/**
 * @author jmcgr
 *This class will keep track of which questions are being asked, which answers are being chosen, and be able to print those results
 */
public class VotingService {
	//variables that keep track of the total amount of students the simulation has created, as well as how many questions have been asked
	private int totalStudents;
	private int multChoiceQuestions = 5;
	private int singChoiceQuestions = 5;
	
	//constructor creates the VotingService object for use by the SimulationDriver 
	//and sets the total students to the amount of students the driver has created
	VotingService(int numOfStudentsCreated){
		totalStudents = numOfStudentsCreated;
	}
	
	//returns to the SimulationDriver the total number of students for printing to the screen
	public int getTotalStudents() {
		return totalStudents;
	}
	
	//returns the amount of multiple choice questions there are left to be asked
	public int getmultQsLeft() {
		return multChoiceQuestions;
	}
	
	//returns the amount of multiple choice questions there are left to be asked
	public int getSingQsLeft() {
		return singChoiceQuestions;
	}
	
	//decSingQs and decMultQs both decrement the amount of questions to be asked, when that question type has been asked, respectively
	public void decSingQsLeft() {
		--singChoiceQuestions;
	}
	public void decMultQsLeft() {
		--multChoiceQuestions;
	}
	
	//prints all the choices made by students after each question
	public void printQResults(ArrayList<Student> currStudent, int currentQ, int questionChosen) {
		System.out.println();
		for(int k = 0; k < currStudent.size(); k++) {
			if(questionChosen == 0) {
				System.out.println(currStudent.get(k).getStudentID() + " chose: " + currStudent.get(k).getSingChoiceAnswers().get(currentQ));
			}
			else if(questionChosen == 1) {
				System.out.println(currStudent.get(k).getStudentID() + " chose: " + currStudent.get(k).getMultChoiceAnswers().get(currentQ));
			}
		}
	}
	
	//prints the total choices for each letter chosen at the end of the program
	public void printTotalResults(ArrayList<Student> currStudent) {
		System.out.println("\nThe total amount of A's chosen: " + currStudent.get(0).getAsChosen());
		System.out.println("The total amount of B's chosen: " + currStudent.get(0).getBsChosen());
		System.out.println("The total amount of C's chosen: " + currStudent.get(0).getCsChosen());
		System.out.println("The total amount of D's chosen: " + currStudent.get(0).getDsChosen());
	}
}
