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
 * Servlet implementation class DoUserDel
 */
@WebServlet("/manage/admin_douserdel")
public class DoUserDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoUserDel() {
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
			
		//获取被删除对象id
		String id=request.getParameter("id");
		
	
		//从数据库的用户表中删除
		int count=SHEEP_USERDao.del(id);
		
		//成功或失败重定向到哪

		if(count>0) {
			response.sendRedirect("admin_douserselect?cp="+request.getParameter("cpage"));
		}else{
			PrintWriter out=response.getWriter();
			
			out.write("<script>");
			out.write("alert('用户删除失败');");
			out.write("location.href='admin_douserselect?cp="+request.getParameter("cpage")+"'");
			out.write("</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=utf-8");
					
				//获取被删除对象id
				String[] ids=request.getParameterValues("id[]");
				
				
				//从数据库的用户表中删除
				
				for(int i=0;i<ids.length;i++) {
					SHEEP_USERDao.del(ids[i]);
				}				
				//成功或失败重定向到哪			
				response.sendRedirect("/Mail/manage/admin_douserselect");				
	}

}
