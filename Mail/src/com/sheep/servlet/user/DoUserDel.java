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
		//�����ַ���
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
			
		//��ȡ��ɾ������id
		String id=request.getParameter("id");
		
	
		//�����ݿ���û�����ɾ��
		int count=SHEEP_USERDao.del(id);
		
		//�ɹ���ʧ���ض�����

		if(count>0) {
			response.sendRedirect("admin_douserselect?cp="+request.getParameter("cpage"));
		}else{
			PrintWriter out=response.getWriter();
			
			out.write("<script>");
			out.write("alert('�û�ɾ��ʧ��');");
			out.write("location.href='admin_douserselect?cp="+request.getParameter("cpage")+"'");
			out.write("</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�����ַ���
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=utf-8");
					
				//��ȡ��ɾ������id
				String[] ids=request.getParameterValues("id[]");
				
				
				//�����ݿ���û�����ɾ��
				
				for(int i=0;i<ids.length;i++) {
					SHEEP_USERDao.del(ids[i]);
				}				
				//�ɹ���ʧ���ض�����			
				response.sendRedirect("/Mail/manage/admin_douserselect");				
	}

}
