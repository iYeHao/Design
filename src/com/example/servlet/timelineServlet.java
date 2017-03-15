package com.example.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.daoimp.filedImp;
import com.example.demo.Field;
import com.common.code.*;

public class timelineServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public timelineServlet() {
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

		String fid ="123456";
		filedImp imp =new filedImp();
		ArrayList<Field> flist =imp.trackback(fid);
		int size=flist.size();
		if(size!=0){
			String str1=flist.get(0).getFtext();
			if(size==1){
				flist.get(0).setContribution(1);
				request.setAttribute("flist", flist);
				request.getRequestDispatcher("/time.jsp").forward(request, response);
			}else{
			String str2=null;
			double s[]=new double [size];//个个版本和最终版本的相似度
			s[0]=1;
			double c[]=new double[size];//个个版本的作者的贡献度
			TextAnalyse ta=new TextAnalyse();
		for(int i=1;i<size;i++){
			 str2=flist.get(i).getFtext();
			 s[i]=ta.getSimilarity(str1, str2);
			 System.out.println(s[i]);
		}
		for(int i=0;s.length-i-2>=0;i++){
			c[i]=(s[s.length-i-2]-s[s.length-i-1])/(1-s[s.length-1]);
			System.out.println(c[i]);
		}
		for(int i=0;i<c.length-1;i++){
			System.out.println(c.length);
			flist.get(i).setContribution(c[c.length-i-2]);
		}
		}
		}else{
			request.setAttribute("flist", flist);
			request.getRequestDispatcher("/time.jsp").forward(request, response);
		}
		request.setAttribute("flist", flist);
		request.getRequestDispatcher("/timeline.jsp").forward(request, response);
		
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
