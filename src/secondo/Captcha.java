package secondo;
import java.util.Random;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

 
public class Captcha {
	
	private String[] domande = {"Dov'è il Big Ben?", "Qual è la capitale della Birmania?", "Qual è l'integrale di e^x?"};
	private String domanda = null;
	private String[] pwds = {"4653a0272adfb98c8bb74f2e634c8d0d1d819fff", "7be9748982698fdf7e39def428f9735c20622ccd", "1624dce91de495347430ec2518baf6c6a5328d2e"};
	private String pwd = null;
	private int scelta = 0;
	private Random casuale = new Random();
	
	public Captcha() throws NoSuchAlgorithmException
	{
		this.domanda = proponiDomanda();
		this.pwd = Input.sha1(pwds[scelta]);
		//this.scelta = 0;
	}
	
	String proponiDomanda()
	{
		scelta = casuale.nextInt(2);
		return domande[scelta];
	}
	
	boolean controllaDomanda(String challenge)
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