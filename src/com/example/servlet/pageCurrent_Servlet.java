package com.example.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.net.aso.i;

import com.example.daoimp.filedImp;
import com.example.demo.Field;

public class pageCurrent_Servlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public  pageCurrent_Servlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		javax.servlet.http.HttpSession session1=request.getSession();
		String userid=(String) session1.getAttribute("userid");
		String current=request.getParameter("page_current");
		int page_current=Integer.parseInt(current);//定义当前页                
		int page_next=Integer.parseInt(request.getParameter("page_next"));//定义下一页
		int page_size=3;//定义一页的字段的数量
		if(page_current==1){
			if(page_next==1){
				page_current=1;
			}else{
				page_current=page_current+1;
			}
		}else{
			if(page_next==1){
				page_current=page_current-1;
			}else{
				page_current=page_current+1;
			}
		}
		int page_total=0;//定义页的总数
		filedImp imp =new filedImp();
		ArrayList<Field> flist = new ArrayList<Field> ();
		flist=imp.Dshow(userid);
		
		page_total=flist.size()/3+1;
		ArrayList<Field> cflist=new ArrayList<Field>();
		
		if(page_current>=page_total){
			int i=0;
			page_current=page_total;
			while((page_current-1)*page_size+i<flist.size()){
				cflist.add(flist.get(page_size*(page_current-1)+i));
				i=i+1;
			}
		}else{
			cflist.add(flist.get(page_size*(page_current-1)));
			cflist.add(flist.get(page_size*(page_current-1)+1));
			cflist.add(flist.get(page_size*(page_current-1)+2));
		}
		
		
		request.setAttribute("page_current", page_current);
		
		request.setAttribute("flist", cflist);
		
		request.getRequestDispatcher("/account5.jsp").forward(request, response);
	
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
	this.doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
