package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.daoimp.FieldBaseImp;
import com.example.daoimp.VersionImp;
import com.example.daoimp.planImp;
import com.example.demo.Plan;
import com.example.demo.Version;
import com.example.demo.VersionLink;

public class fragbottom_Servlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public fragbottom_Servlet() {
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

		int vid = Integer.parseInt(request.getParameter("vid"));
		VersionImp vimp = new VersionImp();
		FieldBaseImp fimp = new FieldBaseImp();
		VersionLink version=vimp.showVersion(vid);
		String fieldName = fimp.getName(version.getFid());
		request.setAttribute("version", version);
		request.setAttribute("fieldName", fieldName);
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("/fragbottom.jsp").forward(request, response);
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
		int vid = Integer.parseInt(request.getParameter("vid"));
		int userid=(Integer) request.getSession().getAttribute("userid");
		String vcomment = new String(request.getParameter("vcomment").getBytes("8859_1"),"utf-8");
		String vtext = new String(request.getParameter("vtext").getBytes("8859_1"),"utf-8");
		VersionImp vimp = new VersionImp();
		VersionLink versionLink = vimp.showVersion(vid);
		Version version = new Version();
		version.setVparent(vid);
		version.setPid(versionLink.getPid());
		version.setFid(versionLink.getFid());
		version.setUserid(userid);
		version.setVcomment(vcomment);
		version.setVtext(vtext);
		version.setCreatetime(new Timestamp(new java.util.Date().getTime()));	
		vimp.add(version);
		PrintWriter out = response.getWriter();
		out.println("{\"success\": true}");
		out.flush();
		out.close();
		//response.sendRedirect("version_Servlet?pid=" + versionLink.getPid() + "&fid=" + versionLink.getFid());
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
