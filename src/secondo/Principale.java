package secondo;
 
class Principale {
	
	static primo.Utente temporaneo = null;
	static boolean a = true;
	
	public static void main(String[] args) {
		
		int scelta = 0;
		
		do {
			visualizzaMenu();
		}
		while(a)/* quando? */;

	}
	
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
			catch(EccezioneLogin loginerrato)
			{
				System.out.println("Utenza bloccata, impossibile accedere");
			}
		visualizzaSchermataLogin();
		
	}

}
