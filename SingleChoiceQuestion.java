/**
 * 
 */

/**
 * @author jmcgr
 *
 */
public class SingleChoiceQuestion implements Question {
	//a character set so when a question is being printed, the list can be started with a-d, respectively 
	private char c = 'a';	
	//question set
	private String 
		q1 = "There are 7 continents in the world", 
		q2 = "Thomas Jefferson was the first president of the United States", 
		q3 = "Camels have three sets of eyelids", 
		q4 = "Herbivore animals consume meat", 
		q5 = "Led Zeppelin is the greatest band ever";
	
	//2D array to hold the questions and their possible answers
	private String[][] QASet;
	
	//constructor creates the choice object and the 2D array that hold the questions and their answers
	SingleChoiceQuestion(){
		generateQASet();
	}
	
	@Override
	public void generateQASet() {
		QASet = new String[][]{
			{q1, "true", "false"},
			{q2, "true", "false"}, 
			{q3, "true", "false"},
			{q4, "true", "false"},
			{q5, "true", "false"}};
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
