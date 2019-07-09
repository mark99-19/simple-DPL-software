package primo;

import java.util.TimerTask;
import java.util.Timer;
import java.sql.*;
import secondo.Starter;

class Task extends TimerTask{
	public void run() {
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
				String sqlString = "UPDATE Utenti SET token = null Where indirizzomail = ?; ";
				PreparedStatement ps = conn.prepareStatement(sqlString);
				ps.setString(1, Starter.disessione.gethmail);
		}
		catch(Exception e)
		{
			System.err.println(e);
		}
		
	}
}
