package Mastermind;

public class Couleur {

	private int color;
	
	public Couleur(int color)
	{
		this.color = color;
	}
	
  public int getColor()
  {
    return this.color;
  }
  
  @Override
  public String toString()
  {
    return ""+this.getColor();
  }
}
