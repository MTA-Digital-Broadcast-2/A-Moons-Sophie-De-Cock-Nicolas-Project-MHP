/**
 *De klasse PartTimeWerknemer is een java applicatie
 *
 *@author Sophie Moons
 *@version 1,0
 */
import java.lang.*;

public class Factuur implements Betaalbaar{
/**
 *Dit is een main function, hier start het programma
 */

 
public int factuurNr;
public float factuurBedrag;

public Factuur(int factuurNr,float factuurBedrag)
{
this.factuurNr=factuurNr;
this.factuurBedrag=factuurBedrag;
}

public void betaal()
{
System.out.println("Betaal het factuur "+factuurNr+" voor een bedrag van "+factuurBedrag);
}

}//einde programma
