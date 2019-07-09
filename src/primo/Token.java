package primo;

import java.security.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Base64;
import java.sql.*;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.mysql.cj.jdbc.MysqlDataSource;
import secondo.Starter;

public class Token {
	
	private String token;
	
	public Token () {
		this.token = generateNewToken();
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	
	private static final SecureRandom secureRandom = new SecureRandom(); //threadsafe
	private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder(); //threadsafe
	
	private String generateNewToken() {
	    byte[] randomBytes = new byte[24];
	    secureRandom.nextBytes(randomBytes);
	    return base64Encoder.encodeToString(randomBytes);
	}
	
	public void addToken() {//deve prendere come argomento l utente in cui inserire il token e anche il token
		try {
			
				MysqlDataSource dataSource = new MysqlDataSource();
				dataSource.setUser("root");
				dataSource.setPassword("password");
				dataSource.setServerName("milan.onthewifi.com");
				dataSource.setDatabaseName("DPO");
				Connection conn = dataSource.getConnection();
		/*		Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT indirizzo_mail AS mail, parola AS password, token AS token, contatore AS contatore FROM Utenti WHERE (indirizzo_mail = " + hash1 + " AND parola = " + hash2+")");
		*/		//Starter.diSessione.mail
				
				String sqlString = "UPDATE File SET Token = ? WHERE mail = ?; ";
				//-----------------------------------------------------------
				//aggiungere token e hash
				//-------------------------------------------------------------
				PreparedStatement ps = conn.prepareStatement(sqlString);
				ps.setString(1, this.token);
				ps.setString(2, Starter.disessione.gethmail());
				conn.close();
			}
			catch(Exception e){
				System.err.println(e);
			}
	}
	
	public void removeToken() {//deve prendere come argomento l utente in cui eliminare il token e anche il token
		try {
				MysqlDataSource dataSource = new MysqlDataSource();
				dataSource.setUser("root");
				dataSource.setPassword("password");
				dataSource.setServerName("milan.onthewifi.com");
				dataSource.setDatabaseName("DPO");
				Connection conn = dataSource.getConnection();
		/*		Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT indirizzo_mail AS mail, parola AS password, token AS token, contatore AS contatore FROM Utenti WHERE (indirizzo_mail = " + hash1 + " AND parola = " + hash2+")");
		*/		
				String sqlString = "UPDATE File SET Token = null WHERE hash = ?; ";
				PreparedStatement ps = conn.prepareStatement(sqlString);
				ps.setString(1, this.token);
				conn.close();
			}
		catch(Exception e){
			System.err.println(e);
		}
	}
}
