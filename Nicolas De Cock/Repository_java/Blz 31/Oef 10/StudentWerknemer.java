import java.lang.*;	//uitzondering, deze doet hij al automatisch dus moet niet 


public class StudentWerknemer extends PartTimeWerknemer{
	
	public StudentWerknemer(String initVoornaam,String initAchternaam,int initwNummer, float initSalaris, int initUrengw)
	{
		super(initVoornaam,initAchternaam,initwNummer,initSalaris,initUrengw);
		super.setRSZ((float)0.05);
	}
	
	
}	//einde programma