 package com.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.STAFF;
import com.service.STAFFDao;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	//在服务器端进行验证
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=utf-8");
				
				String number = request.getParameter("number");
				String password = request.getParameter("password");
				String desk = request.getParameter("desk");
				String sex = request.getParameter("sex");
				String mobile = request.getParameter("mobile");
				//创建用户实体
				STAFF u = new STAFF(number, password, sex, desk,  mobile);
				//加入到数据库的用户表中
				int count = STAFFDao.insert(u);
				

				//成功或失败重定向到哪里
				
				if(count >0 ) {
					response.sendRedirect("login.jsp");//注册成功则跳转至登录页面
				} else {
					PrintWriter out = response.getWriter();
					
					out.write("<script>");
					out.write("alert('用户注册失败!')");
					out.write("location.href='reg.jsp'");//注册失败则重新回到注册页面
					out.write("</script>");
					
				}
	}

}
