package com.example.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.daoimp.filedImp;
import com.example.demo.Field;

public class newplan6_Servlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public newplan6_Servlet() {
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
		String ftext=new String(request.getParameter("tdqd").getBytes("8859_1"),"utf-8");
		String fname="特大应急启动";
		int userid=(Integer) request.getSession().getAttribute("userid");
		Object ppid=request.getSession().getAttribute("pid");
		int pid=(Integer)ppid;
		java.util.Date d =(java.util.Date) request.getSession().getAttribute("date");
		Date date=new Date(d.getTime());
		filedImp imp=new filedImp();
		ArrayList<Field> flist= new ArrayList<Field>();
		Field f = new Field();
		f=imp.addfiled(ftext, fname, userid, pid, date);
		flist.add(f);
		String ftext1=new String(request.getParameter("tdbs").getBytes("8859_1"),"utf-8");
		String fname1="特大指挥与部署";
		f=imp.addfiled(ftext1, fname1, userid, pid, date);
		flist.add(f);
		String ftext2=new String(request.getParameter("tdjs").getBytes("8859_1"),"utf-8");
		String fname2="特大应急结束";
		f=imp.addfiled(ftext2, fname2, userid, pid, date);
		flist.add(f);
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setAttribute("flist", flist);
		request.getRequestDispatcher("/newplan6.jsp").forward(request, response);
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
