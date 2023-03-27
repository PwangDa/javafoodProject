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
           	document.write("<img src='https://cdn.discordapp.com/attachments/931150181540450368/1088433240819376148/ezgif-5-867d124f68.gif' id='foo' style='width : 80px; position:absolute; transition:all 0.3s ease-in; z-index: 1;'>");
        }());
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//로그인 정보 확인        
function notlogin(){
	alert('로그인을 하셔야합니다.')
    location.href = '/login';
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//조회수 증가
function hit(num){
    console.log(num)
    $.ajax({
        type : 'get',
        url : '/my_page/hits?song='+num ,
        data: 'text' ,
		success : function(res){
       		console.log('조회수 : ',res);
		}
    })
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//좋아요 증가
function good(num){
	$.ajax({
		type : 'get',
		url : '/my_page/good?good='+num ,
		data : 'text' ,
		success : function(res){
       		console.log(res);
       		if(res==1) alert('좋아요를 클릭했습니다.')
       		else alert('좋아요 실패')
		}
 	})
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//로딩후 진행
window.onload = function(){
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//프로필 사진 업로드
	$('#but').on('click',function () {
	  $.ajax({
	    url: "/ajax/fileup",
	    type: "POST",
	    data: new FormData($("#form")[0]),
	    enctype: 'multipart/form-data',
	    processData: false,
	    contentType: false,
	    cache: false,
	    success: function () {
	    	alert("이미지 저장 성공")
			location.href = '/my_page?page=a';
	    },
	    error: function () {
	    	alert("이미지 저장 실패")
	    }
	  })
	})
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
	        xml.open('get','/my_page/out');
	        xml.send();
	        xml.onload=function(){
				let a = xml.responseText;
				console.log('a : ',a)
				if(a==1){
					alert('회원탈퇴가 실패 할뻔 하다가 정상적으로탈퇴 되었습니다.^^.')
					location.href = '/my_page'
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
let c= false;
	function aj(key, callback, chak){
		let xml = new XMLHttpRequest();
	    xml.open('get','/login/ajax?'+key);
	    xml.send();
	    xml.onload=function(){
	    	console.log('아자스 값 : ',xml.responseText)
	        z=xml.responseText;
	        if(z==1){
	            alert('사용가능.');
	            console.log(z)
	        }else if(z==2) {
	            alert('값을 입력해주세요.');
				console.log(z)
				
			}else{
	            console.log(z)
	            alert('사용불가.');
	        }
	        callback(z,chak);
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

