/**
 * @author jmcgr
 *
 */
public class MultipleChoiceQuestion implements Question {
	//a character set so when a question is being printed, the list can be started with a-d, respectively
	private char c = 'a';
	//question set
	private String 
	q1 = "What is the capital of California?", 
	q2 = "How many justices make up the United States Supreme Court?", 
	q3 = "How many states are in the US?", 
	q4 = "What is the official NBA team of Los Angeles?", 
	q5 = "Which Ninja Turle are you?";
	
	//2D array to hold the questions and their possible answers
	private String[][] QASet;
	
	//constructor creates the choice object and the 2D array that hold the questions and their answers
	MultipleChoiceQuestion(){
		generateQASet();
	}

	@Override
	public void generateQASet() {
		QASet = new String[][]{
			{q1,"Canada", "Sacramento", "New Orleans", "Seattle"},
			{q2, "1", "85", "9", "13"}, 
			{q3, "7", "48", "50", "52"},
			{q4, "The Dodgers", "The Golden State Warriors", "The Lakers", "The 49ers"},
			{q5, "Leonardo", "Raphael", "Donatello", "Michelangelo"}};
	}

	@Override
	public void getQuestion(int questionNumber) {
		c = 'a';
		int questionLocation = questionNumber - 1;
		
		System.out.println("\n" + QASet[questionLocation][0]);
		for(int i = 1; i < QASet[questionLocation].length; i++, c++) {
			System.out.print(c + ") " + QASet[questionLocation][i] + "\n");
			}
	}

}
