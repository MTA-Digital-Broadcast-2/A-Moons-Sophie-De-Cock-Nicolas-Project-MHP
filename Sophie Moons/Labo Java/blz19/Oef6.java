//bestandsnaam: Oef6.java //<-- uitzonderlijke zelf importerende bibliotheek (moet dus niet in staan feitelijk)

/**
 *De klasse Oef6 is een java applicatie
 *
 *@author Sophie Moons
 *@version 1,0
 */
import java.lang.*;

public class Oef6{

/**
 *Dit is een main function, hier start het programma
 *@param args -> hiermee kan een array meegegeven worden via command line
 */
public static void main(String args[])
{
int elementen[]={12,34, 56, 78, 123, 234, 99, 88};

    int grootsteNummer = elementen[0];
               
    for(int i=1; i< elementen.length; i++)
    {
      if(elementen[i] > grootsteNummer)
	  {
       grootsteNummer = elementen[i];     
	  }
    }
	
System.out.println("Het grootste nummer in de reeks is: "+grootsteNummer);

}//einde main
}//einde program