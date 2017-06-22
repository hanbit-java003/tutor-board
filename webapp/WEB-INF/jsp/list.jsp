<%@page import="com.hanbit.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시판 목록</title>
	<link rel="stylesheet" href="//unpkg.com/bootstrap@3.3.7/dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="/css/board.css">
</head>
<body>

<table id="board-list" class="table table-striped table-hover">
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
		<tr no="<%=article.getNo() %>">
			<td><%=article.getNo() %></td>
			<td><%=article.getTitle() %></td>
			<td><%=article.getWriter() %></td>
			<td><%=article.getViews() %></td>
		</tr>
	<% } %>
	</tbody>
</table>
<%
	int totalCount = (int) request.getAttribute("totalCount");
	int rowsPerPage = 5;
	int pagesToShow = 2;
	int totalPages = (totalCount / rowsPerPage)
			+ (totalCount % rowsPerPage == 0 ? 0 : 1);
	int currentPage = 1;
	
	try {
		currentPage = Integer.valueOf(request.getParameter("page"));
	}
	catch (Exception e) {
		currentPage = 1;
	}
	
	int firstPage = 1;
	int lastPage = totalPages;
	int startPage = ((currentPage - 1) / pagesToShow) * pagesToShow + 1;
	int endPage = Math.min(startPage + pagesToShow - 1, lastPage);
	int prevPage = startPage - 1;
	int nextPage = endPage + 1;
%>
<nav class="board-pages" aria-label="Page navigation">
  <ul class="pagination">
    <li<%=(prevPage < 1 ? " class=\"disabled\"" : "") %>>
      <a class="board-page" page="<%=prevPage %>" href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <% for (int i=startPage; i<=endPage; i++) { %>
    <li<%=(i == currentPage ? " class=\"active\"" : "") %>>
    	<a class="board-page" page="<%=i %>" href="#"><%=i %></a>
    </li>
    <% } %>
    <li<%=(nextPage > lastPage ? " class=\"disabled\"" : "") %>>
      <a class="board-page" page="<%=nextPage %>" href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
<div class="board-buttons">
	<button id="board-new" class="btn btn-primary">글쓰기</button>
</div>
<script src="//unpkg.com/jquery@3.2.1"></script>
<script src="//unpkg.com/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
<script src="/js/list.js"></script>
</body>
</html>







