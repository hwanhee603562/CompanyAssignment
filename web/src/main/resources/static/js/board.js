updateHeader();

let page = new URLSearchParams(location.search).get('page');

function beforePage(  ){
	
	if( page <= 1 ){
		return
	}
	
	window.location.href = `/board?page=${page-1}`
}


function afterPage( totalPageCount ){
	
	if( page >= totalPageCount ){
		return
	}
	
	window.location.href = `/board?page=${parseInt(page) + 1}`
}


// 상세페이지 이동
function redirectDetailed(bno) {
	window.location.href = '/detailedBoard?bno=' + bno;
}


$('.beforeBtn [type="button"]').on('click', beforePage);
$('.afterBtn [type="button"]').on('click', afterPage);


