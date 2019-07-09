package primo;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import secondo.Starter;
 
public class Controllo_FS implements Runnable{
	
	private String hash1 = null;
	private int level;
	
	/* nel caso di accesso a dati non autorizzati c'è una privilege escalation, 
	 * quindi Controllo_FS istanzia un oggetto privilege escalation.
	 * pattern nel suo costruttore avra l'eccezione bloccoUtenza */
	
	//metodo che controllo livello dei file a cui ha accesso l'utente
	public void run() {//throws Eccezione_BloccaUtenza{
	
		this.level = 0;
		
		try {
	        this.hash1 = MD5checksum.getMD5Checksum(/*file nel buffer di input*/);
	        
	    }
		catch (Exception e) {
	        e.printStackTrace();
	    }
		
		try{
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
			
		/*---------------------------------------------------------------------
		 * modificare valori databse
		 * ---------------------------------------------------------------------
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
				String sqlString = "SELECT livello FROM Files WHERE hash = ?; ";
				PreparedStatement ps = conn.prepareStatement(sqlString);
				ps.setString(1, this.hash1);	
				ResultSet rs = null;
					
				rs = ps.executeQuery();
				
				
		/*		rs.close();
				stmt.close();
				conn.close();
		*/		
				while(rs.next()) {
					this.level = rs.getInt("livello");
				}		
				conn.close();
		}
		catch(SQLException error)
		{
			System.err.println(error);
		}
		//Starter.diSessione.livello
		
		if(Starter.disessione.livello != level) {
			//lancia eccezione blocca utenza
			
			throw new Eccezione_BloccoUtenza();
		}
	
	}

} 

/*
Classe controlloFS 
- prende il fle nel buffer di input e lo trasforma in stringa(hash direttamente)
- la stringa va poi trasformata in hash

- si controlla se nel database ce l hash di quel file 
- e si ritorna il livello del file 

- che va confrontato con il livello dell utente di sessione 
- e poi nel caso lancera eccezione blocca utenza  
*/
  