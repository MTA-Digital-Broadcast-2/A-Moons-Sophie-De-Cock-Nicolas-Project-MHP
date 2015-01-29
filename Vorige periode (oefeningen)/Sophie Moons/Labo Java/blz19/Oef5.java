/**
 *De klasse Oef5 is een java applicatie
 *
 *@author Sophie Moons
 *@version 1,0
 */
import java.lang.*;

public class Oef5{

static boolean IsPriemgetal(int num)
       {
          boolean isPriemgetal = true;
          int factor = num / 2;
 
            int i = 0;
 
            for (i = 2; i <= factor; i++)
            {
                if ((num % i) == 0)
                    isPriemgetal = false;
            }
            return isPriemgetal;
        }

/**
 *Dit is een main function, hier start het programma
 *@param args -> hiermee kan een array meegegeven worden via command line
 */
 
public static void main(String args[])
{
for (int i = 3; i < 100; i++)
            {
                if (IsPriemgetal(i) == true)
                    System.out.println(i);
            }

}//einde main
}//einde program