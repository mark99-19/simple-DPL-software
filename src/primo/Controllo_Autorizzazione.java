package primo;

import secondo.Starter;

public class Controllo_Autorizzazione {
	
	private boolean authorization = true;
	
	
	public static void controlloLivelli(int livello1, int livello2) throws Eccezione_Autorizzazione {
		/* decisione di gestione delle policy, l'utente non ha accesso al dato se il suo livello è diverso
		 * in ogni caso, oppure solo se il suo livello è minore, mentre se è maggiore ha accesso a tutti
		 * i dati inferiori */
		if(Starter.disessione.getLivello() != livello2) {
			throw new Eccezione_Autorizzazione(); 
		}
	}
	
	public void setAuthorization(boolean value) {
		this.authorization = value;
	}
	
	public boolean getAuthorization() {
		return authorization;
	}
}

//paragonare livello uenti sessione.livello con livello dati
//
    