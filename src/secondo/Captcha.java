package secondo;
import java.util.Random;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Captcha {
	
	private String[] domande = new String[3];
	private String domanda;
	private String[] pwds = new String[3];
	private String pwd;
	int scelta = 0;
	Random casuale = new Random();
	
	public Captcha() throws NoSuchAlgorithmException
	{
		this.domanda = proponi_domanda();
		this.pwd = Input.sha1(pwds[scelta]);
		scelta = 0;
	}
	
	private String proponi_domanda()
	{
		scelta = casuale.nextInt(2);
		return domande[scelta];
	}
	
	public boolean controlla_domanda(String challenge)
	{
		try {
			if(challenge.equals(Input.sha1(this.pwd)));
			{
				return true;
			}
		} catch (NoSuchAlgorithmException e) {
			System.err.println(e);
		}
		return false;
		
	}
	
	 
	
	 

}