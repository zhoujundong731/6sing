package com.chinasoft.fsing.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.fsing.biz.AlbumBiz;
import com.chinasoft.fsing.biz.SongBiz;
import com.chinasoft.fsing.biz.SongTypeBiz;
import com.chinasoft.fsing.biz.UserBiz;
import com.chinasoft.fsing.util.DateUtil;
import com.chinasoft.fsing.util.DelUtil;
import com.chinasoft.fsing.vo.Album;
import com.chinasoft.fsing.vo.Song;
import com.chinasoft.fsing.vo.SongType;
import com.chinasoft.fsing.vo.SubPage;
import com.chinasoft.fsing.vo.User;
import com.jspsmart.upload.SmartFile;
import com.jspsmart.upload.SmartFiles;
import com.jspsmart.upload.SmartRequest;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class ManagerSong
 */
public class ManagerSong extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserBiz ubiz;
	private SongBiz sbiz; 
	private SongTypeBiz stbiz;
	private AlbumBiz abiz;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManagerSong() {
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

		String temp=request.getParameter("temp".trim());
		List<SongType> songtypes=null;
		List<Song> songs=null;
		List<Album> albums=null;
		String uid,uname,path="file/",name1=null,name2=null,name3=null,bid,sname,stext,slrc,sid,msg=null;
		if(temp!=null){
			ubiz=new UserBiz();
			sbiz=new SongBiz();
			stbiz=new SongTypeBiz();
			abiz=new AlbumBiz();
			String [] values=null;
			Song song;
			SmartUpload up;
			SmartFiles files;
			SmartRequest request2;
			SmartFile file1,file2,file3;
			User user=null;
			Album album=null;
			if(request.getParameter("msg")!=null){
				msg=request.getParameter("msg");
			}
			switch (Integer.parseInt(temp)) {
			//发送所有的歌手信息
			case 1:
				List<User> arts=ubiz.showArt();
				request.setAttribute("arts", arts);
				request.getRequestDispatcher("managerIndex.jsp?page=addSongShowUser.jsp").forward(request, response);
				break;
				//给页面传送歌手的专辑信息和歌曲类型信息
			case 2:
				uid=request.getParameter("uid");
				uname=request.getParameter("uname");
				request.setAttribute("uid", uid);
				uname=new String(uname.getBytes("iso-8859-1"),"utf-8");
				request.setAttribute("uname", uname);
				songtypes=stbiz.showAll();
				request.setAttribute("songtypes", songtypes);
				albums=abiz.showAlbumsByUser(uid);
				request.setAttribute("albums", albums);
				request.getRequestDispatcher("managerIndex.jsp?page=addSong.jsp").forward(request, response);
				break;
				//添加歌曲信息
			case 3:
				up=new SmartUpload("utf-8");
				up.initialize(this.getServletConfig(), request, response);
				up.setAllowedFilesList("mp3,flac,mp4");
				up.setMaxFileSize(1024*1024*100);
				try {
					up.upload();
					files=up.getFiles();
					file1=files.getFile(0);
					file2=files.getFile(1);
					file3=files.getFile(2);
					if(!file1.isMissing()){
						Date date=new Date();
						name1=DateUtil.getLongTime(date)+"."+file1.getFileExt();
						file1.saveAs(path+name1);
					}
					if(!file2.isMissing()){
						Date date=new Date();
						name2=DateUtil.getLongTime(date)+"."+file2.getFileExt();
						file2.saveAs(path+name2);
					}
					if(!file3.isMissing()){
						Date date=new Date();
						name3=DateUtil.getLongTime(date)+"."+file3.getFileExt();
						file3.saveAs(path+name3);
					}

				} catch (SmartUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request2=up.getRequest();
				uid=request2.getParameter("uid");
				user=new User();user.setUid(Integer.parseInt(uid));
				bid=request2.getParameter("bid".trim());
				sname=request2.getParameter("sname".trim());
				slrc=request2.getParameter("slrc".trim());
				stext=request2.getParameter("stext".trim());
				values=request2.getParameterValues("songtypes");
				songtypes=new ArrayList<>();
				for(String stid:values){
					SongType st=new SongType(Integer.parseInt(stid), null);
					songtypes.add(st);
				}

				album=new Album();
				if(bid!=null){
					album.setBid(Integer.parseInt(bid));
				}
				song=new Song(user, album, sname, name1, name2, name3, slrc, stext);
				song.setSongtypes(songtypes);
				if(sbiz.addSong(song)){
					msg="添加成功！";
				}else{
					if(name1!=null){
						DelUtil.DelFile(this.getServletContext().getRealPath("/")+path+name1);
					}
					if(name2!=null){
						DelUtil.DelFile(this.getServletContext().getRealPath("/")+path+name2);
					}
					if(name3!=null){
						DelUtil.DelFile(this.getServletContext().getRealPath("/")+path+name3);
					}
					msg="添加失败";
				}
				request.getRequestDispatcher("ManagerSong?temp=4&msg="+msg).forward(request, response);
				break;
				//查看所有歌曲信息
			case 4:
				String cp=request.getParameter("cp");
				SubPage subPage=new SubPage();
				if(cp==null){
					subPage.setCurrentPage(1);
				}else{
					subPage.setCurrentPage(Integer.parseInt(cp));
				}
				subPage.setTotalElement(sbiz.getAllSongNum());
				subPage.setShowNumber(5);
				songs=sbiz.showAllSong(subPage);
				request.setAttribute("songs", songs);
				request.setAttribute("subpage",subPage);
				request.getRequestDispatcher("managerIndex.jsp?page=showAllSong.jsp&msg="+msg).forward(request, response);
				break;
				//删除歌曲
			case 5:
				sid=request.getParameter("sid");
				song=new Song();
				song.setSid(Long.parseLong(sid));
				if(sbiz.delSong(song)){
					if((name1=song.getSmaddress())!=null){
						DelUtil.DelFile(this.getServletContext().getRealPath("/")+path+name1);
					}
					if((name2=song.getSwaddress())!=null){
						DelUtil.DelFile(this.getServletContext().getRealPath("/")+path+name2);
					}
					if((name3=song.getSvaddress())!=null){
						DelUtil.DelFile(this.getServletContext().getRealPath("/")+path+name3);
					}
					msg="删除成功！";

				}else{
					msg="删除失败";
				}
				request.getRequestDispatcher("ManagerSong?temp=4&msg="+msg).forward(request, response);
				break;
				//通过ID获取歌曲信息
			case 6:
				sid=request.getParameter("sid");
				song=sbiz.showOneSong(sid);
				request.setAttribute("song", song);
				request.getRequestDispatcher("managerIndex.jsp?page=showOneSong.jsp").forward(request, response);
				break;
				//修改前的页面
			case 7:
				sid=request.getParameter("sid");
				song=sbiz.showOneSong(sid);
				request.setAttribute("song", song);
				songtypes=stbiz.showAll();
				request.setAttribute("songtypes", songtypes);
				request.getRequestDispatcher("managerIndex.jsp?page=updateSong.jsp").forward(request, response);
				break;
				//修改
			case 8:
				up=new SmartUpload("utf-8");
				up.initialize(this.getServletConfig(), request, response);
				up.setAllowedFilesList("mp3,flac,mp4");
				up.setMaxFileSize(1024*1024*100);
				try {
					up.upload();
					files=up.getFiles();
					file1=files.getFile(0);
					file2=files.getFile(1);
					file3=files.getFile(2);
					if(!file1.isMissing()){
						Date date=new Date();
						name1=DateUtil.getLongTime(date)+"."+file1.getFileExt();
						file1.saveAs(path+name1);
					}
					if(!file2.isMissing()){
						Date date=new Date();
						name2=DateUtil.getLongTime(date)+"."+file2.getFileExt();
						file2.saveAs(path+name2);
					}
					if(!file3.isMissing()){
						Date date=new Date();
						name3=DateUtil.getLongTime(date)+"."+file3.getFileExt();
						file3.saveAs(path+name3);
					}

				} catch (SmartUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request2=up.getRequest();
				sid=request2.getParameter("sid");
				sname=request2.getParameter("sname".trim());
				slrc=request2.getParameter("slrc2".trim());
				if(slrc==null){
					slrc=request2.getParameter("slrc".trim());
				}
				stext=request2.getParameter("stext".trim());
				String type=request2.getParameter("type".trim());
				if("y".equals(type)){
					values=request2.getParameterValues("songtypes");
					songtypes=new ArrayList<>();
					for(String stid:values){
						SongType st=new SongType(Integer.parseInt(stid), null);
						songtypes.add(st);
					}
				}else{	
				}
				String d1,d2,d3;
				d1=request2.getParameter("d1");
				d2=request2.getParameter("d2");
				d3=request2.getParameter("d3");
				if(name1==null){
					name1=d1;
				}
				if(name2==null){
					name2=d2;
				}
				if(name3==null){
					name3=d3;
				}
				song=new Song(user, album, sname, name1, name2, name3, slrc, stext);
				song.setSid(Long.parseLong(sid));
				song.setSongtypes(songtypes);
				if(sbiz.updateSong(song)){
					if(name1!=null){
						DelUtil.DelFile(this.getServletContext().getRealPath("/")+path+d1);
					}
					if(name2!=null){
						DelUtil.DelFile(this.getServletContext().getRealPath("/")+path+d2);
					}
					if(name3!=null){
						DelUtil.DelFile(this.getServletContext().getRealPath("/")+path+d3);
					}
					msg="修改成功！";
				}else{
					if(name1!=null){
						DelUtil.DelFile(this.getServletContext().getRealPath("/")+path+name1);
					}
					if(name2!=null){
						DelUtil.DelFile(this.getServletContext().getRealPath("/")+path+name2);
					}
					if(name3!=null){
						DelUtil.DelFile(this.getServletContext().getRealPath("/")+path+name3);
					}
					msg="修改失败！";
				}
				request.getRequestDispatcher("ManagerSong?temp=4&msg="+msg).forward(request, response);
				break;
			case 9:
				sid=request.getParameter("sid");
				bid=request.getParameter("bid");
				if(sbiz.delFromAlbum(sid)){
					msg="删除成功！";
				}else{
					msg="删除失败！";
				}
				request.getRequestDispatcher("ManagerAlbum?temp=4&msg="+msg+"&bid="+bid).forward(request, response);
				break;
			default:
				break;
			}
		}
	}

}
