package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
   UserDAO dao;
    public Admin() {
        super();
        
    }
    public void init(ServletConfig config)throws ServletException {
    	dao=new UserDAO();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("html");
			
		if(request.getAttribute("return")!=null){
			
	    	response.sendRedirect("Attend.html");
	    } else{
	    	out.println("<!DOCTYPE html><html lang='en'><head><meta charset='UTF-8'><meta name='viewport' content='width=device-width, initial-scale=1.0'><title>Tableau avec menu à gauche</title><link rel='stylesheet' href='css.css'></head><body><div class='container'><div class='menu-container'><ul class='menu'><li><a href='#'>DATABASE</a></li><li><a href='http://127.0.0.1:1880/ui'>DASHBORD</a></li><li><a href='Ajouter' >NEWDRIVERS</a></li></ul></div><div class='content'> <div class='table-container'><table><h1> The Future Drivers<br/><br/></h1><thead><tr><th>ID</th><th>First Name</th><th>Last Name</th><th>Age</th><th>Address</th><th>Number</th><th>Email</th><th>Login</th><th>Password</th><th>Update</th><th>Delete</th></tr></thead>");
	    	out.println(" <div class='disconnect-link'><i ><img src='steering-wheel.png' width='40px' height='40px'></i><a href='login.jsp' ><button id='disconnect-btn'>Disconnect</button></a><i><img src='iot.png' width='40px' height'40px'></i></div>");
	    	List<User> us=new ArrayList<User>();
	    	
	    	us=dao.allusers();
	    	for(User u:us){
	    		out.println("<tr><td>"+u.getID()+"</td><td>"+u.getFIRST_NAME()+"</td><td>"+u.getLAST_NAME()+"</td><td>"+u.getAGE()+"</td><td>"+u.getADRESS()+ "</td><td>"+u.getNUMBER()+"</td><td>"+u.getMAIL_ADRESS()+"</td><td>"+u.getLOGIN()+"</td><td>"+u.getPASSWORD()+"</td><td><a href='ServletUD?ID="+u.getID()+"&op=up&db=1'>  <img src='cloud.png' alt='Description de l'image' width='30px' height='30px'></a></td><td><a href='Servlet2?ID="+u.getID()+"&&op=dl&&db=1'><img src='cloud.png' alt='Description de l'image' width='30px' height='30px'></a></td></tr>");
	    		//out.println("<tr><td>"+u.getID()+"</td><td>"+u.getFIRST_NAME()+"</td><td>"+u.getLAST_NAME()+"</td><td>"+u.getAGE()+"</td><td>"+u.getADRESS()+ "</td><td>"+u.getNUMBER()+"</td><td>"+u.getMAIL_ADRESS()+"</td><td>"+u.getLOGIN()+"</td><td>"+u.getPASSWORD()+"</td><td><a href='ServletUD?ADRESS="+u.getADRESS()+"&&MADRESS="+u.getMAIL_ADRESS()+"&&NUMBER="+u.getNUMBER()+"&&AGE="+u.getAGE()+"&&PASSWORD="+u.getPASSWORD()+"&&ID="+u.getID()+"&&op=up'>
	    	}
	    	out.println("</tbody></table></div></div></div></body></html>");
	    	
	    }
	}

}

