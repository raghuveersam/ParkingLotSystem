package database;

public class DatabaseSingleton {
	
	private static DbConnection instance;
	
	
	public static DbConnection getInstance(){
		if(instance == null){
			instance = new DbConnection();	
		}
		
		return instance;
	}

}
