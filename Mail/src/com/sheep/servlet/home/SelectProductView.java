package com.sheep.servlet.home;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sheep.entity.SHEEP_CATEGORY;
import com.sheep.entity.SHEEP_PRODUCT;
import com.sheep.service.SHEEP_CATEGORYDao;
import com.sheep.service.SHEEP_PRODUCTDao;

/**
 * Servlet implementation class SelectProductView
 */
@WebServlet("/selectproductview")
public class SelectProductView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectProductView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<SHEEP_CATEGORY> flist=SHEEP_CATEGORYDao.selectCat("father");
		request.setAttribute("flist", flist);
		
		ArrayList<SHEEP_CATEGORY> clist=SHEEP_CATEGORYDao.selectCat("child");
		request.setAttribute("clist", clist);
		
		String id=request.getParameter("id");
		
		//获取最近访问
		HttpSession session=request.getSession();
		//从SESSION获取一下ids
		ArrayList<Integer> ids=(ArrayList<Integer>)session.getAttribute("ids");
		if(ids==null) {
			ids=new ArrayList<Integer>();
		}
		
		//最近访问最多放五个，如果多于五个将第一个删除
		if(ids.size()>=5) {
			ids.remove(0);
		}
		
		//添加列表里，但只要一份
		if(id!=null &&(ids.contains(Integer.parseInt(id)))) {
			ids.add(Integer.parseInt(id));
		}
		
		session.setAttribute("ids", ids);

		ids=(ArrayList<Integer>)session.getAttribute("ids");
		if(ids !=null) {
			ArrayList<SHEEP_PRODUCT> lastlylist=SHEEP_PRODUCTDao.selectAllById(ids);
			request.setAttribute("lastlylist", lastlylist);
		}
		
		SHEEP_PRODUCT p=null;
		 
		if(id!=null) {
			p=SHEEP_PRODUCTDao.selectById(Integer.parseInt(id));
			request.setAttribute("p", p);
		}
		
		if(p!=null) {
			int cid=p.getPRODUCT_CID(); 
			ArrayList<SHEEP_PRODUCT> classlist=SHEEP_PRODUCTDao.selectAllByCid(cid);
			request.setAttribute("classlist", classlist);
			
			SHEEP_CATEGORY cate=SHEEP_CATEGORYDao.selectById(cid);
			request.setAttribute("cate", cate);
		}
		
		
		
		request.getRequestDispatcher("productview.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
