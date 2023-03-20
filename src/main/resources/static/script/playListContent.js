    let deleteList = document.querySelector("span.delete");
    let deleteSong = document.querySelectorAll("span.deleteSong");
    let deleteSong2 = document.querySelectorAll("span.deleteSong form");
    
    let selected = document.querySelectorAll("input.songCheck");
    
    deleteList.addEventListener('click', ()=>
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
    
    //선택된 것 삭제하기 만들다 만거
//    for(let i = 0; i < selected.length; i++)
//    {
//		selected[i].addEventListener('checked', ()=>
//		{
//			selected[i].parentNode.style.
//		});
//	}
    
    (function (){  
        document.onmousemove=function (e){ var ob=document.getElementById("foo").style; ob.left=e.pageX+15+"px"; ob.top=e.pageY+15+"px";}
        document.write("<img src='https://tistory1.daumcdn.net/tistory/4694508/skin/images/hai1.gif' id='foo' style='position:absolute; transition:all 0.3s ease-in'>");
     }());