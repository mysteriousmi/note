package com.qst.note.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.qst.note.dao.NoteDao;
import com.qst.note.result.Result;

public class UpdateNoteServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public UpdateNoteServlet(){
		super();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/htmml;charset = utf-8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String tel = request.getParameter("tel");
		String noteTime = request.getParameter("noteTime");
		
		NoteDao dao = new NoteDao();
		Gson gson =new Gson();
		Result result = new Result();
		
		result.isSuccess = dao.ModifyNote(title, content, noteTime, tel);
		result.msg=result.isSuccess?"记录成功":"保存失败";
		
		response.getWriter().append(gson.toJson(result));

	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
