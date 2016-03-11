package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import database.DatabaseSingleton;
import database.DbConnection;


public class LotDao {
	
	Logger logger = Logger.getLogger("LotDao");

	public boolean queryLot(String lot) {
		Statement ps = null;
		ResultSet rs = null;
		try {
			
			ps = DatabaseSingleton.getInstance().getConnection();
			rs = ps.executeQuery("select count(*) as count from " + lot);

			int lotvalue = 0;
			while (rs.next()) {
				lotvalue = rs.getInt("count");
			}
			if (lotvalue >=2) {
				logger.log(Level.INFO,"Querying Lot queue");
				
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean queryLotQueue(String lot){
		Statement ps = null;
		ResultSet rs = null;
		DbConnection d = DatabaseSingleton.getInstance();
		ps = d.getConnection();
		try {
			rs = ps.executeQuery("select count(*) as count from " + lot + "queue");
			int lotqueuevalue = 0;
			while (rs.next()) {
				lotqueuevalue = rs.getInt("count");
			}
			if(lotqueuevalue>=1){
				logger.log(Level.INFO,"Lot Queue is full");
				return true;
			}
			
		} catch (SQLException e) {
			logger.log(Level.SEVERE,e.toString());
		}
		return false;
	}
	
	public void doInsertLot(String lottable, int id) {
		logger.log(Level.INFO, "The inserted userid is "+ " "+id);
		DbConnection d = DatabaseSingleton.getInstance();
		Statement ps = null;
		ps = d.getConnection();
		String sql1="insert into "+lottable+"(userid) values ("+id+")";
		try {
			ps.executeUpdate(sql1);
		} catch (SQLException e) {
			logger.log(Level.SEVERE,e.toString());
		}

	}
	
}
