/**
 * 
 */
import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * @author jmcgr
 *This class will allow for student objects to be created in order to simulate those student answering random questions
 */
public class Student {
	//random number generators to create unique student IDs and random choices made by each student
	Random IDGenerator = new Random();
	Random randChoice = new Random();
	
	//hashmap to hold character answers(a-d) for each question
	HashMap<Integer, Character> answerMap;
	
	//a lists of multiple choice and single choice answers chosen by students
	private ArrayList<Character> multipleChoiceAnswers;
	private ArrayList<Character> singleChoiceAnswers;
	
	//variables to store values used by methods of the student class, instantiated within said methods
	private char choiceMade;
	private int generatedID;
	private int choiceNum;
	private String uniqueStudentID = "011";
	private static int asChosen, bsChosen, csChosen,dsChosen;
	
	//constructor creates the student object and creates the student's unique ID, 
	//the hashmap of question answers, and the choices made for each question
	Student(){
		generateUniqueID();
		generateAnswerMap();
		generateAnswerList();
	}
	
	//creates unique student ID
	private void generateUniqueID() {
		generatedID = IDGenerator.nextInt(999999)+ 100000;
		uniqueStudentID += Integer.toString(generatedID);
	}
	
	//returns the unique ID as a string
	public String getStudentID() {
		return uniqueStudentID;
	}
	
	//creates the answer key hashmap
	public void generateAnswerMap() {
		answerMap = new HashMap<Integer, Character>();
		answerMap.put(0, 'a');
		answerMap.put(1, 'b');
		answerMap.put(2, 'c');
		answerMap.put(3, 'd');
	}
	
	//creates the list for chosen answers
	public void generateAnswerList() {
		multipleChoiceAnswers = new ArrayList<Character>();
		singleChoiceAnswers = new ArrayList<Character>();
	}
	
	//allows the student object to select an answer to a given question, and increments the total of each answer chosen
	public void makeChoice(int questionType) {
		if(questionType == 0) {
			choiceNum = randChoice.nextInt(2);
			if(choiceNum == 0) {
				choiceMade = answerMap.get(0);
				singleChoiceAnswers.add(choiceMade);
				++asChosen;
			}
			else if(choiceNum == 1) {
				choiceMade = answerMap.get(1);
				singleChoiceAnswers.add(choiceMade);
				++bsChosen;
			}
		}
		else if(questionType == 1) {
			choiceNum = randChoice.nextInt(4);
			if(choiceNum == 0) {
				choiceMade = answerMap.get(0);
				multipleChoiceAnswers.add(choiceMade);
				++asChosen;
			}
			else if(choiceNum == 1) {
				choiceMade = answerMap.get(1);
				multipleChoiceAnswers.add(choiceMade);
				++bsChosen;
			}
			else if(choiceNum == 2) {
				choiceMade = answerMap.get(2);
				multipleChoiceAnswers.add(choiceMade);
				++csChosen;
			}
			else if(choiceNum == 3) {
				choiceMade = answerMap.get(3);
				multipleChoiceAnswers.add(choiceMade);
				++dsChosen;
			}
		}
	}
	
	//list of multiple choice answers chosen
	public ArrayList<Character> getMultChoiceAnswers() {
		return multipleChoiceAnswers;
	}
	
	//list of single choice answers chosen
	public ArrayList<Character> getSingChoiceAnswers() {
		return singleChoiceAnswers;
	}
	
	//returns the total amount of 'a' answers chosen
	public int getAsChosen(){
		return asChosen;
	}
	
	//returns the total amount of 'b' answers chosen
	public int getBsChosen(){
		return bsChosen;
	}
	
	//returns the total amount of 'c' answers chosen
	public int getCsChosen() {
		return csChosen;
	}
	
	//returns the total amount of 'd' answers chosen
	public int getDsChosen() {
		return dsChosen;
	}
}
