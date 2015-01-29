//bestandsnaam: Oef3.java //<-- uitzonderlijke zelf importerende bibliotheek (moet dus niet in staan feitelijk)

/**
 *De klasse Oef3 is een java applicatie
 *
 *@author Sophie Moons
 *@version 1,0
 */
import java.lang.*;

public class Oef3{

/**
 *Dit is een main function, hier start het programma
 *@param args -> hiermee kan een array meegegeven worden via command line
 */
public static void main(String args[])
{
float som=0;
boolean plusOFMin=true;
int deler=1;

for(int i=1;i<10001;i++)
{

if(plusOFMin)
{
som+=1.0/deler;
plusOFMin=!plusOFMin;
}
else
{
som-=1.0/deler;
plusOFMin=!plusOFMin;
}

deler+=2;
}

float uitkomstPi=4*som;

System.out.println(uitkomstPi);

}//einde main
}//einde program