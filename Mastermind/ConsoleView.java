package Mastermind;
import java.util.*;
import java.util.Scanner;

public class ConsoleView {
	private final int GAMELIMIT = 5;
	private final int CHOICESNUMBER = 4;
  public ArrayList<Couleur> PlayerChoices;
  private Mastermind m = new Mastermind(CHOICESNUMBER);
	
	public ConsoleView()
	{
    this.m = m;
	}
	
	private void writeResult(int[] playerChoices)
	{
		
		for(int i = 0; i < CHOICESNUMBER; i++) {
			for(int j = 0; i < CHOICESNUMBER; i++) {
				System.out.println();
			}
		}
	}
  
  public void start()
  {
    Scanner input = new Scanner(System.in);
    int counter = 0;
    while(!m.getWin()){
      this.show();
      counter++;
      if(counter > GAMELIMIT)
        break;
      PlayerChoices = new ArrayList<Couleur>(GAMELIMIT);
      for(int i = 1; i <= CHOICESNUMBER; i++){
        System.out.println("Choix de la couleur en position "+i+" : ");
        PlayerChoices.add(new Couleur(input.nextInt()));
      }
      System.out.println("Vous avez choisi "+PlayerChoices.get(0)+" "+PlayerChoices.get(1)+" "+PlayerChoices.get(2)+" "+PlayerChoices.get(3));
      ArrayList<Integer> result = m.compareAndGetResult(PlayerChoices);
      System.out.println("Voici les réponses "+result.get(0)+" "+result.get(1)+" "+result.get(2)+" "+result.get(3));
    }
    this.show();
   
    if(m.getWin())
      System.out.println("Bravo, Vous avez trouvé la bonne combinaison ! ");
    else
      System.out.println("C'est raté :/");
  }
  
  private void show()
  {
    ArrayList<Couleur> list;
    for(int i = 0; i < GAMELIMIT; i++) {
      System.out.print("|");
      list = m.getLineByGame(i);
      for(int j = 0; j < CHOICESNUMBER; j++) {
        if(list != null && list.get(j) != null)
          System.out.print(" "+list.get(j)+" ");
        else
          System.out.print(" o ");
      }
    System.out.println("|");
    }
  }
  
  private void showResult()
  {
    
  }
}
