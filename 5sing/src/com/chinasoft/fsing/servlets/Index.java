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
import com.chinasoft.fsing.vo.User;

/**
 * Servlet implementation class Index
 */
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserBiz ubiz;
	private SongBiz sbiz;
	private AlbumBiz bbiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String info="info";
		HttpSession session=request.getSession();
		session.setAttribute("info", info);
		ubiz=new UserBiz();
		sbiz=new SongBiz();
		bbiz=new AlbumBiz();
		User oneUser=ubiz.getIndexOne();
		session.setAttribute("oneUser", oneUser);
		List<User> tenUser=ubiz.getIndexTen(oneUser);
		session.setAttribute("tenUser", tenUser);
		List<Song> tenYuan=sbiz.getTenSongYuan();
		List<Song> tenFan=sbiz.getTenSongFan();
		List<Song> tenSui=sbiz.getTenSongSui();
		List<Song> yuanPai=sbiz.getTenSongYuanPai();
		List<Song> yuanHou=sbiz.getTenSongYuanHou();
		List<Song> fanPai=sbiz.getTenSongFanPai();
		List<Song> topDown=sbiz.getTopDown(4);
		List<Song> topCum=sbiz.getTopCnum(4);
		List<Album> tenAlbums=bbiz.getTenAlbums(10);
		session.setAttribute("tenYuan", tenYuan);
		session.setAttribute("tenFan", tenFan);
		session.setAttribute("tenSui", tenSui);
		session.setAttribute("yuanPai", yuanPai);
		session.setAttribute("yuanHou", yuanHou);
		session.setAttribute("fanPai", fanPai);
		session.setAttribute("topDown", topDown);
		session.setAttribute("topCum", topCum);
		session.setAttribute("tenAlbums", tenAlbums);
		response.sendRedirect("index.jsp");
		
	}

}
