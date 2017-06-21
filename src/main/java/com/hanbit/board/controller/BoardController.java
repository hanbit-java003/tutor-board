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
		
		return "/list";
	}
	
	public String edit() {
		return "/edit";
	}
	
	public String detail() {
		return "/detail";
	}
	
}
