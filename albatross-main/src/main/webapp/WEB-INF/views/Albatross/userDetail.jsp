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
    
    <a href="/Albatross/userDetail?uuid=${userAuthentication.user.uuid}" class="sidebarOption active">
  		<span class="material-icons">perm_identity</span>
  		<h2>Profile</h2>
	</a>
	
	<a href="/Albatross/follow" class="sidebarOption">
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
        <h2>Home</h2>
      </div>
		<!------------------------------------------- Profile ------------------------------------- -->
      		<div class="profile">
        		<div class="background-image">
            		<img class="background-img" src="https://source.unsplash.com/random" alt="Background Image">
        		</div>
        		
        		<c:choose>
          			<c:when test="${UserVO.profile_link == null}">
          				<img class="profile-image" src="https://i.pinimg.com/originals/a6/58/32/a65832155622ac173337874f02b218fb.png"/>
          			</c:when>
          		<c:otherwise>
          			<img class="profile-image" src="/images/${UserVO.profile_link}"/>
          		</c:otherwise> 
          		</c:choose>

      		</div>
      	<div class="user-info">
      		<div class="join-info">
        		<div class="user-nickname">${UserVO.nickname}</div>
        		<span class="material-icons post__badge"> verified </span>
        		<span id="followIcon" class="material-icons widgets__profileIcon" style=""> add </span>
        		<c:if test="${UserVO.uuid == userAuthentication.user.uuid}">
                	<span id="editProfileIcon" class="material-icons widgets__profileIcon" data-url="/Albatross/edit?uuid=${userAuthentication.user.uuid}" > edit_note </span>	
				</c:if>
        	
        	</div>
        		<div class="user-tag">@KR${UserVO.uuid}</div>
        		<div>${UserVO.mail}</div>

        	<div class="user-bio" style="margin-top: 5%; margin-bottom: 2%;">${UserVO.intro}</div>
        	<div class="join-info">
          		<span class="material-icons widgets__calendarIcon"> calendar_month </span>
          		<div class="user-join-date">가입일:${UserVO.joindate}</div>
        	</div>
      	</div>
      <!------------------------------------------- Profile END ------------------------------------- -->  	
	<!------------------------------------------- tweetBoard ------------------------------------- -->
     	<div class = tweetBoard>  
     		
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
    <script src="/resources/assets/js/tweet.js"></script>
    <script src="/resources/assets/js/follow.js"></script>
    <script src="/resources/assets/js/heart.js"></script>
    <script>
    const tweetBoardDiv = $("div.tweetBoard");
    // 전역 변수들 
    
    let page; //현재 페이지 index
    
    var maxSize = 1024 * 1024 * 40; //40MB
    var $uploadResult = $(".uploadResult ul");
    var regex = new RegExp("(.*/)\.(exe|sh|zip|alz)$");
    
    // ----------------------------------------------------------------
    //함수 실행
    showList();
    window.onload = setupFollow;
 // ----------------------------------------------------------------함수 라인-----------------------------------------------
    //트윗 리스트 보여주는 함수  
    function showList(page){
	 	if(page == null){
	 		page = 1;
	 		tweetBoardDiv.html("");
	 	}
	 	var tempUuid = ${UserVO.uuid};
	 	
    	tweetService.getTweetList({
    		page : page,
    		str : "TU",
    		type : "nomal",
    		uuid : tempUuid
    	},function(result){
    		console.log("main.jsp 의 함수");
    		console.log(result);
    		let list = result;
    		let str ="";
    		//하트관련
    		let currentUUID = ${userAuthentication.user.uuid}; 
    		
    		for(let i = 0; i<list.length; i++){
				let check = false;
				check = list[i].replyDate == list[i].updateDate;
				date = check ? list[i].replyDate : list[i].updateDate;
				
				str += `<div class="post">`;
				str += `<div class="post__avatar">`;
				
				//하트 총수
				let heartTotal = heartService.getTotal(list[i].tid);
				
				// 프로필
				if(list[i].profile_link == null){
					str += `<img src="https://i.pinimg.com/originals/a6/58/32/a65832155622ac173337874f02b218fb.png"`;	
				}
				else{
					str += `<img src="/images/` + list[i].profile_link + `"`;	
				}
				str += `alt="" class="post__profile" data-url="/Albatross/userDetail?uuid=`+ list[i].uuid + `"/> </div>`;
				str += `<div class="post__body" data-url="/Albatross/tweetDetail?tid=`+ list[i].tid + `">`;
				str += `<div class="post__header">`;
				str += `<div class="post__headerText">`;
				str += `<h3> ` + list[i].nickname;
				str += `<span class="post__headerSpecial"><span class="material-icons post__badge"> verified </span>@KR`+ String(list[i].uuid).padStart(10, '0')+`</span>`;
				str += `</h3>`;
				str += `</div>`;
				str += `<div class="post__headerDescription">`;
				str += `<p style="max-width: 509px;">`+ list[i].content + `<p>`;
				str += `</div></div>`;
				// 이미지
				if(list[i].image_link != null){
					str += `<img src="/images/` + list[i].image_link + `"/>`;
				}
				str += `<div class="post__footer">`;
				str += `<span class="material-icons"> repeat </span>`;
				
				
				//하트 
				let thisTid = list[i].tid;
				let exists;
				str += `<div style="display: flex; justify-content: space-around; align-items: center;">`
				if(heartService.exists({
		    		uuid : currentUUID,
		    		tid : thisTid
		    	})){
	    			str += `<span id="like-icon" class="material-icons liked"> favorite </span>`;
	    			str += `<h5 style="margin-left: 5px; color: #e91e63;">` + heartTotal +`</h5></div>`;
	    		}
	    		else{
					str += `<span id="like-icon" class="material-icons not-liked"> favorite_border </span>`;
					str += `<h5 style="margin-left: 5px;">` + heartTotal +`</h5></div>`;
	    		}
				
				
				str += `<span class="material-icons"> reply </span>`;
				str += `</div>`;
				str += `</div>`;
				str += `</div>`;
			}
    		
    		tweetBoardDiv.append(str);
    		page++;
    	});
    }
    
    //파일 유효성 체크
    function checkExtension(fileName, fileSize){
		if(regex.test(fileName)){
			alert("업로드할 수 없는 파일의 형식입니다. ");
			return false;
		}
		
		if(fileSize >= maxSize){
			alert("파일 사이즈 초과");
			return false;
		}
		return true;
	}
    
    // 사진 첨부한거 보여주는거 
    function showUploadResult(file){
		var str = "";
		$(file).each(function(i, file){
			if(!file.fileType){
				str += "<li>";
				str += "<div>";
				str += "</div>";
				str += "<span>" +"이상한거 들어와버렸는데?" +file.fileName + "</span>";
				str += "</li>";
			}else{
				console.log("uploadPath : "+file.uploadPath);
				console.log("file.uuid : "+file.uuid);
				console.log("file.fileName : "+file.fileName);
				
				var path =file.uploadPath + "\\" + file.uuid +"_"+ file.fileName;
				var fileName = encodeURIComponent(path);
				str += "<li data-filename='"+file.fileName+"' data-uuid='"+file.uuid+"' data-uploadpath='"+file.uploadPath+"' data-filetype='" + file.fileType + "'>";
				str += "<div class='post__body' style='display: flex; align-items: center; justify-content: center; height: 100%;'>";
				str += "<img src='/display?fileName=" + fileName + "' width='100'>";
				str += "</div>";
				str += "<span id='tempImgPath' style='display: none;'>" + path + "</span>";
				str += "</li>";
			}
		});	
		$uploadResult.append(str);
	}
    
 // ----------------------------------------------------------------이벤트 함수-----------------------------------------------
  //검색
 var searchInput = document.getElementById('searchInput');

 searchInput.addEventListener('keydown', function(event) {
	    if (event.key === 'Enter' || event.keyCode === 13) {
	    	if(searchInput.value !== null && searchInput.value.trim() !== ''){
	    		console.log("1번");
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
 
 // editProfileIcon 누르면 수정페이지로 진입
 $(document).on('click', '#editProfileIcon', function() {
	    var url = $(this).data('url'); // Get the redirect url
	    window.location.href = url; // Redirect to the url
});  
 
 
 	// 트윗 작성 
    $("button.tweetBox__tweetButton").on("click", function(e){
    	e.preventDefault();
    	console.log("트윗작성 함수");
    
    	var textValue = $("textarea[name='tweetTextArea']").val();

    	if(textValue !== ""){
        	//일단 유저아이디 이렇게 + 이미지 링크 넣어야 함
        	console.log("큰 if안에 들어옴");
        	var tempUuid ='<sec:authentication property="principal.user.uuid"/>';
			var tempImgPath = $('#tempImgPath').text();				
				
        	tweetService.add({
            	uuid : tempUuid,
            	content: textValue,
            	image_link : tempImgPath
        	},function(){
            	$("textarea[name='tweetTextArea']").val("");
            	$(".uploadResult ul li").remove();
            	
            	page=null;
            	showList();
        	});     
    	}
    	else{
    		alert("글을 입력해주세요.");
    	}
    });
    
	//사진 첨부 
	$("input[type='file']").change(function(e){
		$(".uploadResult ul li").remove();
		
		var formData = new FormData();
		var file =$(this)[0].files[0]; 
		console.log(file);
		
		//유효성 검사
		if(!checkExtension(file.name, file.size)){
			return false;
		}
		
		// 파일 데이터 파싱 완료
		formData.append("multipartFile", file);
		
		
		//controller로 보냄
		//42줄 enctype="multipart/form-data" 해야함
		$.ajax({
			url: '/upload',
			processData: false,
			contentType: false,
			data: formData,
			type: "post",
			dataType: "json",
			success: function(result){
				console.log(result);
				showUploadResult(result);
			}
		});
	});
	
	function setupFollow() {
        var iconElement = document.getElementById('followIcon');
        var tempF ='<sec:authentication property="principal.user.uuid"/>';
       	var tempT =${UserVO.uuid};
       	
        var condition;
        followService.exists({
    		from_uid : tempF,
    		to_uid : tempT
    	},function(result){
    		condition = result;
    		
    		console.log("컨디션 "+ condition);
    		if(tempF == tempT){
    			iconElement.style.display = 'none';
    			return;}
            if (!condition) {
                iconElement.innerHTML = 'add'; // Material Icons에서 'add' 아이콘을 사용합니다.
                iconElement.onclick = addFunction; // 추가 기능을 수행하는 함수를 연결합니다.
            } else {
                iconElement.innerHTML = 'check_circle'; // Material Icons에서 'check_circle' 아이콘을 사용합니다.
                iconElement.style.color = '#e91e63'; // 아이콘 색깔을 빨간색으로 변경합니다.
                iconElement.onclick = removeFunction; // 제거 기능을 수행하는 함수를 연결합니다.

                
            }
    	});
        
        
        
    }
	
	
	// 추가 기능을 수행하는 함수입니다.
    function addFunction() {
    	var tempF ='<sec:authentication property="principal.user.uuid"/>';
       	var tempT =${UserVO.uuid};
       	
       	followService.add({
    		from_uid : tempF,
    		to_uid : tempT
    	});
       	
		alert('팔로우 되었습니다.');
		location.reload(true);
        
    }

    // 제거 기능을 수행하는 함수입니다.
    function removeFunction() {
    	var tempF ='<sec:authentication property="principal.user.uuid"/>';
       	var tempT =${UserVO.uuid};
       	
       	var fid = followService.getFid({
    		from_uid : tempF,
    		to_uid : tempT
    	},function(result){
    		console.log("FID = " + result);
           	followService.remove(result);
            alert('팔로우 해제 되었습니다.');
            location.reload(true);
    	});

    }
    </script>
  </body>
</html>