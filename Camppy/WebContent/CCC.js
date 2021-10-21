

function ScreenView(data) {

	let divData = $('<div  />').addClass('data');
	$(divData).append(
		$('<div />').html('<a href="구매페이지.jsp"><img  style="display: block; margin: 0px auto;" width = "500px" src="./img2/' + data.i_info + '"></a>'), //이미지 생성 
		$('<div style="text-align:center;" />').html(data.i_name),  //상품이름
		$('<div style="text-align:center;" />').html(data.ori_p)  //상품가격
	);
	return divData;
}