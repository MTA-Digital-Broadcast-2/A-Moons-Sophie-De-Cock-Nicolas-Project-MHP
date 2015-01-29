import java.lang.*;	//uitzondering, deze doet hij al automatisch dus moet niet 


public class PartTimeWerknemer extends Werknemer{
	
	public int urenGewerkt;
	
	public PartTimeWerknemer(String initVoornaam,String initAchternaam,int initwNummer, float initSalaris, int initUrengw)
	{
		super(initVoornaam,initAchternaam,initwNummer,initSalaris);
		urenGewerkt = initUrengw;
	}
	
	public float getWeekLoon()
	{
		return this.salaris * (float)this.urenGewerkt;
	}
	
}	//einde programma