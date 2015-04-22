package com.chinasoft.fsing.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MV
 */
public class MV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MV() {
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
		String temp=request.getParameter("temp");
		String path=null;
		if(temp!=null){
			switch (Integer.parseInt(temp)) {
			case 1:
				path="aa.mp4";
				request.setAttribute("path", path);
				request.getRequestDispatcher("player.jsp").forward(request, response);
				break;
			case 2:
				path="bb.mp4";
				request.setAttribute("path", path);
				request.getRequestDispatcher("player.jsp").forward(request, response);
				break;
			case 3:
				path="cc.mp4";
				request.setAttribute("path", path);
				request.getRequestDispatcher("player.jsp").forward(request, response);
				break;
			case 4:
				path="dd.mp4";
				request.setAttribute("path", path);
				request.getRequestDispatcher("player.jsp").forward(request, response);
				break;
			case 5:
				path="ee.mp4";
				request.setAttribute("path", path);
				request.getRequestDispatcher("player.jsp").forward(request, response);
				break;

			default:
				break;
			}
		}
	}

}
