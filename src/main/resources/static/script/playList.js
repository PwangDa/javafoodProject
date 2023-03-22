let imgAddList = document.querySelector("img.addList");
let divSearch = document.querySelector("div.search");
let spanAddList = document.querySelector("span.addList");
let inputAddListBtn = document.querySelector("input.addList_btn");



imgAddList.addEventListener('click', ()=>
{
    divSearch.classList.toggle("hidden");
});
spanAddList.addEventListener('click', ()=>
{
    divSearch.classList.toggle("hidden");
});

function fn_addList()
{
    let title = PL_addList.addList_title.value;

    if(title.length == 0 || title == "")
    {
		alert("플레이 리스트 제목을 입력해주세요.")
    }
    else
    {
        PL_addList.method='get';
        PL_addList.action='addPlayList';
        PL_addList.submit();
    }
}
inputAddListBtn.addEventListener('click', ()=>
{
    fn_addList();
});



(function (){  
    document.onmousemove=function (e){ var ob=document.getElementById("foo").style; ob.left=e.pageX+15+"px"; ob.top=e.pageY+15+"px";}
    document.write("<img src='https://tistory1.daumcdn.net/tistory/4694508/skin/images/hai1.gif' id='foo' style='position:absolute; transition:all 0.3s ease-in'>");
 }());