let heartService = (function(){
	
	//하트 삭제
	function remove(hid){
		console.log('하트 삭제 함수 들어옴!');
		console.log(typeof(hid));
		$.ajax({
    		url: '/heart/' + hid,
    		type: 'DELETE',
    		success: function(result) {
      		// 서버에서 "success" 또는 "fail" 문자열을 반환하므로, 이를 확인하여 처리합니다.
      			if(result === 'success') {
        			console.log('하트 해제 성공!');
      			} else {
        			console.log('하트 해제 실패!');
      			}
    		},
    		error: function(request, status, error) {
      			console.log('Ajax 요청 실패!');
      			console.log('status:', status);
      			console.log('error:', error);
    		}
  		});
	}
	

 	// 좋아요 하기
 	function add(heart){
 		console.log("add heart.....");
 		
 		$.ajax({
 			url:"/heart/new",
 			type:"post",
 			data:JSON.stringify(heart),
 			async: false,
 			contentType: "application/json; charset=utf-8",
 			success: function(result){
 			}
 		});
 	}
 	
 	// 좋아요 유무 확인
 	function exists(heart){
 		var result = null;
 		
 		$.ajax({
    		url: '/heart/exists',
    		type: 'GET',
    		dataType: 'json',
    		data: heart,
    		async: false,
    		success: function(data) {
    			result = data;
    		},
    		error: function(error) {
        		console.error(error);
    		}
		});
		
		return result;		
 	}



 	
 	function getHid(heart) {
 	let result;
 	
    $.ajax({
    		url: '/heart/get',
    		type: 'GET',
    		dataType: 'json',
    		data: heart,
    		async: false,
    		success: function(data) {
    			console.log("결과"+data);
    			result = data;
    			
    		},
    		error: function(error) {
        		console.error(error);
    		}
		});		
		return result;
	}
	
	function getTotal(tid){
	
		var result = null;
		
		$.ajax({
	    		url: '/heart/getTotal/'+ tid,
	    		type: 'GET',
	    		async: false,
	    		success: function(data) {
					result = data;
	    		},
	    		error: function(error) {
	        		console.error(error);
	    		}
			});		
		return result;
	}
	
	
	return{add: add, remove: remove, exists: exists, getHid:getHid, getTotal:getTotal}
})();