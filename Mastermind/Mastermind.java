package progJava;
import java.util.*;
import progJava.*;

public class Mastermind {
	
	private  ArrayList<Couleur> secretCode;
	private ArrayList<ArrayList<Couleur>> list;
	private int choicesNumber;
	private boolean win;
	
	public Mastermind(int colors) 
	{
	}
	
	
	
	public ArrayList<Couleur> createSecretCode()
	{
		for(int i = 0; i < choicesNumber; i++) {
			int couleur = 1;
			//int couleur = rand(couleur);
			Couleur color = new Couleur(couleur);
			secretCode.add(color);
		}
		return secretCode;
	}
	
	public ArrayList<Integer> compareAndGetResult(ArrayList<Couleur> playerChoices)
	{
		list.add(playerChoices);
		ArrayList<Integer> result = new ArrayList<Integer>();
		this.win = true;
		for (Couleur color : playerChoices) {
			int comparatorResult = compareColor(color, playerChoices.indexOf(color));
			if(comparatorResult ==  0 || comparatorResult == 1)
				this.win = false;
			result.set(playerChoices.indexOf(color), comparatorResult );
		}
		return result;
	}
	
	public int compareColor(Couleur playerChoice, int position)
	{
		int result = 0;
		if(secretCode.contains(playerChoice)) {
			result++;
			Couleur colorCode = secretCode.get(position);
			if(colorCode.toString() == playerChoice.toString())
				result++;
		}
		
		return result;
	}
	
	public boolean getWin()
	{
		return this.win;
	}
}
