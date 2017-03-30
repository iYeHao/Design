package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.daoimp.userImp;
import com.example.demo.Register;
import com.example.demo.User;

public class RegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public RegisterServlet() {
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

		userImp imp=new userImp();
		String uname = request.getParameter("username");
		String upassword=request.getParameter("userpassword");
		int uage;
		if(request.getParameter("userage")!=null)
		{  uage = Integer.parseInt( request.getParameter("userage"));
		}
		else {
			 uage =0;
		}
		String uemail = request.getParameter("useremail");
		String usex =request.getParameter("usersex");
		String cpassword=request.getParameter("cuserpassword");
		boolean b=imp.find(uname);
		Register form = new Register();
		form.setUname(uname);
		form.setUsex(usex);
		form.setUage(uage);
		form.setCpassword(cpassword);
		form.setUemail(uemail);
		form.setUsex(usex);
		form.setUpassword(upassword);
		if(b==true){
			form.getErrors().put("uname", "*用户名已存在，请更换");
			
		}
		if(form.validate()==false||b==true){
			request.setAttribute("form", form);
			response.setHeader("Content-type", "text/html;charset=UTF-8");
    		response.setCharacterEncoding("UTF-8");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return ;
		}
		int ulevel=0;
		User user=imp.register(uemail, uname, upassword, uage, ulevel, usex);
		PrintWriter out=response.getWriter();
		response.setHeader("Content-type", "text/html;charset=UTF-8");
	    response.setCharacterEncoding("UTF-8");
		 if(user!=null)
		 {
			 out.print("<script language='javascript' >alert('Sucessfully signed up! Please login in!');window.location.href='login.jsp';</script>");
	    	//	request.getRequestDispatcher("/login.jsp").forward(request, response);	
	    	}else{
	    		request.getRequestDispatcher("/error.jsp").forward(request, response);
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
