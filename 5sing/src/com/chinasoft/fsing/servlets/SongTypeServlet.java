package com.chinasoft.fsing.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.fsing.biz.SongTypeBiz;
import com.chinasoft.fsing.vo.SongType;

/**
 * Servlet implementation class SongTypeServlet
 */
public class SongTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SongTypeBiz stbiz;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SongTypeServlet() {
		super();
		stbiz=new SongTypeBiz();
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
		if(temp!=null&&!"".equals(temp)){
			List<SongType> songtypes=new ArrayList<>();
			SongType st=null;
			String stid=null;
			String stname=null;
			String msg=null;
			if((request.getParameter("msg"))!=null){
				msg=request.getParameter("msg");
			}
			switch (Integer.parseInt(temp)) {
			case 1:
				stname=request.getParameter("stname");
				if(stname!=null &&!"".equals(stname)){
					st=new SongType(stname);
					if(stbiz.addSongType(st)){
						msg="Ìí¼Ó³É¹¦£¡";
					}else{
						msg="Ìí¼ÓÊ§°Ü!";
					}
				}else{
					msg="Ìí¼ÓÊ§°Ü£¡";
				}
				//request.getRequestDispatcher("managerIndex.jsp?page=null.jsp&msg="+msg).forward(request,response);
				request.getRequestDispatcher("SongTypeServlet?temp=2&msg="+msg).forward(request, response);
				break;
			case 2:
				songtypes=stbiz.showAll();
				request.setAttribute("songtypes", songtypes);
				request.getRequestDispatcher("managerIndex.jsp?page=showAllSongtype.jsp").forward(request,response);
				break;
			case 3:
				stid=request.getParameter("stid");
				if(stbiz.delSongType(stid)){
					msg="É¾³ý³É¹¦£¡";
				}else{
					msg="É¾³ýÊ§°Ü£¡";
				}
				//request.getRequestDispatcher("managerIndex.jsp?page=null.jsp&msg="+msg).forward(request,response);
				request.getRequestDispatcher("SongTypeServlet?temp=2&msg="+msg).forward(request, response);
				break;
			case 4:
				stid=request.getParameter("stid");
				stname=request.getParameter("stname");
				st=new SongType(Integer.parseInt(stid), stname);
				if(stbiz.updateSongType(st)){
					msg="ÐÞ¸Ä³É¹¦£¡";
				}else{
					msg="ÐÞ¸ÄÊ§°Ü£¡";
				}
				//request.getRequestDispatcher("managerIndex.jsp?page=null.jsp&msg="+msg).forward(request,response);
				request.getRequestDispatcher("SongTypeServlet?temp=2&msg="+msg).forward(request, response);
				break;
			default:
				break;
			}
		}
	}

}
