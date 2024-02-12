<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>  
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Albatross</title>
    <link rel="stylesheet" href="/resources/assets/css/main.css"/>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
      integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
      crossorigin="anonymous"
    />
  </head>
  <body>
  	<!-- 전역 변수 설정 -->
  	<sec:authentication var="userAuthentication" property="principal" />
  	<c:set var="profileLink" value="${userAuthentication.user.profile_link}" />
    
    <!-- sidebar starts -->
    <div class="sidebar">
      <img id="mainImg" src="/resources/images/albatrossIcon.png" style="width:40px; height:40px; margin-left:20px;"/>
      
    <a href="/Albatross/main" class="sidebarOption">
  		<span class="material-icons">home</span>
  		<h2>Home</h2>
	</a>
    
    <a href="/Albatross/userDetail?uuid=${userAuthentication.user.uuid}" class="sidebarOption">
  		<span class="material-icons">perm_identity</span>
  		<h2>Profile</h2>
	</a>
	
	<a href="/Albatross/follow" class="sidebarOption active">
  		<span class="material-icons">group</span>
  		<h2>Friends</h2>
	</a>

	<a href="/Albatross/main" class="sidebarOption">
  		<span class="material-icons">more_horiz</span>
  		<h2>More</h2>
	</a>

      <button class="sidebar__tweet">Tweet</button>
    
    </div>
    <!-- sidebar ends -->
	
	<div class = "sidebarBottom">
        <div class="sidebarOption2">
          <div class="sidebarUserImage">
          	<c:choose>
          		<c:when test="${profileLink == null}">
          			<img src="https://i.pinimg.com/originals/a6/58/32/a65832155622ac173337874f02b218fb.png"/>
          		</c:when>
          		<c:otherwise>
          			<img src="/images/<sec:authentication property="principal.user.profile_link"/>"/>
          		</c:otherwise> 
          	</c:choose>
          </div>
          <div class="sidebarUserInfo" style="margin-left:10px;">
            <h2><sec:authentication property="principal.user.nickname"/></h2>
            <p><sec:authentication property="principal.user.mail"/></p>
          </div>
           <span id="logOut" class="material-icons" style="margin-left:10px;"> logout </span>
        </div>
    </div>
      
    <!-- feed starts -->
    <div class="feed">
      <div class="feed__header">
        <h2>FOLLOW</h2>
      </div>

      <div id="tweetBoard" class = "tweetBoard">  
      <!-- post starts -->
      
      
      
      <!-- post ends -->
		</div>    
    </div>
    <!-- feed ends -->
	
    <!-- widgets starts -->
    <div class="widgets">
      <div class="widgets__input">
        <span class="material-icons widgets__searchIcon"> search </span>
        <input id="searchInput" type="text" placeholder="Search" />
      </div>

      <div class="widgets__widgetContainer">
        <h2>What's happening?</h2>
        <blockquote class="twitter-tweet">
          <p lang="en" dir="ltr">
            🕶️ 
          </p>
          &mdash; NewJeans (@NewJeans_ADOR)
          <a href="https://twitter.com/NewJeans_ADOR/status/1735072119825031316"
            >Dec 20, 2023</a
          >
        </blockquote>
        <script async src="https://platform.twitter.com/widgets.js" charset="utf-8"></script>
      </div>
    </div>
    <!-- widgets ends -->

    <!-- HTML 문서의 마지막에 JavaScript 파일을 연결 -->
    <script src="/resources/assets/js/jquery.min.js"></script>
	<script src="/resources/assets/js/jquery.dropotron.min.js"></script>
	<script src="/resources/assets/js/browser.min.js"></script>
	<script src="/resources/assets/js/breakpoints.min.js"></script>
	<script src="/resources/assets/js/util.js"></script>
    <script src="/resources/assets/js/main.js"></script>
    <script src="/resources/assets/js/follow.js"></script>
    <script src="/resources/assets/js/user.js"></script>
    <script>
    const tweetBoardDiv = $("div.tweetBoard");
    // 전역 변수들 
        

// ----------------------------------------------------------------
	showList();
 // ----------------------------------------------------------------함수 라인-----------------------------------------------
  function showList(){
		var tempFromUid = ${userAuthentication.user.uuid};
			
    	followService.get(tempFromUid,function(result){
    		console.log(result);
    		let list = result;
    		let str ="";
    		
    		for(let i = 0; i<list.length; i++){
				let user = userService.getD(list[i].to_uid);
				
				str += `<div class="post">`;
				str += `<div class="post__avatar">`;
			

				// 프로필
				if(user.profile_link == null){
					str += `<img src="https://i.pinimg.com/originals/a6/58/32/a65832155622ac173337874f02b218fb.png"`;	
				}
				else{
					str += `<img src="/images/` + user.profile_link + `"`;	
				}
				str += `<div class="post__body" data-url="/Albatross/userDetail?uuid=`+ user.uuid + `">`;
				str += `<div class="post__header">`;
				str += `<div class="post__headerText">`;
				str += `<h3> ` + user.nickname;
				str += `<span class="post__headerSpecial"><span class="material-icons post__badge"> verified </span>@KR`+ String(user.uuid).padStart(10, '0')+`</span>`;
				str += `</h3>`;
				str += `</div>`;
				str += `<div class="post__headerDescription">`;
				str += `<p style="max-width: 509px;">`+ user.intro + `<p>`;
				str += `<div class="user-join-date">팔로우일:`+list[i].followdate+`</div>`;
				str += `</div></div>`;
				str += `</div>`;
				str += `</div>`;
			}
    		
    		tweetBoardDiv.html(str);
    	});
    }
 // ----------------------------------------------------------------이벤트 함수-----------------------------------------------
 
 //검색
 var searchInput = document.getElementById('searchInput');

 searchInput.addEventListener('keydown', function(event) {
	    if (event.key === 'Enter' || event.keyCode === 13) {
	    	if(searchInput.value !== null && searchInput.value.trim() !== ''){
	    		console.log(searchInput.value);
	    		window.location.href = "/Albatross/search/?str="+searchInput.value; 	
	    	}
	      
	    }
	});
 
 // post 글 누를 시 리다이렉트
 $(document).on('click', '.post__body', function() {
    var url = $(this).data('url'); // Get the redirect url
    window.location.href = url; // Redirect to the url
});   
 
 // post 프로필 이미지 누를 시 리다이렉트
 $(document).on('click', '.post__profile', function() {
    var url = $(this).data('url'); // Get the redirect url
    window.location.href = url; // Redirect to the url
});  

	
    </script>
  </body>
</html>