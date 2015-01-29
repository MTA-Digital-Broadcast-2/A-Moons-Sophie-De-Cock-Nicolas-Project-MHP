import java.lang.*;	//uitzondering, deze doet hij al automatisch dus moet niet 

/**
 *De Klasse Oef4 is een java applicatie
 *
 *@Author Nicolas De Cock
 *@version 1,0
 */

public class Oef4{
	/**
	 *Dit is een main functie, hier start het programma
	 *@param args Hiermee kan een array meegegeven worden via command line
	 */
	public static void main(String args[])
	{
		int getal = 4302;
		getal = ((~getal)+1);
		System.out.println(getal);
	
	}	//einde main
}	//einde programma