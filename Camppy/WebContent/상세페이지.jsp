<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>상세페이지</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v5.15.4/js/all.js"
	crossorigin="anonymous"></script>
<!-- Google fonts-->
<link
	href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic"
	rel="stylesheet" type="text/css" />
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800"
	rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/styles.css" rel="stylesheet" />
</head>
<body>
	  <% String select = request.getParameter("check"); %>
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-light" id="mainNav">
		<div class="container px-4 px-lg-5">
			<a class="navbar-brand" href="index.html">Index Page</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				Menu <i class="fas fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ms-auto py-4 py-lg-0">
					<li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4"
						href="Camping.jsp?check=Tent">Tent</a></li>
					<li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4"
						href="Camping.jsp?check=SleepingBag">Sleeping Bag</a></li>
					<li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4"
						href="etc.html">Etc</a></li>
					<li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4"
						href="login.html">Login</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- Page Header-->
	<header class="masthead"
		style="background-image: url('assets/img/post-bg.jpg')">
		<div class="container position-relative px-4 px-lg-5">
			<div class="row gx-4 gx-lg-5 justify-content-center">
				<div class="col-md-10 col-lg-8 col-xl-7">
					<div class="post-heading">
						<h1>Etc Page</h1>
						<h2 class="subheading">소제목</h2>



						<!-- 필요하면 링크 span 사용 
                            <span class="meta">
                                Posted by
                                <a href="#!">Start Bootstrap</a>
                                on August 24, 2021
                            </span>
                             -->
					</div>
				</div>
			</div>
		</div>
	</header>

	<!-- 내용 -->

	<!-- 아이템 추가하는 위치 -->
	<script>
	
		
	</script>
 <main class="mb-4">
            <div class="container px-4 px-lg-5">
                <div class="row gx-4 gx-lg-5 justify-content-center">
                    <div class="col-md-10 col-lg-8 col-xl-7">
                    
                      <script>
                            	
                            //DAO 에서 만든 파라미터변수값 select 를 가져 와서 TopPick 에 넣어서 사용 한다.
                            //교수님이 JSP 를 사용을 도와주셔서 땡겨왔다.
                       
                                $.ajax({
                                	url: './OutputServlet', //서블렛 주소 호출
                                	dataType: "json", //받아올 타입 json
                                	data: {
                                		check: TopPick //부모값 안에 들어갈 (TopPick) 값을 비교해서 값을 화면에 출력해준다.
                                	},
                                	success: function (result) {
                                		console.log(result);
                                		//id값을 TopPick 에서 설정되는 값으로 유연하게 바뀐다. 
                                		$('#pageInfo').html(TopPick);
                                		for (let data of result) {
                                			console.log((ScreenView(data)));
                                			$('#ScreenOutput').append(ScreenView(data));
                                		}
                                	},
                                	error: function (out) {
                                		console.log(out);
                                	}
                                });
                                
                                function ScreenView(data) {

                                	let divData = $('<div  />').addClass('data');
                                	$(divData).append(
                                		$('<div />').html('<img  style="display: block; margin: 0px auto;" width = "500px" src="./img2/' + data.i_info + '">'), //이미지 생성 
                                		
                                	);
                                	return divData;
                                }
                            </script>
                       
                       
                       <!-- 아이템 추가하는 위치 -->
                    <br> [ 캠핑 의모든것 ] 카즈미X5 (Made in Korea)


				<div
					style="padding: 0 0 10px 5px; font: 11px dotum; letter-spacing: -1px; color: #666666">
					겁나비싼 텐트</div>
				<table border="0" cellpadding="0" cellspacing="0" class="top">
					<tbody>
						<tr>
							<td height="2"></td>
						</tr>
						<!--tr><td colspan="2"><span style="padding-bottom:5px; padding-left:14px; color:#EF1C21">절찬리 판매중!!</span></td></tr-->
						
						<tr>
							<th>대여가격 :</th>
							<td><b><span id="price">25,000</span>원</b></td>
						</tr>
	
					</tbody>
				</table>
				<table border="0" cellpadding="0" cellspacing="0">
					<tbody>
						<tr>
							<td height="5"></td>
						</tr>
						<tr height="">
							<th>상품상태 :</th>
							<td>신상품</td>
						</tr>
						<tr>
							<th>제조사 :</th>
							<td>전화문의</td>
						</tr>
						<tr>
							<th>브랜드 :</th>
							<td>전화문의</td>
						</tr>
						<tr>
							<th>정 원 :</th>
							<td>전화문의</td>
						</tr>
						<tr>
							<th>수령방법 :</th>
							<td>택배 및 매장방문수령</td>
						</tr>

						<tr>
							<th>재 고 :</th>
							<td>전화문의</td>
						</tr>
						<tr>
							<th>기준 대여일 :</th>
							<!-- <td><b>1박 2일 / 1박 추가시 30% 증가</b></td> -->
						</tr>
						<input type="hidden" name="ea" step="1" min="1" max="0" value="1">

						<tr>
							<th>제품상태 :</th>

						</tr>
					</tbody>
				</table>



				<!-- 필수 옵션 일체형 -->
				<table border="0" cellpadding="0" cellspacing="0" class="top">
					<tbody>
						<tr>
							<td height="6"></td>
						</tr>
						<tr>
							<th valign="top">대여일 :
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
							<td>
								<div>
									<select name="opt[]"
										onchange="chkOption(this);chkOptimg();nsGodo_MultiOption.set();"
										required="" fld_esssential="" msgr="대여일 선택을 해주세요">
										<option value="">== 옵션선택 ==</option>
										<option value="매장방문(1박2일)">매장방문(1박2일)</option>
										<option value="매장방문(2박3일)">매장방문(2박3일) (32,500원)</option>
										<option value="매장방문(3박4일)">매장방문(3박4일) (40,000원)</option>
										<option value="매장방문(4박5일)">매장방문(4박5일) (47,500원)</option>
										<option value="매장방문(5박6일)">매장방문(5박6일) (52,500원)</option>
										<option value="택배(1박2일)⇒(왕복택배비)">택배(1박2일)⇒(왕복택배비)
											(35,000원)</option>
										<option value="택배(2박3일)⇒(왕복택배비)">택배(2박3일)⇒(왕복택배비)
											(42,500원)</option>
										<option value="택배(3박4일)⇒(왕복택배비)">택배(3박4일)⇒(왕복택배비)
											(50,000원)</option>
										<option value="택배(4박5일)⇒(왕복택배비)">택배(4박5일)⇒(왕복택배비)
											(57,500원)</option>
									</select>
								</div>
							</td>
						</tr>
						<tr>
							<td height="6"></td>
						</tr>
					</tbody>
				</table>
                       
                       
                    </div>
                </div>
            </div>
        </main>

	


	<!-- Footer-->
	<footer class="border-top">
		<div class="container px-4 px-lg-5">
			<div class="row gx-4 gx-lg-5 justify-content-center">
				<div class="col-md-10 col-lg-8 col-xl-7">
					<ul class="list-inline text-center">
						<li class="list-inline-item"><a href="#!"> <span
								class="fa-stack fa-lg"> <i
									class="fas fa-circle fa-stack-2x"></i> <i
									class="fab fa-twitter fa-stack-1x fa-inverse"></i>
							</span>
						</a></li>
						<li class="list-inline-item"><a href="#!"> <span
								class="fa-stack fa-lg"> <i
									class="fas fa-circle fa-stack-2x"></i> <i
									class="fab fa-facebook-f fa-stack-1x fa-inverse"></i>
							</span>
						</a></li>
						<li class="list-inline-item"><a href="#!"> <span
								class="fa-stack fa-lg"> <i
									class="fas fa-circle fa-stack-2x"></i> <i
									class="fab fa-github fa-stack-1x fa-inverse"></i>
							</span>
						</a></li>
					</ul>
					<div class="small text-center text-muted fst-italic">Copyright
						&copy; Your Website 2021</div>
				</div>
			</div>
		</div>
	</footer>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
</body>
</html>
