 		/*댓글 입력창 if문*/
        /* function fn_sendComment(){
        	
        	var frmCommand = document.frmComment;
        	var id = frmCommand.id.value;
        	var cont = frmCommand.cont.value;
        	if(id.length == 0 || id == ""){
        		alert("아이디를 입력해주세요")
        	}else if(cont.length == 0 || cont == ""){
        		alert("내용을 입력해주세요")
        	}else{
            frmComment.method = "post";
            frmComment.action = "/javafood_team/javafood?javafood=1&command=addcommnet.do";
            frmComment.submit();
        	}
        } */
 		
        function fn_sendComment_2(){
        	
        	var frmCommand = document.frmComment_2;
        	var id = frmCommand.id_2.value;
        	var cont = frmCommand.cont_2.value;
        	
        	if(id.length == 0 || id == ""){
        		alert("아이디를 입력해주세요")
        	}else if(cont.length == 0 || cont == ""){
        		alert("내용을 입력해주세요")
        	}else{
            frmComment.method = "post";
            frmComment.action = "/javafood_team/javafood?javafood=1&command=addReply.do";
            frmComment.submit();
        	}
        }
        
        let btn_del = document.querySelector(".btn_del");
        
         /*btn_del.addEventListener('click', function() {
    	           if(){
    	           		console.log('안녕 친구들');

    	           }
    	     });*/
        //window.onload
        var prevScrollpos = window.pageYOffset;
       // window.onscroll = headerbarToggle
        //window.onload = headerbarToggle
       // function headerbarToggle(){
            console.log(1234);
        /*메뉴상단 스크롤 함수*/
            /*var headerbar = document.getElementById("menu");
            var currentScrollPos = window.pageYOffset;
            if(prevScrollpos < currentScrollPos){
                headerbar.style.opacity = 1;
            }else{
                headerbar.style.opacity = 0.6;
            }*/
            
            /*앨범 < > 함수*/
            let prev = document.querySelector(".prev");
            let next = document.querySelector(".next");
            let slides = document.querySelector(".clides");
            let slds = document.querySelector("#slds");
            let slidelmg = document.querySelectorAll(".clides li");
            let current = 0; //현재 슬라이드 인덱스
            let slideCount = slidelmg.length;

            let slideWidth = 760; //한개의 슬라이드 넓이
            let slideMargin = 100;
            let currentIdx = 0;

            // slides.style.width = (slideWidth + slideMargin) * slideCount + 'px';

            function moveSlide(num) {
                slides.style.left = -num * 890 + 'px';
                currentIdx = num;
            }

    	    //    next.addEventListener('click', function() {
    	    //        console.log(slideCount); /*5*/
    	    //        if(current !== slideCount-1){
    	    //        		console.log('안녕 친구들');
    	    //     	    current = slideCount;
    	    //     	    console.log(current);
    	    //        		slds.classList.add("marLeft");
    	    //        }
    	    //    });

            console.log('총 앨범 갯수 slideCount : '+slideCount); 
            console.log(' (slideCount / 4) : '+(slideCount / 4)); 
               next.addEventListener('click', function() {
    	           if(currentIdx <= (slideCount / 4)-1){
    	           		console.log('안녕 친구들');
    	        	    console.log('next: current : '+current);
                        moveSlide(currentIdx + 1);
                        console.log('currentIdx : '+currentIdx);
    	           }
    	       });
    	        
               prev.addEventListener('click', function() {
    	    	   if(currentIdx !== 0){
    	           	    console.log('hello');
                        console.log('prev : current : '+current);
    	           	    console.log(slideCount);
                        moveSlide(currentIdx - 1)
    	    	   }
    	       });

    	    //    prev.addEventListener('click', function() {
    	    // 	   if(current !== 0){
    	    //        	console.log('hello');
    	    //        	console.log(slideCount);
    	    //        	slds.classList.remove("marLeft");
    	    //        	current = 0;
    	    // 	   }
    	    //    });
    	    
    	    

    	       
// 체크박스에서 값 가져오기
function getCheckedValue() {
	const checkboxes = document.querySelectorAll('input[name="chk"]:checked');
	let checkedValue = [];
	checkboxes.forEach((checkbox) => {
		checkedValue.push(checkbox.value);
	})
	console.log(checkedValue)
	//document.getElementByID("btn").value = checkedValue;
	return checkedValue;
}
       // }//윈도우 window.onload  끝


(function() {
	document.onmousemove = function(e) { var ob = document.getElementById("foo").style; ob.left = e.pageX + 15 + "px"; ob.top = e.pageY + 15 + "px"; }
	document.write("<img src='https://tistory1.daumcdn.net/tistory/4694508/skin/images/hai1.gif' id='foo' style='position:absolute; transition:all 0.3s ease-in; z-index: 1;'>");
}());

//담기 버튼 누르면, 곡이 추가될 플레이 리스트 선택하는 팝업 뜨게 하기
let addList = document.querySelectorAll("img.addList");

//console.log(addList);

for(let i = 0; i < addList.length; i++)
{
	addList[i].addEventListener("click", (event)=> //()=>는 화살표 함수
	{
		console.log("img.addList의 EventListener 실행됨."); //확인용
		
		addList[i].parentNode.parentNode.target = "_blank"; //새 창으로 열기
		addList[i].parentNode.parentNode.submit(); //form 서밋하기
	});
}

//여러 개가 체크 된 곡들을 플레이 리스트에 추가하기
let addLists = document.querySelector(".addLists");
let addLists_b = document.querySelector(".addLists");


addLists.addEventListener("click", ()=>{
	console.log('123');
	let string = "";
	for(let i = 0; i < getCheckedValue().length; i++)
	{
		string += "songNumber=";
		string += getCheckedValue()[i];
		if(getCheckedValue.length-1 != i)
		{
			string += "&";
		}
	}
		addLists.parentNode.parentNode.action = "playListAdd?"+string;
		addLists.parentNode.parentNode.target = "_blank";
		addLists.parentNode.submit();
	});
