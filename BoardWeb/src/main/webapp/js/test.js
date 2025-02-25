/**
 * js/test.js
 * JSON 포맷 (문자열 - 객체)
 */
//삭제함수
function deleteRow(id){
	console.log(id);
	fetch('removeMember.do?mid='+id)
	.then(function(result){
		return result.json();
	}).then((result) => {
		if(result.retCode="OK"){
			document.querySelector(`tr[data-id="${id}"]`).remove();
		}else if(result.retCode="NG"){
			alert('삭제실패')
		}else{
			alert('알수없는 코드')
		}
	})
} //end of deleteRow.

// 서버(서블릿) -> jsp페이지

// Asynchronous javascript and xml <- AJAX (비동기 자바스크립트와 XML)
fetch('testData.do')
.then(function(result){
  return result.json();
})
.then(function(result){
  const memberAry = result;
  let str = ''
  for(item of memberAry){
	str += `<tr data-id="${item.memberId}">
			       <td>${item.memberId}</td>
			       <td>${item.passwd}</td>
			       <td>${item.memberName}</td>
			       <td>${item.reponsibility}</td>
				   <td><button onclick="deleteRow('${item.memberId}')" class="btn btn-danger">삭제</button></td>
			    </tr>
	       `
  }
  document.querySelector('#list').innerHTML=str;
})

document.querySelector('#addMember').addEventListener('click',function(e){
	let mid = document.querySelector('input[name="mid"').value;
	let mpw = document.querySelector('input[name="mpw"').value;
	let mname = document.querySelector('input[name="mname"').value;

	fetch('addMember.do?mid='+mid+'&mpw='+mpw+'&mname='+mname)
	.then(function(result){
		return result.json();
	}).then(function(result){
		if(result.retCode="OK"){
			document.querySelector('#list').innerHTML+=`<tr data-id="${mid}">
						       					<td>${mid}</td>
						                        <td>${mpw}</td>
						                        <td>${mname}</td>
						                        <td>User</td>
							                    <td><button onclick="deleteRow('${mid}')" class="btn btn-danger">삭제</button></td>
						                        </tr>`;
		}else if(result.retCode="NG"){
			alert('등록실패')
		}else{
			alert('알수없는 코드')
		}
	})
})


