package com.sheep.servlet.cate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sheep.entity.SHEEP_CATEGORY;
import com.sheep.entity.SHEEP_USER;
import com.sheep.service.SHEEP_CATEGORYDao;
import com.sheep.service.SHEEP_USERDao;

/**
 * Servlet implementation class DoUserCate
 */
@WebServlet("/manage/admin_docateadd")
public class DoUserCate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoUserCate() {
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
		
		int fid=Integer.parseInt(request.getParameter("parentId"));
		String name=request.getParameter("className");
		
		
		//�����û�ʵ��
		SHEEP_CATEGORY cate=new SHEEP_CATEGORY(0,name,fid);
			
		//���뵽���ݿ���û�����
		int count=SHEEP_CATEGORYDao.insert(cate);
		
		
		//�ɹ���ʧ���ض�����		
		response.sendRedirect("admin_cateselect");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
