import java.lang.*;	//uitzondering, deze doet hij al automatisch dus moet niet 


public class Werknemer{
	
	public String voornaam;
	public String achternaam;
	public int werknemerNummer;
	protected float salaris;
	
	public Werknemer(String initVoornaam,String initAchternaam,int initwNummer, float initSalaris)
	{
		voornaam = initVoornaam;
		achternaam = initAchternaam;
		werknemerNummer = initwNummer;
		salaris = initSalaris;
	}
	
	public void salarisVerhogen(int percentage)
	{
		float verhogingsfactor = (float)percentage/100;
		salaris += salaris * verhogingsfactor;
	}
	
	public float getSalaris()
	{
		return salaris;
	}
	
}	//einde programma