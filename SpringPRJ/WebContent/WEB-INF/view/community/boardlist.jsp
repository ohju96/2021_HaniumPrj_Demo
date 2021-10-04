<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="static poly.util.CmmUtil.nvl"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="poly.dto.ProjectsDTO"%>

<!DOCTYPE html>
<html lang="en">
<!-- 컨토롤러에서 실행된 로직들의 결과값을 가져온다 == rlist에 담아진 값들  -->
<%
	List<ProjectsDTO> rList = (List<ProjectsDTO>) request.getAttribute("rList");
%>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">  
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>커뮤니티 게시판</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="/resource/css/style.css">
</head>
<body>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	<div class="container">
		<h2>
			<a href="/index.do"><img src="/resource/img/logo.png" class="img_size2" alt="올포유 로고"></a>
		</h2>
		<h2 class="h2_seat">
			<code class="h2_seat_color">커뮤니티 게시판</code>
		</h2>
		<table class="table table-striped">
			<thead class="thead_color">
				<tr>
					<th>글 번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>날짜</th>
				</tr>
			</thead>
			<tbody>
			<!-- rList안의 ProjectsDTO가 p에 순차적으로 대입되며 실행되는 for문 -->
				<%
					for (ProjectsDTO p : rList) {
				%>
				
				<tr onclick="location.href='/community/boardsee.do?number=<%=p.getBoard_seq()%>'">
					<td><%=p.getBoard_seq()%></td>
					<td><%=p.getBoard_title()%></td>
					<td><%=p.getBoard_writer()%></td>
					<td><%=p.getBoard_regdate()%></td>
				</tr>
				
				<%
					}
				%>
			</tbody>
		</table>

		<div class="div_button">
			
			<button type="button"
				onclick="location.href='/community/boardwrite.do' "
				class="btn button_FA6862 button_FA6862_seat">글쓰기</button>
				<button type="button"
				onclick="location.href='/index.do' "
				class="btn button_FA6862 button_FA6862_seat" style="width:120px; margin-right: 10px;">이전 페이지</button>
		</div>

	</div>
	<br>

	<nav>
		<ul class="pagination justify-content-center">
			<li class="page-item"><a class="page-link a_color" href="">이전</a></li>
			<li class="page-item"><a class="page-link a_color" href="">1</a></li>
			<li class="page-item"><a class="page-link a_color" href="">2</a></li>
			<li class="page-item"><a class="page-link a_color" href="">3</a></li>
			<li class="page-item"><a class="page-link a_color" href="">다음</a></li>
		</ul>
	</nav>
</body>
</html>

