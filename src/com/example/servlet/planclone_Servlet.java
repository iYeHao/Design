package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.daoimp.VersionImp;
import com.example.daoimp.planImp;
import com.example.demo.PlanDetail;

public class planclone_Servlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public planclone_Servlet() {
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

		String pid= (String)request.getParameter("pid");
		String userid= (String) request.getSession().getAttribute("userid");
		String vidStr = (String)request.getParameter("vids");
		String[] vidStrArray = vidStr.split(",");
		List<String> vids = new ArrayList();
		for(int i = 0; i < vidStrArray.length; i++) {
			vids.add((vidStrArray[i]));
		}
		VersionImp imp = new VersionImp();
		imp.versionClone(vids);
		response.sendRedirect("fragtotal_Servlet?pid=" + pid);
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
