package com.chinasoft.fsing.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import com.chinasoft.fsing.biz.ManagerBiz;
import com.chinasoft.fsing.vo.Manager;

/**
 * Servlet implementation class UpdateManager
 */
public class UpdateManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ManagerBiz managerBiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateManager() {
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
		managerBiz=new ManagerBiz();
		HttpSession session=request.getSession();
		String mid=request.getParameter("mid");
		String mphone=request.getParameter("mphone");
		String memail=request.getParameter("memail");
		String mname=request.getParameter("mname");
		String mpower=request.getParameter("mpower");
		String mflag=request.getParameter("mflag");
		String msg="";
		Manager manager=new Manager(Integer.parseInt(mid), mname, mphone, memail, Integer.parseInt(mpower), Integer.parseInt(mflag));
		if(managerBiz.updateManager(manager)){
			session.setAttribute("manager", manager);
			msg="修改成功！";
		}else{
			msg="修改失败";
			System.out.println("shibai");
		}
		request.getRequestDispatcher("managerIndex.jsp?page=showOneManagerInfo.jsp&msg="+msg).forward(request, response);
	}

}
