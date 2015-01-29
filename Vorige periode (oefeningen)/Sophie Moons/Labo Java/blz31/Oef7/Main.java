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
PartTimeWerknemer harry = new PartTimeWerknemer("Harry","Pjotter",26,2540,6);
Werknemer gerrit = new Werknemer("Gerrit","Demesmaeker",32,2321);
StudentWerknemer lilo = new StudentWerknemer("Lilo","Debruyn",20,1800,7);

harry.setRSZ((float)0.45);

System.out.println("Harry zijn RSV percentage is: "+gerrit.getRSZ());
System.out.println("Gerrit zijn RSV percentage is: "+harry.getRSZ());
System.out.println("Lilo zijn RSV percentage is: "+lilo.getRSZ());

}//einde main
}//einde programma