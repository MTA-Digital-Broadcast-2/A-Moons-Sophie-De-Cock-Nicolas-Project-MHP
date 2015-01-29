import java.lang.*;	//uitzondering, deze doet hij al automatisch dus moet niet 


public class Faktuur implements Betaalbaar{
	
	public int faktuurNr;
	public int faktuurBedrag;
	
	public Faktuur(int initNr, int initBedrag)
	{
		faktuurNr = initNr;
		faktuurBedrag = initBedrag;
	}
	
	public String betaal(float sal, String naam)
	{
		String s = "Betaal het faktuur " + naam + " voor een bedrag van " + sal + " !";
		return s;
	}
	
}	//einde programma