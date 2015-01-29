import java.lang.*;	//uitzondering, deze doet hij al automatisch dus moet niet 


public class Werknemer implements Betaalbaar{
	
	public String voornaam;
	public String achternaam;
	public int werknemerNummer;
	protected float salaris;
	private float RSZpercentage = (float)0.33;
	
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
	
	public void setRSZ(float RSZ)
	{
		RSZpercentage = RSZ;
	}
	
	public float getRSZ()
	{
		return RSZpercentage;
	}
	
	public void betaal()
	{
		System.out.println("Betaal het salaris van " + getSalaris() + " aan de werknemer " + this.voornaam + " !!");
		//String s = "Betaal het salaris van " + this.salaris + " aan de werknemer " + this.voornaam + " !!";
		//return s;
	}
	
}	//einde programma