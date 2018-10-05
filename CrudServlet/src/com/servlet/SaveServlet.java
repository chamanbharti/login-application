package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String userId = req.getParameter("userId");
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String address = req.getParameter("address");
		//String hobbies = req.getParameter("hobbies");
		String[] hobbies= req.getParameterValues("hobbies");
		String hobby="";
		for (int i = 0; i < hobbies.length; i++) {
			hobby = hobby + hobbies[i] + ",";
		}
		String interest = req.getParameter("interest");
		
		//User user=null;
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspcrud","root","@kalim#2009");
			
			ps = con.prepareStatement("update user set user_name=?,password=?,address=?,hobbies=?,interest=? where user_id=?");
			
			
				//user = new User();
				
		         ps.setString(1,name);  
		         ps.setString(2,password);  
		         ps.setString(3,address);  
		         ps.setString(4,hobby);  
		         ps.setString(5,interest);
		         ps.setString(6,userId);  
		         
		         int i=ps.executeUpdate();//
		         if(i>0)  {
						RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
						rd.forward(req, resp);
					}else{
						RequestDispatcher rd=req.getRequestDispatcher("index.html");
						rd.forward(req, resp);
					}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

}
