package com.qst.note.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.qst.note.bean.Notebean;
import com.qst.note.util.DBUtil;

public class NoteDao {

	public Boolean insert(String title,String content,String noteTime, String tel ) {
	int id = new UserDao().getIDbyTel(tel);
			if(id<1) 
				return false;
			Connection c = DBUtil.getConnection();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年mm月dd日 HH:mm:ss");
			String nowTime = sdf.format(new Date());
			
			try {
				PreparedStatement pst =(PreparedStatement)c.prepareStatement
						("insert into note_table(title,content,note_name,user_id,create_time)value(?,?,?,?,?)");
				pst.setString(1, title);
				pst.setString(2, content);
				pst.setString(3, noteTime);
				pst.setInt(4, id);
				pst.setString(5, nowTime);
				pst.execute();
				DBUtil.close(c, pst, null);
				return true;
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
				return false;
			}
}

	public Notebean getNoteByID(int id) {
		// TODO Auto-generated method stub
			Notebean note = new Notebean();
			Connection c = DBUtil.getConnection();
	try {
		PreparedStatement pst =(PreparedStatement)c.prepareStatement
				("select * from note_table where id=?");
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		if(rs.first()) {
			note.setId(id);
			note.setTitle(rs.getString("title"));
			note.setContent(rs.getString("content"));
			note.setCreate_time(rs.getString("create_time"));
			note.setUpdateTime(rs.getString("updateTime"));
			note.setNote_time(rs.getString("note_time"));
			note.setUser_id(rs.getString("user_id"));
			
		}
	}catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return note;
		
	}

	public Boolean ModifyNote(int id,String title, String content, String noteTime, String tel) {
		// TODO Auto-generated method stub
		if(id < 1)
			return false;
		Connection c = DBUtil.getConnection();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年mm月dd日 HH:mm:ss");
		String nowTime = sdf.format(new Date());
		
		try {
			PreparedStatement pst =(PreparedStatement)c.prepareStatement
					("update note_table set title=?,content=?,note_time=?,update=?,where id=?");
			pst.setString(1, title);
			pst.setString(2, content);
			pst.setString(3, noteTime);
			pst.setString(4, nowTime);
			pst.setInt(5, id);
			pst.execute();
			DBUtil.close(c, pst, null);
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return null;
	}
}
