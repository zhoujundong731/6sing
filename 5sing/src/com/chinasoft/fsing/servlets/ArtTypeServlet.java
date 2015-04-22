package com.chinasoft.fsing.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import com.chinasoft.fsing.biz.ArtTypeBiz;
import com.chinasoft.fsing.vo.ArtType;

/**
 * Servlet implementation class ArtTypeServlet
 */
public class ArtTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArtTypeBiz atbiz;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ArtTypeServlet() {
		super();
		atbiz=new ArtTypeBiz();
		System.out.println("��ʼ��һ��");
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
		String atid=null,atname=null,msg=null;
		String temp=request.getParameter("temp");
		if(temp!=null&&!"".equals(temp)){
			if(request.getParameter("msg")!=null){
				msg=(String)request.getParameter("msg");
			}
			switch (temp) {
			//���
			case "1":
				atname=request.getParameter("atname");
				if(atbiz.addArtType(new ArtType(atname))){
					msg="��ӳɹ���";
				}else{
					msg="���ʧ�ܣ�";
				}
				request.getRequestDispatcher("ArtTypeServlet?temp=2&msg="+msg).forward(request, response);
				break;
				//��ʾ
			case "2":
				List<ArtType> arttypes=atbiz.showAll();
				request.setAttribute("arttypes", arttypes);
				request.getRequestDispatcher("managerIndex.jsp?page=showAllArtType.jsp&msg="+msg).forward(request,response);
				break;
				//ɾ��
			case "3":
				atid=request.getParameter("atid");
				if(atbiz.delArtType(atid)){
					msg="ɾ���ɹ���";
				}else{
					msg="ɾ��ʧ�ܣ�";
				}
				request.getRequestDispatcher("ArtTypeServlet?temp=2&msg="+msg).forward(request, response);
				break;
			case "4":
				atid=request.getParameter("atid");
				atname=request.getParameter("atname");
				if(atbiz.updateArtType(new ArtType(Integer.parseInt(atid), atname))){
					msg="�޸ĳɹ���";
				}else{
					msg="�޸�ʧ�ܣ�";
				}
				request.getRequestDispatcher("ArtTypeServlet?temp=2&msg="+msg).forward(request, response);
				break;
			default:
				break;
			}

		}
	}


}
