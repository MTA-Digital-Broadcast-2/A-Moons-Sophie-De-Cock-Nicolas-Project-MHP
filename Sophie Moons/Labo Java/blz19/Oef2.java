//bestandsnaam: Oef2.java //<-- uitzonderlijke zelf importerende bibliotheek (moet dus niet in staan feitelijk)

/**
 *De klasse Oef2 is een java applicatie
 *
 *@author Sophie Moons
 *@version 1,0
 */
import java.lang.*;

public class Oef2{

/**
 *Dit is een main function, hier start het programma
 *@param args -> hiermee kan een array meegegeven worden via command line
 */
public static void main(String args[])
{
String[] dagen={"zondag","maandag","dinsdag","woensdag","donderdag","vrijdag","zaterdag"};
int h=1;

System.out.println("Data februari 2009:\n");

while (h<29) //28 dagen toen
{
for(int i=0;i<dagen.length;i++)
{
System.out.println(dagen[i]+" "+h+" februari");
h++;
}
}


}//einde main
}//einde program