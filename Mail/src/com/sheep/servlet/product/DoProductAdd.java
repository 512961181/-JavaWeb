package com.sheep.servlet.product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.sheep.entity.SHEEP_PRODUCT;
import com.sheep.service.SHEEP_PRODUCTDao;

/**
 * Servlet implementation class DoProductAdd
 */
@WebServlet("/manage/admin_doproductadd")
public class DoProductAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoProductAdd() {
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
		
		//床架SmartUpload对象	
		SmartUpload su=new SmartUpload();
		
		//初始化
		su.initialize(this.getServletConfig(),request,response);
		
		//上传过程
		try {
			su.upload();
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//获取上传文件的对象
		Files fs=su.getFiles();
		File f=fs.getFile(0);
		
		//获取上传文件的名字
		String fname=f.getFileName();
		
		try {
			su.save("images/product");
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Request req1=su.getRequest();
		
		
		String pname=req1.getParameter("productName");
		pname=new String(pname.getBytes("GBK"),"utf-8");//解决SmartUpload上传数据库乱码
		
		String id=req1.getParameter("parentId");
		id=new String(id.getBytes("GBK"),"utf-8");
		
		String price=req1.getParameter("productPrice");
		price=new String(price.getBytes("GBK"),"utf-8");
		
		String desc=req1.getParameter("productDesc");
		desc=new String(desc.getBytes("GBK"),"utf-8");
		
		String stock=req1.getParameter("productStock");
		stock=new String(stock.getBytes("GBK"),"utf-8");
		
		SHEEP_PRODUCT p=new SHEEP_PRODUCT(
					0,
					pname,
					desc,
					Integer.parseInt(price),
					Integer.parseInt(stock),
					Integer.parseInt(id.split("-")[0]),
					Integer.parseInt(id.split("-")[1]),
					fname
				);
		int count=SHEEP_PRODUCTDao.insert(p);
		
		//成功或失败重定向到哪
		if(count>0) {
			response.sendRedirect("admin_productselect");
		}else{
			PrintWriter out=response.getWriter();
			
			out.write("<script>");
			out.write("alert('商品添加失败');");
			out.write("location.href='manage/admin_toproductadd';");
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
