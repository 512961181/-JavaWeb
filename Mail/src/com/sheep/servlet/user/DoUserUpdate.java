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
 * Servlet implementation class DoUserUpdate
 */
@WebServlet("/manage/admin_douserupdate")
public class DoUserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoUserUpdate() {
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
		
		
		String username=request.getParameter("userName");
		String name=request.getParameter("name");
		String pwd=request.getParameter("passWord");
		String sex=request.getParameter("sex");
		String birthday=request.getParameter("birthday");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String address=request.getParameter("address");
		String userStatus=request.getParameter("userStatus");
		
		int status=1;
		
		if(userStatus!=null){
			status=Integer.parseInt(userStatus);
		}
		//�����û�ʵ��
		SHEEP_USER user=new SHEEP_USER(username,name,pwd,sex,birthday,null,email,mobile,address,status);
		
		
		//���뵽���ݿ���û�����
		int count=SHEEP_USERDao.update(user);
		
		//�ɹ���ʧ���ض�����

		if(count>0) {
			response.sendRedirect("admin_douserselect?cp="+request.getParameter("cpage"));
		}else{
			PrintWriter out=response.getWriter();
			
			out.write("<script>");
			out.write("alert('�û��޸�ʧ��');");
			out.write("location.href='manage/admin_touserupdate?id="+username+"'");
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
