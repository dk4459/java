/**
 * reply.js
 */
//페이징
let page=1;
//목록
svc.replyList({bno,page},
	function(result){
	let resultAry = result;
	resultAry.forEach(function(reply){
		let target = document.querySelector('.content>ul')
		target.innerHTML += makeRep(reply);
		
		})
	},function(err){console.log(err)});

	
function makeRep(result ={}){
			let str = ''
			str += `<li data-id="${result.replyNo}"><span class="col-sm-2">${result.replyNo}</span>
			 		<span class="col-sm-5">${result.reply}</span>
			 		<span class="col-sm-2">${result.replyer}</span>
			 		<span class="col-sm-2"><button class="btn btn-danger" onclick="deleteRep(${result.replyNo})">삭제</button></span>
					</li>`
			return str;
}
//댓글 등록 이벤트
document.querySelector('#addReply').addEventListener('click',function(e){
	let reply = document.querySelector('#reply').value;
	if(reply.length < 1){
		alert('댓글을 입력하세요')
		return;
	}
	let replyer =logId;
	let param ={bno,reply,replyer}
	svc.addReply(param//
		,function(result){
		if(result.retCode=='OK'){
			alert('등록완료')
			let target = document.querySelector('.content>ul')
			target.innerHTML += makeRep(result.retVal);
		}else{
			alert('처리 예외 발생')
		}
	},function(err){console.log(err)});
});
//댓글 삭제 이벤트
function deleteRep(rno){
	if(!confirm("삭제하시겠습니까")){
		alert('취소합니다.')
	return;
	}
	let writer = document.querySelector('li[data-id="'+rno+'"] span:nth-of-type(3)').textContent
	if(writer!=logId){
		alert('권한이 없습니다.');
		return
	}
	svc.removeReply(rno,function(result){
			if(result.retCode =='OK'){
				document.querySelector('li[data-id="'+rno+'"]').remove();
			}else{
				alert('처리 예외 발생');
			}
		},function(err){console.log(err)})
}