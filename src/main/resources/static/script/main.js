	let cursor = "https://tistory1.daumcdn.net/tistory/4694508/skin/images/hai1.gif";
	(function (){  
	    document.onmousemove=function (e){ var ob=document.getElementById("foo").style; ob.left=e.pageX+15+"px"; ob.top=e.pageY+15+"px";}
		document.write("<img src='https://cdn.discordapp.com/attachments/931150181540450368/1088433240819376148/ezgif-5-867d124f68.gif' id='foo' style='width : 80px; position:absolute; transition:all 0.3s ease-in; z-index: 1;'>");
	 }());

	 let hitListPage = 0;
	 
	 let hitListNextButton = document.querySelector(".hitNext");
	 let hitListPrevButton = document.querySelector(".hitPrev");
	 let hitListContent = document.querySelector(".hitSongContent");
	 
	 let randomNextButton = document.querySelector(".ranNext");
	 let randomPrevButton = document.querySelector(".ranPrev");
	 let randomListContent = document.querySelector(".ranSongContent");
	 
	 let artistNextButton = document.querySelector(".artistNext");
	 let artistPrevButton = document.querySelector(".artistPrev");
	 let artistListContent = document.querySelector(".artistContent");
	 
	 hitListNextButton.addEventListener("click", ()=>
	 {
		hitListPage++;
		if(hitListPage > 4)
		{
			hitListPage = 4;
		}
			
		hitListContent.classList.add("songContentPage" + hitListPage);
			
		for(let i = 0; i <= 4; i++)
		{
			if(i == hitListPage)
			{
				continue;
			}
			else if(hitListContent.classList.contains("songContentPage" + i) )
			{
				hitListContent.classList.remove("songContentPage" + i);
			}
		}
	});
	
	hitListPrevButton.addEventListener("click", ()=>
	 {

		hitListPage--;
		if(hitListPage < 0)
		{
			hitListPage = 0;
		}
			
		hitListContent.classList.add("songContentPage" + hitListPage);
			
		for(let i = 0; i <= 4; i++)
		{
			if(i == hitListPage)
			{
				continue;
			}
			else if(hitListContent.classList.contains("songContentPage" + i) )
			{
				hitListContent.classList.remove("songContentPage" + i);
			}
		}
	});
	
	 randomNextButton.addEventListener("click", ()=>
	 {
		hitListPage++;
		if(hitListPage > 4)
		{
			hitListPage = 4;
		}
			
		randomListContent.classList.add("ranSongContentPage" + hitListPage);
			
		for(let i = 0; i <= 4; i++)
		{
			if(i == hitListPage)
			{
				continue;
			}
			else if(randomListContent.classList.contains("ranSongContentPage" + i) )
			{
				randomListContent.classList.remove("ranSongContentPage" + i);
			}
		}
	});
	
	
	
	randomPrevButton.addEventListener("click", ()=>
	 {

		hitListPage--;
		if(hitListPage < 0)
		{
			hitListPage = 0;
		}
			
		randomListContent.classList.add("ranSongContentPage" + hitListPage);
			
		for(let i = 0; i <= 4; i++)
		{
			if(i == hitListPage)
			{
				continue;
			}
			else if(randomListContent.classList.contains("ranSongContentPage" + i) )
			{
				randomListContent.classList.remove("ranSongContentPage" + i);
			}
		}
	});
	
	
	
	
	function hit(num){
		var id = $('#id').val()
		console.log(num)
		console.log("실행");
		$.ajax({
			type : 'get',
			url : 'http://localhost:8080/javafood_team/aj?id1='+id+'&num='+num,
			data: 'text'
		})
	}
	function good(num){
		console.log(num)
		$.ajax({
			type : 'get',
			url : 'http://localhost:8080/javafood_team/aj?&good='+num,
			data : 'text'
		})
	}
	
//	let color = '#';
//	let letters = ['f6c9cc', 'a8c0c0', 'FEBF36', 'FF7238', '6475A0', 'acc7bf', '5e5f67', 'c37070', 'eae160', 'bf7aa3', 'd7d967'];
//	
//	color += letters[Math.floor(Math.random() * letters.length)];
//	document.getElementById('wrap').style.backgroundColor = color;
	
	
		//팝업창 jQuery 작동
        jQuery(document).ready(function() {
			cookiedata = document.cookie; 
	        if(cookiedata.indexOf("close=Y")<0){ 
	        	$('#myModal').show();
	        }else{ 
	        	$("#myModal").hide(); 
	        }
        });
        
        //팝업 Close 기능
        function close_pop(flag) {
			 
			if($("input[name=layer_close]").is(":checked") == true){ 
        		setCookie("close","Y",1); 
        	} 
            $('#myModal').hide();
            console.log('cookie >> '+cookiedata);
        };
       
       //쿠키 시간 설정 
    function setCookie(cname, cvalue, exdays) { 
    	var d = new Date(); 
        d.setTime(d.getTime() + (exdays*10*60*1000)); //시간설정 
 //       d.setTime(d.getTime() + (exdays*24*60*60*1000)); //시간설정 
        var expires = "expires="+d.toUTCString(); 
        var temp = cname + "=" + cvalue + "; " + expires; 
        console.log('temp >> '+temp);
        document.cookie = temp; 
    } 
        
        
        
        

