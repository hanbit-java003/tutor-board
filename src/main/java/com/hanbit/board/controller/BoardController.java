package com.hanbit.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.hanbit.board.dao.CommonDAO;
import com.hanbit.board.vo.BoardVO;

public class BoardController {
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public BoardController(HttpServletRequest request,
			HttpServletResponse response) {
		
		this.request = request;
		this.response = response;
	}

	public String list() {
		SqlSession sqlSession = CommonDAO.openSession();
		List<BoardVO> list = sqlSession.selectList("board.selectList");
		sqlSession.close();
		
		request.setAttribute("list", list);
		
		return "/list";
	}

	public String add() {
		return "/new";
	}
	
	public String doAdd() {
		SqlSession sqlSession = CommonDAO.openSession();
		
		int no = sqlSession.selectOne("board.selectNextNo");
		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String contents = request.getParameter("contents");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setNo(no);
		boardVO.setTitle(title);
		boardVO.setWriter(writer);
		boardVO.setContents(contents);
		
		sqlSession.insert("board.insertArticle", boardVO);
		sqlSession.commit();
		sqlSession.close();
		
		return "/list";
	}
	
	public String edit() {
		return "/edit";
	}
	
	public String detail() {
		int no = Integer.valueOf(request.getParameter("no"));
		
		SqlSession sqlSession = CommonDAO.openSession();
		BoardVO boardVO = sqlSession.selectOne("board.selectArticle", no);
		sqlSession.update("board.updateViews", no);
		sqlSession.commit();
		sqlSession.close();
		
		request.setAttribute("article", boardVO);
		
		return "/detail";
	}
	
	public String doDelete() {
		int no = Integer.valueOf(request.getParameter("no"));
		
		SqlSession sqlSession = CommonDAO.openSession();
		sqlSession.delete("board.deleteArticle", no);
		sqlSession.commit();
		sqlSession.close();
		
		return "/list";
	}
	
}












