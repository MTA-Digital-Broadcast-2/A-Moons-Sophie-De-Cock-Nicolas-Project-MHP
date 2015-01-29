/**
 *De klasse Main is een java applicatie
 *
 *@author Sophie Moons
 *@version 1,0
 */
import java.lang.*;

public class Main{

/**
 *Dit is een main function, hier start het programma
 *@param args -> hiermee kan een array meegegeven worden via command line
 */
public static void main(String args[])
{
Werknemer david = new Werknemer("David", "Davidse", 24, 2000);
Werknemer jolien = new Werknemer("Jolien", "Harman", 22, 1900);
Werknemer fred = new Werknemer("Fred", "Fredrickson", 12, 2000);
Werknemer jaap = new Werknemer("Jaap", "Jan", 14, 2000);

System.out.println(david.werknemerNummer);


}//einde main
}//einde programma