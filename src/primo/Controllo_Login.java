package primo; 
 
import java.sql.*;

import secondo.Input;
 
public class Controllo_Login extends Controllo_Utente {
	
	
	public static boolean controlloHash(String hash1, String hash2)			//lo metto boolean, se hai dubbi ne riparliamo
	{
		try{
			//connessione col server mySql
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://milan.onthewifi.com/","sql7283837","bDzxrtThh8");  
			//server, username, pwd; 
			Statement stmt = con.createStatement();  
			ResultSet rs = stmt.executeQuery("SELECT Indirizzo_mail, Parola, Token FROM Utenti WHERE Indirizzo_mail = " + hash1 + " AND Parola = " + hash2 + " AND Token IS NULL;");
			while(rs.next()) 
			/*RIGA PER DEBUG*/System.out.println(rs.getString(1)+" " +rs.getString(2));  
			con.close();  
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
			default: throw new Eccezione_Login();
		}
	}

}
