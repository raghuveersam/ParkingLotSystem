package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;



import database.DatabaseSingleton;
import database.DbConnection;
import dao.Users;

public class UsersDao {

	Logger logger = Logger.getLogger("UsersDao");

	

	public void doSignup(Users user ){
		DbConnection d = DatabaseSingleton.getInstance();
		Statement ps = null;
		
		
		try {
			ps = d.getConnection();
			String sql1 = "insert into users (username,password,email,firstname,lastname) values ('"
					+ user.getUsername() + "','" + user.getPassword() + "','" + user.getEmail() + "','"
					+ user.getFirstname() + "','" + user.getLastname() + "')";

			logger.log(Level.INFO, sql1);
			ps.executeUpdate(sql1);
			

			ps.close();
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.toString());	
		}
	}
	
	
	
	public int getuserid(String username){
		DbConnection d = DatabaseSingleton.getInstance();
		Statement ps = null;
		ResultSet rs = null;
		
		int id=0;
		
		try {
			ps = d.getConnection();
			
			String sql = "select id from users where username = '"+username+"'";
			System.out.println(sql);
			rs = ps.executeQuery(sql);
		
			while(rs.next()){
				id = rs.getInt("id");
			}
			ps.close();
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.toString());
		}
		
		return id;
		
	}

	

	public boolean checkExistUser(Users user){
		
		boolean condition = false;
		int count;
		DbConnection d = DatabaseSingleton.getInstance();
		Statement ps = null;
		ResultSet rs = null;
		
		try {
			ps = d.getConnection();
			
			String sql = "select username,email from users where username = '" + user.getUsername() + "' and email = '"
					+ user.getEmail() + "'";
			rs = ps.executeQuery(sql);
			count = 0;
			while (rs.next()) {
				count++;
			}
			if(count ==0){
				condition = true;
			}else{
				System.out.println("userid exist");
				return condition;
			}
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.toString());	
		}
		return condition;
	}
	
	

	public boolean doLogin(String username, String password) {
		int count;
		try {
			DbConnection d = DatabaseSingleton.getInstance();
			Statement ps = null;
			ResultSet rs = null;
			ps = d.getConnection();

			String sql = "select username,password from users where username = '" + username + "'and password = '"
					+ password + "'";
			logger.log(Level.INFO, sql);
			rs = ps.executeQuery(sql);

			count = 0;
			while (rs.next()) {
				count = count + 1;
			}
			ps.close();
			if (count == 1) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.toString());
		}
		return false;
	}

}
