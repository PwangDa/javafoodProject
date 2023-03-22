

	let btn_all = document.querySelector("#btn_all");
	
	btn_all.addEventListener("click", function(){
		console.log('리스트를 조회합니다');
		let xhr = new XMLHttpRequest();
        xhr.open("get", "/list/artist");
        xhr.send();      
        
	});
	

	
	

	

	
	