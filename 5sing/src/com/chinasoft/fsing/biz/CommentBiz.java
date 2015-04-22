package com.chinasoft.fsing.biz;

import java.util.List;

import com.chinasoft.fsing.dao.CommentDao;
import com.chinasoft.fsing.vo.Comment;

public class CommentBiz {
	private CommentDao cdao;
	
	
	public CommentBiz() {
		cdao=new CommentDao();
	}

	//�������
	public boolean addComm(Comment comm){
		boolean flag=false;
		if(cdao.addComm(comm)>0){
			flag=true;
		}
		return flag;
	}
	//�鿴�Լ�������
	public List<Comment> showCommByUid(String uid){
		return cdao.showCommByUid(uid);
	}
	//�鿴����������
	public List<Comment> showCommBySid(String sid){
		return cdao.showCommBySid(sid);
		
	}
}
