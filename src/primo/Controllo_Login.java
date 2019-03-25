package primo; 

import java.sql.*;
 
public class Controllo_Login extends Controllo_Utente {
	
	public static void controlloHash(String hash1, String hash2)
	{
		try{  
			//connessione col server mySql
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://sql7.freesqldatabase.com/sql7283837","sql7283837","bDzxrtThh8");  
			//server, username, pwd; 
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("SELECT Indirizzo_mail, Parola FROM Utenti WHERE Indirizzo_mail = " + hash1 + " AND Parola = " + hash2 + ";");  
			while(rs.next()) 
			//System.out.println(rs.getString(1)+" " +rs.getString(2));  
			con.close();  
			//autenticazione eseguita
			
			/***********
			 --------------INSERIRE THROW--------------------
			 ***********/
			}
			catch(Exception e){ 
				System.err.println(e);
			}  
			//catch(Exception exception_login)
			}
	
	public static void controlloContatore(int contatore) throws EccezioneLogin
	{
		switch(contatore) {
			case 0: Output.visualizzaSchermataLoginGiusta();
			break;
			case 1: Output.visualizzaSchermataLoginErrata();
			break;
			case 2: Output.visualizzaSchermataLoginCaptcha();
			break;
			default: throw new EccezioneLogin();
		}
	}

}
