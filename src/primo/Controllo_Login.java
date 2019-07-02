package primo; 
import java.sql.*;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.mysql.cj.jdbc.MysqlDataSource;
import secondo.Input;
import secondo.Captcha;
import secondo.ClientSFTP;;

public class Controllo_Login extends Controllo_Utente {
	
	//private RemoteSSH terminale;
	
	
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
	/*		Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT indirizzo_mail AS mail, parola AS password, token AS token, contatore AS contatore FROM Utenti WHERE (indirizzo_mail = " + hash1 + " AND parola = " + hash2+")");
	*/		
			String sqlString = "SELECT indirizzo_mail, parola, token, contatore FROM Utenti WHERE indirizzo_mail = ? AND parola = ?; ";
			PreparedStatement ps = conn.prepareStatement(sqlString);
			ps.setString(1, hash1);
			ps.setString(2, hash2);
			ResultSet rs = null;
			try {
				
				
			rs = ps.executeQuery();
			
			
	/*		rs.close();
			stmt.close();
			conn.close();
	*/		
			while(rs.next())
			{
				
				String token = rs.getString("token");
				if(token == null)
				{
					int contatore = rs.getInt("contatore");
					switch(contatore)
					{
					case 0:
						
						return true;
					case 1:
						
						return true;
					case 2:
						return Input.verificaBot();
						
						//Output.visualizzaSchermataLoginCaptcha();
						
					default: Eccezione_Login blocco = new Eccezione_Login();	
					}
				}
				else
				{
					return false;
				}
				
				
				
			}
			if(!rs.next())
			{
				System.err.println("Errore! Login non effettuato. Username o password errati!");
				return false;
			}
			}
			
			catch(Exception e)
			{
				System.err.println(e);
			}
			/*RIGA PER DEBUG*/ //System.out.println(rs.getString(1)+" " +rs.getString(2));  
			conn.close();
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
	
/*	private static void controlloContatore(int contatore) throws Eccezione_Login				//abbiamo scelto di tenerlo localmente per evitare 
	{
		//Aggiungere query SQL per controllo contatore
		
		
		
		switch(contatore) {
			case 0: Output.visualizzaSchermataLoginGiusta();
			break;
			case 1: Output.visualizzaSchermataLoginErrata();
			break;
			case 2: Output.visualizzaSchermataLoginCaptcha();
			break;
			default: throw new Eccezione_Login();						//circostanza sospetta, da segnalare
		}  
	}*/

}
