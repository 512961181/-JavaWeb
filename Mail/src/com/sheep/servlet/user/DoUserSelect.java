package com.sheep.servlet.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sheep.entity.SHEEP_USER;
import com.sheep.service.SHEEP_USERDao;

/**
 * Servlet implementation class DoUserSelect
 */
@WebServlet("/manage/admin_douserselect")
public class DoUserSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoUserSelect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cpage=1;//��ǰҳ
		int count=5;//ÿҳ��ʾ����
		//��ȡ�û�ָ����ҳ�� 
		String cp=request.getParameter("cp");
		
		//�����û������Ĺؼ���
		String keyword=request.getParameter("keywords");
		
		if(cp!=null) {
			cpage=Integer.parseInt(cp);
		}
		
		int arr[]=SHEEP_USERDao.totalPage(count,keyword);
		
		//��ȡ�����û���¼
		ArrayList<SHEEP_USER> list=SHEEP_USERDao.selectAll(cpage,count,keyword);
	
		//�ŵ������������
		request.setAttribute("userlist", list);
		request.setAttribute("tsum",arr[0]);
		request.setAttribute("tpage",arr[1]);
		request.setAttribute("cpage",cpage);
		
		if(keyword!=null) {
			request.setAttribute("searchParams", "&keywords="+keyword);
		}
		
		request.getRequestDispatcher("admin_user.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
