updateHeader();


function postBoard(){
	
	console.log(111)
	
	let formData = $('#memberInfo').serialize();
	
	/* 유효성 검사 */
	
	
	/* 게시글 등록 */
	$.ajax({
		url: "postBoard",
		method: "post",
		data: formData,
		success: result => {
			
			if( result ){
				alert('게시글 등록에 성공했습니다')
			} else {
				alert('게시글 등록에 실패했습니다')
			}
			
		},
		error : e => {
			console.log(e)
		}
		
	})
	
	
}

$('.buttonBox input[type="button"]').on('click', postBoard);