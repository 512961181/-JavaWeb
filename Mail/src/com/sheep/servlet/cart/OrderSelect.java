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
 * Servlet implementation class OrderSelect
 */
@WebServlet("/orderselect")
public class OrderSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderSelect() {
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
		
		HttpSession session=request.getSession();
		String isLogin=(String)session.getAttribute("isLogin");
		
		SHEEP_USER user=(SHEEP_USER)session.getAttribute("name");
		
		String eids=request.getParameter("eids");
		
		if(user!=null && isLogin.equals("1")) {
			int totalprice=0;//购物车结算总价
			String ids[]=eids.split(",");
			
			ArrayList<SHEEP_CART> list=new ArrayList<SHEEP_CART>();
			
			for(int i=0;i<ids.length;i++) {
				SHEEP_CART es=SHEEP_CARTDao.getCartShop(ids[i]);
				int dprice=es.getCart_p_price()*es.getCart_quantify();
				totalprice=+dprice;
				list.add(es);
				
			}
			request.setAttribute("shoplist", list);
			request.setAttribute("totalprice", totalprice);
			request.getRequestDispatcher("order.jsp").forward(request, response);
			
		}else {
			PrintWriter out=response.getWriter();	
			out.write("<script>");
			out.write("alert('登录后，再购买！');");
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
