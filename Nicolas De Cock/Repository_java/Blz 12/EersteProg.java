import java.lang.*;	//uitzondering, deze doet hij al automatisch dus moet niet 

/**
 *De Klasse EersteProg is een java applicatie
 *
 *@Author Nicolas De Cock
 *@version 1,0
 */

public class EersteProg{
	/**
	 *Dit is een main functie, hier start het programma
	 *@param args Hiermee kan een array meegegeven worden via command line
	 */
	public static void main(String args[])
	{
		drukaf(100);
	}	//einde main
	
	/**
	 * Dit is een methode die een lus zal doorlopen en elke keer een getal zal afdrukken
	 *@param m Hiermee wordt een int meegegeven die zal bepalen hoeveel keer er door de lus wordt gelopen
	 */
	private static void drukaf(int m)
	{
		int a;
		for(a=0;a<m;a++)
		{
			System.out.println(a);
		}		
	}
	
}	//einde programma