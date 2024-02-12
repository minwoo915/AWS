let tweetService = (function(){
	
	function get(tid, callback){
		$.get("/tweet/" + tid, function(tweet){
			if(callback){ callback(tweet); }
			});
	}
	
	//트윗 삭제
	function del(tid){
		console.log('트윗 삭제 함수 들어옴!');
		$.ajax({
    		url: '/tweet/' + tid,
    		type: 'DELETE',
    		success: function(result) {
      		// 서버에서 "success" 또는 "fail" 문자열을 반환하므로, 이를 확인하여 처리합니다.
      			if(result === 'success') {
        			console.log('트윗 삭제 성공!');
      			} else {
        			console.log('트윗 삭제 실패!');
      			}
    		},
    		error: function(request, status, error) {
      			console.log('Ajax 요청 실패!');
      			console.log('status:', status);
      			console.log('error:', error);
    		}
  		});
	}
	
	
	//트윗 가져오기
	function getTweetList(param, callback, error){
		
 		let page = param.page || 1; //let variable = a || b; ----> a가  값이 없으면 b로 사용된다. 
 		let tempStr = param.str || "T";
 		let tempType = param.type || "nomal";
 		let tempUuid = param.uuid || null;
 		let tempContent = param.content || null;
 		let tempRefTid = param.reftid || null; 
 		
 		$.ajax({
    		url: '/tweet/list',
    		type: 'GET',
    		dataType: 'json',
    		data: {
        		pageNum: page, 
        		amount: 10, 
        		str: tempStr,
        		t_type: tempType,
        		uuid: tempUuid,
        		content: tempContent,
        		ref_tid : tempRefTid
    		},
    		success: function(result) {
        		if(callback){
 					callback(result);
 				}
    		},
    		error: function(error) {
        		console.error(error);
    		}
		});		
 	}
 	
 	//추가하기
 	function add(tweet, callback){
 		console.log("add tweet.....");
 		
 		$.ajax({
 			url:"/tweet/new",
 			type:"post",
 			data:JSON.stringify(tweet),
 			contentType: "application/json; charset=utf-8",
 			success: function(result){
 				if(callback){
 					callback(result);
 				}
 			}
 		});
 	}
 	
 	
	return{get:get, getTweetList:getTweetList, add: add, del: del}
})();