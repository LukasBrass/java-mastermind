package Mastermind;
import java.util.*;
import java.util.Scanner;

public class ConsoleView {
	private int GAMELIMIT;
	private int CHOICESNUMBER;
  private boolean cheatMode = false;
  public ArrayList<Couleur> PlayerChoices;
  private Mastermind m;
	
	public ConsoleView(int gameLimit, int choicesNumber, int colorsNumber)
	{
    this.GAMELIMIT = gameLimit;
    this.CHOICESNUMBER = choicesNumber;
    this.m = new Mastermind(choicesNumber, colorsNumber);
	}
  
  public void start()
  { 
    Scanner input = new Scanner(System.in);
    int counter = 0;
    String typed;
    
    this.showExplanations();
    
    while(!m.getWin()){
      this.show();
      counter++;
      if(counter > GAMELIMIT)
        break;
      PlayerChoices = new ArrayList<Couleur>(GAMELIMIT);
      System.out.println("Menu : pour lancer le mode triche, entrez \"t\", sinon entrez \"play\"");
      typed = input.next();
      if(typed.charAt(0) == 't')
      {
        this.cheatMode = !this.cheatMode;
        System.out.println("Mode triche "+ (this.cheatMode ? "activé" : "désactivé"));
        this.show();
      }
      for(int i = 1; i <= CHOICESNUMBER; i++){
        System.out.println("Choix de la couleur en position "+i+" : ");
        PlayerChoices.add(new Couleur(input.nextInt()));
      }
      System.out.println(this.addToString("Vous avez choisi",PlayerChoices));
      System.out.println(this.addToString("Voici les réponses :", this.translateResponse(m.compareAndGetResult(PlayerChoices))));
    }
    this.thisIsTheEnd();
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
          System.out.print(" - ");
      }
    System.out.println("|");
    }
    
    if(this.cheatMode)
      System.out.println(this.addToString("|", m.getSecretCode())+" |");
  }
  
    private void thisIsTheEnd()
  {
    if(m.getWin())
      System.out.println("Bravo, Vous avez trouvé la bonne combinaison ! ");
    else
      System.out.println("C'est raté :/");
    this.show();
    System.out.println(this.addToString("Le bon résultat était :", m.getSecretCode()));
  }
  
  private ArrayList<String> translateResponse(ArrayList<Integer> result)
  {
    ArrayList<String> responseList = new ArrayList<String>(CHOICESNUMBER);
    for(int response : result) {
      switch(response) {
        case 0 : responseList.add("X");
          break;
        case 1 : responseList.add("~");
          break;
        case 2 : responseList.add("O");
          break;
      }
    }
    return responseList;
  }
  
  private String addToString(String string, ArrayList<?> array)
  {
    for(Object var : array) {
      string += " "+var;
    }
    return string;
  }
  
  private void showExplanations()
  {
    System.out.println("Quelques explications : Les couleurs sont des numéros, allant de 1 à ce que vous avez choisi précédemment.");
    System.out.println("Lors d'un resultat : ");
    System.out.println("Le symbole X signifie que cette couleur est une mauvaise couleur,");
    System.out.println("Le symbole ~ signifie que cette couleur existe mais n'est pas placée au bon endroit,");
    System.out.println("Le symbole O signifie que cette couleur existe et est au bon endroit");
  }
  
}
