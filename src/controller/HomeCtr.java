package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Users;
import service.UsersService;


public class HomeCtr extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger("HomeCtr");

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		logger.log(Level.INFO, req.getServletPath());
		if(req.getServletPath().equals("/Login")){
			doLogin(req,resp);
		}else if(req.getServletPath().equals("/signup")){
			doSignup(req,resp);
		}else if(req.getServletPath().equals("/Home")){
			showHome(req,resp);
		}

	}

	
	public void showHome(HttpServletRequest req, HttpServletResponse resp){
		redirectToHome(req,resp);
	}
	
	public void redirectToHome(HttpServletRequest req,HttpServletResponse resp){
		try {
			req.getRequestDispatcher("home.jsp").forward(req, resp);
		} catch (Exception e) {
			logger.log(Level.SEVERE,"Redirection Failed to HomePage");
		}
	}
	
	public void doSignup(HttpServletRequest req, HttpServletResponse resp){
		
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String lot = req.getParameter("lotdetails");
		
		
		
		Users userclass = new Users();
		userclass.setEmail(email);
		userclass.setFirstname(firstname);
		userclass.setLastname(lastname);
		userclass.setUsername(username);
		userclass.setPassword(password);
		userclass.setLot(lot);
		
		
		UsersService usersService = new UsersService();
		
		usersService.doSignup(userclass);
		
	
	}
	
	
	

	public void doLogin(HttpServletRequest req, HttpServletResponse resp){
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		UsersService usersService = new UsersService();
		
		if(usersService.doLogin(username, password)){
			logger.log(Level.INFO, "Login Successful");
			HttpSession session = req.getSession(true);
			session.setAttribute("username", username);
			req.setAttribute("username",username);
			redirectToHome(req, resp);
		}else{
			System.out.println("failure");
		}
	}
	
	
}
