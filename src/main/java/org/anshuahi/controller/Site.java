package org.anshuahi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.anshuahi.entity.User;
import org.anshuahi.model.UsersModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Site
 */
@WebServlet("/site")
public class Site extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page").toLowerCase();
		switch (page) {
			case "listusers": {
				listUsers(request, response);
				break;
			}
			case "adduser": {
				addUser(request, response);
				break;
			}
			default:
				request.setAttribute("title", "Error Page");
				request.getRequestDispatcher("error.jsp").forward(request, response);
				break;
		}
	}
	
	protected void listUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<User> users = new ArrayList<User>();
		users = new UsersModel().listUser();
		request.setAttribute("users", users);
		request.setAttribute("title", "List Users");
		request.getRequestDispatcher("listusers.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setAttribute("title", "Add User");
		request.getRequestDispatcher("addUser.jsp").forward(request, response);
	}

}
