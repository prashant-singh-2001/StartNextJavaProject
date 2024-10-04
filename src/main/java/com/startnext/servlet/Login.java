package com.startnext.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.startnext.DAO.UserDAO;
import com.startnext.bean.UserBean;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		UserBean ab=new UserBean();
		ab.setUsername(request.getParameter("uname"));
		ab.setPassword(request.getParameter("pword"));
		try {
			if(UserDAO.login(ab))
			{
				ab=UserDAO.getUser(ab);
				HttpSession session=request.getSession();				
				session.setAttribute("userob", ab);
				session.setAttribute("admin", ab.getUsername());
				session.setAttribute("uid", ab.getId());
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("login2.jsp");
				rd.forward(request, response);
			}
			catch(ClassNotFoundException | SQLException e ) {
				e.printStackTrace();
			}
		}
	}

}
