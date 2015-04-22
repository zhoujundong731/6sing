package com.chinasoft.fsing.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.fsing.biz.UserBiz;
import com.chinasoft.fsing.vo.User;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserBiz ubiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ubiz=new UserBiz();
		String msg=null;
		String uaccount = request.getParameter("uaccount");
		String upass = request.getParameter("upass1");
		int usex =Integer.parseInt(request.getParameter("usex")) ;
		String uemail = request.getParameter("uemail");
		String uphone = request.getParameter("uphone");
		User user=new User(uaccount, upass, uemail, uphone, usex);
		if(ubiz.userRegister(user)){
			msg="×¢²á³É¹¦£¬ÇëµÇÂ½£¡";
			request.getRequestDispatcher("login.jsp?msg="+msg).forward(request, response);
		}else{
			msg="×¢²áÊ§°Ü£¬ÇëÖØÐÂ×¢²á£¡";
			request.getRequestDispatcher("register.jsp?msg="+msg).forward(request, response);
		}
	}

}
