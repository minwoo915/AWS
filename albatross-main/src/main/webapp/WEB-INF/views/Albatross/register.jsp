<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Albatross Signup Page</title>
    <link rel="stylesheet" href="/resources/assets/css/register.css"/>
</head>
<body>
    <div class="container">
        <h2>Albatross Sign up</h2>
        <form id="signupForm">
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
                <button type="button" id="checkEmailBtn">Check Email</button>
                <p id="emailStatus"></p>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <div class="form-group">
                <label for="nickname">Nickname:</label>
                <input type="text" id="nickname" name="nickname" required>
            </div>
            <div class="form-group">
                <label for="intro">Introduce your self:</label>
                <textarea id="intro" name="intro" placeholder="Hello World!!"></textarea>
            </div>
            
            <div class = "uploadResult">
			<ul></ul>
		  	</div>
		  	
            <div class="form-group">
                <label for="picture">Profile picture:</label>
                <input type="file" id="picture" name="picture" accept="image/*">
            </div>
            <div class="form-group">
                <button type="submit">Sign up</button>
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
    var isEmailDuplicated = false; // 이메일 중복 여부를 저장하는 변수
    
    <!-- 이벤트 함수들  -->
    $('#checkEmailBtn').on('click', function(e) {
        e.preventDefault();
        
        var email = $('#email').val();
        var emailStatus = $('#emailStatus');
        
        userService.checkMail(email, function(result){
            if (result) {
                emailStatus.text('Email already exists');
                emailStatus.css('color', 'red');
                isEmailDuplicated = true; // 이메일이 중복되었음을 표시
            } else {
                emailStatus.text('Email available');
                emailStatus.css('color', 'green');
                isEmailDuplicated = false; // 이메일이 중복되지 않았음을 표시
            }
        });
    });

        
	 // 제출
	 $("#signupForm").on('submit', function(e) {
	     e.preventDefault();
	     console.log("유저 생성 함수");
	     
	     var email = $("#email").val();
	     var password = $("#password").val();
	     var nickname = $("#nickname").val();
	     var intro = $("#intro").val();
	
	  	// 이메일이 중복되었다면 회원가입을 중단
	     if(isEmailDuplicated) {
	         alert("이메일이 이미 존재합니다. 다른 이메일을 입력해주세요.");
	         return;
	     }
	     
	     console.log(email, password, nickname, intro);
	
	     tempPath = $('#tempImgPath').text();
	     
	     userService.add({
	     	mail : email,
	     	password: password,
	     	nickname: nickname,
	     	intro: intro,
	     	profile_link : tempPath
	 	},function(){
	 		alert("성공적으로 회원가입이 완료 되었습니다!!!");
	 		window.location.href = '/Albatross/Login';
	 	});     
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
