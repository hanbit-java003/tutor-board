package com.hanbit.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.hanbit.board.controller.BoardController;
import com.hanbit.board.dao.CommonDAO;

public class FrontServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException {

		String uri = req.getRequestURI();
		int endIndex = uri.lastIndexOf(".view");
		String viewName = uri.substring(0, endIndex);
		
		BoardController controller = new BoardController(req, res);
		
		switch (viewName) {
			case "/list": {
				viewName = controller.list();
				break;
			}
			case "/new": {
				viewName = controller.add();
				break;
			}
			case "/edit": {
				viewName = controller.edit();
				break;
			}
			case "/detail": {
				viewName = controller.detail();
				break;
			}
			default: {
				viewName = "/404";
			}
		}
		
		String path = "/WEB-INF/jsp" + viewName + ".jsp";
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		dispatcher.forward(req, res);
	}
	
}
