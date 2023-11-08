package Program;
import java.sql.*;
import com.mysql.jdbc.*;

public class DataBaseHandler extends Configs{
	Connection dbConectoin;
	//метод для підключення до бази
	public Connection getDbConection() throws ClassNotFoundException, SQLException{
		String conectionString ="jdbc:mysql://" + dbHost+ ":"
				+ dbPort + "/" +dbName;
		
		//Class.forName("com.mysql.jdbc.Driver");
		dbConectoin =DriverManager.getConnection(conectionString,dbUser,dbPass);
		
		
		return dbConectoin;
		
	}
	
	//метод для створення нового користувача в базі даних
	public void newUser(String username,String email) throws ClassNotFoundException, SQLException {
		
		String insert =("INSERT INTO " +Const.USER_TABLE+" ("+Const.USER_USERNAME+", "+ Const.USER_EMAIL+") VALUES (?, ?)");
		
		PreparedStatement prSt =getDbConection().prepareStatement(insert);
		prSt.setString(1,username);
		prSt.setString(2,email);
		
		prSt.executeUpdate();// помилку вибиває при виконані цюого метода
		dbConectoin.commit();
		
	}
}
