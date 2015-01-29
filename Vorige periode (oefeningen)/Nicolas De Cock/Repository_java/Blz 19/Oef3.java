import java.lang.*;	//uitzondering, deze doet hij al automatisch dus moet niet 

/**
 *De Klasse Oef2 is een java applicatie
 *
 *@Author Nicolas De Cock
 *@version 1,0
 */

public class Oef3{
	/**
	 *Dit is een main functie, hier start het programma
	 *@param args Hiermee kan een array meegegeven worden via command line
	 */
	public static void main(String args[])
	{
		double pi=0.0;
		int g =1;
		double som=0.0;
		boolean somV = true;
		
		for(int i=0;i<=10000;i++)
		{
			if(somV)
			{
				som += 1.0/g;
				somV = !somV;
			}
			else
			{
				som -= 1.0/g;
				somV = !somV;
			}
			g+=2;
		}
		
		pi = 4 * som;
		System.out.println(pi);
		
		
	
	}	//einde main
}	//einde programma