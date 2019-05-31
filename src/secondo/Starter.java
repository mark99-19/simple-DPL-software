package secondo;
import primo.*;
 
class Principale {
	
	static primo.Utente temporaneo = null;
	//static Controllo_Login controllorelogin = new Controllo_Login();
	
	
	
	public static void main(String[] args) {
		
		//int scelta = 0;
		
		do {
			visualizzaMenu();
		}
		while(true)/* quando? */;

	}
	
	private static void visualizzaMenu()
	{
		
		System.out.println("Benvenuto nel Data Loss Prevention");
		System.out.println("Effettua l'autenticazione (max. 3 tentativi)");
		System.out.println("Prestare attenzione: ogni tentativo errato verrà segnalato");
		autenticazione();
		
		
	}

	private static void autenticazione()
	{
		System.out.print("Indirizzo mail: ");
		String str1 = Input.inserimento();
		System.out.print("Password: ");
		System.out.println();
		String str2 = Input.inserimento();
		Controllo_Login.controlloHash(str1, str2);
	}

}
