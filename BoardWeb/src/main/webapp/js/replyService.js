/**
 * replyService.js
 */
const svc = {
	name: "HONG",
	showName : function(){
		return this.name;
	},
	//목록 메소드.
	  replyList: function(bno, successCallback,errorCallback){
		fetch('replyList.do?bno='+bno)
		.then(function(result){
			return result.json();
		})
		.then(successCallback)//정상처리시 실행 함수.
		.catch(errorCallback) //에러시 실행할 함수
	  },
	 //등록 메소드.
	  addReply(param={bno,reply,replyer},successCallback,errorCallback){
		fetch('addReply.do?bno='+param.bno+'&reply='+param.reply+'&replyer='+param.replyer)
		.then(result=> result.json())	//화살표 함수.
		.then(successCallback)		    //정상처리시 실행 함수.
		.catch(errorCallback) 	    	//에러시 실행할 함수
	  },
	   	removeReply(replyNo,successCallback,errorCallback){
			fetch('replyRemove.do?rno='+replyNo)
			.then(result=> result.json())	//화살표 함수.
			.then(successCallback)		    //정상처리시 실행 함수.
			.catch(errorCallback) 	    	//에러시 실행할 함수
	   }
}
  