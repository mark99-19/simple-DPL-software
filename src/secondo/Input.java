package secondo;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.*;
 

public class Input {
	
	/*InputStreamReader tastiera = new InputStreamReader(System.in);*/
	static Scanner tastiera = new Scanner(System.in);
	
	static public String inserimento()
	{
		String parola;
		parola = tastiera.next();
		
		return parola;
		/*return scannerizzato;*/
	}
	
	static private void captcha()
	{
		Captcha codice_controllo;
		codice_controllo = new Captcha();
	}

}
