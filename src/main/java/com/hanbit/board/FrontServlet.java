package com.hanbit.board;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class FrontServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException {
		
		String resource = "mybatis/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory
			= new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int result = sqlSession.selectOne("board.selectDual");
		sqlSession.close();
		
		System.out.println(result);

		String uri = req.getRequestURI();
		int endIndex = uri.lastIndexOf(".view");
		String viewName = uri.substring(0, endIndex);
		
		switch (viewName) {
			case "/list":
			case "/new":
			case "/edit":
			case "/delete":
			case "/detail": {
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
