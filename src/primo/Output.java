package primo;
 
import secondo.*;

class Output {
	
	public static void visualizzaMenu()
	{
		
		System.out.println("Benvenuto nel Data Loss Prevention");
		System.out.println("Effettua l'autenticazione (max. 3 tentativi)");
		System.out.println("Prestare attenzione: ogni tentativo errato verrà segnalato");
		try
		{
			Controllo_Utente.controlloContatore(temporaneo.getContatore());
		} 
			catch(Exception errore)
			{
				
			}
			catch(Eccezione_Login loginerrato)
			{
				System.out.println("Utenza bloccata, impossibile accedere");
			}
		visualizzaSchermataLogin();
		
	}
	
	public static void visualizzaSchermataLoginGiusta()			//magari private?
	{
		
	}
	
	public static void visualizzaSchermataLoginErrata()			//magari private?
	{
		
	}
	
	public static void visualizzaSchermataLoginCaptcha()			//magari private?
	{
		
	}
}
