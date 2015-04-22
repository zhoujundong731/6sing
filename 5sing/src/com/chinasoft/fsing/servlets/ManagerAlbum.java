package com.chinasoft.fsing.servlets;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.fsing.biz.AlbumBiz;
import com.chinasoft.fsing.biz.UserBiz;
import com.chinasoft.fsing.util.DateUtil;
import com.chinasoft.fsing.util.DelUtil;
import com.chinasoft.fsing.vo.Album;
import com.chinasoft.fsing.vo.User;
import com.jspsmart.upload.SmartFile;
import com.jspsmart.upload.SmartFiles;
import com.jspsmart.upload.SmartRequest;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class ManagerAlbum
 */
public class ManagerAlbum extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AlbumBiz bbiz;
	private UserBiz ubiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerAlbum() {
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
		String path="userimages/",name=null;
		SmartRequest request2;
		SmartFiles files;
		Album album;
		SmartUpload up;
		String msg=null,bid,bname,btext,bimage,uid;
		List<Album> albums=null;
		User user=null;
		if(temp!=null){
			ubiz=new UserBiz();
			bbiz=new AlbumBiz();
			msg=request.getParameter("msg");	
			switch (Integer.parseInt(temp)) {
			//发送歌手信息
			case 1:
				List<User> arts=ubiz.showArt();
				request.setAttribute("arts", arts);
				request.getRequestDispatcher("managerIndex.jsp?page=addAlbumShowUser.jsp").forward(request, response);
				break;
			//信息添加
			case 2:
				up=new SmartUpload("UTF-8");
				up.initialize(this.getServletConfig(), request, response);
				up.setAllowedFilesList("jpg,gif,png");
				up.setMaxFileSize(2*1024*1024);
				try {
					up.upload();
					SmartFiles smartFiles=up.getFiles();
					SmartFile file=smartFiles.getFile(0);
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
				user=new User();
				user.setUid(Integer.parseInt(uid));
				bname=request2.getParameter("bname");
				btext=request2.getParameter("btext");
				bimage=name;
				album=new Album(bname, btext, bimage, user);
				if(bbiz.addAlbum(album)){
					msg="添加成功！";
					
				}else{
					if(name!=null){
							DelUtil.DelFile(this.getServletContext().getRealPath("/")+path+name);
					}
					msg="添加失败！";
				}
				request.getRequestDispatcher("ManagerAlbum?temp=3&msg="+msg).forward(request, response);
				break;
			//查看专辑信息
			case 3:
				albums=bbiz.showAll();
				request.setAttribute("albums", albums);
				request.getRequestDispatcher("managerIndex.jsp?page=showAllAlbum.jsp&msg="+msg).forward(request, response);
				break;
				//查看专辑详情
			case 4:
				bid=request.getParameter("bid");
				album=bbiz.showOne(bid);
				request.setAttribute("album", album);
				request.getRequestDispatcher("managerIndex.jsp?page=showOneAlbum.jsp&msg="+msg).forward(request, response);
				break;
				//删除专辑
			case 5:
				bid=request.getParameter("bid");
				if(bbiz.delAlbum(bid)){
					album=bbiz.showOne(bid);
					DelUtil.DelFile(this.getServletContext().getRealPath("/")+path+album.getBimage());
					msg="删除成功";
				}else{
					msg="删除失败！";
				}
				request.getRequestDispatcher("ManagerAlbum?temp=3&msg="+msg).forward(request, response);
				break;
				//修改专辑前
			case 6:
				bid=request.getParameter("bid");
				album=bbiz.showOne(bid);
				request.setAttribute("album", album);
				request.getRequestDispatcher("managerIndex.jsp?page=updateAlbum.jsp&msg="+msg).forward(request, response);
				break;
			case 7:
				up=new SmartUpload("UTF-8");
				up.initialize(this.getServletConfig(), request, response);
				up.setAllowedFilesList("jpg,gif,png");
				up.setMaxFileSize(2*1024*1024);
				try {
					up.upload();
					SmartFiles smartFiles=up.getFiles();
					SmartFile file=smartFiles.getFile(0);
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
				bid=request2.getParameter("bid");
				bname=request2.getParameter("bname");
				btext=request2.getParameter("btext");
				if(name!=null){
					bimage=name;
				}else{
					bimage=request2.getParameter("bimage");
				}
				album=new Album(bname, btext, bimage, null);
				album.setBid(Integer.parseInt(bid));
				if(bbiz.updateAlbum(album)){
					msg="修改成功！";
					DelUtil.DelFile(this.getServletContext().getRealPath("/")+path+request2.getParameter("bimage"));
					
				}else{
					msg="修改失败！";
					if(name!=null){
						DelUtil.DelFile(this.getServletContext().getRealPath("/")+path+name);
					}
				}
				request.getRequestDispatcher("ManagerAlbum?temp=3&msg="+msg).forward(request, response);
				break;
			default:
				break;
			}
		}
	}

}
