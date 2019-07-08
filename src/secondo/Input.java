package secondo;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
    

public class Input {
	
	/*InputStreamReader tastiera = new InputStreamReader(System.in);*/
	static Scanner tastiera = new Scanner(System.in);
	
	static public String inserimento()
	{
		String parola;
		parola = tastiera.nextLine();
		
		return parola;
		/*return scannerizzato;*/
	}
	
	
	
	static public boolean verificaBot() throws NoSuchAlgorithmException
	{
		Captcha codice_controllo;
		codice_controllo = new Captcha();
		System.out.println(codice_controllo.proponiDomanda());
		if(codice_controllo.controllaDomanda(inserimento()))
		{
			return true;
		}
		return false;
		
	}
	
	public static String sha512(String passwordToHash){
		String generatedPassword = null;
		/*
		 * no salt
			String salt = "test";
		*/
		    try {
		         MessageDigest md = MessageDigest.getInstance("SHA-512");
		         //md.update(salt.getBytes(StandardCharsets.UTF_8));
		         byte[] bytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
		         StringBuilder sb = new StringBuilder();
		         for(int i=0; i< bytes.length ;i++){
		            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		         }
		         generatedPassword = sb.toString();
		        } 
		       catch (NoSuchAlgorithmException e){
		        e.printStackTrace();
		       }
		    return generatedPassword;
		}
	
	static String sha1(String input) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
         
        return sb.toString();
    }
	
	public static void connessioneSQL()
	{
		//	connessioneSSH();
		/*	NON FUNZIONA. MAI PIU' DRIVER MANAGER. PER I POSTERI:
		 * String dbName = "DPO";
			String dbUserName = "root";
			String dbPassword = "password";
			//connessione col server mySql
			Class.forName("com.mysql.cj.jdbc.Driver");
			//String connectionString = "UPDATE MyTableName " + "SET email = 'ripon.wasim@smile.com' WHERE email='peace@happy.com'";
			String connectionString = "jdbc:mysql://127.0.0.1:3306/" + dbName + "?user=" + dbUserName + "&password=" + dbPassword + "&useUnicode=true&characterEncoding=UTF-8";  
			
		*/	
			MysqlDataSource dataSource = new MysqlDataSource();
			dataSource.setUser("root");
			dataSource.setPassword("password");
			dataSource.setServerName("milan.onthewifi.com");
			dataSource.setDatabaseName("DPO");
			Connection conn = dataSource.getConnection();
	/*		Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT indirizzo_mail AS mail, parola AS password, token AS token, contatore AS contatore FROM Utenti WHERE (indirizzo_mail = " + hash1 + " AND parola = " + hash2+")");
	*/
	}

}
