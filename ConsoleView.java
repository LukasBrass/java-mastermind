package Mastermind;

public class ConsoleView {
	private final int GAMELIMIT = 5;
	private final int CHOICESNUMBER = 4;
	
	public ConsoleView()
	{
		Mastermind m = new Mastermind(CHOICESNUMBER);
	}
	
	private void writeResult(int[] playerChoices)
	{
		
		for(int i = 0; i < CHOICESNUMBER; i++) {
			for(int j = 0; i < CHOICESNUMBER; i++) {
				System.out.println();
			}
		}
	}
}
