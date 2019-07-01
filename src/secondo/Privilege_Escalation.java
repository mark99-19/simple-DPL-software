package secondo;

import primo.Utente;

public class Privilege_Escalation extends Pattern{
	
	public Privilege_Escalation()
	{
		
	}
	
	private int timestamp = 0;
	private int livello_dato_tentato;
	private int livello_utente_attuale;
	private Utente utente_collegato;
	private String indirizzo_ip;
	/*Da completare con i campi che ho messo nel db*/
	
	
	public int getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}
	public int getLivello_dato_tentato() {
		return livello_dato_tentato;
	}
	public void setLivello_dato_tentato(int livello_dato_tentato) {
		this.livello_dato_tentato = livello_dato_tentato;
	}
	public int getLivello_utente_attuale() {
		return livello_utente_attuale;
	}
	public void setLivello_utente_attuale(int livello_utente_attuale) {
		this.livello_utente_attuale = livello_utente_attuale;
	}
	public Utente getUtente_collegato() {
		return utente_collegato;
	}
	public void setUtente_collegato(Utente utente_collegato) {
		this.utente_collegato = utente_collegato;
	}
	public String getIndirizzo_ip() {
		return indirizzo_ip;
	}
	public void setIndirizzo_ip(String indirizzo_ip) {
		this.indirizzo_ip = indirizzo_ip;
	} 

	
	
	
	
}
