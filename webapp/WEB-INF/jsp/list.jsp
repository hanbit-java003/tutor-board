<%@page import="com.hanbit.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시판 목록</title>
	<link rel="stylesheet"
		href="//unpkg.com/bootstrap@3.3.7/dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="/css/board.css">
</head>
<body>

<table class="table">
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
	<%
	List<BoardVO> list = (List<BoardVO>) request.getAttribute("list");
	%>
	<% for (BoardVO article : list) { %>
		<tr>
			<td><%=article.getNo() %></td>
			<td><%=article.getTitle() %></td>
			<td><%=article.getWriter() %></td>
			<td><%=article.getViews() %></td>
		</tr>
	<% } %>
	</tbody>
</table>
<%
	int totalPages = 5;
	int cPage = 1;
	
	try {
		cPage = Integer.valueOf(request.getParameter("page"));
	}
	catch (Exception e) {
		cPage = 1;
	}
%>
<nav class="board-pages" aria-label="Page navigation">
  <ul class="pagination">
    <li>
      <a href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <% for (int i=1; i<=totalPages; i++) { %>
    <li<%=(i == cPage ? " class=\"active\"" : "") %>><a href="#"><%=i %></a></li>
    <% } %>
    <li>
      <a href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
<div class="board-buttons">
	<button class="btn btn-primary">글쓰기</button>
</div>
<script src="//unpkg.com/jquery@3.2.1"></script>
<script src="//unpkg.com/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</body>
</html>







