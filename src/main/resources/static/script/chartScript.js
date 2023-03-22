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
