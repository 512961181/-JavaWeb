package com.sheep.servlet.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sheep.entity.SHEEP_CATEGORY;
import com.sheep.service.SHEEP_CATEGORYDao;

/**
 * Servlet implementation class ToProductAdd
 */
@WebServlet("/manage/admin_toproductadd")
public class ToProductAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToProductAdd() {
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
		
		request.getRequestDispatcher("admin_productadd.jsp").forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
