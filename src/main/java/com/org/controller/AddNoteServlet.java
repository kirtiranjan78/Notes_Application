package com.org.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.UserDao;
import com.org.dto.Notes;
import com.org.dto.User;
@WebServlet("/addnote")
public class AddNoteServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user=(User) session.getAttribute("userObj");
		String title = req.getParameter("title");
		String description = req.getParameter("note");
		Notes n=new Notes();
		n.setTitle(title);
		n.setDescrp(description);
		n.setUser(user);
		List<Notes> list=new ArrayList<Notes>();
		list.add(n);
		UserDao ud=new UserDao();
		ud.addNote(user,list);
		resp.sendRedirect("home.jsp");
	}
}
