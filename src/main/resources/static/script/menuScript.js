////////////////////////////////////////////////////////////////////////////////////////////////////////
//하위 매뉴바 숨기기
$("#di").hide();

////////////////////////////////////////////////////////////////////////////////////////////////////////
//검색값 넘기기
$("#cli").on("click",function (){
	var tex = $('#opt').val();
	var pot = $('#pot').val();
	location.href="/main?Search=1&opt="+tex+"&pot="+pot
	})
////////////////////////////////////////////////////////////////////////////////////////////////////////
//마우스 올리면 하위 매뉴바 보이기
$('#spa').on('mouseover',function(){
	$('#di').slideDown();
})

////////////////////////////////////////////////////////////////////////////////////////////////////////
//마우스 치우면 하위 매뉴바 숨기기
$('#di').on('mouseleave',function(){
	$('#di').slideUp();
})
////////////////////////////////////////////////////////////////////////////////////////////////////////
//로그인 했을때 로그아웃
$('#outId').on('click',function (){
	if (confirm('정말 로그아웃을 하겠습니까?')){
		location.href = '/main?out=out'
		alert('로그아웃이 성공했습니다.')
	} 
    else 
    	alert('취소하였습니다.');
    })
////////////////////////////////////////////////////////////////////////////////////////////////////////