package com.startnext.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.startnext.bean.StartupBean;

import jakarta.servlet.http.Part;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
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
		StartupBean sb=new StartupBean();
		Part img=request.getPart("st_img");
		String imgName=img.getSubmittedFileName();
		String uploadPath="G:\\java_web_app\\start-next_1\\src\\main\\webapp"+imgName;
		try {
			FileOutputStream file= new FileOutputStream(uploadPath);
			InputStream is=img.getInputStream();
			byte[] data=new byte[is.available()];
			is.read(data);
			file.close();
		}
		catch(Exception e) {
			
		}
				}

}
