package com.sheep.servlet.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sheep.entity.SHEEP_CART;
import com.sheep.entity.SHEEP_USER;
import com.sheep.service.SHEEP_CARTDao;

/**
 * Servlet implementation class ShowCart
 */
@WebServlet("/showcart")
public class ShowCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ÉèÖÃ×Ö·û¼¯
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session=request.getSession();
		String isLogin=(String)session.getAttribute("isLogin");
		
		SHEEP_USER user=(SHEEP_USER)session.getAttribute("name");
		
		if(user!=null && isLogin.equals("1")) {
			String uid=(String)user.getUSER_ID();
			ArrayList<SHEEP_CART> list=SHEEP_CARTDao.getCart(uid);
			request.setAttribute("shoplist", list);
			request.getRequestDispatcher("cart.jsp").forward(request, response);
			
		}else {
			PrintWriter out=response.getWriter();
			
			out.write("<script>");
			out.write("alert('µÇÂ¼ºó£¬ÔÙ¹ºÂò£¡');");
			out.write("location.href='login.jsp';");
			out.write("</script>");
			out.close();
			
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
