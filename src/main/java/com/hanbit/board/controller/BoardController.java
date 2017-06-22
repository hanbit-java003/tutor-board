package com.hanbit.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.hanbit.board.dao.CommonDAO;
import com.hanbit.board.vo.BoardVO;
import com.hanbit.board.vo.PageVO;

public class BoardController {
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public BoardController(HttpServletRequest request,
			HttpServletResponse response) {
		
		this.request = request;
		this.response = response;
	}

	public String list() {
		int currentPage = 1;
		
		try {
			String page = request.getParameter("page");
			currentPage = Integer.valueOf(page);
		}
		catch (Exception e) {
			currentPage = 1;
		}
		
		int rowsPerPage = 5;
		int firstIndex = (currentPage - 1) * rowsPerPage;
		
		PageVO pageVO = new PageVO();
		pageVO.setFirstIndex(firstIndex);
		pageVO.setRowsPerPage(rowsPerPage);
		
		SqlSession sqlSession = CommonDAO.openSession();
		List<BoardVO> list = sqlSession.selectList("board.selectList", pageVO);
		int totalCount = sqlSession.selectOne("board.countTotal");
		sqlSession.close();
		
		request.setAttribute("list", list);
		request.setAttribute("totalCount", totalCount);
		
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
		int no = Integer.valueOf(request.getParameter("no"));
		
		SqlSession sqlSession = CommonDAO.openSession();
		BoardVO boardVO = sqlSession.selectOne("board.selectArticle", no);
		sqlSession.close();
		
		request.setAttribute("article", boardVO);
		
		return "/edit";
	}
	
	public String doEdit() {
		int no = Integer.valueOf(request.getParameter("no"));
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String contents = request.getParameter("contents");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setNo(no);
		boardVO.setTitle(title);
		boardVO.setWriter(writer);
		boardVO.setContents(contents);
		
		SqlSession sqlSession = CommonDAO.openSession();
		sqlSession.update("board.updateArticle", boardVO);
		sqlSession.commit();
		sqlSession.close();

		return "/detail.view?no=" + no;
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












