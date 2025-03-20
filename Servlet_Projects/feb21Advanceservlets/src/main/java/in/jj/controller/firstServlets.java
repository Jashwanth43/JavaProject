package in.jj.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/first")
//@WebServlet("/test")
public class firstServlets extends HttpServlet 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static{
		System.out.println("Servlet loading...");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		System.out.println("Request type is POST");
	}
}
