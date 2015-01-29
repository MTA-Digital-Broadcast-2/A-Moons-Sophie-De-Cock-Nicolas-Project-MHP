import java.lang.*;	//uitzondering, deze doet hij al automatisch dus moet niet 

/**
 *De Klasse Oef2 is een java applicatie
 *
 *@Author Nicolas De Cock
 *@version 1,0
 */

public class Oef2{
	/**
	 *Dit is een main functie, hier start het programma
	 *@param args Hiermee kan een array meegegeven worden via command line
	 */
	public static void main(String args[])
	{
		String dag = "zondag";
		int cycle=0;
		
		for(int i=1;i<=28;i++)
		{
			switch(cycle)
			{
				case 0: dag = "zondag";
						cycle++;
					break;
				case 1: dag = "maandag";
						cycle++;
					break;
				case 2: dag = "dinsdag";
						cycle++;
					break;
				case 3: dag = "woensdag";
						cycle++;
					break;
				case 4: dag = "donderdag";
						cycle++;
					break;
				case 5: dag = "vrijdag";
						cycle++;
					break;
				case 6: dag = "zaterdag";
						cycle=0;
					break;
			}
			System.out.println(dag + " " + i + " februari 2009");
			
		}
	
	}	//einde main
}	//einde programma