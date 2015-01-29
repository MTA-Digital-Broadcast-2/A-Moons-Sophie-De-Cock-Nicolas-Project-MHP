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
Factuur factuur1 = new Factuur(1203973, (float)23200.34);

factuur1.betaal();

}//einde main
}//einde programma