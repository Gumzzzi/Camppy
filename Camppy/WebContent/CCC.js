

function ScreenView(data) {

	let divData = $('<div  />').addClass('data');
	$(divData).append(
		$('<div />').html('<img  style="display: block; margin: 0px auto;" width = "500px" src="./img2/' + data.i_info + '">'), //이미지 생성 
		$('<div  />').html(data.i_name),  //상품이름
		$('<div />').html(data.ori_p)  //상품가격
	);
	return divData;
}