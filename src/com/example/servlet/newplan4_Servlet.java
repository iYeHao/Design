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

public class newplan4_Servlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public newplan4_Servlet() {
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
		String ftext=new String(request.getParameter("ldzz").getBytes("8859_1"),"utf-8");
		String fname="领导机构及职责";
		String userid=(String) request.getSession().getAttribute("userid");
		String pid=(String) request.getSession().getAttribute("pid");
		java.util.Date d =(java.util.Date) request.getSession().getAttribute("date");
		Date date=new Date(d.getTime());
		filedImp imp=new filedImp();
		ArrayList<Field> flist= new ArrayList<Field>();
		Field f = new Field();
		f=imp.addfiled(ftext, fname, userid, pid, date);
		flist.add(f);
		String ftext1=new String(request.getParameter("zhzz").getBytes("8859_1"),"utf-8");
		String fname1="指挥机构及职责";
		f=imp.addfiled(ftext1, fname1, userid, pid, date);
		flist.add(f);
		String ftext2=new String(request.getParameter("cyzz").getBytes("8859_1"),"utf-8");
		String fname2="指挥机构成员单位及职责";
		f=imp.addfiled(ftext2, fname2, userid, pid, date);
		flist.add(f);
		String ftext3=new String(request.getParameter("xczz").getBytes("8859_1"),"utf-8");
		String fname3="现场指挥机构及职责";
		f=imp.addfiled(ftext3, fname3, userid, pid, date);
		flist.add(f);
		String ftext4=new String(request.getParameter("xtzz").getBytes("8859_1"),"utf-8");
		String fname4="综合协调机构及职责";
		f=imp.addfiled(ftext4, fname4, userid, pid, date);
		flist.add(f);
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setAttribute("flist", flist);
		request.getRequestDispatcher("/newplan4.jsp").forward(request, response);
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
