package com.hanbit.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		
		int x = Integer.valueOf(req.getParameter("x"));
		int y = Integer.valueOf(req.getParameter("y"));
		
		int result = x + y;
		
		req.setAttribute("result", result);
		
		RequestDispatcher dispatcher
			= req.getRequestDispatcher("/WEB-INF/jsp/hello.jsp");
		dispatcher.forward(req, resp);
	}
	
}










