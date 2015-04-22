package com.chinasoft.fsing.biz;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.chinasoft.fsing.dao.SongDao;
import com.chinasoft.fsing.dao.UserAndArtTypeDao;
import com.chinasoft.fsing.dao.UserDao;
import com.chinasoft.fsing.vo.ArtType;
import com.chinasoft.fsing.vo.Menu;
import com.chinasoft.fsing.vo.Song;
import com.chinasoft.fsing.vo.SubPage;
import com.chinasoft.fsing.vo.User;

public class UserBiz {
	private UserDao udao;
	private UserAndArtTypeDao uadao;
	private SongDao sdao;


	public UserBiz() {
		udao=new UserDao();
		uadao=new UserAndArtTypeDao();
		sdao=new SongDao();
	}

	//��Ƭǽ
	public List<User> getPhoto(int num){
		return udao.getPhoto(num);
	}
	//���
	public User getIndexOne(){
		return udao.getIndexOneUser();
	}
	//ʮ��������
	public List<User> getIndexTen(User user){
		return udao.getTenUser(user);
	}

	//c��ѯ����
	public int getUserNum(){
		return udao.getUserNum();
	}


	//��½
	public User userLogin(String uaccount,String upass){

		User user= udao.login(uaccount, upass);
		return user;
	}
	//�û�ע��
	public boolean  userRegister(User user){
		boolean flag=false;
		if(udao.search(user.getUaccount())>0){
		}else{
			if(udao.userRegister(user)>0){
				flag=true;
			}else{;
			}

		}
		return flag;
	}
	//��Ӹ���
	public boolean  artRegister(User user1){
		boolean flag=false;
		List<ArtType> list=user1.getArttypes();
		if(udao.search(user1.getUaccount())>0){
		}else{
			if(udao.artRegister(user1)>0){
				User user2=udao.getOneUserByName(user1.getUname());
				boolean flag2=true;
				for(ArtType at:list){
					if(uadao.add(user2, at)>0){
					}else{
						flag2=false;
					}
				}
				if(flag2){
					flag=true;
				}else{
					udao.del(user2.getUid()+"");
				}
			}else{

			}
		}
		return flag;
	}

	//����
	//����
	public boolean lock(String uid){
		boolean flag=false;
		User user=udao.getOneUserById(uid);
		if(user.getUflag()==0){
			if(udao.lock(1+"", uid)>0){
				flag=true;
			};
		}else{
			if(udao.lock(0+"", uid)>0){
				flag=true;
			};
		}
		return flag;
	}
	//ɾ��
	public boolean  delArt(String uid){
		boolean flag=false;
		if(udao.del(uid)>0){
			flag=true;
		}
		return flag;
	}

	//�޸���Ϣ(���޸�����)
	public boolean  updateUser(User user){
		boolean flag=false;
		if(udao.update(user)>0){
			flag=true;
		}
		return flag;
	}
	//�޸ģ��޸����ͣ�
	public boolean updateUserType(User user){
		boolean flag=false;
		if(udao.update(user)>0){
			if(user.getArttypes()!=null){
				uadao.delArtTypeByUid(user.getUid());
				for(ArtType at:user.getArttypes()){
					uadao.add(user, at);
				}

			}
			flag=true;
		}else{

		}
		return flag;
	}

	//����Ա�鿴��Ϣ
	public List<User> showAllUser(){
		return udao.showAllUser();
	}
	public List<User> showAllUser(SubPage sub){
		return udao.showAllUser(sub);
	}
	//�鿴���и���
	public List<User> showArt(){
		List<User> users=udao.showAllUser();
		List<User> artList=new ArrayList<>();
		for(User u:users){
			if(u.getUpower()==1){
				artList.add(u);
			}
		}
		return artList;
	}
	//�鿴�����û�
	public User showOneUser(String uid){
		User user=udao.getOneUserById(uid);
		List<ArtType> arttypes=uadao.getArtTypesByUser(uid);
		if(arttypes!=null){
			user.setArttypes(arttypes);
		}
		return user;
	}
	//�鿴�û��͸���
	public User showOneUserAndSong(String uid){
		User user=udao.getOneUserById(uid);
		List<Song> songs=sdao.showAllSongByUid(uid);
		user.setSongs(songs);
		return user;
	}


}
