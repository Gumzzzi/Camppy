// (name=value)형태로 단위로 저장이되는데 ; 이전까지의 문자열을 잘라와서
// x 에 "=" 이전의 문자열인 name의 값을 가지고
// y 에 "=" 이후의 문자열인 value의 값을 가지게된다
// 현재 로그인한 유저의 ID가 value 이므로 y를 리턴받게했다

// 세션쿠키를 사용하게됬으므로 사용하지 않는 함수가됬습니다..
function getCookie() {
    var x, y;
    var val = document.cookie.split(';');
    for (var i = 0; i < val.length; i++) {
        x = val[i].substr(0, val[i].indexOf('='));
        y = val[i].substr(val[i].indexOf('=') + 1);
        x = x.replace(/^\s+|\s+$/g, '');
        console.log(y);

        return y;
    }
}



// LoginUser의 값을 없애 로그아웃 처리하는것
// expire가 0 으로 설정되고 삭제되는것이 아니라
// value가 "" 공백처리되는것이며 세션이 종료되는 시점에
// 쿠키자체의 수명이 다하여 사라지는것 

function delUserCookie() {

	if(!(sessionStorage.getItem('LoginUser')=="")){
		sessoionStorage.removeItem('LoginUser');
	}


/*    if (!(getCookie === "")) {
        document.cookie = 'loginUser=; expires=0; path/';
        location.reload();
        alert('로그아웃되었습니다.');

    }*/
}

// 로그인 쿠키를 가졌는지 아닌지 비교해서
// 가지고있다면 로그아웃 버튼과 환영 메시지 li를 상단 ul에 추가하고
// 가지고있지 않다면 로그인 페이지로 들어갈수있는 로그인 버튼을 상단 ul에 추가하는 함수

function LogioCreate() {
    let login, logout, weclome
    let ul = $('#mom');

	let userid = sessionStorage.getItem('LoginUser');
	
    console.log(ul);
    console.log(userid+" logio");
    
   	

    if(sessionStorage.getItem('LoginUser')==null) {
        login = $('<li />').attr('class', 'nav-item').attr('id', 'loginBtn')
        $(login).html(
            '<a class="nav-link px-lg-3 py-3 py-lg-4">Login</a>'
        );
        ul.append(login);

        // console.log($('#loginBtn'));
        //$('#loginBtn').attr('style', 'display:none')
        //$('#loginBtn').attr('display','none');

    } else {
        logout = $('<li />').attr('class', 'nav-item').attr('id', 'logoutBtn');
        $(logout).html(
            '<a class="nav-link px-lg-3 py-3 py-lg-4" onclick="delUserCookie()" href="index.html">Logout</a>'
        );
        ul.append(logout);

        let id = userid;
        welcome = $('<li />').attr('class', 'nav-item').attr('id', 'welcometxt');
        $(welcome).html(
            `<a class="nav-link px-lg-3 py-3 py-lg-4">${id}님 안녕하세요!</a>`
        )
        $(welcome).html();
        ul.append(welcome);
    }
}

// 쿠키 테스트용 함수 value가 존재한다면 true 없다면 false 를 반환한다

function cookieCheck() {
    console.log(!(getCookie() === ""))
}