/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//마우스 이모티콘
 (function () {
            document.onmousemove = function (e) {
                var ob = document
                    .getElementById("foo")
                    .style;
                ob.left = e.pageX + 15 + "px";
                ob.top = e.pageY + 15 + "px";
            }
            document.write(
                "<img src='https://tistory1.daumcdn.net/tistory/4694508/skin/images/hai1.gif' i" +
                "d='foo' style='position:absolute; transition:all 0.3s ease-in; z-index: 1;'>"
            );
        }());
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//로그인 정보 확인        
function notlogin(){
	alert('로그인을 하셔야합니다.')
    location.href = '/login';
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//회원 탈퇴 성공 여부
function urseout(){
	
	if (out == 1)  alert('회원이 정상적으로 탈퇴되었습니다.')
	else alert('회원탈퇴가 실패하였습니다.')
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//사진 업로드
function but() {
    var url = $("#form").attr("action");
    var form = $('#form')[0];
    var formData = new FormData(form);
    $.ajax({
        url: url,
        type: 'POST',
        data: formData,
        contentType: false,
        processData: false,
        cache: false,
        success: function () {
            alert("이미지 저장 성공")
            location.href = 'javafood?javafood=5&remove=1';
        },
        error: function () {
            alert("이미지 저장 실패")
        }
    })
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//회원 재생기록 확인
function replay(id){
	location.href = 'javafood?javafood=5&usre='+id
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//유튜브 링크
function hit(num){
    var id = $('#id').val()
    console.log(num)
    $.ajax({
        type : 'get',
        url : 'http://localhost:8080/javafood_team/aj?id1='+id+'&num='+num,
        data: 'text'
    })
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//좋아요 증가
function good(num){
	console.log(num)
	$.ajax({
		type : 'get',
		url : 'http://localhost:8080/javafood_team/aj?&good='+num,
		data : 'text'
	})
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//로딩후 진행
window.onload = function(){
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//로그아웃
	$('#outsession').on("click",function(){
		console.log("3번클릭");
		if (confirm('정말 로그아웃을 하겠습니까?')) 
			location.href = '/my_page?page=c'
	    else 
	    	alert('취소하였습니다.');
	    })
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//회원탈퇴
	$('#outid').on('click', function () {
	    var li1 = confirm('정말로 회원탈퇴를 하실건가요?');
	    var li2 = false;
	    var li3 = false;
	    var li4 = false;
	    var li5 = false;
	    var li6 = false;
	    if (li1 === true) 
	        li2 = confirm('한번 탈퇴하면 되돌릴수가 업습니다!')
	    if (li2 === true) 
	        li3 = confirm('그래도 하시겠습니까?')
	    if (li3 === true) 
	        li4 = confirm('다시한번 생각해 주세요.')
	    if (li4 === true) 
	        li5 = confirm('마지막 기회 입니다.')
	    if (li5 === true) 
	        li6 = confirm('진짜?')
	    if (li6 === true) {
	        
	        alert('회원탈퇴를 합니다.ㅜㅜ')
	        let xml = new XMLHttpRequest();
	        xml.open('get','my_page/out');
	        xml.send();
	        xml.onload=function(){
				let a = xml.responseText;
				console.log('a : ',a)
				if(a==1){
					alert('회원이 정상적으로탈퇴 되었습니다.')
				}else {
					alert('회원탈퇴가 실패하였습니다.^^.')
					}
			}
	    }
	})
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//다시작성 수정하기 클릭 불가
	$('#re').on('click', function () {
		$('#end').attr('disabled', true);
    })
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//아자스로 보내서 중복되는값 확인
    let c = false;
    function aj(key, callback, chak) {
        let xml = new XMLHttpRequest();
        xml.open('get', 'http://localhost:8080/javafood_team/aj?' + key);
        xml.send();
        xml.onload = function () {
            let z = 0;
            c = xml.responseText;
            if (c != 1) {
                z = 1;
                alert('사용가능.');
            } else {
                z = 0;
                alert('사용중입니다.');
            }
            callback(z, chak);
        }
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//중복확인 클릭시 수정가능
    function fn(call, chak) {
        call != 1
            ? $(chak).prop('checked', false)
            : $(chak).prop('checked', true);
        let j = 0;
        for (let i = 0; i < $('.ch').length; i++) {
            if ($('.ch')[i].checked == true) 
                j++;
            }
        j == 4
            ? $('#end').attr('disabled', false)
            : $('#end').attr('disabled', true);
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//비밀번호 일치 화인
    $("#pwbutt").on("click", function () {
        if ($("#pw1").val() == $("#pw2").val()) {
            alert("비밀번호가 일치합니다.");
            fn(1, '#ch2');
        } else {
            alert("잘못입력 하셨습니다.");
            fn(0, '#ch2');
        }
    })
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//닉네임 중복 확인
    $("#nicbutt").on("click", function () {
        aj("nic=" + $('#nic').val(), fn, '#ch3');
    })
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//메일 중복 확인
    $("#mailbutt").on("click", function () {
        aj('email=' + $('#email').val(), fn, '#ch4')
    })
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//핸드폰 중복 확인
    $("#phonebutt").on("click", function () {
        let phone = 'phone=' + $('#phone1').val() + "-" + $('#phone2').val() + "-" + $(
            '#phone3'
        ).val();
        aj(phone, fn, '#ch7');
    })
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}

