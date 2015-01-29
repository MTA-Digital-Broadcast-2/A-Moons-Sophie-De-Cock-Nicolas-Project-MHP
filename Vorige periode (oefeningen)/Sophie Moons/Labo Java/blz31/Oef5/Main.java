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
PartTimeWerknemer gerrit = new PartTimeWerknemer("Gerrit","Demesmaeker",32,2321,7);

System.out.println("Harry zijn loon: "+harry.salaris);
System.out.println("Gerrit zijn loon: "+gerrit.salaris);

harry.salarisVerhogen(10);

System.out.println("Harry zijn loon na promotie: "+harry.salaris);
System.out.println("Gerrit zijn loon na promotie: "+gerrit.salaris);

}//einde main
}//einde programma