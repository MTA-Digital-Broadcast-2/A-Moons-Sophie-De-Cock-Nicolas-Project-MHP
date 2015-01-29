import java.lang.*;	//uitzondering, deze doet hij al automatisch dus moet niet 

/**
 *De Klasse Oef1 is een java applicatie
 *
 *@Author Nicolas De Cock
 *@version 1,0
 */

public class Oef1{
	/**
	 *Dit is een main functie, hier start het programma
	 *@param args Hiermee kan een array meegegeven worden via command line
	 */
	public static void main(String args[])
	{
		for(int i=1;i<=9;i++)
		{
			for(int j=1;j<=9;j++)
			{
				int p = i*j;
				System.out.println(i+"x"+j + "=" +p);
			}
		}
	
	}	//einde main
}	//einde programma