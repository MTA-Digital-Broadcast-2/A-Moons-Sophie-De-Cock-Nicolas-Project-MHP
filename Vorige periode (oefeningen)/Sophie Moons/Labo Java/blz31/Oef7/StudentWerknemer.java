/**
 *De klasse StudentWerknemer is een java applicatie
 *
 *@author Sophie Moons
 *@version 1,0
 */
import java.lang.*;

public class StudentWerknemer extends PartTimeWerknemer{
/**
 *Dit is een main function, hier start het programma
 */
 
 /**
 * Deze klasse erft over van de klasse PartTimeWerknemer
 * Dit zijn de data-leden (gegevens)
 * Daaronder staat de constructor
 */

public float rszPercentage = (float)(0.05);


public StudentWerknemer(String voornaam, String achternaam, int nr, float sal, int urenGw)
{
super(voornaam,achternaam,nr,sal, urenGw);
}

public void setRSZ(float rsz)
{
rszPercentage=rsz;
}

public float getRSZ()
{
return rszPercentage;
}

}//einde programma
