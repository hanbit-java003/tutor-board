<%@page import="com.hanbit.board.vo.ReplyVO"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.text.StringEscapeUtils"%>
<%@page import="com.hanbit.board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
BoardVO article = (BoardVO) request.getAttribute("article");
int currentPage = 1;

try {
	currentPage = Integer.valueOf(request.getParameter("page"));
}
catch (Exception e) {
	currentPage = 1;
}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title><%=article.getTitle() %></title>
	<link rel="stylesheet" href="//unpkg.com/bootstrap@3.3.7/dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="/css/board.css">
</head>
<body>
<div class="form-group">
	<label>제목</label>
	<div class="board-text"><%=StringEscapeUtils.escapeHtml4(article.getTitle()) %></div>
</div>
<div class="form-group">
	<label>작성자</label>
	<div class="board-text"><%=StringEscapeUtils.escapeHtml4(article.getWriter()) %></div>
</div>
<div class="form-group">
	<label>내용</label>
	<div class="board-contents"><%=StringEscapeUtils.escapeHtml4(article.getContents()).replace("\n", "<br>") %></div>
</div>
<input type="hidden" id="page" value="<%=currentPage %>">
<input type="hidden" id="board-no" value="<%=article.getNo() %>">
<div class="board-buttons">
	<button id="board-edit" class="btn btn-warning">수정</button>
	<button id="board-delete" class="btn btn-danger">삭제</button>
	<button id="board-list" class="btn btn-default">목록</button>
</div>

<div class="board-reply-box">
	<input type="text" id="board-reply-writer" class="form-control"
		placeholder="작성자">
	<textarea id="board-reply" class="form-control"></textarea>
	<button type="button" id="board-reply-send" class="btn btn-primary">댓글쓰기</button>
</div>
<%
List<ReplyVO> replies
	= (List<ReplyVO>) request.getAttribute("replies");
%>
<ul class="board-replies">
	<% for (ReplyVO reply : replies) { %>
	<li>
		<span class="reply-writer"><%=StringEscapeUtils.escapeHtml4(reply.getWriter()) %></span>
		<span class="reply-contents"><%=StringEscapeUtils.escapeHtml4(reply.getContents()).replace("\n", "<br>") %></span>
		<span class="reply-actions">
			<a href="/delete/reply.do?no=<%=article.getNo() %>&rno=<%=reply.getRno() %>">삭제</a>
		</span>
	</li>
	<% } %>
</ul>

<script src="//unpkg.com/jquery@3.2.1"></script>
<script src="//unpkg.com/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
<script src="/js/detail.js"></script>
</body>
</html>





