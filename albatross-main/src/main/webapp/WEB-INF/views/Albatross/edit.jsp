<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Edit Page</title>
    <link rel="stylesheet" href="/resources/assets/css/register.css"/>
</head>
<body>
    <!-- 전역변수 설정 -->
	<sec:authentication var="userAuthentication" property="principal" />

    
    
    <div class="container">
        <h2>Edit</h2>
        <form id="signupForm">
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" value="${UserVO.password}" required>
            </div>
            <div class="form-group">
                <label for="nickname">Nickname:</label>
                <input type="text" id="nickname" name="nickname" value="${UserVO.nickname}" required>
            </div>
            <div class="form-group">
                <label for="intro">Introduce your self:</label>
                <textarea id="intro" name="intro" >${UserVO.intro}</textarea>
            </div>
            
            <div class = "uploadResult">
			<ul>
			<li>
			<c:choose>
          		<c:when test="${UserVO.profile_link == null}">
          			<img class="profile-image" src="https://i.pinimg.com/originals/a6/58/32/a65832155622ac173337874f02b218fb.png" style="width: 80px; height: auto;"/>
          		</c:when>
          		<c:otherwise>
          			<img class="profile-image" src="/images/${UserVO.profile_link}" style ="width:200px; height: auto;"/>
          			<span id="tempImgPath" style="display: none;"> ${UserVO.profile_link} </span>
          		</c:otherwise>
          	</c:choose>
			</li>
			</ul>
		  	</div>
		  	
            <div class="form-group">
                <label for="picture">Profile picture:</label>
                <input type="file" id="picture" name="picture" accept="image/*">
            </div>
            <div class="form-group">
                <button type="submit">Complete</button>
                <button type="button" id="cancelButton">Cancel</button>
            </div>
        </form>
    </div>
    
    <!-- HTML 문서의 마지막에 JavaScript 파일을 연결 -->
    <script src="/resources/assets/js/jquery.min.js"></script>
	<script src="/resources/assets/js/jquery.dropotron.min.js"></script>
	<script src="/resources/assets/js/browser.min.js"></script>
	<script src="/resources/assets/js/breakpoints.min.js"></script>
	<script src="/resources/assets/js/util.js"></script>
    <script src="/resources/assets/js/user.js"></script>
    <script>
    <!-- 전역변수 -->
    var maxSize = 1024 * 1024 * 40; //40MB
    var $uploadResult = $(".uploadResult ul");
    var regex = new RegExp("(.*/)\.(exe|sh|zip|alz)$");
    
    <!-- 이벤트 함수들  -->
        
	 // 제출
	 $("#signupForm").on('submit', function(e) {
	     e.preventDefault();
	     console.log("유저 생성 함수");
	     var uuid = ${UserVO.uuid};
	     var password = $("#password").val();
	     var nickname = $("#nickname").val();
	     var intro = $("#intro").val();
	
	     tempPath = $('#tempImgPath').text();
	     
	     userService.modify({
	    	uuid : uuid,
	     	password: password,
	     	nickname: nickname,
	     	intro: intro,
	     	profile_link : tempPath
	 	},function(){
	 		alert("성공적으로 정보 변경이 완료되었습니다!!!");
	 		window.location.href = '/Albatross/Login';
	 	});     
	 });
	 
	 
	 $("#cancelButton").on('click', function(e) {
		  e.preventDefault();
		  window.location.href = '/Albatross/main';
	});
        
//----------------------------------------------프사 관련-------------------------------------------        
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
        
        // 첨부한거 보여주는거 
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
        
      //----------------------------------------------프사 관련 끝-------------------------------------------       
        
       
    </script>
</body>
</html>
