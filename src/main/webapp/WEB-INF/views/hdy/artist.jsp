<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "java.sql.Date"
    import = "java.util.List"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Artist.jsp TTTTest전용</title>
<!--  <script link src ="/script/artistScript.js"></script> -->
 <style>
  	    #cont{
            background-image:
            linear-gradient(
                to bottom,
                rgba(0, 0, 0, 0) 10%,
                rgba(0, 0, 0, 0.25) 25%,
                rgba(0, 0, 0, 0.5) 50%,
                rgba(0, 0, 0, 0.75) 75%,
                rgb(0, 0, 0) 100%
            ),
            url("${album_list[0].artist_img}") ; 
            background-repeat: no-repeat;
            background-size: cover;
            background-position: center 30%;
            height: 550px;     
            position: relative;
        }
   </style>
<link rel="stylesheet" href="/style/artistCSS.css">
</head>
<body>
<%--  <jsp:include page="menu.jsp"></jsp:include>  --%>
    <div id = "home">
        <div id = "cont" class = "contain">     
            <div class = "text1"> 
            <%--forEach 안하고 하나의 값만 가져오고 싶을때 --%>
                <h1>${album_list[0].artistname }</h1>
                <p class="text_box">${album_list[0].artist_info }</p>
                <div> <a target="_blank" href="https://namu.wiki/w/%EC%95%84%EC%9D%B4%EC%9C%A0">출처:namuwiki</a></div>
            </div>
        </div>
        <div id ="cont1_1">
            <h2 style="text-align: center; margin: 13px;">음악</h2>            
			<%-- 음악 부분 forEach --%>
           	
           		<c:forEach var="album" items="${album_list}" end="5" varStatus="loop">
	            <div id = "cont1">
	                <div class = "box1_1">
	                    <a href="/albumpage?album=${album.album_name}"><img class="img1" src="${album.imagelink }"></a>
	                </div>
	                <div class = "box1 text2"><a href="${album.link}"><strong>${album.songname}</strong></a></div>
	                <div class = "box1 text2" style = "color:rgb(192, 192, 192);">${album_list[0].artistname }</div>
	                <div class = "box1 text2"><a style = "color:rgb(192, 192, 192);" href="/albumpage?album=${album.album_name}">${album.album_name }</a></div>
	                <div><!-- 하트 버튼 -->
	                	<img class="img2 heart" src="https://c11.kr/1asbx" onclick="good(${ album.songnumber })">
	                </div>
	                <div><!-- 재생 버튼 -->
	                	<a href="${album.link}" target='_blank'><img class="img img2" src="https://c11.kr/1asd1" onmouseover="this.src='https://c11.kr/1asd5'" onmouseout="this.src='https://c11.kr/1asd1'" onclick="hit(${ album.songnumber })"></a>
	                </div>
	                <form name="addPlayList" method="post" action="/playListAdd">
						<div><!-- 담기 버튼 -->
							<input type="hidden" class="put" name="songNumber" value="${ album.songnumber }">
							<input type="hidden" class="put" name="addWhere" value="NewGenre">
	            			<img class="img img2 addList" src="https://c11.kr/1asd6" onmouseover="this.src='https://c11.kr/1asd9'" onmouseout="this.src='https://c11.kr/1asd6'">
	            		</div>	  
            		</form>              
	            </div>
	            <hr>
            	</c:forEach>
	        	<details class="detail">
                    <summary style="color: rgb(150, 150, 150);">펼치기</summary>
                    <c:forEach var="album" items="${album_list}" begin="6" varStatus="loop">
	            		<div id = "cont1">
			                <div class = "box1_1">
			                    <a href="/albumpage?album=${album.album_name}"><img class="img1" src="${album.imagelink }"></a>
			                </div>
			                <div class = "box1 text2"><a href="${loop.count}"><strong>${album.songname}</strong></a></div>
			                <div class = "box1 text2" style = "color:rgb(192, 192, 192);">${album_list[0].artistname }</div>
			                <div class = "box1 text2"><a style = "color:rgb(192, 192, 192);" href="/albumpage?album=${album.album_name}">${album.album_name }</a></div>
           					<div><!-- 하트 버튼 -->
	                			<img class="img2 heart" src="https://c11.kr/1asbx" onclick="good(${ album.songnumber })">
	                		</div>
	                		<form name="addPlayList" action="/my">
		                		<div><!-- 재생 버튼 -->
		                			<a href="${album.link}" target='_blank'><img class="img img2" src="https://c11.kr/1asd1" onmouseover="this.src='https://c11.kr/1asd5'" onmouseout="this.src='https://c11.kr/1asd1'" onclick="hit(${ album.songnumber })"></a>
		                			<input type="hidden" class="put" name="song" value="${ album.songnumber }">
		                		</div>
	                		</form>
	                		<form name="addPlayList" method="post" action="/playListAdd">
								<div><!-- 담기 버튼 -->
									<input type="hidden" class="put" name="songNumber" value="${ album.songnumber }">
									<input type="hidden" class="put" name="addWhere" value="NewGenre">
	            					<img class="img img2 addList" src="https://c11.kr/1asd6" onmouseover="this.src='https://c11.kr/1asd9'" onmouseout="this.src='https://c11.kr/1asd6'">
	            				</div>	  
            				</form>      
	            		</div>
	            		<hr>
            		</c:forEach>
                </details>
           
        </div>
        <div id = "cont3">
                <p class="point prev">&lang;</p>
            <h2 style="text-align: center; margin: 0px; display: inline;">앨범</h2>
                <p class="point next">&rang;</p>
            <div id="cont3_1">
                <ul id = "slds" class="clides">
				<%-- 앨범 부분 forEach --%>
                <c:forEach var ="album" items="${album_list}" varStatus="loop">
                    <li>
                        <a href="/albumpage?album=${album.album_name}"><img  class="image" src="${album.imagelink }"></a>
                        <br>
                        <a style = "font-size:14px;" href="/albumpage?album=${album.album_name}"><span class="al_name"><strong>${album.album_name }</strong></span></a>
                    </li>
                </c:forEach>
                </ul>
            </div>
        </div>
        <div>
        	<br>
            <h2 style="text-align: center; margin: 0px;">댓글</h2>
            <form name="frmComment" method="post" action="/insert.do">
                <div class="comment">
                <%-- 만약 로그인 한 데이터가 없을 시 출력--%>
                <c:if test="${empty nic}">
                    <div class="text2">
                        <img class="image1" name="ima" src="http://blog.tofte-it.dk/wp-content/uploads/2018/12/profile-picture.png">
                        <input class="input1" type="text" name="id" placeholder="로그인을 해주세요"  disabled>
                    </div>
                    <div class="text2">
                        <textarea class="text_area" name="cont" placeholder="*로그인을 해주세요"  disabled></textarea>
                    </div>
                    <div class="text2">
                        <input class="btn" type="submit" value="등록" disabled>
                    </div>
                </c:if>
                <%-- 만약 로그인을 했으면 로그인한 데이터 값이 출력됨--%>
                <c:if test="${not empty nic}">
                    <div class="text2">
                        <img class="image1" src="${img }"><%--로그인 한 이미지 값이 출력--%>
                        <input class="input1" type="text" name="id" placeholder="${nic }" value="${nic }" readonly>
                        <%--readonly로 되어있어도 어차피 실제 로그인 한 세션값을 불러오기 때문에 페이지소스보기에서 고쳐도 상관없다 --%>
                    </div>
                    <div class="text2">
                        <textarea class="text_area" name="cont" placeholder="*게시물의 저작권 등 분쟁, 개인정보 노출로 인한 책임은 작성자 또는 게시자에게 있음을 유의해 주세요."></textarea>
                    </div>
                    <div class="text2">
                        <input class="btn" type="submit" value="등록">
                    </div>
                </c:if>
                    <%-- 등록버튼을 눌렀을 때 등록한 페이지의 값을 가져갈 수 있게 추가--%>
                    <input type ="hidden" name="songnum" value="${album_list[0].songnumber }">
                    <input type ="hidden" name="myimg" value="${img }">
                    <input type ="hidden" name="arti" value="${album_list[0].artistname}">
                </div>
            </form>
            </div>
        <div class="command">
            <hr>
	    	<div><%-- 댓글 부분 forEach --%>
	    	  	<c:forEach var ="comment" items="${commentList}">
	            	<c:if test="${comment.level == 1 }">
	                	<div class="comment" >
                            <div class="text2 cont2_1">
	                            <img class="image2" src="${comment.myimg }">
	                            <div class="id2">${comment.comment_id }</div>
	                        </div>
	                        <div class="text2">
	                            <div class="cont2">${comment.comment_cont }</div>
	                            <div class="date1">${comment.comment_Date }</div>
	                            <details id="detail">
		                   		 	<summary style="color: rgb(150, 150, 150);">답글달기</summary>
		                   		 	<form name="frmComment_2" method="post" action="/reply.do">
			                    		<div class="comment" >
			                    				<c:if test="${empty nic}">
						                        	<img class="image3" src="http://blog.tofte-it.dk/wp-content/uploads/2018/12/profile-picture.png">
						                        </c:if>
						                        <c:if test="${not empty nic}">
						                        	<img class="image3" src="${img }">
						                        </c:if>
						                        <input class="input2" type="text" name="id_2" placeholder="ID" value="${nic}"  readonly>
						                        <input class="input3" type="text" name="cont_2" placeholder="답글 추가..." >
						                        <input class="btn1" type="submit" value="답글"> 
						                    	<input type ="hidden" name="command_articleNO" value="${comment.articleNO }">
						                    	<input type ="hidden" name="command_myimg" value="${img }">
<%-- 						                    	<input type ="hidden" name="command_myimg" value="${login_dto[0].myimg }"> --%>
												<input type ="hidden" name="arti" value="${album_list[0].artistname}">
			                			</div>
		                            </form>
                				</details>
	                        </div>
	                        <div class="text2">
	                        	<form action="/del.do">
	                            	<input class='btn btn_del' type="submit" value="삭제">
	                            	<input type ="hidden" name="command_articleNO" value="${comment.articleNO }">
									<input type ="hidden" name="arti" value="${album_list[0].artistname}">
									<input type ="hidden" name="command_nic" value="${comment.comment_id}">
									<input type ="hidden" name="command_id" value="${comment.id}">
								</form>	                            
	                        </div>
	                	</div>
                        
	             	</c:if>
                    	<%--대댓글 등록했을 때 form --%>
	             		<form name="frmComment_2" action="/del.do">
			            	<c:if test="${comment.level >= 2}">
			            		<div class="reply">
				        			<div class="comment_1">
                                            <span class="comment_1_1">└</span>
						                    <img class="image3" src="${comment.myimg }">
						                    <p class="comment_1_1">${comment.comment_id }</p>
						                    <p class="comment_1_1" style="color: rgb(113, 113, 113);">${comment.comment_Date }</p>
						                    <input class="btn1 comment_1_2 btn_del"  type="submit" value="삭제">
						                    <input type ="hidden" name="command_articleNO" value="${comment.articleNO }">
											<input type ="hidden" name="arti" value="${album_list[0].artistname}"> 
											<input type ="hidden" name="command_nic" value="${comment.comment_id}">
											<input type ="hidden" name="command_id" value="${comment.id}">
				        			</div>
				        			<div class="comment_1_3">
				                        <span class="comment_1_4" style="margin-right :70px;"></span>
				                        ${comment.comment_cont }
				                    </div>
				                </div>
			            	</c:if>
			            </form>
                    </c:forEach>  
            </div>                 
        </div>
    </div>


</body>
<script link src ="/script/artistScript.js"></script>
</html>