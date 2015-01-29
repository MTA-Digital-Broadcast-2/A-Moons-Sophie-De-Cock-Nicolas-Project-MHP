/**
 *De klasse Werknemer is een java applicatie
 *
 *@author Sophie Moons
 *@version 1,0
 */
import java.lang.*;

public class Werknemer{
/**
 *Dit is een main function, hier start het programma
 */
 
 /**
 * Dit zijn de data-leden (gegevens)
 * Daaronder staat de constructor
 */
 
public String voornaam;
public String achternaam;
public int werknemerNummer;
protected float salaris;

public Werknemer(String voornaam, String achternaam, int wNummer, float salaris)
{
this.voornaam=voornaam;
this.achternaam=achternaam;
werknemerNummer=wNummer;
this.salaris=salaris;
}

public void salarisVerhogen(int percentage)
{
float verhogingsFactor=(float)percentage/100;
salaris+=salaris*verhogingsFactor;
}

public float getSalaris()
{
return salaris;
}

}//einde programma
