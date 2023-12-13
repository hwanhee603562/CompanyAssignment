

// 이메일 인증 상태변수
let mailCheckState = false;


// 이메일 인증 버튼 클릭 시
function sendEmail(){
	
	// 이메일 유효성 검사
	if( document.memberInfo.memail.value == '' ){
		alert('이메일을 입력해주십시오');
		return false;
	}
	
	let emailCheck = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.(com)$/;
	if( !emailCheck.test( document.memberInfo.memail.value ) ){
		alert('이메일 형식이 올바르지 않습니다');
		return false;
	}

	
	/* 이메일 전송 */
	$.ajax({
		url:"/sendEmail",
		method:"post",
		data: { toEmail: document.memberInfo.memail.value } ,
		success : result =>{
			
			// 이메일 전송 성공
			if( result ){
				
				alert( '이메일을 전송하였습니다' )
				document.querySelector('.outputEmail').innerHTML = `
					남은시간 <span class="timebox"> 03:00 </span>
					<input type="text" class="inputEmailNo">
					<button type="button" onClick="checkEmailNo()"> 확인 </button>
				`
				
				// 타이머 실행
				settimer();
				
			} 
			// 이메일 전송 실패
			else {
				alert( '이메일 전송에 실패하였습니다' )
			}

		},
		error : e =>{
			console.log(e);
		}
	});
	
}

// 초기 timer 설정
let timer = 180;

// 타이머 생성
function settimer(){
	
	timerInter = setInterval( () => {
		 
		let m = parseInt( timer/60 );
		let s = parseInt( timer%60 );
			
		m = m < 10 ? "0"+m : m;
		s = s < 10 ? "0"+s : s;
		
		document.querySelector('.timebox').innerHTML = `${m}:${s}`;
		timer--;
		
		if( timer < 0 ){
			
			// 메소드 종료
			clearInterval( timerInter );
			document.querySelector('.outputEmail').innerHTML = ``;
			
		}
	}, 1000 );
	
}


// 서버측 세션과 이메일 정보 비교
function checkEmailNo(){
	
	let emailNo = document.querySelector('.inputEmailNo').value;
	
	/* 유효성 검사 */
	if( emailNo == '' ){
		alert('인증번호를 입력해주십시오');
		return false;
	}
	
	
	$.ajax({
		url:"/checkEmail",
		method:"post",
		data: { inputEemail: emailNo },
		success : result =>{
			
			if( result ){
				
				alert( '이메일 인증에 성공하였습니다' );
				mailCheckState = true;
				
				document.querySelector('.outputEmail').innerHTML = ``;
				
				
			} else {
				
				alert( '이메일 인증에 실패하였습니다' )
				
			}

		},
		error : e =>{
			console.log(e);
		}
	});
	
	
}


// 회원가입 버튼 클릭 시
function submit(){
	
	let formData = $('#memberInfo').serialize();
	
	/* 유효성 검사 */
	if( document.memberInfo.mname.value == '' ){
		alert('이름을 입력해주십시오');
		return false;
	}
	if( document.memberInfo.mid.value == '' ){
		alert('아이디를 입력해주십시오');
		return false;
	}
	if( document.memberInfo.mpwd.value == '' ){
		alert('비밀번호를 입력해주십시오');
		return false;
	}
	if( document.memberInfo.checkPwd.value == '' ){
		alert('비밀번호 확인란을 입력해주십시오');
		return false;
	}
	if( document.memberInfo.mpwd.value != document.memberInfo.checkPwd.value ){
		alert('입력하신 비밀번호 확인란이 일치하지 않습니다')
		return false;
	}
	if( !mailCheckState ){
		alert('이메일 인증을 실시하시기 바랍니다');
		return false;
	}

	
	
	/* 회원가입 */
	$.ajax({
		url:"/postMember",
		method:"post",
		data: formData ,
		success : result =>{
			
			if( result ){
				alert( '회원가입에 성공하였습니다' )
			} else {
				alert( '회원가입에 실패하였습니다' )
			}

		},
		error : e =>{
			console.log(e);
		}
	});
	

	
}








































