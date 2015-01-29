import java.lang.*;	//uitzondering, deze doet hij al automatisch dus moet niet 


public class PartTimeWerknemer extends Werknemer{
	
	public int urenGewerkt;
	
	public PartTimeWerknemer(String initVoornaam,String initAchternaam,int initwNummer, float initSalaris, int initUrengw)
	{
		super(initVoornaam,initAchternaam,initwNummer,initSalaris);
		urenGewerkt = initUrengw;
	}
	
	public float getWeekLoon()
	{
		return this.salaris * (float)this.urenGewerkt;
	}
	
	public void salarisVerhogen(int percentage)
	{
		if(percentage > 5)
		{
			percentage = 0;
			System.out.println("Fout: slecht 5% opslag toegestaan !! pech gehad");
		}
		else
		{
			super.salarisVerhogen(percentage);
		}
	}
	
	
}	//einde programma