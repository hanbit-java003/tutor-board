package com.hanbit.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardController {
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public BoardController(HttpServletRequest request,
			HttpServletResponse response) {
		
		this.request = request;
		this.response = response;
	}

	public String list() {
		return "/list";
	}

	public String add() {
		return "/new";
	}
	
	public String edit() {
		return "/edit";
	}
	
	public String detail() {
		return "/detail";
	}
	
}
