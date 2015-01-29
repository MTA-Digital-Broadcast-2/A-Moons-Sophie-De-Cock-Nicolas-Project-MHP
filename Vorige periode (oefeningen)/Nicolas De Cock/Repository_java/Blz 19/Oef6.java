import java.lang.*;	//uitzondering, deze doet hij al automatisch dus moet niet 

/**
 *De Klasse Oef4 is een java applicatie
 *
 *@Author Nicolas De Cock
 *@version 1,0
 */

public class Oef6{
	/**
	 *Dit is een main functie, hier start het programma
	 *@param args Hiermee kan een array meegegeven worden via command line
	 */
	public static void main(String args[])
	{
		
		int a[] = {12,34,56,78,123,234,99,88};
		int grootste = 0;
		
		for(int i=0;i<8; i++)
		{
			if(a[i] > grootste)
			{
				grootste = a[i];
			}
		}
		System.out.println(grootste);
		
	}	//einde main
}	//einde programma