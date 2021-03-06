package com.example.servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.common.code.Segmentation;
import com.common.code.TextAnalyse;
import com.example.daoimp.FieldBaseImp;
import com.example.daoimp.VersionImp;
import com.example.daoimp.filedImp;
import com.example.daoimp.planImp;
import com.example.daoimp.userImp;
import com.example.demo.Field;
import com.example.demo.Plan;
import com.example.demo.Version;
import com.example.demo.VersionLink;

public class fragout_Servlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public fragout_Servlet() {
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

		String vid = request.getParameter("vid");
		VersionImp vimp = new VersionImp();
		planImp pimp = new planImp();
		FieldBaseImp fimp = new FieldBaseImp();
		VersionLink version=vimp.showVersion(vid);
		Plan plan = pimp.showPlan(version.getPid());
		String fieldName = fimp.getName(version.getFid());
		request.setAttribute("version", version);
		request.setAttribute("plan", plan);
		request.setAttribute("fieldName", fieldName);
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("/fragout.jsp").forward(request, response);
	}

	public void Evaluate(ArrayList<Field> flist) throws Exception{ 
		ArrayList<Field> list=flist;
		int size=list.size();
		double sim1[] ={0},sim2[] ={0};
		for(int i=0;i<size;i++){
			sim1[i]=TextAnalyse.getSimilarity(list.get(i).getFtext(),list.get(0).getFtext());
			
		}
		Segmentation seg=new Segmentation();
		
		for(int i=0;i<size;i++){
			sim2[i]=TextAnalyse.getSimilarity2(seg.seg_list(list.get(i).getFtext().replaceAll("[\\pP��������]", "")),
					seg.seg_list(list.get(0).getFtext().replaceAll("[\\pP��������]", "")));
		}
		double newlevel=0;
		userImp uimp=new userImp();
		for(int i=0;i<size;i++){
			newlevel=sim1[i]*0.5+sim2[i]*0.5;
			uimp.reviselevel(newlevel,list.get(i).getUserid() );
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
		String vid = request.getParameter("vid");
		HttpSession se=request.getSession();
		String userid=(String) se.getAttribute("userid");
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
		filedImp fimp=new filedImp();
		ArrayList<Field> flist=new ArrayList<Field>();
		flist=fimp.trackback(vid);
		try {
			Evaluate(flist);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("version_Servlet?pid=" + versionLink.getPid() + "&fid=" + versionLink.getFid());
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
