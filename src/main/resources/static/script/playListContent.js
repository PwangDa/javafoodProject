    let deleteList1 = document.querySelector("span#delete");
    let deleteSong = document.querySelectorAll("span.deleteSong");
    let deleteSong2 = document.querySelectorAll("span.deleteSong form");
    
    let editBtn = document.querySelector("span#editList");
    let editInputs = document.querySelectorAll(".edit");
	let inputEditListBtn = document.querySelector("input.editList_btn");
	
	let inputCheck = document.querySelectorAll("input.checkListNumber");
    

    
    deleteList1.addEventListener('click', ()=>
    {
        if(confirm("정말로 해당 플레이 리스트를 삭제하겠습니까?") )
        {

        	deleteList.method='get';
        	deleteList.action='deletePlayList';
        	deleteList.submit();
        }
    });
    for(let i = 0; i < deleteSong.length; i++)
    {
        deleteSong2[i].addEventListener('click', (event)=>
        {
            if(confirm("정말로 해당 곡을 리스트에서 삭제하겠습니까?") )
            {
                event.currentTarget.method='get';
                event.currentTarget.action='deleteContent';
                event.currentTarget.submit();
            }
        });
    }
    
    editBtn.addEventListener('click', ()=>
    {
		for(let i=0; i<editInputs.length; i++)
		{			
			editInputs[i].classList.toggle("hidden");
		}
	});
    
    inputEditListBtn.addEventListener("click", ()=>
	{
		let title = PL_editList.editList_title.value;
		let explain = PL_editList.editList_explain.value;
		let listImage = PL_editList.editList_listImage.value;
		
		if(title.length == 0 || title == "")
		{
			alert("플레이 리스트 제목을 입력해주세요.");
		}
		else
		{
			if(explain == "" || listImage == "" || explain.length == 0 || listImage == 0)
			{
				if(confirm("플레이 리스트의 설명이나 이미지 URL 란이 비었습니다. 정말로 수정하시겠습니까?") )
				{
					PL_editList.method = 'get';
					PL_editList.action = 'editPlayList';
					PL_editList.submit();
				}
			}
			else
			{
				PL_editList.method = 'get';
				PL_editList.action = 'editPlayList';
				PL_editList.submit();
			}
		}
	});
    
    //선택된 것 삭제하기 만들다 만거
//    for(let i = 0; i < inputCheckListNumber.length; i++)
//    {
//		inputCheckListNumber[i].addEventListener('checked', ()=>
//		{
//			selected[i].value;
//		});
//	}

	function getCheckedSong()
	{
    	let inputCheckListNumber = document.querySelectorAll("input.checkListNumber:checked");
    	let checkedListNumber = [];
    	
    	inputCheckListNumber.forEach( (event) =>
    	{
			checkedListNumber.push(event.value);
		});
		console.log("체크된 노래의 listNumber : " + checkedListNumber);
		
		if(checkedListNumber.length > 0)
		{
			document.querySelector("span.deleteChecked").classList.remove("hidden");
		}
		else
		{
			document.querySelector("span.deleteChecked").classList.add("hidden");
		}
		
		return checkedListNumber;
	}
	
	//getCheckedSong()은 체크박스에 onclick으로 걸어둠.
	

    
    document.querySelector("input.chk_url").addEventListener("change", ()=>
	{
	//	console.log("change됨.");
		document.querySelector(".editList_imageUrl").classList.remove("hidden");
		document.querySelector(".addList_imageFile").classList.add("hidden");
	});
	
	document.querySelector("input.chk_file").addEventListener("change", ()=>
	{
	//	console.log("change 또됨.");
		document.querySelector(".editList_imageUrl").classList.add("hidden");
		document.querySelector(".addList_imageFile").classList.remove("hidden");
	});
	    
    
    
    
    (function (){  
        document.onmousemove=function (e){ var ob=document.getElementById("foo").style; ob.left=e.pageX+15+"px"; ob.top=e.pageY+15+"px";}
        document.write("<img src='https://tistory1.daumcdn.net/tistory/4694508/skin/images/hai1.gif' id='foo' style='position:absolute; transition:all 0.3s ease-in'>");
     }());