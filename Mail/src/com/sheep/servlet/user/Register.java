package com.sheep.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sheep.entity.SHEEP_USER;
import com.sheep.service.SHEEP_USERDao;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String username=request.getParameter("userName");
		String name=request.getParameter("name");
		String pwd=request.getParameter("passWord");
		String sex=request.getParameter("sex");
		String year=request.getParameter("birthday");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String address=request.getParameter("address");
		
		//创建用户实体
		SHEEP_USER u=new SHEEP_USER(username,name,pwd,sex,year,null,email,mobile,address,1);
		
		
		//加入到数据库的用户表中
		int count=SHEEP_USERDao.insert(u);
		
		//成功或失败重定向到哪

		if(count>0) {
			response.sendRedirect("login.jsp");
		}else{
			PrintWriter out=response.getWriter();
			
			out.write("<script>");
			out.write("alert('用户注册失败');");
			out.write("location.href='reg.jsp';");
			out.write("</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
