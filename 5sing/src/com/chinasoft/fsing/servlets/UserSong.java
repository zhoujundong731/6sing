package com.chinasoft.fsing.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasoft.fsing.biz.AlbumBiz;
import com.chinasoft.fsing.biz.SongBiz;
import com.chinasoft.fsing.biz.UserBiz;
import com.chinasoft.fsing.vo.Album;
import com.chinasoft.fsing.vo.Song;
import com.chinasoft.fsing.vo.SubPage;
import com.chinasoft.fsing.vo.User;

/**
 * Servlet implementation class UserSong
 */
public class UserSong extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserBiz ubiz;
	private SongBiz sbiz;
	private AlbumBiz bbiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSong() {
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
		HttpSession session=request.getSession();
		if(temp!=null){
			List<User> users=null;
			List<Song> songs=null;
			Album album=null;
			String uid,sid,bid;
			User user=null;
			Song song=null;
			ubiz=new UserBiz();
			sbiz=new SongBiz();
			bbiz=new AlbumBiz();
			List<User> photo=null;
			switch (Integer.parseInt(temp)) {
			//照片墙功能
			case 1:
				photo=ubiz.getPhoto(11);
				//session.setAttribute("photo", photo);
				request.setAttribute("photo", photo);
				request.getRequestDispatcher("photo.jsp").forward(request, response);
				break;
				//显示歌手详情
			case 2:
				uid=request.getParameter("uid");
				user=ubiz.showOneUserAndSong(uid);
				request.setAttribute("oneUser", user);
				request.getRequestDispatcher("showUser.jsp").forward(request, response);
				break;
				//听一首歌
			case 3:
				sid=request.getParameter("sid");
				sbiz.addClick(sid);
				song=sbiz.showOneSong(sid);
				request.setAttribute("song",song);
				request.getRequestDispatcher("yinyue.jsp").forward(request, response);
				break;
				//原创推荐
			case 4:
				temp="原创推荐音乐";
				request.setAttribute("temp", temp);
				songs=(List<Song>)session.getAttribute("tenYuan");
				request.setAttribute("songs", songs);
				request.getRequestDispatcher("paiHangBang.jsp").forward(request, response);
				break;
				//翻唱推荐
			case 5:
				temp="翻唱推荐音乐";
				songs=(List<Song>)session.getAttribute("tenFan");
				request.setAttribute("songs", songs);
				request.setAttribute("temp", temp);
				request.getRequestDispatcher("paiHangBang.jsp").forward(request, response);
				break;
				//原创排行
			case 6:
				temp="原创排行音乐";
				songs=(List<Song>)session.getAttribute("yuanPai");
				request.setAttribute("songs", songs);
				request.setAttribute("temp", temp);
				request.getRequestDispatcher("paiHangBang.jsp").forward(request, response);
				break;
				//翻唱排行
			case 7:
				temp="翻唱排行音乐";
				songs=(List<Song>)session.getAttribute("fanPai");
				request.setAttribute("songs", songs);
				request.setAttribute("temp", temp);
				request.getRequestDispatcher("paiHangBang.jsp").forward(request, response);
				break;
				//下载排行
			case 8:
				temp="下载排行音乐";
				songs=(List<Song>)session.getAttribute("topDown");
				request.setAttribute("songs", songs);
				request.setAttribute("temp", temp);
				request.getRequestDispatcher("paiHangBang.jsp").forward(request, response);
				break;
				//收藏排行
			case 9:
				temp="收藏排行音乐";
				songs=(List<Song>)session.getAttribute("topCum");
				request.setAttribute("songs", songs);
				request.setAttribute("temp", temp);
				request.getRequestDispatcher("paiHangBang.jsp").forward(request, response);
				break;
				//查看所有用户
			case 10:
				String cp=request.getParameter("cp");
				SubPage subPage=new SubPage();
				if(cp==null){
					subPage.setCurrentPage(1);
				}else{
					subPage.setCurrentPage(Integer.parseInt(cp));
				}
				subPage.setTotalElement(ubiz.getUserNum());
				subPage.setShowNumber(5);
				users=ubiz.showAllUser(subPage);
				request.setAttribute("subpage",subPage);
				request.setAttribute("users", users);
				request.getRequestDispatcher("showAllUser.jsp").forward(request, response);
				break;
				//查看专辑信息
			case 11:
				bid=request.getParameter("bid");
				album=bbiz.showOne(bid);
				request.setAttribute("album", album);
				request.getRequestDispatcher("type.jsp").forward(request, response);
				break;
				//播放全部
			case 12:
				songs=(List<Song>)session.getAttribute("topDown");
				request.setAttribute("songs", songs);
				request.setAttribute("temp", temp);
				request.getRequestDispatcher("yinyue.jsp").forward(request, response);
				break;
				//搜索style sname
			case 13:
				String stype=request.getParameter("stype");
				String sname=request.getParameter("sname");
				temp="您的搜索结果";
				songs=sbiz.searchFrom(stype, sname);
				request.setAttribute("songs", songs);
				request.setAttribute("temp", temp);
				request.getRequestDispatcher("paiHangBang.jsp").forward(request, response);
				break;
			default:
				
				break;
			}
			
		}
	}

}
