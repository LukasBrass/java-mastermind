package Mastermind;
import java.util.*;

public class Mastermind {
	
	private  ArrayList<Couleur> secretCode = new ArrayList<Couleur>();
	private ArrayList<ArrayList<Couleur>> list = new ArrayList<ArrayList<Couleur>>();
	private int choicesNumber;
  private int colorsNumber;
	private boolean win = false;
	
	public Mastermind(int choicesNumber, int colorsNumber) 
	{
    this.choicesNumber = choicesNumber;
    this.colorsNumber = colorsNumber;
    this.secretCode = createSecretCode();
    secretCode = this.secretCode;
    list = this.list;
	}
	
	
	
	public ArrayList<Couleur> createSecretCode()
	{
    Random r = new Random();
		for(int i = 0; i < choicesNumber; i++) {
			Couleur color = new Couleur(1 + r.nextInt(colorsNumber - 1));
			this.secretCode.add(color);
		}
		return secretCode;
	}
	
	public ArrayList<Integer> compareAndGetResult(ArrayList<Couleur> playerChoices)
	{
		list.add(playerChoices);
		ArrayList<Integer> result = new ArrayList<Integer>(4);
		this.win = true;
		for (Couleur color : playerChoices) {
			int comparatorResult = compareColor(color, playerChoices.indexOf(color));
			if(comparatorResult ==  0 || comparatorResult == 1)
				this.win = false;
			result.add(comparatorResult );
		}
		return result;
	}
	
	public int compareColor(Couleur playerChoice, int position)
	{
    boolean colorExists = false;
    boolean samePosition = false;
    for(Couleur secretColor : secretCode){
     if(secretColor.getColor() == playerChoice.getColor()){
       colorExists = true;
       if(secretCode.indexOf(secretColor) == position)
         samePosition = true;
     }
    }
    int result = colorExists ? 1 : 0;
    if(samePosition)
      result++;
		return result;
  }
  
  public ArrayList<Couleur> getLineByGame(int index)
  {
    try {
      return list.get( index );
    } catch ( Exception e ) {
    return null;
    }
  }
	
	public boolean getWin()
	{
		return this.win;
	}
  
  public ArrayList<Couleur> getSecretCode()
  {
    return this.secretCode;
  }
}
