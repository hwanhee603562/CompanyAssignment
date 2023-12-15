function login(){
	
	/* 유효성 검사 */
	if( document.loginInfo.mid.value == "" ){
		alert('아이디를 입력하십시오');
		return false;
	}
	if( document.loginInfo.mpwd.value == "" ){
		alert('비밀번호를 입력하십시오');
		return false;
	}
	
	/* 로그인 */
	$.ajax({
		url:"/checkMemberInfo",
		method:"post",
		data: {
			mid : document.loginInfo.mid.value,
			mpwd : document.loginInfo.mpwd.value
		} ,
		async: false,
		success : result =>{
			
			if( result != null ){
				
				sessionStorage.setItem('member', JSON.stringify(result));
				
			} else {
				alert( '아이디/비밀번호를 확인하십시오' )
				return false;
			}

		},
		error : e =>{
			console.log(e);
		}
	});
	
	window.location.href = '/board?page=1';
	
}









