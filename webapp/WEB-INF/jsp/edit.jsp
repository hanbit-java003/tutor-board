<%@page import="com.hanbit.board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
BoardVO article = (BoardVO) request.getAttribute("article");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>글수정</title>
	<link rel="stylesheet" href="//unpkg.com/bootstrap@3.3.7/dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="/css/board.css">
</head>
<body>
<form id="board-form" method="post" action="/edit.do">
	<div class="form-group">
		<label for="board-title">제목</label>
		<input name="title" value="<%=article.getTitle() %>" type="text" class="form-control" id="board-title" placeholder="제목">
	</div>
	<div class="form-group">
		<label for="board-writer">작성자</label>
		<input name="writer" value="<%=article.getWriter() %>" type="text" class="form-control" id="board-writer" placeholder="작성자">
	</div>
	<div class="form-group">
		<label for="board-contents">내용</label>
		<textarea name="contents" class="form-control" id="board-contents"><%=article.getContents() %></textarea>
	</div>
	<input type="hidden" name="no" id="board-no" value="<%=article.getNo() %>">
	<div class="board-buttons">
		<button type="button" id="board-send" class="btn btn-success">저장</button>
		<button type="button" id="board-reset" class="btn btn-default">초기화</button>
		<button type="button" id="board-cancel" class="btn btn-danger">취소</button>
	</div>
</form>

<script src="//unpkg.com/jquery@3.2.1"></script>
<script src="//unpkg.com/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
<script src="/js/edit.js"></script>
</body>
</html>





