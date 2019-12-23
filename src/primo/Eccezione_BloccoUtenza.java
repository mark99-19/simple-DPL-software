package primo;

import java.util.Timer;
import java.util.TimerTask;

public class Eccezione_BloccoUtenza extends Exception{
	  
	//eccezione login_error catturata nel catch di controllo_hash
	//eccezione quando rs è null
	
	//eccezione_login deve bloccare l'utenza PER UN CERTO TEMPO da quando viene chiamata
	
	//aggiunge il token al datbase e dopo mezz ora lo rimuove 
 
	/**
	 * 
	 */
	Timer timer = new Timer();
	TimerTask task = new TaskData();
	Token tokenUtente = new Token();

	tokenUtente.addToken();
	timer.schedule(task, 1800000);

} 
   