<%@page import="vo.ReviewBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
ReviewBean article = (ReviewBean)request.getAttribute("article");
%>
<html lang="en">
<head>
<script type="text/javascript">
	function modifyboard(){
		modifyform.submit();
	}
</script>	
	
<link rel="stylesheet" type="text/css" href="css/board_write_style.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/gpstyle2.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="shortcut icon"
	href="http://simbyone.com/wp-content/uploads/2014/04/3455e6f65c33232a060c28829a49b1cb.png">
<title>그린플레이트 게시판</title>
<link
	href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900,200italic,300italic,400italic,600italic,700italic,900italic'
	rel='stylesheet' type='text/css'>

<link href="css/Icomoon/style.css" rel="stylesheet" type="text/css" />
<link href="css/animated-header.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="_scripts/jquery-2.0.2.min.js"></script>
<script type="text/javascript" src="_scripts/jquery-ui-1.10.4.min.js"></script>
<script type="text/javascript" src="_scripts/jquery.isotope.min.js"></script>
<script type="text/javascript" src="_scripts/animated-header.js"></script>

<link rel="stylesheet" type="text/css" href="css/loginstyle.css" />
<script type="text/javascript" src="_scripts/login.js"></script>


<link rel="stylesheet" type="text/css" href="css/boardstyle.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<link
	href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900,200italic,300italic,400italic,600italic,700italic,900italic'
	rel='stylesheet' type='text/css'>

</head>
<body>


	<%@include file="header.jsp"%>

	<nav>
		<img src="img\board_nav_img.jpg" style="width: 100%">
	</nav>

	<section style="min-height: 604px">
		<div id="write-bar">
			<form class="form-horizontal" role="form" action="reviewModifyPro.bo" method="post" name = "modifyform">
				<input type = "hidden" name = "rnum" value = "<%=article.getRnum()%>"/>
				<div class="form-group">
					<label for="qtitle" class="col-sm-2 control-label">제목</label>
					<div class="col-sm-10">
						<input type="text" class="form-control"
							placeholder="게시글 제목을 입력하세요" value = "<%=article.getRtitle()%>" name="rtitle"
							required="required">
					</div>
				</div>
				<div class="form-group">
					<label for="qpass" class="col-sm-2 control-label">비밀번호</label>
					<div class="col-sm-10">
						
							<input type="password" class="form-control"
								placeholder="비밀번호를 입력하세요" value="" name="rpass"
								required="required">
				
					
					</div>
				</div>
				<div class="form-group">
					<label for="nick" class="col-sm-2 control-label">작성자</label>
					<div class="col-sm-10">
						
							<input type="text" class="form-control" placeholder="작성자를 입력하세요"
								value = "<%=article.getNick()%> "Readonly name="nick" required="required">
					
						
					</div>
				</div>

				<div class="form-group">
					<label for="qcontent" class="col-sm-2 control-label">게시글</label>
					<div class="col-sm-10">
						<textarea class="form-control" rows="10" name="rcontent"
							required="required"><%=article.getRcontent()%></textarea>
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-sm-10 col-sm-offset-2">
						<a class="btn btn-success" style="color: white" href="javascript:modifyboard()">수정</a>&nbsp;&nbsp;
			            <a class="btn btn-success" style="color: white" href="javascript:history.go(-1)">뒤로</a>
					</div>
				</div>
		</div>
		</form>


	</section>
	<footer style="margin-top: 1px;">
		<%@include file="footer.jsp"%>
	</footer>



</body>
</html>
