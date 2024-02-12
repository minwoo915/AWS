/**
 * 
 */
let userService = (function(){

	function getD(uuid) {
    var result = null;

    $.ajax({
        url: "/user/" + uuid,
        type: 'get',
        dataType: 'json',
        async: false,
        success: function(data) {
            result = data;
        }
    });

   return result;
}
	
	
	function get(uuid, callback){
		$.get("/user/" + uuid, function(result){
			if(callback){ callback(result); }
		});
	}
	 	
 	//추가하기
 	function add(user, callback){
 		console.log("add User for js....."+user.intro);
		if(user.intro == ""){
			user.intro = null;
		}
		if(user.profile_link == ""){
			user.profile_link = null;
		}
		
 		$.ajax({
 			url:"/user/new",
 			type:"post",
 			data:JSON.stringify(user),
 			contentType: "application/json; charset=utf-8",
 			success: function(result){
 				if(callback){
 					callback(result);
 				}
 			}
 		});
 	}

 	//유저 수정
 	function modify(user, callback){
 		console.log("modify User for js....."+user);
 		
 		if(user.intro == ""){
			user.intro = null;
		}
		if(user.profile_link == ""){
			user.profile_link = null;
		}
		
        $.ajax({
            url: "/user/modify/" + user.uuid,
            type: "post",
            data: JSON.stringify(user),
            contentType:"application/json; charset=utf-8",
            success: function(result){
                if(callback) {callback(result);}
            }	
        });
    }

    function checkMail(mail, callback){
    	console.log("check Email for js....." + mail);
    	
        $.get('/user/check/"' + mail +'"', function(result){
			if(callback){ callback(result); }
		});
    	
    }
    
	return{get:get, add: add, checkMail:checkMail, modify:modify, getD: getD}
})();