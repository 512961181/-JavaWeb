package com.sheep.servlet.home;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sheep.entity.SHEEP_CATEGORY;
import com.sheep.entity.SHEEP_PRODUCT;
import com.sheep.service.SHEEP_CATEGORYDao;
import com.sheep.service.SHEEP_PRODUCTDao;

/**
 * Servlet implementation class SelectProductList
 */
@WebServlet("/selectproductlist")
public class SelectProductList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectProductList() {
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
		
		String fid=request.getParameter("fid");
		String cid=request.getParameter("cid");
		
		int id=0;
		ArrayList<SHEEP_PRODUCT> list=null ;
		if(fid!=null) {
			id=Integer.parseInt(fid);
			list=SHEEP_PRODUCTDao.selectAllByFid(id);
		}
		
		if(cid!=null) {
			id=Integer.parseInt(cid);
			list=SHEEP_PRODUCTDao.selectAllByCid(id);
		}
		
		request.setAttribute("list", list);
		request.setAttribute("title", SHEEP_CATEGORYDao.selectById(id).getCATE_NAME());
		request.getRequestDispatcher("productlist.jsp").forward(request, response);
		
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
