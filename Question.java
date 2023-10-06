/**
 * @author jmcgr
 *
 */
public interface Question {
	/**
	 * generateQASet() takes the set of prewritten questions, and instantiates a 2D array that stores both the question(as the first entry in the row),
	 * followed by the potential answers to that question in the columns
	 */
	public void generateQASet();
	
	/**
	 * getQuestion(), when called by the SimulationDriver, will print to the screen the question and potential answers to the screen
	 * @param questionNumber, the value that determines which question within the set of questions will be printed to the screen
	 */
	public void getQuestion(int questionNumber);
}
