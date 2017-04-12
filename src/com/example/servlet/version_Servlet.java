package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kopitubruk.util.json.JSONConfig;
import org.kopitubruk.util.json.JSONUtil;

import com.example.daoimp.FieldBaseImp;
import com.example.daoimp.VersionImp;
import com.example.daoimp.planImp;
import com.example.demo.Plan;
import com.example.demo.VersionLink;

public class version_Servlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public version_Servlet() {
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

		int pid = Integer.parseInt(request.getParameter("pid"));
		int fid = Integer.parseInt(request.getParameter("fid"));
		VersionImp vimp = new VersionImp();
		planImp pimp = new planImp();
		FieldBaseImp fimp = new FieldBaseImp();
		List<VersionLink> links = vimp.getLinks(pid, fid);
		JSONConfig cfg = new JSONConfig();
		cfg.addReflectClass(VersionLink.class);
		String json = JSONUtil.toJSON(links, cfg);
		Plan plan = pimp.showPlan(pid);
		String fieldName = fimp.getName(fid);
		request.setAttribute("links", json);
		request.setAttribute("plan", plan);
		request.setAttribute("fieldName", fieldName);
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("/Version.jsp").forward(request, response);
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
