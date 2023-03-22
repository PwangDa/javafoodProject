	let join = document.querySelector("#join");
	
	join.addEventListener("submit", function(){
		if(join.artistname.value.length == 0){
			alert('내용을 입력해주세요');
		}else if(join.artistname.value.length != 0){
			console.log('123');
			alert('!!!추가완료!!!');
		}

	});
		


	

	
	

	

	
	