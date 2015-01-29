//bestandsnaam: EersteProg.java 

/**
 *De klasse EersteProg is een java applicatie
 *
 *@Author Sophie Moons
 *@version 1.0
 */

import java.lang.*;//<-- uitzonderlijke zelf importerende bibliotheek (moet dus niet in staan feitelijk)

public class EersteProg{

/**
 *Dit is een main function, hier start het programma
 *@param args -> hiermee kan een array meegegeven worden via command line
 */
public static void main(String args[])
{
//Nummers
int a;
float b;
a=5;
a=a+1;
b=3.3F;//3.3 moet manueel moeten geconverteerd worden naar float
b=b-0.1F;//0.1 moet manueel moeten geconverteerd worden naar float

System.out.println("a="+a+" b="+b+"\n");

if (a>b)
{
System.out.println(a+" is groter dan "+b+"\n");
}

//Operatoren

int c,d,e;
c=100;
d=200;
e=c+d;

System.out.println(c+"+"+d+"="+e);


int x,y,z;
x=80;
y=20;
z=y%x; 

System.out.println(y+"%"+x+"="+z);

//Commentaar oefening
/**
 *Hier wordt de methode drukaf opgeroepen
 *@param drukAf -> hiermee wordt de methode drukaf opgeroepen (100 is de meegegeven parameter)
 */
drukAf(100);

/**
 *Dit is een methode
 *@param drukAf -> de waarde a zal m-aantal keer worden geprint bij het oproepen en daarbij altijd met 1 verhogen
 */
}//einde main

private static void drukAf (int m) //indien public -> ziet het WEL in html pagina
{
int a;
for(a=0;a<m;a++)
{
System.out.println(a);
}
}//einde methode drukaf (methodes moeten buiten main blijven)

}//einde program