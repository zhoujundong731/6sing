package com.chinasoft.fsing.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasoft.fsing.dbutil.DBHelp;
import com.chinasoft.fsing.vo.Album;
import com.chinasoft.fsing.vo.Song;
import com.chinasoft.fsing.vo.SubPage;
import com.chinasoft.fsing.vo.User;

public class SongDao {
	private DBHelp hp;

	public SongDao() {
		super();
	}
	//表单搜索
	public List<Song> searchFrom(String stype,String sname){
		hp=new DBHelp();
		List<Song> list=new ArrayList<>();
		String sql="SELECT s.sid,u.uid,u.uname,u.usex,u.uimage,u.usign,s.sname,s.smaddress,s.swaddress,s.svaddress,s.stext,s.sclick,s.sdown,s.scnum FROM song as s JOIN `user` as u ON s.uid=u.uid WHERE s.sid in (SELECT sid FROM songandsongtype WHERE stid in(SELECT stid FROM songtype WHERE stname LIKE '%"+stype+"%')) AND sname LIKE '%"+sname+"%'";
		try {
			ResultSet rs=hp.query(sql);
			while(rs.next()){
				list.add(new Song(rs.getLong(1), new User(rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6)), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12), rs.getInt(13), rs.getInt(14)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	//点击量
	public int addClick(String sid){
		int temp=-1;
		hp=new DBHelp();
		String sql="UPDATE song SET sclick=(sclick+1) WHERE sid="+sid;
		try {
			temp=hp.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	
	//下载量
	public int addDown(String sid){
		int temp=-1;
		hp=new DBHelp();
		String sql="UPDATE song SET sdown=(sdown+1) WHERE sid="+sid;
		try {
			temp=hp.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	//收藏量
	public int addCnum(String sid){
		int temp=-1;
		hp=new DBHelp();
		String sql="UPDATE song SET scnum=(scnum+1) WHERE sid="+sid;
		try {
			temp=hp.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	//收藏最多
	public List<Song> getTopCnum(int num){
		hp=new DBHelp();
		List<Song> list=new ArrayList<>();
		String sql="SELECT s.sid,u.uid,u.uname,u.usex,u.uimage,u.usign,s.sname,s.smaddress,s.swaddress,s.svaddress,s.stext,s.sclick,s.sdown,s.scnum FROM song as s JOIN `user` as u ON s.uid=u.uid order by s.scnum desc limit "+num;
		ResultSet rs;
		try {
			rs = hp.query(sql);
			while(rs.next()){
				list.add(new Song(rs.getLong(1), new User(rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6)), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12), rs.getInt(13), rs.getInt(14)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	//下载最多
	public List<Song> getTopDown(int num){
		hp=new DBHelp();
		List<Song> list=new ArrayList<>();
		String sql="SELECT s.sid,u.uid,u.uname,u.usex,u.uimage,u.usign,s.sname,s.smaddress,s.swaddress,s.svaddress,s.stext,s.sclick,s.sdown,s.scnum FROM song as s JOIN `user` as u ON s.uid=u.uid order by s.sdown desc limit "+num;
		ResultSet rs;
		try {
			rs = hp.query(sql);
			while(rs.next()){
				list.add(new Song(rs.getLong(1), new User(rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6)), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12), rs.getInt(13), rs.getInt(14)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	//原创排行
	public List<Song> getTenSongYuanPai(){
		hp=new DBHelp();
		List<Song> list=new ArrayList<>();
		String sql="SELECT s.sid,u.uid,u.uname,u.usex,u.uimage,u.usign,s.sname,s.smaddress,s.swaddress,s.svaddress,s.stext,s.sclick,s.sdown,s.scnum FROM song as s JOIN `user` as u ON s.uid=u.uid WHERE s.sid IN(SELECT sid FROM songandsongtype WHERE stid=2) order by s.sclick desc limit 10";
		ResultSet rs;
		try {
			rs = hp.query(sql);
			while(rs.next()){
				list.add(new Song(rs.getLong(1), new User(rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6)), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12), rs.getInt(13), rs.getInt(14)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	//翻唱排行
		public List<Song> getTenSongFanPai(){
			hp=new DBHelp();
			List<Song> list=new ArrayList<>();
			String sql="SELECT s.sid,u.uid,u.uname,u.usex,u.uimage,u.usign,s.sname,s.smaddress,s.swaddress,s.svaddress,s.stext,s.sclick,s.sdown,s.scnum FROM song as s JOIN `user` as u ON s.uid=u.uid WHERE s.sid IN(SELECT sid FROM songandsongtype WHERE stid=4) order by s.sclick desc limit 10";
			ResultSet rs;
			try {
				rs = hp.query(sql);
				while(rs.next()){
					list.add(new Song(rs.getLong(1), new User(rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6)), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12), rs.getInt(13), rs.getInt(14)));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return list;
		}
	//原创候选
	public List<Song> getTenSongYuanHou(){
		hp=new DBHelp();
		List<Song> list=new ArrayList<>();
		String sql="SELECT s.sid,u.uid,u.uname,u.usex,u.uimage,u.usign,s.sname,s.smaddress,s.swaddress,s.svaddress,s.stext,s.sclick,s.sdown,s.scnum FROM song as s JOIN `user` as u ON s.uid=u.uid WHERE s.sid IN(SELECT sid FROM songandsongtype WHERE stid=2) order by s.sclick desc limit 10,10";
		ResultSet rs;
		try {
			rs = hp.query(sql);
			while(rs.next()){
				list.add(new Song(rs.getLong(1), new User(rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6)), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12), rs.getInt(13), rs.getInt(14)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	//随机读取十首歌(原创)
	public List<Song> getTenSongYuan(){
		hp=new DBHelp();
		List<Song> list=new ArrayList<>();
		String sql="SELECT s.sid,u.uid,u.uname,u.usex,u.uimage,u.usign,s.sname,s.smaddress,s.swaddress,s.svaddress,s.stext,s.sclick,s.sdown,s.scnum FROM song as s JOIN `user` as u ON s.uid=u.uid WHERE s.sid IN(SELECT sid FROM songandsongtype WHERE stid=2) order by rand() limit 10";
		ResultSet rs;
		try {
			rs = hp.query(sql);
			while(rs.next()){
				list.add(new Song(rs.getLong(1), new User(rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6)), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12), rs.getInt(13), rs.getInt(14)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	//随机读取十首歌(翻唱)
		public List<Song> getTenSongFan(){
			hp=new DBHelp();
			List<Song> list=new ArrayList<>();
			String sql="SELECT s.sid,u.uid,u.uname,u.usex,u.uimage,u.usign,s.sname,s.smaddress,s.swaddress,s.svaddress,s.stext,s.sclick,s.sdown,s.scnum FROM song as s JOIN `user` as u ON s.uid=u.uid WHERE s.sid IN(SELECT sid FROM songandsongtype WHERE stid=4) order by rand() limit 10";
			ResultSet rs;
			try {
				rs = hp.query(sql);
				while(rs.next()){
					list.add(new Song(rs.getLong(1), new User(rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6)), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12), rs.getInt(13), rs.getInt(14)));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return list;
		}
		//随机读取十首歌
				public List<Song> getTenSongSui(){
					hp=new DBHelp();
					List<Song> list=new ArrayList<>();
					String sql="SELECT s.sid,u.uid,u.uname,u.usex,u.uimage,u.usign,s.sname,s.smaddress,s.swaddress,s.svaddress,s.stext,s.sclick,s.sdown,s.scnum FROM song as s JOIN `user` as u ON s.uid=u.uid order by rand() limit 10";
					ResultSet rs;
					try {
						rs = hp.query(sql);
						while(rs.next()){
							list.add(new Song(rs.getLong(1), new User(rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6)), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12), rs.getInt(13), rs.getInt(14)));
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					return list;
				}
	
	//删除专辑中的歌曲
	public int delFromAlbum(String sid){
		hp=new DBHelp();
		int temp=-1;
		String sql="update song set bid=null where sid="+sid;
		try {
			temp=hp.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	//用户查询自己的歌曲
	public List<Song> showAllSongByUid(String uid){
		hp=new DBHelp();
		List<Song> list=new ArrayList<>();
		hp=new DBHelp();
		String sql="SELECT s.sid,s.sname,s.smaddress,s.swaddress,s.svaddress,s.stext,s.sclick,s.sdown,s.scnum FROM song As s where s.uid="+uid;
		try {
			ResultSet rs=hp.query(sql);
			while(rs.next()){
				list.add(new Song(rs.getLong(1),null, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}



	//查看是否存在(添加前)
	public int isHave(String sname){
		int temp=-1;
		hp=new DBHelp();
		String sql="select count(*) from song where sname=?";
		try {
			ResultSet rs=hp.query(sql, sname);
			if(rs.next()){
				temp=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	//添加歌曲
	public int addSong(Song song){
		hp=new DBHelp();
		String sql;
		int temp=-1;
		if(song.getAlbum().getBid()==0){
			sql="insert into song(sid,uid,sname,smaddress,swaddress,svaddress,slrc,stext,stime) values(?,?,?,?,?,?,?,?,?)";
			try {
				temp=hp.update(sql, song.getSid(),song.getUser().getUid(),song.getSname(),song.getSmaddress(),song.getSwaddress(),song.getSvaddress(),song.getSlrc(),song.getStext(),song.getStime());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					hp.closeAll();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else{
			sql="insert into song(sid,uid,bid,sname,smaddress,swaddress,svaddress,slrc,stext,stime) values(?,?,?,?,?,?,?,?,?,?)";
			try {
				temp=hp.update(sql, song.getSid(),song.getUser().getUid(),song.getAlbum().getBid(),song.getSname(),song.getSmaddress(),song.getSwaddress(),song.getSvaddress(),song.getSlrc(),song.getStext(),song.getStime());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					hp.closeAll();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return temp;
	}
	//删除歌曲
	public int delSong(String sid){
		hp=new DBHelp();
		String sql="delete from song where sid="+sid;
		int temp=-1;
		try {
			temp=hp.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				hp.closeAll();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return temp;
	}
	//修改歌曲信息
	public int updateSong(Song song){
		hp=new DBHelp();
		String sql="update song set sname=?,smaddress=?,swaddress=?,svaddress=?,stext=?,slrc=? where sid=?";
		int temp=-1;
		try {
			temp=hp.update(sql,song.getSname(),song.getSmaddress(),song.getSwaddress(),song.getSvaddress(),song.getStext(),song.getSlrc(),song.getSid());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				hp.closeAll();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return temp;
	}

	//简单的查询歌曲（通过歌曲类型）

	//查看歌曲的专辑（是否有专辑）
	public int isAlbum(String sid){
		hp=new DBHelp();
		int temp=-1;
		String sql="select bid from song where sid=?";
		try {
			ResultSet rs=hp.query(sql, sid);
			if(rs.next()){
				temp=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				hp.closeAll();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return temp;
	}

	//查询歌曲（通过ID,没有专辑的）
	public Song showOneNotAlbum(String sid){
		hp=new DBHelp();
		Song song=null;
		String sql="SELECT s.sid,u.uid,u.uname,u.usex,u.uimage,u.usign,s.sname,s.smaddress,s.swaddress,s.svaddress,s.slrc,s.stext,s.sclick,s.sdown,s.scnum,s.stime FROM song AS s INNER JOIN `user` AS u ON s.uid = u.uid WHERE s.sid = ?";
		try {
			ResultSet rs=hp.query(sql,sid);
			if(rs.next()){
				song=new Song(rs.getLong(1),new User(rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6)), null, rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),rs.getString(12), rs.getInt(13), rs.getInt(14), rs.getInt(15), rs.getString(16));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				hp.closeAll();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return song;
	}
	//查询歌曲（通过ID,有专辑的）
	public Song showOneAlbum(String sid){
		hp=new DBHelp();
		Song song=null;
		String sql="SELECT s.sid,u.uid,u.uname,u.usex,u.uimage,u.usign,b.bid,b.bname,b.btext,b.btime,b.bimage,s.sname,s.smaddress,s.swaddress,s.svaddress,s.slrc,s.stext,s.sclick,s.sdown,s.scnum,s.stime FROM song AS s INNER JOIN `user` AS u ON s.uid = u.uid INNER JOIN album AS b ON b.uid = u.uid AND s.bid = b.bid where sid=?";
		try {
			ResultSet rs=hp.query(sql, sid);
			if(rs.next()){
				song=new Song(rs.getLong(1),new User(rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6)), new Album(rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16),rs.getString(17), rs.getInt(18), rs.getInt(19), rs.getInt(20), rs.getString(21));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				hp.closeAll();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return song;
	}
	//数量
	public int getAllSongNum(){
		int temp=0;
		hp=new DBHelp();
		String sql="select count(*) from song";
		try {
			ResultSet rs=hp.query(sql);
			if(rs.next()){
				temp=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	//查看所有歌曲
	public List<Song> showAllSong(){
		List<Song> list=new ArrayList<>();
		hp=new DBHelp();
		String sql="SELECT s.sid,u.uid,u.uname,u.usex,u.uimage,u.usign,s.sname,s.smaddress,s.swaddress,s.svaddress,s.stext,s.sclick,s.sdown,s.scnum FROM song AS s INNER JOIN `user` AS u ON s.uid = u.uid";
		try {
			ResultSet rs=hp.query(sql);
			while(rs.next()){
				list.add(new Song(rs.getLong(1), new User(rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6)), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12), rs.getInt(13), rs.getInt(14)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	//查看所有歌曲
		public List<Song> showAllSong(SubPage sub){
			List<Song> list=new ArrayList<>();
			hp=new DBHelp();
			String sql="SELECT s.sid,u.uid,u.uname,u.usex,u.uimage,u.usign,s.sname,s.smaddress,s.swaddress,s.svaddress,s.stext,s.sclick,s.sdown,s.scnum FROM song AS s INNER JOIN `user` AS u ON s.uid = u.uid limit ?,?";
			try {
				ResultSet rs=hp.query(sql,sub.getStartIndex(),sub.getShowNumber());
				while(rs.next()){
					list.add(new Song(rs.getLong(1), new User(rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6)), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12), rs.getInt(13), rs.getInt(14)));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
		}
	//查询专辑的歌曲信息
	public List<Song> showSongByBid(String bid){
		List<Song> list=new ArrayList<>();
		hp=new DBHelp();
		String sql="SELECT s.sid,s.sname,s.smaddress,s.swaddress,s.svaddress,s.stext,s.sclick,s.sdown,s.scnum FROM song As s where bid="+bid;
		try {
			ResultSet rs=hp.query(sql);
			while(rs.next()){
				list.add(new Song(rs.getLong(1),null, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
