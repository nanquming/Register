package com.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/checkusernum")//判断用户输入的验证码是否正确
public class CheckUserNum extends HttpServlet {
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String num = request.getParameter("num");
		
		 HttpSession session = request.getSession();
		 
		 String sysCode= (String)session.getAttribute("code");
			 
		 PrintWriter out = response.getWriter();
		if(sysCode.equals(num) ){
			out.print("true");
		}else{
			out.print("false");
		}
		out.close();   
	}
}
