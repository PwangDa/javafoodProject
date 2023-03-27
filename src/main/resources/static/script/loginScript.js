///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//마우스 이미지
(function (){  
	document.onmousemove=function (e){ 
		var ob=document.getElementById("foo").style;
		ob.left=e.pageX+15+"px"; 
		ob.top=e.pageY+15+"px";
		}
	document.write("<img src='https://cdn.discordapp.com/attachments/931150181540450368/1088433240819376148/ezgif-5-867d124f68.gif' id='foo' style='width : 80px; position:absolute; transition:all 0.3s ease-in; z-index: 1;'>");
	}());
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//로그인 성공시 1초 후에 페이지 이동
function loging(){
	let time=1;
	$("#time").append(time);
	setInterval (function(){
		console.log(time);
		time--;
		$("#time").text(time);
		if (time==0){
			location.href='main';
		}
	},1000)
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//화면 로딩후 진행
window.onload=function() {
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//저장된 아이디 쿠키값 가져오기
	$('#idcook').on('click',function(){
		console.log('쿠키값 가져오기')
		let cookie = 'id';
		
		if( $('#idcook').is(':checked') ){
			let id = document.cookie.split(";");
			console.log(id)
			for(let i =0; i<id.length; i++){
				if(id[i].split("=")[0].trim()==cookie)
					id=id[i].split("=")[1].trim();
			}
				console.log('쿠키값 : ',id)
				$('#id12').val(id)
			}else $('#id12').val('')
	})
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// 프로필 파일 업로드
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
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//호그인 화면의 아이디/비밀번호 텍스트 비우기
	if(document.querySelector('.btnClear')!=null){
	    var btnClear = document.querySelector('.btnClear');
	    btnClear.addEventListener('click', function(){
			console.log('123');
	        btnClear.parentNode.querySelector('.tt').value = "";
	    })
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//로고 이미지 클릭시 메인 화면으로 이동
    $('.logo-img').on('click',function(){
		location.href='main'
	})
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//다시작성 클릭시 작성된 텍스트 초기화 및 회원가입 버튼 비활성화
	$('#re').on('click',function(){$('#end').attr('disabled',true);})
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//아자스로 넘겨줘서 중복값 확인
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
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//중복 확인 완료시에 회원가입 버튼 활성화
	function fn(call,chak){
		call!=1?$(chak).prop('checked',false):$(chak).prop('checked',true);
		let j=0;
		for(let i =0; i<$('.ch').length; i++){
			if($('.ch')[i].checked==true)j++;
		}
		j==6?$('#end').attr('disabled',false):$('#end').attr('disabled',true);
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//아이디 중복값 확인
	$('#idbutt').on('click',function(){aj("Id1="+$('#Id1').val(), fn, '#ch1');})
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//비밀번호 일치 확인
	$("#pwbutt").on("click",function(){
		if($("#pw1").val() == $("#pw2").val()){
			alert("비밀번호가 일치합니다.");
			fn(1,'#ch2');
		}else {
			alert("잘못입력 하셨습니다.");
			fn(0,'#ch2');
		}
	})
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//닉네임 중복값 확인
	$("#nicbutt").on("click",function(){aj("nic="+$('#nic').val(), fn, '#ch3');})
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//메일 중복값 확인
	$("#mailbutt").on("click",function(){aj('email='+$('#email').val(), fn, '#ch4')})
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//주민등록번호 중복값 확인
	$("#pnbutt").on("click",function(){
		let pn = 'pn='+$('#pn1').val() +"-"+ $('#pn2').val();
		aj(pn,fn,'#ch6');
	})
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//핸드폰 번호 중복 확인
	$("#phonebutt").on("click",function(){
		let phone = 'phone='+$('#phone1').val() + "-" + $('#phone2').val()+ "-" + $('#phone3').val();
		aj(phone,fn,'#ch7');
	})
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*
	let search = document.querySelector("span.user_search");
	let search2=document.querySelector("div.search");
	search.addEventListener("click", function(){
		search2.classList.toggle("hidden");
	});*/
}
