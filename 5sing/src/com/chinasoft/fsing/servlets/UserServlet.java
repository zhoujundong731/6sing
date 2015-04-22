package com.chinasoft.fsing.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.fsing.biz.ArtTypeBiz;
import com.chinasoft.fsing.biz.UserBiz;
import com.chinasoft.fsing.util.DateUtil;
import com.chinasoft.fsing.util.DelUtil;
import com.chinasoft.fsing.vo.ArtType;
import com.chinasoft.fsing.vo.SubPage;
import com.chinasoft.fsing.vo.User;
import com.jspsmart.upload.SmartFile;
import com.jspsmart.upload.SmartFiles;
import com.jspsmart.upload.SmartRequest;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserBiz ubiz;
	private ArtTypeBiz atbiz;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
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
		String uname,usex,uimage,utext,msg = null,uid;
		User user=null;
		List<ArtType> arttypes=new ArrayList<>();
		List<User> users=null;
		if(temp!=null&&!"".equals(temp)){
			
			if(request.getParameter("msg")!=null){
				msg=request.getParameter("msg");
			}
			ubiz=new UserBiz();
			switch (Integer.parseInt(temp)) {
			//查询所有的歌手类型
			case 1:
				atbiz=new ArtTypeBiz();
				arttypes=atbiz.showAll();
				request.setAttribute("arttypes", arttypes);
				request.getRequestDispatcher("managerIndex.jsp?page=addArt.jsp").forward(request, response);
				break;
				//添加歌手s
			case 2:
				SmartUpload up=new SmartUpload("UTF-8");
				up.initialize(this.getServletConfig(), request, response);
				up.setAllowedFilesList("jpg,gif,png");
				up.setMaxFileSize(2*1024*1024);
				String path="userimages/";
				String name=null;
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
				SmartRequest request2=up.getRequest();
				uname=request2.getParameter("uname");
				usex=request2.getParameter("usex");
				uimage=name;
				utext=request2.getParameter("utext");
				String[] check=request2.getParameterValues("arttype");
				for(String cc:check){
					ArtType at=new ArtType();
					at.setAtid(Integer.parseInt(cc));
					arttypes.add(at);
				}
				user=new User(uname, Integer.parseInt(usex), uimage, utext, arttypes);
				user.setArttypes(arttypes);
				if(ubiz.artRegister(user)){
					msg="添加成功！";
				}else{
					if(name!=null){						
						DelUtil.DelFile(this.getServletContext().getRealPath("/")+path+name);
					}
					msg="添加失败!";
				}
				request.getRequestDispatcher("UserServlet?temp=3&msg="+msg).forward(request, response);
				break;
				//显示所有的用户和歌手(fenye)
			case 3:
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
				request.getRequestDispatcher("managerIndex.jsp?page=showAllUser.jsp&msg="+msg).forward(request, response);
				break;
				//修改用户状态
			case 4:
				uid=request.getParameter("uid");
				if(ubiz.lock(uid)){
					msg="修改成功！";
				}else{
					msg="修改失败！";
				}
				request.getRequestDispatcher("UserServlet?temp=3&msg="+msg).forward(request, response);
				break;
				//修改前需要的数据
			case 5:
				atbiz=new ArtTypeBiz();
				arttypes=atbiz.showAll();
				request.setAttribute("arttypes", arttypes);
				uid=request.getParameter("uid");
				user=ubiz.showOneUser(uid);
				request.setAttribute("user", user);
				request.getRequestDispatcher("managerIndex.jsp?page=updateArt.jsp").forward(request, response);
				break;
				//修改用户信息
			case 6:
				SmartUpload up2=new SmartUpload("UTF-8");
				up2.initialize(this.getServletConfig(), request, response);
				up2.setAllowedFilesList("jpg,gif,png");
				up2.setMaxFileSize(2*1024*1024);
				String path2="userimages/";
				String name2=null;
				try {
					up2.upload();
					SmartFiles smartFiles=up2.getFiles();
					SmartFile file=smartFiles.getFile(0);
					if(!file.isMissing()){
						Date date=new Date();
						name2=DateUtil.getLongTime(date)+"."+file.getFileExt();
						file.saveAs(path2+name2);
					}
				} catch (SmartUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				SmartRequest request3=up2.getRequest();
				uid=request3.getParameter("uid");
				user=ubiz.showOneUser(uid);
				uname=request3.getParameter("uname");
				usex=request3.getParameter("usex");
				utext=request3.getParameter("utext");
				String type=request3.getParameter("type");
				String uimageo=request3.getParameter("uimageo");
				if(name2!=null){
					uimage=name2;
				}else{
					uimage=user.getUimage();
				}
				utext=request3.getParameter("utext");
				if("y".equals(type)){
					String[] check2=request3.getParameterValues("arttype");
					for(String cc:check2){
						ArtType at=new ArtType();
						at.setAtid(Integer.parseInt(cc));
						arttypes.add(at);
					}
					user=new User(Integer.parseInt(uid), null, uname, null, null, null, null, Integer.parseInt(usex), uimage, utext, 0, 0);
					user.setArttypes(arttypes);				
				}else {
					user=new User(Integer.parseInt(uid), null, uname, null, null, null, null, Integer.parseInt(usex), uimage, utext, 0, 0);
					
				}
				if(ubiz.updateUserType(user)){
					msg="修改成功！";
					if(name2!=null){
					DelUtil.DelFile(this.getServletContext().getRealPath("/")+path2+uimageo);
					}
				}else{
					msg="修改失败！";
					if(name2!=null){
						DelUtil.DelFile(this.getServletContext().getRealPath("/")+path2+name2);
					}
				}
				request.getRequestDispatcher("UserServlet?temp=3&msg="+msg).forward(request, response);
				break;
			case 7:
				uid=request.getParameter("uid");
				if(ubiz.delArt(uid)){
					msg="删除成功!";
				}else{
					msg="删除失败!";
				}
				request.getRequestDispatcher("UserServlet?temp=3&msg="+msg).forward(request, response);
				break;
			default:
				break;
			}
		}
	}

}
