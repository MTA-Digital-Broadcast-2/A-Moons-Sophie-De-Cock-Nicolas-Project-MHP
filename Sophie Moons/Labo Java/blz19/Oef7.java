/**
 *De klasse Oef7 is een java applicatie
 *
 *@author Sophie Moons
 *@version 1,0
 */
import java.lang.*;

public class Oef7{

/**
 *Dit is een main function, hier start het programma
 *@param args -> hiermee kan een array meegegeven worden via command line
 */
public static void main(String args[])
{
int elementen[]={12,34, 56, 78, 123, 234, 99, 88};
int elementenB[]={43,86,94,23,19,54,345,2}; //moet dus een tweede array maken

//sorteert elementen[]
   for (int j = 0; j<elementen.length; j++) 
   {
        for (int k = 0; k < elementen.length; k++)
		{
            if (elementen[j] < elementen[k])
			{
                int buffer = elementen[j];
                elementen[j] = elementen[k];
                elementen[k] = buffer; 
            }
        }
    }

//sorteert elementenB[]
for(int i=0;i<elementenB.length;i++)
	{
		for (int j=0;j<elementen.length;j++)
		{
			if(elementenB[i]<elementenB[j])
			{
                int buffer = elementenB[i];
                elementenB[i] = elementenB[j];
                elementenB[j] = buffer; 
			}
		}
	}
	
	
/*//Probeersels

//grootste nummer uit elementen
    int grootsteNummer = elementen[0];
               
    for(int i=1; i< elementen.length; i++)
    {
      if(elementen[i] > grootsteNummer)
	  {
       grootsteNummer = elementen[i];
	  }
	  elementen[i]=0;
    }
	
	
 /*int i, j, temp;
     for ( i = 0; i < elementen.length - 1; i ++ ) 
     {
          for ( j=i+1; j < elementen.length; j++)
          {
               if( elementen[i] < elementen[j] )         //sorting into descending order
               {
                       temp = elementen[i];   //swapping
                       elementen[i] = elementen[j];
                       elementen[j] = temp; 
                }           
          }
     }
}



/*int i = 0;
    int volgordeNummer = elementenB[i];
               
    for(int h=1; h< elementen.length; h++)
    {
	      if(elementen[h] < volgordeNummer)
			{
			volgordeNummer = elementenB[i];
			elementen[h]=0;			
			i++;			
			}
    }*/

System.out.println("De volgende elementen zitten in Array B: ");

for(int i =0;i<elementen.length;i++)
{
System.out.println(elementenB[i]);
}

}//einde main
}//einde program