package com.chinasoft.fsing.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasoft.fsing.biz.ManagerBiz;
import com.chinasoft.fsing.biz.MenuBiz;
import com.chinasoft.fsing.vo.Manager;
import com.chinasoft.fsing.vo.Menu;

/**
 * Servlet implementation class ManagerLoginServlet
 */
public class ManagerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ManagerBiz mbiz;
	private MenuBiz mubiz;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManagerLoginServlet() {
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
		Manager manager=null;
		ServletContext application=this.getServletContext();
		HttpSession session=request.getSession();
		mbiz=new ManagerBiz();
		mubiz=new MenuBiz();
		String mname=request.getParameter("mname");
		String mpass=request.getParameter("mpass");
		/*		String mname="manager";
		String mpass="manager";*/
		List<Menu> menus=new ArrayList<>();
		manager=mbiz.login(mname, mpass);
		String str="";
		System.out.println("用户登陆,运行了一次！");
		if(manager!=null){
			List<String> onLineMan=(List<String>)application.getAttribute("onLineMan");
			if(onLineMan.contains(manager.getMname())){
				response.sendRedirect("login.jsp?mm=2");
			}else{
				menus=mubiz.showMenu(manager);
				session.setAttribute("manager", manager);
				session.setAttribute("menus", menus);
				response.sendRedirect("manager/managerIndex.jsp?page=null.jsp");
			}
		}else{
			response.sendRedirect("login.jsp?mm=3");
		}
	}

}
