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


document.querySelector("input.chk_url").addEventListener("change", ()=>
{
//	console.log("change됨.");
	document.querySelector(".addList_imageUrl").classList.remove("hidden");
	document.querySelector(".addList_imageFile").classList.add("hidden");
});

document.querySelector("input.chk_file").addEventListener("change", ()=>
{
//	console.log("change 또됨.");
	document.querySelector(".addList_imageUrl").classList.add("hidden");
	document.querySelector(".addList_imageFile").classList.remove("hidden");
});


(function (){  
    document.onmousemove=function (e){ var ob=document.getElementById("foo").style; ob.left=e.pageX+15+"px"; ob.top=e.pageY+15+"px";}
	document.write("<img src='https://cdn.discordapp.com/attachments/931150181540450368/1088433240819376148/ezgif-5-867d124f68.gif' id='foo' style='width : 80px; position:absolute; transition:all 0.3s ease-in; z-index: 1;'>");
 }());