package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.daoimp.planImp;

public class planindex_Servlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public planindex_Servlet() {
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
		PrintWriter out=response.getWriter();
		String pname =new String(request.getParameter("pname").getBytes("8859_1"),"utf-8");
		String ptype  = new String (request.getParameter("ptype").getBytes("8859_1"),"utf-8");
		java.util.Date date =(java.util.Date) request.getSession().getAttribute("date");
		Date d=new Date(date.getTime());
		String userid =(String) request.getSession().getAttribute("userid");
		planImp imp =new planImp();
		String pid=imp.addplan(pname,ptype,d,userid);
		if(pid!=null){
			response.setHeader("Content-type", "text/html;charset=UTF-8");
			javax.servlet.http.HttpSession session1=request.getSession();
			session1.setAttribute("pid", pid);
			request.getRequestDispatcher("/planindex.jsp").forward(request, response);
			
		}else{
			 out.print("<script language='javascript' >alert('Failed!');window.location.href='planindex.jsp';</script>");
		}
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
