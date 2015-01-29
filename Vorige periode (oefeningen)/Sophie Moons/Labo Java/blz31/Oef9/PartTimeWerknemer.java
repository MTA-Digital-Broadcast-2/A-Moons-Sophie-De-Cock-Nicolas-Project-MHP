/**
 *De klasse PartTimeWerknemer is een java applicatie
 *
 *@author Sophie Moons
 *@version 1,0
 */
import java.lang.*;

public class PartTimeWerknemer extends Werknemer{
 /**
 * Deze klasse erft over van de klasse Werknemer
 * Dit zijn de data-leden (gegevens)
 * Daaronder staat de constructor
 */
 
public int urenGewerkt;

public PartTimeWerknemer(String voornaam, String achternaam, int nr, float sal, int urenGw)
{
super(voornaam,achternaam,nr,sal); //erft over van Werknemer (de superklasse)
this.urenGewerkt=urenGw;
}

public void salarisVerhogen(int percentage)
{
if(percentage>5)
{
percentage=0;
System.out.println("Fout: slechts 5% opslag toegestaan.");
}
else
{
super.salarisVerhogen(percentage); //super moet erbij staan voor de overgeërfde methode aan te roepen
}
}

public float getWeekLoon()
{
return this.salaris*(float)this.urenGewerkt;
}

}//einde programma
