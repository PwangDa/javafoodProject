	let join = document.querySelector("#join");
	let join_1 = document.querySelector("#join_1");
	let join_2 = document.querySelector("#join_2");
	
	join.addEventListener("submit", function(){
		if(join.artistname.value.length == 0){
			alert('내용을 입력해주세요');
		}else if(join.artistname.value.length != 0){
			console.log('123');
			alert('!!!추가완료!!!');
		}

	});
	
	join_1.addEventListener("submit", function(){		
			alert('!!!수정완료!!!');

	});
	
	join_2.addEventListener("submit", function(){		
			alert('!!!삭제완료!!!');

	});
		


	

	
	

	

	
	