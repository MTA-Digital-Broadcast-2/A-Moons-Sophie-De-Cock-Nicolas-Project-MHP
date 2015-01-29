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
	
	System.out.println("dit is mijn eerste Java programmatje\n");

	int a;
	float b;
	a = 5;
	a = a+1;
	b = 3.3F;		//F dient om ineens float te maken en niet een double (anders error "double to float")
	b=b-0.01F;
	System.out.println("a = " + a + "\nen b = "+b);

	if(a>b)
	{
	System.out.println("\n"+a+" is groter dan "+b);		//vergelijking geeft een boolean
	}






	}	//einde main
}	//einde programma