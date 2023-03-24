/**
 * 
 */

function refresh() {

	/* setTimeout('location.reload()', 60000); */
	window.scrollTo({ left: 0, top: 0, behavior: "smooth" });

}
////////////////////////////////////////////////////////////////////////////////////////		

/*function nowtime() {
	let now = new Date();

	let hour = now.getHours();
	let minute = now.getMinutes();
	let second = now.getSeconds();

	if (hour < 10) {
		hour = "0" + hour;
	}
	if (minute < 10) {
		minute = "0" + minute;
	}
	if (second < 10) {
		second = "0" + second;
	}

	document.getElementById("timebox").value = hour + ":" + minute
		+ ":" + second;
	//console.log(123, document.getElementById("timebox"));
}


window.addEventListener("load", function() {
	//HTML이 다 load가 완료 됐을 때 실행됨
	nowtime();
	setInterval(function() {

		nowtime();
	}, 1000); //1초 단위
})*/

		$(function() {
            setInterval(function() {
                $.get("/get-current-time", function(time) {
					/*console.log(time)*/
                    //$("#current-time").text(time);
                    $("#server-time-input").val(time);
                });
            }, 1000);
        });
        
/*function showServerTime() {
            var now = new Date();
            var hours = now.getHours();
            var minutes = now.getMinutes();
            var seconds = now.getSeconds();
            var timeString = hours + ':' + minutes + ':' + seconds;
            //document.getElementById("server-time-input").value = timeString;
        }*/
        
window.addEventListener("load", function() {
	//HTML이 다 load가 완료 됐을 때 실행됨
	showServerTime();
	setInterval(function() {

		showServerTime();
	}, 1000); //1초 단위
})
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// 조회수 증가
function hit(num) {
	console.log(num)
	$.ajax({
		type: 'get',
		url: '/my_page/hits?song=' + num,
		data: 'text',
		success: function(res) {
			console.log(res);
		}
	})
}


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

/*function addhit(id,song) {
	console.log("id = "+id)
	console.log("song = "+song)
	location.href = 'chart&play='+song+'&id='+id;
	
}*/

/*function playVideo() {
	
	const login = "${login}";
	const songnumber = "${dao.songnumber}";
	
	// 유튜브 동영상 ID 생성
	const videoId = "유튜브 동영상 ID를 여기에 입력하세요";
	// 유튜브 동영상 링크 생성
		const videoUrl = `https://www.youtube.com/watch?v=${videoId}`;
		// 새 창에서 유튜브 동영상 링크 열기
		 window.open(videoUrl, '_blank');
}*/

/*	let save = document.querySelectorAll("img.save");
	for(let i=0; i<save.length; i++){
		save[i].addEventListener("click",function(){
			console.log("담기 버튼 눌림");
			
			save[i].parentNode.target = "_blank";
			save[i].parentNode.submit();
		});
	}
	
	//여러 개가 체크 된 곡들을 플레이 리스트에 추가하기
	let allsave = document.querySelector("img#allsave");
	allsave.addEventListener("click", function(){
		allsave.parentNode.action = "chart&songNumbers="+getCheckedValue()+"&addWhere=song";
		allsave.parentNode.submit();
	});*/

//담기 버튼 누르면, 곡이 추가될 플레이 리스트 선택하는 팝업 뜨게 하기
let addList = document.querySelectorAll("img.addList");

//console.log(addList);

for (let i = 0; i < addList.length; i++) {
	addList[i].addEventListener("click", function() {
		console.log("save의 EventListener 실행됨."); //확인용

		addList[i].parentNode.target = "_blank"; //새 창으로 열기
		addList[i].parentNode.submit(); //form 서밋하기
	});
}

//여러 개가 체크 된 곡들을 플레이 리스트에 추가하기
let addLists = document.querySelector("img#addLists");


addLists.addEventListener("click", function() {
	let string = "";
	for (let i = 0; i < getCheckedValue().length; i++) {
		string += "songNumber=";
		string += getCheckedValue()[i];
		if (getCheckedValue.length - 1 != i) {
			string += "&";
		}
	}
	addLists.parentNode.action = "playListAdd?" + string;
	addLists.parentNode.target = "_blank";
	addLists.parentNode.submit();
});
//////////////////////////////////////////////////////////////////////////////////////////
/* refresh(); */

function checkSelectAll() {

	const checkboxes = document.querySelectorAll('input[name="check"]');
	const checked = document.querySelectorAll('input[name="check"]:checked');
	const selectAll = document.querySelector('input[name="checkall"]');

	if (checkboxes.length === checked.length) {
		selectAll.checked = true;
	} else {
		selectAll.checked = false;
	}

}
function selectAll(selectAll) {
	console.log(selectAll.checked);
	const checkboxes = document.getElementsByName("check");

	checkboxes.forEach((checkbox) => {
		checkbox.checked = selectAll.checked;
	})
}
// 체크박스에서 값 가져오기
function getCheckedValue() {
	const checkboxes = document.querySelectorAll('input[name="check"]:checked');
	let checkedValue = [];
	checkboxes.forEach((checkbox) => {
		checkedValue.push(checkbox.value);
	})
	console.log(checkedValue)
	return checkedValue;
}

(function() {
	document.onmousemove = function(e) { var ob = document.getElementById("foo").style; ob.left = e.pageX + 15 + "px"; ob.top = e.pageY + 15 + "px"; }
	document.write("<img src='https://tistory1.daumcdn.net/tistory/4694508/skin/images/hai1.gif' id='foo' style='position:absolute; transition:all 0.3s ease-in; z-index: 1;'>");
}());

/*아이디 찾기*/
// 닉네임 정규식 체크해서 값 건지기
$("#findid_nic").on("keyup", function(){
	var id_nic = $("#findid_nic").val();	//닉네임 입력값
	var id_niccheck = /^[가-힣]+$/;			//닉네임 정규식
	//이름 정규식이 맞지 않으면?
	if(!id_niccheck.test(id_nic)){
		$("#s_findid_nic").html("이름에는 띄어쓰기, 숫자, 영어, 특수문자를 입력할 수 없습니다").css("color","red");
	}else{
		$("#s_findid_nic").html("");
	}
	
})
// 전화번호 정규식 체크해서 값 건지기
$("#findid_phone1").blur(function(){
	var id_phone1 = $("#findid_phone1").val();		//phone1 값
	var id_phonecheck = /^\b{3}$/;				// 전화번호 정규식
	// 전화번호 정규식이 맞으면?
	if(id_phonecheck.test(id_phone1)){
		$("#s_findid_phone").html("");
		id_phone();
	}else{
		$("#s_findid_phone").html("전화번호에는 숫자만 입력 가능합니다.").css("color","red");
	}
});

$("#findid_phone2").blur(function(){
	var id_phone2 = $("#findid_phone2").val();		//phone2 값
	var id_phonecheck = /^\b{3,4}$/;				// 전화번호 정규식
	// 전화번호 정규식이 맞으면?
	if(id_phonecheck.test(id_phone2)){
		$("#s_findid_phone").html("");
		id_phone();
	}else{
		$("#s_findid_phone").html("전화번호에는 숫자만 입력 가능합니다.").css("color","red");
	}
});

$("#findid_phone3").blur(function(){
	var id_phone3 = $("#findid_phone3").val();		//phone3 값
	var id_phonecheck = /^\b{3,4}$/;				// 전화번호 정규식
	// 전화번호 정규식이 맞으면?
	if(id_phonecheck.test(id_phone3)){
		$("#s_findid_phone").html("");
		id_phone();
	}else{
		$("#s_findid_phone").html("전화번호에는 숫자만 입력 가능합니다.").css("color","red");
	}
});

//전화번호 함수 (합쳐서, 맨앞 0 떼기)
 function id_phone(){
	 var id_phone1 = $("#findid_phone1").val();
	 var id_phone2 = $("#findid_phone2").val();
	 var id_phone3 = $("#findid_phone3").val();
	 // 전화번호 입력값이 null값이 아니면
	 if(id_phone1 != "" && id_phone2 != "" && id_phone3 != ""){
		 // 전화번호 전체 정규식 체크(9~11자 사이의 숫자로만 이뤄짐)
		 var id_phone = id+phone1+id_phone2+id_phone3;
		 var id_phonecheck = /^\d{9,11}$/;
		 // 정규식 체크되면
		 if(id_phonecheck.test(id_phone)){
			 //맨 앞에 숫자 하나 잘라서 넣기
			 var id_phone2 = id_phone.substr(1,10);
			 // hidden으로 숨겨둔 곳에 전체 전화번호넣음(-없이)
			 $("#findid_totalphone").val(id_phone2);
		 }
	 }
 };
 
 /*비밀번호 찾기*/
 // 아이디 정규식 체크해서 값 건지기
 $("#findpw_id").on("keyup", function(){
	 var pw_id = $("#find_id").val();
	 var pw_idcheck = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-z]([-_\.]?[0-9a-z])*\.[a-z]{2,3}$/;
	 //아이디 정규식 안맞으면?
	 if(!pw_idcheck.test(pw_id)){
		 $("#s_findpw_id").html("아이디는 올바른 형식의 이메일로 입력해주세요.").css("color","red");
	 }else{
		 $("#s_findpw_id").html("");
	 }
 }); //아이디 정규식 닫음
 // 이름 정규식 체크해서 값 건지기
 $("#findpw_name").on("keyup", function(){
	 var pw_name = $("#findpw_name").val();		//이름 입력값
	 var pw_namecheck = /^[가-힣]+$/;	//이름 정규식
	 // 이름 정규식이 맞지 않으면?
	 if(!pw_namecheck.test(pw_name)){
		 $("#s_findpw_name").html("이름에는 띄어쓰기, 숫자, 영어, 특수문자를 입력할 수 없습니다.")
	 }else{
		 $("#s_findpw_name").html("");
	 }
 })
 //전화번호 정규식 체크해서 값 건지기
 $("#findpw_phone1").blur(function(){
	 var pw_phone1 = $("#findpw_phone1").val();
	 var pw_phonecheck = /^\d{3}$/;
	 //전화번호 정규식이 맞으면?
	 if(pw_phonecheck.test(pw_phone1)){
		 $("#s_findpw_phone").html("");
		 pw_phone();
	 }else{
		 $("#s_findpw_phone").html("전화번호에는 숫자만 입력 가능합니다.").css("color","red");
	 }
 });
 
 $("#findpw_phone2").blur(function(){
	 var pw_phone2 = $("#findpw_phone2").val();		//phone2 값
	 var pw_phonecheck = /^\d{3,4}$/; 				// 전화번호 정규식
	 // 전화번호 정규식이 맞으면?
	 if(pw_phonecheck.test(pw_phone2)){
		 $("#s_findpw_phone").html("");
		 pw_phone();
	 }else{
		 $("#s_findpw_phone").html("전화번호에는 숫자만 입력 가능합니다.").css("color","red");
	 }
 });
 
 $("#findpw_phone3").blur(function(){
	 var pw_phone3 = $("#findpw_phone3").val();		//phone3 값
	 var pw_phonecheck = /^\d{3,4}$/; 				// 전화번호 정규식
	 // 전화번호 정규식이 맞으면?
	 if(pw_phonecheck.test(pw_phone3)){
		 $("#s_findpw_phone").html("");
		 pw_phone();
	 }else{
		 $("#s_findpw_phone").html("전화번호에는 숫자만 입력 가능합니다.").css("color","red");
	 }
 });
 // 전화번호(합치고, 맨앞에 0떼기)
 function pw_phone(){
	 var pw_phone1 = $("#findpw_phone1").val();
	 var pw_phone2 = $("#findpw_phone2").val();
	 var pw_phone3 = $("#findpw_phone3").val();
	 // 전화번호 입력값이 null값이 아니면
	 if(pw_phone1 != "" && pw_phone2 != "" && pw_phone3 != ""){
		 //전화번호 전체 정규식 체크(9~11자 사이의 숫자로만 이뤄짐)
		 var pw_phone = pw_phone1+pw_phone2+pw_phone3;
		 var pw_phonecheck = /^\d{9,11}$/;
		 //정규식 체크되면
		 if(pw_phonecheck.test(pw_phone)){
			 //맨 앞에 숫자 하나 잘라서 넣기
			var pw_phone2 = pw_phone.substr(1,10);
			//hidden으로 숨겨둔 곳에 전체 전화번호넣음(-없이)
			$("#findpw_totalphone").val(pw_phone2);
		 }
	 }
 };
