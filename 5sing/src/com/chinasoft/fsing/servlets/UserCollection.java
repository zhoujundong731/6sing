package com.chinasoft.fsing.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasoft.fsing.biz.CollectionBiz;
import com.chinasoft.fsing.biz.CommentBiz;
import com.chinasoft.fsing.biz.SongBiz;
import com.chinasoft.fsing.vo.Collection;
import com.chinasoft.fsing.vo.Comment;
import com.chinasoft.fsing.vo.Song;
import com.chinasoft.fsing.vo.User;

/**
 * Servlet implementation class UserCollection
 */
public class UserCollection extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CollectionBiz cbiz;
	private CommentBiz cobiz;
	private SongBiz sbiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCollection() {
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
		if(temp!=null){
			Collection coll=null;
			cbiz=new CollectionBiz();
			cobiz=new CommentBiz();
			String msg=null,ctid,sid;
			sbiz=new SongBiz();
			msg=request.getParameter("msg");
			List<Comment> comments=null;
			HttpSession session=request.getSession();
			User user=(User)session.getAttribute("user");
			if(user==null){
			}
			String uid=user.getUid()+"";
			List<Collection> colls=null;
			switch (Integer.parseInt(temp)) {
			//��ȡ�û��ղ�
			case 1:
				colls=cbiz.showAllCollByUid(uid);
				request.setAttribute("colls", colls);
				request.getRequestDispatcher("userIndex.jsp?page=showAllColl.jsp&msg="+msg).forward(request, response);
				break;
			case 2:
				ctid=request.getParameter("ctid");
				if(cbiz.delColl(ctid)){
					msg="ȡ���ɹ���";
				}else{
					msg="ȡ��ʧ�ܣ�";
				}
				request.getRequestDispatcher("UserCollection?temp=1&msg="+msg).forward(request, response);
				break;
				//����ղ�
			case 3:
				sid=request.getParameter("sid");
				if(cbiz.isColl(user.getUid()+"", sid)){
					msg="�����ղع��˸�����";
				}else{
					Song song=new Song();
					song.setSid(Long.parseLong(sid));
					coll=new Collection(user, song);
					if(cbiz.addColl(coll)){
						msg="�ղسɹ���";
						sbiz.addCnum(sid);
					}else{
						msg="�ղ�ʧ�ܣ�";
					}
				}
				request.getRequestDispatcher("UserCollection?temp=1&msg="+msg).forward(request, response);
				break;
				//�鿴��������
			case 4:
				comments=cobiz.showCommByUid(user.getUid()+"");
				request.setAttribute("comments", comments);
				request.getRequestDispatcher("userIndex.jsp?page=showAllComment.jsp&msg="+msg).forward(request, response);
				break;
				//�鿴����������
			case 5:
				sid=request.getParameter("sid");
				comments=cobiz.showCommBySid(sid);
				request.setAttribute("comments", comments);
				Song song=sbiz.showOneSong(sid);
				song.setSid(Long.parseLong(sid));
				request.setAttribute("song", song);
				request.getRequestDispatcher("comment.jsp?msg="+msg).forward(request, response);
				break;
				//��������
			case 6:
				sid=request.getParameter("sid");
				song=new Song();song.setSid(Long.parseLong(sid));
				String ctext=request.getParameter("ctext");
				Comment comment=new Comment(ctext, user, song);
				if(cobiz.addComm(comment)){
					msg="���۳ɹ���";
				}else{
					msg="����ʧ�ܣ�";
				}
				request.getRequestDispatcher("UserCollection?temp=5&sid="+sid+"&msg="+msg).forward(request, response);
				break;
				
			default:
				break;
			}
			
		}
	}

}
