package secondo;
import primo.*;
 
class Starter {
	
	private static primo.Utente disessione = null;
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
		
		System.out.println("Benvenuto nel sistema di Data Loss Prevention");
		System.out.println("Effettua l'autenticazione (max. 3 tentativi)");
		System.out.println("Prestare attenzione: ogni tentativo errato verra' segnalato");
		if(autenticazione())
		{
			System.out.println("Benvenuto "+disessione.getMail()+"");
		}
		
		
	}
	
	private static boolean autenticazione()
	{
		System.out.print("Indirizzo mail: ");
		String str1 = Input.sha512((Input.inserimento()));
		System.out.print("Password: ");
		String str2 = Input.sha512((Input.inserimento()));
		System.out.println();		
		if(Controllo_Login.controlloHash(str1, str2))
			{
				disessione.setMail(str1);
				return true;
			}
		return false;
	}

	
}
