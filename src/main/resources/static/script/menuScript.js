////////////////////////////////////////////////////////////////////////////////////////////////////////
//하위 매뉴바 숨기기
$("#di").hide();

////////////////////////////////////////////////////////////////////////////////////////////////////////
//검색값 넘기기
$("#cli").on("click",function (){
	var tex = $('#opt').val();
	var pot = $('#pot').val();
	location.href="/search?opt="+tex+"&pot="+pot
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
//화면 로딩후 진행
////////////////////////////////////////////////////////////////////////////////////////////////////////
// 프로필 사진 유무 확인
let xml = new XMLHttpRequest();
xml.open('get','/ajax/filedo?fileName='+id+'.JPG');
xml.send();
xml.onload=function(){
	console.log('아자스 값 : ',xml.responseText)
    z=xml.responseText;
    console.log('id : ', id)
//    if(z!=''){
//        alert('이미지가져옴');
//        console.log(z)
//	}else{
//        console.log(z)
//        let a='asd'
//        alert('이미지 못가져옴');
//    }
}
////////////////////////////////////////////////////////////////////////////////////////////////////////
