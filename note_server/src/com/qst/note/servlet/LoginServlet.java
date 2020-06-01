package com.qst.note.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.qst.note.dao.UserDao;
import com.qst.note.result.Result;

public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static final HttpServletResponse response = null;
	
	public LoginServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset = utf-8");
		
		String tel = request.getParameter("tel");
		String pass = request.getParameter("pass");
		
		UserDao dao = new UserDao();
		Result rs = new Result();
		Gson gson = new Gson();
		
		rs.isSuccess = dao.login(tel, pass);
		rs.msg = rs.isSuccess?"µÇÂ½³É¹¦":"µÇÂ½Ê§°ÜÇëÖØÐÂµÇÂ¼";
		response.getWriter().append(gson.toJson(rs));
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, response);
	}
}
