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

		req.setCharacterEncoding("UTF-8");
		
		String uri = req.getRequestURI();
		BoardController controller = new BoardController(req, res);
		String viewName = "/404";
		
		if (uri.endsWith(".view")) {
			viewName = handleView(uri, controller);
			
			String path = "/WEB-INF/jsp" + viewName + ".jsp";
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			dispatcher.forward(req, res);
		}
		else if (uri.endsWith(".do")) {
			viewName = handleAction(uri, controller);
			
			String path = "";
			
			if (viewName.contains("?")) {
				path = viewName;
			}
			else {
				path = viewName + ".view";
			}
			
			res.sendRedirect(path);
		}
	}
	
	private String handleAction(String uri, BoardController controller) {
		int endIndex = uri.lastIndexOf(".do");
		String actionName = uri.substring(0, endIndex);
		String viewName = "/404";
		
		switch (actionName) {
			case "/new": {
				viewName = controller.doAdd();
				break;
			}
			case "/edit": {
				viewName = controller.doEdit();
				break;
			}
			case "/delete": {
				viewName = controller.doDelete();
				break;
			}
			case "/reply": {
				viewName = controller.doReply();
				break;
			}
		}
		
		return viewName;
	}
	
	private String handleView(String uri, BoardController controller) {
		int endIndex = uri.lastIndexOf(".view");
		String viewName = uri.substring(0, endIndex);
		
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
		
		return viewName;
	}
	
}







