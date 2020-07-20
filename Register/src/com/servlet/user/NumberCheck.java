package com.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.STAFFDao;

@WebServlet("/numbercheck")//寻找数据库中是否有注册输入的工号，避免重复
public class NumberCheck extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String number = request.getParameter("number");
		int count = STAFFDao.selectByNumber(number);
		PrintWriter out = response.getWriter();
		if(count >0 ){  //说明数据库已存在
			out.print("false");
		}else{
			out.print("true");
		}
		out.close();
	}
}
