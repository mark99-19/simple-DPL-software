package primo; 
  
import java.sql.*;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.mysql.cj.jdbc.MysqlDataSource;

import secondo.Input;
 
public class Controllo_Login extends Controllo_Utente {
	
	private static String pwd = "password";
	
	
	public static boolean controlloHash(String hash1, String hash2)			//lo metto boolean, se hai dubbi ne riparliamo
	{
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
			MysqlDataSource dataSource = new MysqlDataSource();
			dataSource.setUser("root");
			dataSource.setPassword("password");
			dataSource.setServerName("milan.onthewifi.com");
			dataSource.setDatabaseName("DPO");
			Connection conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT indirizzo_mail, parola, token, Contatore FROM Utenti WHERE indirizzo_mail = " + hash1 + " AND parola = " + hash2 /*+ " AND Token IS NULL;"*/);
			
	/*		rs.close();
			stmt.close();
			conn.close();
	*/		
			
			while(rs.next())
			{
				String token = rs.getString("token");
				if(token != null)
				{
					int contatore = rs.getInt("contatore");
					switch(contatore)
					{
					case 0:
						return true;
					case 1:
						return true;
					case 2:
						Output.visualizzaSchermataLoginCaptcha();
						return false;
					default: //eccezione di blocco utenza	
					}
				}
			}
			/*RIGA PER DEBUG*/ System.out.println(rs.getString(1)+" " +rs.getString(2));  
			conn.close();
			if(rs == null)
			{
				System.err.println("Errore! Login non effettuato");
			}
			//autenticazione eseguita
			return true;
			/***********
			 --------------INSERIRE THROW--------------------
			 ***********/
			}
			catch(Exception e){
				//throw new Eccezione_Login tentato;
				System.err.println(e);
				return false;
			}  
			//catch(Exception exception_login)
			}
	
	private static void controlloContatore(int contatore) throws Eccezione_Login				//abbiamo scelto di tenerlo localmente per evitare 
	{
		/*Aggiungere query SQL per controllo contatore*/
		
		
		
		switch(contatore) {
			case 0: Output.visualizzaSchermataLoginGiusta();
			break;
			case 1: Output.visualizzaSchermataLoginErrata();
			break;
			case 2: Output.visualizzaSchermataLoginCaptcha();
			break;
			default: throw new Eccezione_Login();						//circostanza sospetta, da segnalare
		}
	}

}
