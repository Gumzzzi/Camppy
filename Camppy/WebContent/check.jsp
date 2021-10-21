<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>화면출력 보조사이트</title>
</head>
<body>

	<script>
	//DB 에서 data 받아오기
		
		$.ajax({
			url:'./OutputServlet',
			dataType:"json",
			data: {
				check : "Tent",
				check : "SleepingBag"
				},
				
			success: function(result){
				console.log(result);
			   for(let data of result){
				   console.log((ScreenView(data)));
				$('#ScreenOutput').append(ScreenView(data));
			   }
			},
			
			error: function(out){
				console.log(out);
			}
		});
	
		function ScreenView (data){

			let divData = $('<div />').addClass('data');
			$(divData).append(
				$('<div />').html('<img width = "300px" src="./img2/'+data.i_info+'">'), //이미지 생성 
				$('<div />').html(data.i_name),  //상품이름
				$('<div />').html(data.ori_p)  //상품가격
			);
			return divData;
		}
		
		</script>
</body>
</html>