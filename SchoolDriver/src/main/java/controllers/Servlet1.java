package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;

@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UserDAO dao; 
    public Servlet1() {
        super();
        
       
    }
    public void init(ServletConfig config) throws ServletException {
    
    	dao=new UserDAO();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u=new User();
		String login=request.getParameter("login");
		String password=request.getParameter("password");
		String op=request.getParameter("op");
		if(op!=null) {
		if(op.equals("auth")) {
			if(login.equals("Lafkih_Rihab")&& password.equals("pass123")||login.equals("Mahboub_Wissal")&& password.equals("pass123")) {
				response.sendRedirect("Admin");
			}else {
			u=dao.authentifier(login,password);
			if(u!=null) {
			request.getSession().invalidate();
			HttpSession ses=request.getSession(true);
			ses.setAttribute("user",u);
			//tak en arduino
			response.sendRedirect("Acceuil.jsp");
		}else{
			request.setAttribute("msg","Login Or Password invalid!!");
			RequestDispatcher dispatcher=request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}}
			}
		if(op.equals("insc")) {
			String First=request.getParameter("First Name");
			String Last=request.getParameter("Last Name");
			int Age=Integer.parseInt(request.getParameter("Age"));
			String Adress=request.getParameter("Adress");
			String Number=request.getParameter("Number");
			String Email=request.getParameter("Email");
			String Login=request.getParameter("Login");
			String Password=request.getParameter("Password");
			User ut=new User(First,Last,Age,Adress,Number,Email,Login,Password);
			dao.inscrireDemande(ut);
			request.setAttribute("return", "1");
			//les infos->admin
			RequestDispatcher dispatcher=request.getRequestDispatcher("Admin");
			dispatcher.forward(request,response);
		}
	}
	}


}
