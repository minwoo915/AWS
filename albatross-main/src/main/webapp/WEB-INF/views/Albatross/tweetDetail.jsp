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
  
  	<!-- JSTL 전역 변수 설정 -->
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
        <h2>Post Detail</h2>
      </div>
	<!-------------------------------------------------- target Post----------------------------------- -->
	<div class="tweetTarget"> 
	<div class="post">
        <div class="post__avatar">
          <c:choose>
          		<c:when test="${TweetDTO.profile_link == null}">
          			<img class="post__profile" data-url="/Albatross/userDetail?uuid=${TweetDTO.uuid}" src="https://i.pinimg.com/originals/a6/58/32/a65832155622ac173337874f02b218fb.png"/>
          		</c:when>
          		<c:otherwise>
          			<img class="post__profile" data-url="/Albatross/userDetail?uuid=${TweetDTO.uuid}" src="/images/${TweetDTO.profile_link}"/>
          		</c:otherwise> 
          	</c:choose>
        </div>

        <div class="postTarget__body">
          <div class="post__header">
            <div class="post__headerText">
              <h3>
                ${TweetDTO.nickname}
                <span class="post__headerSpecial">
                	<span class="material-icons post__badge"> verified </span>@KR${String.format("%010d", TweetDTO.uuid)}</span>
              </h3>
            </div>
            <div class="post__headerDescription">
              <p>${TweetDTO.content}</p>
            </div>
          </div>
          
        <c:if test="${TweetDTO.image_link != null}">
                <img src="/images/${TweetDTO.image_link}"/>		
		</c:if>
          
          <div class="post__footer">
            <span class="material-icons"> repeat </span>
            <div style="display: flex; justify-content: space-around; align-items: center;">
            	<span id="like-icon" class="material-icons not-liked"> favorite_border </span>
            	<h5 style="margin-left: 5px;">0</h5>
            </div>
            <span id="reportIcon" class="material-icons"> report </span>
            <c:if test="${TweetDTO.uuid == userAuthentication.user.uuid}">
                <span id ="deleteIcon" class="material-icons"> delete </span>		
			</c:if>
          </div>
        </div>
      </div>
	</div>
      <!-------------------------------------------------- tweetbox starts----------------------------------- -->
      <div class="tweetBox">
        <form>
          <div class = "uploadResult">
			<ul></ul>
		  </div>
          <div class="tweetbox__input">
            <c:choose>
          		<c:when test="${profileLink == null}">
          			<img src="https://i.pinimg.com/originals/a6/58/32/a65832155622ac173337874f02b218fb.png"/>
          		</c:when>
          		<c:otherwise>
          			<img src="/images/<sec:authentication property="principal.user.profile_link"/>"/>
          		</c:otherwise> 
          	</c:choose>
            <div id ="textAreaDiv">
              <textarea name = "tweetTextArea" rows="2" cols="30" placeholder="Input Reply!!"></textarea>
            </div>
            
          </div>

          <div class="button-group">
          	
            <label for="file-upload" class="tweetBox__imageButton">
  				<span class="material-icons"> image </span>
			</label>
			<input id="file-upload" type="file" style="display: none;">
            <button class="tweetBox__tweetButton">Tweet</button>
          </div>
        
        </form>
      </div>
      <!-- tweetbox ends -->
	<!------------------------------------------- tweetBoard ------------------------------------- -->
      <div class = tweetBoard>  
      <!-------------------------------------------여기에 글들 추가 될꺼임!! ------------------------------------- -->
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
          <a href="https://twitter.com/NewJeans_ADOR/status/1737669221860180151"
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
    checkHeart();
 // ----------------------------------------------------------------함수 라인-----------------------------------------------
    function checkHeart() {
	 	console.log("함수 진입");
  		let currentUUID =${userAuthentication.user.uuid};
  		let thisTid = ${TweetDTO.tid};
  		
  		var icon = document.getElementById('like-icon');
  		var h5 = document.querySelector('h5'); // h5 태그를 선택합니다.
  		
  		let total = heartService.getTotal(thisTid);
  		h5.textContent = total; // 텍스트 내용을 변경합니다.
  		
  		if(heartService.exists({
  			uuid : currentUUID,
    		tid : thisTid
  		})){
  			icon.textContent = 'favorite';
  			icon.style.color = '#e91e63';
  			h5.style.color = '#e91e63';
  		}
	}
 
 
 	//댓글 리스트 보여주는 함수  
    function showList(page){
	 	if(page == null){
	 		page = 1;
	 		tweetBoardDiv.html("");
	 	}
	 	
	 	var tempReftid = ${TweetDTO.tid};
    	tweetService.getTweetList({
    		page : page,
    		str : "TR",
    		type : "reply",
    		reftid : tempReftid
    	},function(result){
    		console.log("main.jsp 의 함수");
    		console.log(result);
    		let list = result;
    		let str ="";
    		//좋아요 관련 변수
    		let currentUUID = ${userAuthentication.user.uuid}; 
    		
    		for(let i = 0; i<list.length; i++){
				let check = false;
				check = list[i].replyDate == list[i].updateDate;
				date = check ? list[i].replyDate : list[i].updateDate;
				
				//하트 총수
				let heartTotal = heartService.getTotal(list[i].tid);
				
				str += `<div class="post">`;
				str += `<div class="post__avatar">`;
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
  
 document.getElementById('like-icon').addEventListener('click', function() {
	let currentUUID =${userAuthentication.user.uuid};
	let thisTid = ${TweetDTO.tid};
	var h5 = document.querySelector('h5'); // h5 태그를 선택합니다.
	let total;
	
    if(heartService.exists({
  			uuid : currentUUID,
    		tid : thisTid
  		})) {//좋아요 했음, 삭제 해야됨
    	let hhid = heartService.getHid({
  			uuid : currentUUID,
    		tid : thisTid
  		})
  		heartService.remove(hhid);
    	total = heartService.getTotal(thisTid);
    	h5.textContent = total;
    	h5.style.color = '#000000';
    	
        this.textContent = 'favorite_border';
        this.classList.remove('liked');
        this.classList.add('not-liked');
    } else { //좋아요 안했음, 추가 해야됨
    	heartService.add({
  			uuid : currentUUID,
    		tid : thisTid
  		});
    	total = heartService.getTotal(thisTid);
    	h5.textContent = total;
    	h5.style.color = '#e91e63';
    	
    	this.textContent = 'favorite';
        this.classList.remove('not-liked');
        this.classList.add('liked');
    }
});
 
 
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
 $(document).on('click', '#reportIcon', function() {
	 let currentUUID =${userAuthentication.user.uuid};
	 let thisTid = ${TweetDTO.tid};
	 
	 $.ajax({
 		url: '/declare/new',
 		type: 'POST',
 		contentType: 'application/json',
 		dataType: 'json',
 		data: JSON.stringify({
 			tid: thisTid,
 			uuid: currentUUID
 		}),
 		success: function(result) {
 			console.log(result);
 			alert("신고 되었습니다.");
 		},
 		error: function(error) {
 			console.log(error);
 			alert("신고 되었습니다.");
 		}
	});		
	 
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
 
 // post 프로필 이미지 누를 시 리다이렉트
 $(document).on('click', '#deleteIcon', function() {
	 alert("삭제되었습니다.");
	var tempTid =${TweetDTO.tid};
	tweetService.del(tempTid);
	 window.location.href = "/Albatross/main";
});  
 
 	// 트윗 작성 
    $("button.tweetBox__tweetButton").on("click", function(e){
    	e.preventDefault();
    	console.log("트윗작성 함수");
    
    	var textValue = $("textarea[name='tweetTextArea']").val();

    	if(textValue !== ""){
        	//일단 유저아이디 이렇게 + 이미지 링크 넣어야 함
        	var tempUuid ='<sec:authentication property="principal.user.uuid"/>';
			var tempImgPath = $('#tempImgPath').text();				
			var	tempT_type = "reply"; //나중에 이거 글 수정에서는 바뀌도록 변경해야 함
        	var tempRefTid = ${TweetDTO.tid};
			
        	tweetService.add({
            	uuid : tempUuid,
            	content: textValue,
            	t_type : tempT_type,
            	ref_tid : tempRefTid,
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
	
    </script>
  </body>
</html>