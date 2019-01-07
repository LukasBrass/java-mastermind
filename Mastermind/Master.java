package Mastermind;
import java.util.*;

public class Master
{
	public static void main(String[] args)
	{
    Scanner input = new Scanner(System.in);
    System.out.println("Veuillez choisir le nombre de tours possibles : ");
    int gameLimit = input.nextInt();
    System.out.println("Veuillez choisir le nombre de couleurs possibles : ");
    int colorNumber = input.nextInt();
    System.out.println("Veuillez choisir le nombre de cases par tour : ");
    int choicesNumber = input.nextInt();
		ConsoleView c = new ConsoleView(gameLimit, choicesNumber, colorNumber);
		c.start();
	}
}