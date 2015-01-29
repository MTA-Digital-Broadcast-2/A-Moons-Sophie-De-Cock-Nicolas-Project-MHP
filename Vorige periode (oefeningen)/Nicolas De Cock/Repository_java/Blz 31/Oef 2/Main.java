import java.lang.*;	//uitzondering, deze doet hij al automatisch dus moet niet 


public class EersteProg{
	
	public static void main(String args[])
	{
		Werknemer nico;
		Werknemer bert;
		Werknemer jan;
		Werknemer karel;
		
		nico = new Werknemer("Nicolas","de cock",1,(float)1200.0);
		bert = new Werknemer("Bert","de Coninck",2,(float)1000.0);
		jan = new Werknemer("Jan","Akkermans",3,(float)1750.0);
		karel = new Werknemer("Karel","Van Praag",4,(float)1450.0);
		
		nico.salarisVerhogen(10);
		bert.salarisVerhogen(10);
		
		System.out.println(nico.getSalaris());
		System.out.println(bert.getSalaris());
		System.out.println(jan.getSalaris());
		System.out.println(karel.getSalaris());
	
	}	//einde main
}	//einde programma