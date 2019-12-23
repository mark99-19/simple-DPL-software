package secondo;
import primo.Utente;
import primo.Controllo_Autorizzazione;
import primo.Controllo_Login;
  
public class Starter {
	
	public static primo.Utente disessione = null;
	private static ClientSFTP trasferimento = null;
	//static Controllo_Login controllorelogin = new Controllo_Login();
	
	
	
	public static void main(String[] args) {
		
		
		
		//int scelta = 0;
		
			visualizzaMenu();
			Runtime.getRuntime().addShutdownHook(new Thread()
			{				//codice per CTRL + C
				public void run()
				{
					
					System.out.println("Programma terminato.");
				}
			    }
			);
		
		/* quando? */

		
		
		
		
	}
	
	private static void visualizzaMenu()
	{
		
		System.out.println("Benvenuto nel sistema di Data Loss Prevention");
		System.out.println("Effettua l'autenticazione (max. 3 tentativi)");
		System.out.println("Prestare attenzione: ogni tentativo errato verra' segnalato");
		if(autenticazione())
		{
			System.out.println("Benvenuto "+disessione.getMail()+"");
			System.out.println("La sessione comincerà a breve:");
			
			trasferimento = new ClientSFTP();
		}
		
		
	}
	
	private static boolean autenticazione()
	{
		System.out.print("Indirizzo mail: ");
		String str1 = Input.inserimento();
		String str1h = Input.sha512(str1);
		System.out.print("Password: ");
		String str2 = Input.sha512((Input.inserimento()));
		System.out.println();		
		if(Controllo_Login.controlloHash(str1h, str2))
			{
				disessione = new Utente();
				disessione.setMail(str1);
				disessione.setHmail(str1h);
				
				return true;
			}
		return false;
	}
	
	

	
}
