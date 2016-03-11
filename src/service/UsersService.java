package service;

import java.util.logging.Level;
import java.util.logging.Logger;

import dao.LotDao;
import dao.Users;
import dao.UsersDao;

public class UsersService {
	
	Logger logger = Logger.getLogger("UsersService");
	private UsersDao usersdao;
	private LotDao lotDao;
	

	public UsersDao getUserdao() {
		return usersdao;
	}
	
	
	public UsersService(){
		 usersdao = new UsersDao();
	}
	
	
	public void doSignup(Users user) {
		
		if(getUserdao().checkExistUser(user)){
			logger.log(Level.INFO,"User does not exist - enrolling the user in the system");
			
			getUserdao().doSignup(user);
			
			int userid= getUserdao().getuserid(user.getUsername());
			
			lotDao = new LotDao();
	
			if(lotDao.queryLot(user.getLot())){
				logger.log(Level.INFO,"Lot is Full -Querying queue");
					if(lotDao.queryLotQueue(user.getLot())){
						logger.log(Level.INFO,"Queue is Full");
					}else{
						logger.log(Level.INFO,"Queue has availablity");
						lotDao.doInsertLot(user.getLot()+"queue",userid);
					}		
			}else{
				logger.log(Level.INFO,"Lot has availablity");
				lotDao.doInsertLot(user.getLot(),userid);
			}
		}else{
			logger.log(Level.SEVERE,"User exist already. Please login");
		}
	}
	
	public boolean doLogin(String username, String password) {
		 return getUserdao().doLogin(username, password);
	}
	
}
