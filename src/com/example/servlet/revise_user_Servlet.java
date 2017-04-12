package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.daoimp.userImp;
import com.example.demo.User;

public class revise_user_Servlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public revise_user_Servlet() {
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
		PrintWriter out = response.getWriter();
		userImp imp =new userImp();
		String userid=(String) request.getSession().getAttribute("userid");
		String uname=request.getParameter("uname");
		String usex=request.getParameter("usex");
		String urealname=new String(request.getParameter("urealname").getBytes("8859_1"),"utf-8");
		int uage=Integer.parseInt(request.getParameter("uage"));
		String uposition =new String(request.getParameter("uposition").getBytes("8859_1"),"utf-8");
		String uemail =request.getParameter("uemail");
		User b=imp.revise(userid,uname,usex,urealname,uage,uposition,uemail);
		if(b.getUserid()!=null){
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("account1_Servlet").forward(request, response);
		}
		else{
			out.print("<script language='javascript' >alert('Please check your information');window.location.href='account2_Servlet';</script>");
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
