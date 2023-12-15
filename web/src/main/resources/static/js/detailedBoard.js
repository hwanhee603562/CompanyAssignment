updateHeader();

function deleteBoard(){
	
	$.ajax({
		url: "/deleteBoard",
		method: "delete",
    	data: { bno: new URLSearchParams(location.search).get('bno') },
		async: false,
		success: result => {
			
			if( result ){
				alert('게시글 등록에 성공했습니다')
			} else {
				alert('게시글 등록에 실패했습니다')
				return;
			}
			
		},
		error : e => {
			console.log(e)
		}
		
	})
	
	window.location.href = '/board?page=1'
	
}

function updateBoard(){
	
	alert('수정페이지로 이동합니다')
	
	window.location.href = `/update?bno=${new URLSearchParams(location.search).get('bno')}`
	
}


$('.updateBtn [type="button"]').on('click', updateBoard);
$('.deleteBtn [type="button"]').on('click', deleteBoard);





