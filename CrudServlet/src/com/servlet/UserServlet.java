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
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String userId = req.getParameter("user");
		String password = req.getParameter("password");
		
		User user=null;
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspcrud","root","@kalim#2009");
			
			ps = con.prepareStatement("select * from user where user_id=? and password=?");
			
			ps.setString(1, userId);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			if(rs.next()){
				user = new User();
				user.setUserId(rs.getString("user_id"));
				user.setName(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setAddress(rs.getString("address"));
				user.setHobbies(rs.getString("hobbies"));
				user.setInterest(rs.getString("interest"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		if(user!=null){
			req.setAttribute("user", user);
			RequestDispatcher rd = req.getRequestDispatcher("editUser.jsp");
			rd.forward(req, resp);
			
		}else{
			System.out.println("user not found");
		}
		
		
		
	}

}
