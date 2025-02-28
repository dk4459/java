/**
 * reply_dt.js
 */
var lang_kor = {        "decimal" : "",
	        "emptyTable" : "데이터가 없습니다.",
	        "info" : "_START_ - _END_ (총 _TOTAL_ 명)", 
	       "infoEmpty" : "0명",  
	      "infoFiltered" : "(전체 _MAX_ 명 중 검색결과)",  
	      "infoPostFix" : "",  
	      "thousands" : ",",    
	    "lengthMenu" : "_MENU_ 개씩 보기",  
	      "loadingRecords" : "로딩중...",  
	      "processing" : "처리중...",        "search" : "검색 : ", 
	       "zeroRecords" : "검색된 데이터가 없습니다.",        
	"paginate" : {            "first" : "첫 페이지",     
		       "last" : "마지막 페이지",            "next" : "다음", 
		           "previous" : "이전"        },      
		  "aria" : {            "sortAscending" : " :  오름차순 정렬", 
			           "sortDescending" : " :  내림차순 정렬"        }};

let table = new DataTable('#example', {
	
    ajax: 'datatable.do?bno='+bno,
	lengthMenu:[   //한페이지에 보여줄 갯수
		[5,10,25,50,-1],
		[5,10,25,50,'All']
	],
	language : lang_kor , //실행할 langage
	order: [[0, 'desc']], //순서
	columnDefs: [ //칼럼마다 넓이 조정
				{"className": "dt-center", "targets": "_all"},
	            { width: 130, targets: 0 },
				{ width: 150, targets: 2 },
				{ width: 200, targets: 3 },
				
	        ]
});

//tr 선택/ 선택해제
let delNo = 0;
table.on('click', 'tbody tr', (e) => {
    let classList = e.currentTarget.classList;
    if (classList.contains('selected')) {
        classList.remove('selected');
    }
    else {
        table.rows('.selected').nodes().each((row) => row.classList.remove('selected'));
        classList.add('selected');
		console.log(document.querySelector('.selected'))
    }
	delNo = e.currentTarget.firstChild.innerHTML;
	console.log(delNo)
});
//등록
function addNewRow(){
	let reply = document.querySelector('#reply').value;;
	console.log(reply)
	let replyer =logId; 

	param={bno,reply,replyer}
	svc.addReply(param,function(result){
		let rvo = result.retVal;
		if(result.retCode=='OK'){
		table.row
				  .add([
					rvo.replyNo,
					rvo.reply,
					rvo.replyer,
					rvo.replyDate
				  ])
				  .draw(false);	
		}else{
			alert('등록불가')
		}
	}),function(err){
		console.log(err);
	}
	
}

document.querySelector('#addReply').addEventListener('click',addNewRow)
 //삭제
document.querySelector('#deleteBtn').addEventListener('click', function () {
	svc.removeReply(delNo,function(result){
		if(result.retCode='OK'){
		table.row('.selected').remove().draw(false);
		}else{
			alert('처리중 오류')
		}	
	}),function(err){
		console.log(err)
	}    
});