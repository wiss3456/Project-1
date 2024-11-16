package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/Servlet2","/ServletUD"})
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       UserDAO dao;
       int n;
      
    public Servlet2() {
        super();
        
    }

	public void init(ServletConfig config) throws ServletException{
		dao=new UserDAO();
		n=0;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		PrintWriter out=response.getWriter();
		int ID=Integer.parseInt(request.getParameter("ID"));
		String op=request.getParameter("op");
		int db=Integer.parseInt(request.getParameter("db"));
		if(op.equals("up")){
			if(db==1) {
			
			if(n==0) {
		    n++;
			out.println("<!DOCTYPE html><html lang='en'><head><meta charset='UTF-8'><meta name='viewport' content='width=device-width, initial-scale=1.0'><title>Tableau avec menu à gauche</title><link rel='stylesheet' href='serv2.css'></head> <body><table ><form action='Servlet2'><tr><td><input type='number' placeholder='Id' readonly='readonly' value='"+ID+"'  name='ID'><td><input type='number' placeholder='Age'  name='Age' required></td><td><input type='text' placeholder='Adress' name='Adress' ></td><td><input type='text' placeholder='Number' name='Number' ></td><td><input type='email' placeholder='Email'  name='Email' ></td><td> <input type='password' placeholder='Password' name='Password' ></td><td><input type='hidden' name='db' value='1'/><input type='submit' name='op' value='up'/></td></tr></form></table></body></html>");
			}
			String ADRESS=request.getParameter("Adress");
			String MAIL_ADRESS=request.getParameter("Email");
			String NUMBER=request.getParameter("Number");
			
			int AGE=Integer.parseInt(request.getParameter("Age"));
			
			String PASSWORD=request.getParameter("Password");
			User u=new User(AGE,ADRESS,NUMBER,MAIL_ADRESS,PASSWORD);
			u.setId(ID);
			 n=dao.updateUser(u);
			response.sendRedirect("Admin");
			n=0;
			}else{
				User d=dao.findByIdD(ID);
				int t=dao.addUser(d);
				response.sendRedirect("Ajouter");
				
			}
			
		}else{
			if(db==1) {
			dao.deleteUser(ID);
			response.sendRedirect("Admin");
		}else{
			dao.deleteDemande(ID);
			response.sendRedirect("Ajouter");
		}
		}
		
	}

	
}
