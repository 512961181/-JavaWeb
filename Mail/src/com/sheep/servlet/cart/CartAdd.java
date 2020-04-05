package com.sheep.servlet.cart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sheep.entity.SHEEP_CART;
import com.sheep.entity.SHEEP_PRODUCT;
import com.sheep.entity.SHEEP_USER;
import com.sheep.service.SHEEP_CARTDao;
import com.sheep.service.SHEEP_PRODUCTDao;

/**
 * Servlet implementation class CartAdd
 */
@WebServlet("/cartadd")
public class CartAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SHEEP_PRODUCT p=null;
		String pid=request.getParameter("id");
		String count=request.getParameter("count");
		String url=request.getParameter("url");
		
		HttpSession session=request.getSession();
		String isLogin=(String)session.getAttribute("isLogin");
		
		SHEEP_USER user=(SHEEP_USER)session.getAttribute("name");
		
		if(user!=null && isLogin.equals("1")) {
			String uid=(String)user.getUSER_ID();
			//通过用户ID和购物车中的商品ID，查看有没有这条记录
			SHEEP_CART srcsp=SHEEP_CARTDao.getCartShop(uid,pid);
			
			if(srcsp!=null) {
				int srccount=srcsp.getCart_quantify();
				int newcount=srccount+Integer.parseInt(count);
	
				//限购五件商品
				if(newcount>=5) {
					newcount=5;
				}
				SHEEP_CARTDao.updatenum(srcsp.getCart_id(),newcount);
			}else {
				if(pid!=null) {
					p=SHEEP_PRODUCTDao.selectById(Integer.parseInt(pid));
				}	
					SHEEP_CART cart=new SHEEP_CART(
								0,
								p.getPRODUCT_FILENAME(),
								p.getPRODUCT_NAME(),
								p.getPRODUCT_PRICE(),
								Integer.parseInt(count),
								p.getPRODUCT_STOCK(),
								p.getPRODUCT_ID(),
								uid,
								1					
							);
					
					SHEEP_CARTDao.insert(cart);

			}
		}else {
			PrintWriter out=response.getWriter();
			
			out.write("<script>");
			out.write("alert('登录后，再购买！');");
			out.write("location.href='login.jsp';");
			out.write("</script>");
			out.close();
			return;
		}
		
		if(url.equals("z")) {
			response.sendRedirect("showcart");
		}else {
			response.sendRedirect("selectproductview?id="+pid);
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
