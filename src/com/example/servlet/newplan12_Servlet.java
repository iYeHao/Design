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

public class newplan12_Servlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public newplan12_Servlet() {
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
		String ftext=new String(request.getParameter("bz").getBytes("8859_1"),"utf-8");
		String fname="组织保障";
		String userid=(String) request.getSession().getAttribute("userid");
		String pid=(String) request.getSession().getAttribute("pid");
		java.util.Date d =(java.util.Date) request.getSession().getAttribute("date");
		Date date=new Date(d.getTime());
		filedImp imp=new filedImp();
		ArrayList<Field> flist= new ArrayList<Field>();
		Field f = new Field();
		f=imp.addfiled(ftext, fname, userid, pid, date);
		flist.add(f);
		String ftext1=new String(request.getParameter("bz2").getBytes("8859_1"),"utf-8");
		String fname1="通信保障";
		f=imp.addfiled(ftext1, fname1, userid, pid, date);
		flist.add(f);
		String ftext2=new String(request.getParameter("bz3").getBytes("8859_1"),"utf-8");
		String fname2="资金保障";
		f=imp.addfiled(ftext2, fname2, userid, pid, date);
		flist.add(f);
		String ftext3=new String(request.getParameter("bz4").getBytes("8859_1"),"utf-8");
		String fname3="队伍保障";
		f=imp.addfiled(ftext3, fname3, userid, pid, date);
		flist.add(f);
		String ftext4=new String(request.getParameter("bz5").getBytes("8859_1"),"utf-8");
		String fname4="交通运输保障";
		f=imp.addfiled(ftext4, fname4, userid, pid, date);
		flist.add(f);
		String ftext5=new String(request.getParameter("bz6").getBytes("8859_1"),"utf-8");
		String fname5="物资保障";
		f=imp.addfiled(ftext5, fname5, userid, pid, date);
		flist.add(f);
		String ftext6=new String(request.getParameter("bz7").getBytes("8859_1"),"utf-8");
		String fname6="宣传保障";
		f=imp.addfiled(ftext6, fname6, userid, pid, date);
		flist.add(f);
		String ftext7=new String(request.getParameter("bz8").getBytes("8859_1"),"utf-8");
		String fname7=" 安全保障";
		f=imp.addfiled(ftext7, fname7, userid, pid, date);
		flist.add(f);
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setAttribute("flist", flist);
		request.getRequestDispatcher("/newplan12.jsp").forward(request, response);
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
