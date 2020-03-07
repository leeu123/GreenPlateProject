<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html lang="en">
 <head>
 <link rel ="stylesheet" type = "text/css" href = "css/gpstyle2.css">

  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link rel="shortcut icon" href="http://simbyone.com/wp-content/uploads/2014/04/3455e6f65c33232a060c28829a49b1cb.png">
<title>Animated Header with scroll</title>

<link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900,200italic,300italic,400italic,600italic,700italic,900italic' rel='stylesheet' type='text/css'>

<link href="css/Icomoon/style.css" rel="stylesheet" type="text/css" />
<link href="css/animated-header.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="_scripts/jquery-2.0.2.min.js"></script>
<script type="text/javascript" src="_scripts/jquery-ui-1.10.4.min.js"></script>
<script type="text/javascript" src="_scripts/jquery.isotope.min.js"></script>
<script type="text/javascript" src="_scripts/animated-header.js"></script>

<link rel="stylesheet" type="text/css" href="css/loginstyle.css"/>
<script type="text/javascript" src="_scripts/login.js"></script>
 </head>
 <body>

  <%@include file = "header.jsp"%>
  <nav>

		<%@include file = "nav.jsp"%>
	</nav>

  <section>
  <div style= "width : 1920px;">
 
  <div id = "restaurant">
  <div id = "restaurant-margin">

  <ul id = "restaurant_margin_ul">
  <li><div id = "restaurant-1"><a href = "restaurant.jsp?rnum=1"><img src = "img/K-001.jpg"><ul id = "restaurant_img_ul"><li><p>정돈</p></li></a><li><span>4.5</span></li></ul></div></li>
  <li><div id = "restaurant-2"><a href = "restaurant.jsp?rnum=2"><img src = "img/K-002.jpg"><ul id = "restaurant_img_ul"><li><p>오스틴(강남점)</p></li></a><li><span>5.0</span></li></ul></div></li>
  <li><div id = "restaurant-3"><a href = "restaurant.jsp?rnum=3"><img src = "img/K-003.jpg"><ul id = "restaurant_img_ul"><li><p>쿠차라(삼성서초사옥점)</p></li></a><li><span>4.0</span></li></ul></div></li>
  </ul>
  </div>
   
  <div id = "restaurant-margin">
  <ul id= "restaurant_margin_ul">
  <li><div id = "restaurant-1"><a href = "restaurant.jsp?rnum=4"><img src = "img/K-004.jpg"><ul id = "restaurant_img_ul"><li><p>꽃을피우고</p></li></a><li><span>3.5</span></li></ul></div></li>
  <li><div id = "restaurant-2"><img src = "img/K-005.jpg"><ul id = "restaurant_img_ul"><li><p>들름집</p></li><li><span>4.0</span></li></ul></div></li>
  <li><div id = "restaurant-3"><img src = "img/K-006.jpg"><ul id = "restaurant_img_ul"><li><p>꽃을피우고</p></li><li><span>3.5</span></li></ul></div></li>
  </ul>
  </div>

   <div id = "restaurant-margin">
   <ul id= "restaurant_margin_ul">
  <li><div id = "restaurant-1"><img src = "img/K-007.jpg"><ul id = "restaurant_img_ul"><li><p>하늬돈까스</p></li><li><span>5.0</span></li></ul></div></li>
 <li><div id = "restaurant-2"><img src = "img/K-008.jpg"><ul id = "restaurant_img_ul"><li><p>투뿔등심</p></li><li><span>5.0</span></li></ul></div></li>
  <li><div id = "restaurant-3"><img src = "img/K-009.jpg"><ul id = "restaurant_img_ul"><li><p>강남진해장</p></li><li><span>4.0</span></li></ul></div></li>
  </ul>
  </div>
  </div>
  <div id = "section-right">
 <span>
<div id="daumRoughmapContainer1576047049962" class="root_daum_roughmap root_daum_roughmap_landing"></div>


<script charset="UTF-8" class="daum_roughmap_loader_script" src="https://ssl.daumcdn.net/dmaps/map_js_init/roughmapLoader.js"></script>

<script charset="UTF-8">
	new daum.roughmap.Lander({
		"timestamp" : "1576047049962",
		"key" : "w7hx",
		"mapWidth" : "350",
		"mapHeight" : "450"
	}).render();
</script></span>
<div id = "con"><img src = "img/con-1.jpg"></div>
<div id = "con"><img src = "img/con-2.jpg"></div>
<div id = "con"><img src = "img/con-3.jpg"></div>

</div>
  </div>
  </section>


  <%@include file = "footer.jsp"%>


	</div>
	
 </body>
</html>
