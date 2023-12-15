
// 로그인 상태에 따른 헤더의 별도 출력
function updateHeader() {
	
    const navElement = document.querySelector('nav');

    if ( 0 < JSON.parse(sessionStorage.getItem('member')).mno ) {
		
        navElement.innerHTML = `
            <span onClick="logOut()" class="signUpBtn">로그아웃</span>
            <a href="/write"><span> 게시글 작성 </span></a>
            <a href="/board?page=1"><span> 게시판 </span></a>`;
            
    } else {
		
        navElement.innerHTML = `
            <a href="/signUp"><span> 회원가입 </span></a>
            <a href="/logIn"><span> 로그인 </span></a>
            <a href="/write"><span> 게시글 작성 </span></a>
            <a href="/board?page=1"><span> 게시판 </span></a>
        `;
        
    }
}


// 로그아웃
function logOut(){
	
	sessionStorage.removeItem( 'member' );
	
	/* 로그아웃 */
	$.ajax({
		url:"/logOut",
		method:"post",
		data: {},
		async: false,
		success : result =>{
			
			if( result ){
				
				alert('로그아웃 되었습니다')
				
			} else {
				return false;
			}

		},
		error : e =>{
			console.log(e);
		}
	});
	
	window.location.href = '/board?page=1';
	
}






















