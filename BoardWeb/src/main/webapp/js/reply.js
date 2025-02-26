/**
 * reply.js
 */
//페이징
let page = 1;

//목록함수
function list() {
	svc.replyList({ bno, page },
		function(result) {
			document.querySelectorAll('li[data-id]').forEach(function(item) {
				item.remove();
			})
			let resultAry = result;
			resultAry.forEach(function(reply) {
				let target = document.querySelector('.content>ul')
				target.innerHTML += makeRep(reply);

			})
		}, function(err) { console.log(err) });
}
//댓글목록 함수실행
list();

//페이징 생성.
function render(){
svc.makePaging(bno,
	function(result) {
		console.log(result.totalCnt); //{totalCnt : 158}
		const totalCnt = result.totalCnt;
		// startPage, endPage,currentPage
		// prev,next
		let currentPage = page;
		let endPage = Math.ceil(currentPage / 10) * 10
		let startPage = endPage - 9;
		let realEnd = Math.ceil(totalCnt / 5);
		endPage = endPage > realEnd ? realEnd : endPage;
		let prev = startPage != 1 ? true : false;
		let next = endPage != realEnd ? true : false;
		if(page>endPage){
			page=endPage;
			list()
		}
		let target = document.querySelector('.footer ul')
		target.innerHTML='';
		let html = ''
		//이전페이지 존재여부
		if (prev) {
			html = `<li class="page-item">
					 <a class="page-link" href="#" data-page="${startPage - 1}">Prev</a>
					 </li>`

		} else {
			html = `<li class="page-item disabled"><a class="page-link" href="#"
							tabindex="-1" aria-disabled="true">Previous</a></li>`

		}
		target.insertAdjacentHTML('beforeend', html);
		//링크생성
		for (let p = startPage; p <= endPage; p++) {
			let html = `<li class="page-item"><a class="page-link ${p == page ? 'active' : ''}" href="#" data-page=${p}>${p}</a></li>`;
			target.insertAdjacentHTML('beforeend', html);
		}
		//이후페이지
		if (next) {
			html = `<li class="page-item">
							 <a class="page-link" href="#" data-page="${endPage + 1}">next</a>
							 </li>`
		} else {
			html = `<li class="page-item disabled"><a class="page-link" href="#"
									tabindex="-1" aria-disabled="true">next</a></li>`
		}
		target.insertAdjacentHTML('beforeend', html);
		addLink();
	},
	function(err) { console.log(err) }
  )
}
render();//페이징 버튼 렌더링함수
//댓글 출력 함수
function makeRep(result = {}) {
	let str = ''
	str += `<li data-id="${result.replyNo}"><span class="col-sm-2">${result.replyNo}</span>
			 		<span class="col-sm-5">${result.reply}</span>
			 		<span class="col-sm-2">${result.replyer}</span>
			 		<span class="col-sm-2"><button class="btn btn-danger" onclick="deleteRep(${result.replyNo})">삭제</button></span>
					</li>`
	return str;
}
//댓글 등록 이벤트
document.querySelector('#addReply').addEventListener('click', function(e) {
	let reply = document.querySelector('#reply').value;
	if (reply.length < 1) {
		alert('댓글을 입력하세요')
		return;
	}
	let replyer = logId;
	let param = { bno, reply, replyer }
	svc.addReply(param//
		, function(result) {
			if (result.retCode == 'OK') {
				alert('등록완료')
				page=1;
				list();
				render();
			} else {
				alert('처리 예외 발생')
			}
		}, function(err) { console.log(err) });
		
});
//댓글 삭제 이벤트
function deleteRep(rno) {
	if (!confirm("삭제하시겠습니까")) {
		alert('취소합니다.')
		return;
	}
	let writer = document.querySelector('li[data-id="' + rno + '"] span:nth-of-type(3)').textContent
	/*if (writer != logId) {
		alert('권한이 없습니다.');
		return
	}*/
	svc.removeReply(rno, function(result) {
		if (result.retCode == 'OK') {
			list();
			render();
		} else {
			alert('처리 예외 발생');
		}
	}, function(err) { console.log(err) })
}

//페이징목록의 링크() 이벤트.
function addLink() {
	let paging = document.querySelectorAll('div.footer>nav a');
	paging.forEach(function(item) {
		item.addEventListener('click', function(e) {
			e.preventDefault();
			page = e.target.getAttribute('data-page');
			list();
			render();
		})
	})
}

