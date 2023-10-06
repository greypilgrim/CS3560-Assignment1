import java.util.ArrayList;
import java.util.Random;
/**
 * @author jmcgr
 *SimulationDriver facilitates a simulation of a random number of students answers both multiple and single choice questions
 */
public class SimulationDriver {
	public static void main(String[] args) {
		//sets the min/max number of students to be randomly created, and the total questions that can be asked
		final int MIN_NUM_OF_STUDENTS = 6;
		final int MAX_NUM_OF_STUDENTS = 11;
		final int TOTAL_QUESTIONS = 10;
		//variable to identify which question type has been randomly chosen by the driver
		int questionChosen;
		
		//create objects and list for the students to be created
		Question sChoice = new SingleChoiceQuestion();
		Question mChoice = new MultipleChoiceQuestion();
		Random randomNum = new Random();
		ArrayList<Student> listOfStudents = new ArrayList<Student>();
		
		//randomly choose the number of students to be created
		int numOfStudents = randomNum.nextInt(MAX_NUM_OF_STUDENTS - MIN_NUM_OF_STUDENTS) + MIN_NUM_OF_STUDENTS;
		//create VotingService object from the amount of students created
		VotingService service = new VotingService(numOfStudents);
		
		//populates a list of students
		generateList(numOfStudents, listOfStudents);
		
		//prints basic info to the screen before asking questions
		System.out.println("There are " + service.getTotalStudents() + " total students");
		System.out.println("All unique student ID's:\n");
		for(int i = 0; i < listOfStudents.size(); i++) {
			System.out.println(listOfStudents.get(i).getStudentID());
		}
		System.out.println();
		
		//prints the question randomly chosen to the screen and simulates each student making a choice
		for(int i = TOTAL_QUESTIONS; i > 0; --i) {
			int presentQ = 0;
			questionChosen = passQtoStudent(chooseQuestion(sChoice, mChoice, service));
			for(int j = 0; j < listOfStudents.size(); j++) {
				listOfStudents.get(j).makeChoice(questionChosen);
			}
			//prints which students made which choices for each question
			service.printQResults(listOfStudents, presentQ, questionChosen);
		}
		//prints total results once all questions have been asked and answered
		service.printTotalResults(listOfStudents);
	}
	
	//populates the list of students based on random number of students chosen to be created
	public static void generateList(int numOfStudents, ArrayList<Student> listOfStudents) {
		for(int i = 1; i <= numOfStudents; i++) {
			Student studentToBeAdded = new Student();
			listOfStudents.add(studentToBeAdded);
		}
	}
	
	//randomly chooses which question will be asked next
	public static int chooseQuestion(Question questionType0, Question questionType1, VotingService service) {
		Random randNum = new Random();
		int randQuestion;
		
		if(service.getmultQsLeft() > 0 && service.getSingQsLeft() > 0) {
			randQuestion = randNum.nextInt(2);
		}
		else if(service.getSingQsLeft() == 0) {
			randQuestion = 1;
		}
		else if(service.getmultQsLeft() == 0) {
			randQuestion = 0;
		}
		else
			randQuestion = -1;
		
		if(randQuestion == 0 && service.getSingQsLeft() != 0) {
			questionType0.getQuestion(service.getSingQsLeft());
			service.decSingQsLeft();
		}
		if(randQuestion == 1 && service.getmultQsLeft() != 0) {
			questionType1.getQuestion(service.getmultQsLeft());
			service.decMultQsLeft();
		}
		return randQuestion;
	}
	
	//returns the value(0/1) to be passed to each student in order to identify which set of answers are possible
	public static int passQtoStudent(int choice) {
		int questionChosen = choice;
		return questionChosen;
	}	
}
