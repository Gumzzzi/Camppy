<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Tent List.</title>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"> </script>

        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v5.15.4/js/all.js" crossorigin="anonymous"></script>

        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet"
            type="text/css" />
        <link
            href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800"
            rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
    </head>

    <body>
    	<!-- 서블릿 에서  -->
        <% String select = request.getParameter("check"); %>
        
            <!-- Navigation-->
            <nav class="navbar navbar-expand-lg navbar-light" id="mainNav">
                <div class="container px-4 px-lg-5">
                    <a class="navbar-brand" href="index.html">캠핑의 모든것 </a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                        data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false"
                        aria-label="Toggle navigation">
                        Menu
                        <i class="fas fa-bars"></i>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarResponsive">
                        <ul class="navbar-nav ms-auto py-4 py-lg-0">
                            <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4"
                                    href="Camping.jsp?check=Tent">Tent</a></li>
                            <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4"
                                    href="Camping.jsp?check=SleepingBag">Sleeping Bag</a></li>
                            <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="etc.html">Etc</a></li>
                            <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="login.html">Login</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <!-- 대문  영역 -->
            <header class="masthead" style="background-image: url('assets/img/바람이부는언덕.PNG')">
                <div class="container position-relative px-4 px-lg-5">
                    <div class="row gx-4 gx-lg-5 justify-content-center">
                        <div class="col-md-10 col-lg-8 col-xl-7">
                            <div class="page-heading">
                            
                                <h1 id="pageInfo">Tent Page</h1>
                                
                                <span class="subheading">소제목</span>
                            </div>
                        </div>
                    </div>
                </div>
            </header>
            <!-- Main Content-->



            <main class="mb-4">
                <div class="container px-4 px-lg-5">
                    <div class="row gx-4 gx-lg-5 justify-content-center">
                        <div class="col-md-10 col-lg-8 col-xl-7">

                            <script>
                            	
                            //DAO 에서 만든 파라미터변수값 select 를 가져 와서 TopPick 에 넣어서 사용 한다.
                            //교수님이 JSP 를 사용을 도와주셔서 땡겨왔다.
                                let TopPick = "<%=select%>";
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
                            </script>
                            
                            <script src="CCC.js"></script>



                            <div id="ScreenOutput"></div>

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
                                <li class="list-inline-item">
                                    <a href="#!">
                                        <span class="fa-stack fa-lg">
                                            <i class="fas fa-circle fa-stack-2x"></i>
                                            <i class="fab fa-twitter fa-stack-1x fa-inverse"></i>
                                        </span>
                                    </a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="#!">
                                        <span class="fa-stack fa-lg">
                                            <i class="fas fa-circle fa-stack-2x"></i>
                                            <i class="fab fa-facebook-f fa-stack-1x fa-inverse"></i>
                                        </span>
                                    </a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="#!">
                                        <span class="fa-stack fa-lg">
                                            <i class="fas fa-circle fa-stack-2x"></i>
                                            <i class="fab fa-github fa-stack-1x fa-inverse"></i>
                                        </span>
                                    </a>
                                </li>
                            </ul>
                            <div class="small text-center text-muted fst-italic">Copyright &copy; Your Website 2021
                            </div>
                        </div>
                    </div>
                </div>
            </footer>
            <!-- Bootstrap core JS-->
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
            <!-- Core theme JS-->
            <script src="js/scripts.js"></script>


    </body>

    </html>