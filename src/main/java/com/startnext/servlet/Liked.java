package com.startnext.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.startnext.DAO.StartupDAO;

import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Liked
 */
@WebServlet("/Liked")
public class Liked extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Liked() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession ses=request.getSession();
		int i=0;
		if(ses.getAttribute("uid")!=null) {
			i=(int)ses.getAttribute("uid");
			try {
				if(StartupDAO.userliked(i, 3)) 
				{
					response.sendRedirect("strtview2.jsp");
				}
				else
				{
					StartupDAO.liked(i, 3);
					response.sendRedirect("strtview3.jsp");
				};
			}catch(ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		else {
			response.sendRedirect("login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
