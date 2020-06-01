package com.qst.note.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.qst.note.bean.Notebean;
import com.qst.note.dao.NoteDao;

public class GetNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public GetNoteServlet() {
		super();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/htmml;charset = utf-8");
		
		int id = Integer.valueOf(request.getParameter("id"));
		NoteDao dao = new NoteDao();
		Gson gson =new Gson();
		Notebean note = dao.getNoteByID(id);
		
		response.getWriter().append(gson.toJson(note));

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
}
}
