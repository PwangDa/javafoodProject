	let cursor = "https://tistory1.daumcdn.net/tistory/4694508/skin/images/hai1.gif";
	(function (){  
	    document.onmousemove=function (e){ var ob=document.getElementById("foo").style; ob.left=e.pageX+15+"px"; ob.top=e.pageY+15+"px";}
	    document.write("<img src='"+cursor+"' id='foo' style='position:absolute; transition:all 0.3s ease-in'>");
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
	
	
	
	/*이스터에그*/
	let konamiCommand = "";
	
	document.addEventListener('keydown', (event) =>
	{
//		console.log("event.key : " + event.key);
		konamiCommand += event.key;
		console.log("konamiCommand : " + konamiCommand);
		
		if(konamiCommand == "ArrowUpArrowUpArrowDownArrowDownArrowLeftArrowRightArrowLeftArrowRightba" || konamiCommand == "ArrowUpArrowUpArrowDownArrowDownArrowLeftArrowRightArrowLeftArrowRightBA")
		{
			document.querySelector("img.esterEgg").classList.remove("hidden");
			cursor = "https://cdn.discordapp.com/attachments/931150181540450368/1085371872557932606/giphy_1.gif";
		}
		if(konamiCommand != "" || konamiCommand != "ArrowUpArrowUpArrowDownArrowDownArrowLeftArrowRightArrowLeftArrowRightba" || konamiCommand != "ArrowUpArrowUpArrowDownArrowDownArrowLeftArrowRightArrowLeftArrowRightBA")
		{
			setTimeout(()=>{konamiCommand = ""; console.log("konamiCommand is reseted.");}, 5000);
		}
	});
	
	
		//팝업창 jQuery 작동
        jQuery(document).ready(function() {
                $('#myModal').show();
        });
        //팝업 Close 기능
        function close_pop(flag) {
             $('#myModal').hide();
        };

