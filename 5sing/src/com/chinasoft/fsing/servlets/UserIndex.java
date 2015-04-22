package com.chinasoft.fsing.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasoft.fsing.biz.SongBiz;
import com.chinasoft.fsing.biz.UserBiz;
import com.chinasoft.fsing.util.DateUtil;
import com.chinasoft.fsing.util.DelUtil;
import com.chinasoft.fsing.vo.Album;
import com.chinasoft.fsing.vo.Song;
import com.chinasoft.fsing.vo.SongType;
import com.chinasoft.fsing.vo.User;
import com.jspsmart.upload.SmartFile;
import com.jspsmart.upload.SmartFiles;
import com.jspsmart.upload.SmartRequest;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class UserIndex
 */
public class UserIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserBiz ubiz;
	private SongBiz sbiz;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserIndex() {
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
		if(temp!=null){
			HttpSession session=request.getSession();
			String uid,uname,usex,uaddress,usign,uphone,uimage,name,uemail,uimageo,msg=null;
			String path="file/",name1=null,name2=null,name3=null,bid,sname,stext,slrc,sid;
			User user=null;
			List<Song> songs=null;
			SmartUpload up;
			Song song=null;
			SmartFiles files;
			SmartFile file;
			SmartFile file1,file2,file3;
			SmartRequest request2;
			ubiz=new UserBiz();
			sbiz=new SongBiz();
			msg=request.getParameter("msg");
			switch (Integer.parseInt(temp)) {
			//回到主页
			case 1:
				response.sendRedirect("../index.jsp");
				break;
			case 2:
				up=new SmartUpload("UTF-8");
				up.initialize(this.getServletConfig(), request, response);
				up.setAllowedFilesList("jpg,gif,png");
				up.setMaxFileSize(2*1024*1024);
				path="userimages/";
				name=null;
				try {
					up.upload();
					files=up.getFiles();
					file=files.getFile(0);
					if(!file.isMissing()){
						Date date=new Date();
						name=DateUtil.getLongTime(date)+"."+file.getFileExt();
						file.saveAs(path+name);
					}
				} catch (SmartUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request2=up.getRequest();
				uid=request2.getParameter("uid");
				uname=request2.getParameter("uname");
				usex=request2.getParameter("usex");
				uphone=request2.getParameter("uphone");
				uemail=request2.getParameter("uemail");
				uaddress=request2.getParameter("uaddress");
				usign=request2.getParameter("usign");
				uimageo=request2.getParameter("uimage");
				uimage=name;
				if(uimage==null){
					uimage=uimageo;
				}
				user=new User(Integer.parseInt(uid), null, uname, null, uemail, uphone, uaddress, Integer.parseInt(usex), uimage, usign, 0, 0);
				if(ubiz.updateUser(user)){
					if(name!=null){
						DelUtil.DelFile(this.getServletContext().getRealPath("/")+path+uimageo);
					}
					msg="修改成功！";
					user=ubiz.showOneUser(uid);
					session.setAttribute("user", user);
					
				}else{
					if(name!=null){
						DelUtil.DelFile(this.getServletContext().getRealPath("/")+name);
					}
					msg="修改失败！";
				}
				request.getRequestDispatcher("userIndex.jsp?page=null.jsp&msg="+msg).forward(request, response);
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
				user=new User();
				user.setUid(Integer.parseInt(uid));
				bid=request2.getParameter("bid".trim());
				sname=request2.getParameter("sname".trim());
				slrc=request2.getParameter("slrc".trim());
				stext=request2.getParameter("stext".trim());
				Album album=new Album();
				song=new Song(user, album, sname, name1, name2, name3, slrc, stext);
				//歌曲类型（原创）
				List<SongType> songtypes=new ArrayList<>();
				songtypes.add(new SongType(2, null));
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
				request.getRequestDispatcher("UserIndex?temp=4&msg="+msg).forward(request, response);
				break;
				//查看用户的歌曲
			case 4:
				user=(User)session.getAttribute("user");
				uid=user.getUid()+"";
				songs=sbiz.showAllSongByUid(uid);
				request.setAttribute("songs", songs);
				request.getRequestDispatcher("userIndex.jsp?page=showAllSong.jsp&msg="+msg).forward(request,response);
				break;
				//查看单个歌曲信息
			case 5:
				sid=request.getParameter("sid");
				song=sbiz.showOneSong(sid);
				request.setAttribute("song", song);
				request.getRequestDispatcher("userIndex.jsp?page=showOneSong.jsp").forward(request, response);
				break;
				//修改前页面
			case 6:
				sid=request.getParameter("sid");
				song=sbiz.showOneSong(sid);
				request.setAttribute("song", song);
				request.getRequestDispatcher("userIndex.jsp?page=updateSong.jsp").forward(request, response);
				break;
				//删除歌曲信息
			case 7:
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
				request.getRequestDispatcher("UserIndex?temp=4&msg="+msg).forward(request, response);
				break;
				//信息修改
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
				song=new Song(user, null, sname, name1, name2, name3, slrc, stext);
				song.setSid(Long.parseLong(sid));
				if(sbiz.updateSong(song)){
					msg="修改成功！";
					if(name1!=null){
						DelUtil.DelFile(this.getServletContext().getRealPath("/")+path+d1);
					}
					if(name2!=null){
						DelUtil.DelFile(this.getServletContext().getRealPath("/")+path+d2);
					}
					if(name3!=null){
						DelUtil.DelFile(this.getServletContext().getRealPath("/")+path+d3);
					}
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
				request.getRequestDispatcher("UserIndex?temp=4&msg="+msg).forward(request, response);
				break;
			}
		}
	}
}

