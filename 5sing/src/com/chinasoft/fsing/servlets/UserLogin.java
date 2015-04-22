package com.chinasoft.fsing.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasoft.fsing.biz.MenuBiz;
import com.chinasoft.fsing.biz.UserBiz;
import com.chinasoft.fsing.dao.UserDao;
import com.chinasoft.fsing.vo.Menu;
import com.chinasoft.fsing.vo.User;

/**
 * Servlet implementation class UserLogin
 */
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserBiz ubiz;
	private MenuBiz mbiz;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uaccount=request.getParameter("uaccount".trim());
		String upass=request.getParameter("upass".trim());
		ServletContext application=this.getServletContext();
		String msg=null;
		HttpSession session=request.getSession();
		ubiz=new UserBiz();
		mbiz=new MenuBiz();
		User user=null;
		user=ubiz.userLogin(uaccount, upass);
		if(user!=null){
			if(user.getUflag()==1){
				List<String> onLineUser=(List<String>)application.getAttribute("onLineUser");
				if(onLineUser.contains(user.getUaccount())){
					response.sendRedirect("login.jsp?mm=2");
				}else{
					List<Menu> menus=mbiz.showMenu(user);
					session.setAttribute("menus", menus);
					session.setAttribute("user", user);
					response.sendRedirect("index.jsp");
				}
			}else if(user.getUflag()==0){
				response.sendRedirect("login.jsp?mm=4");
			}
		}else{
			response.sendRedirect("login.jsp?mm=3");
		}


	}

}
