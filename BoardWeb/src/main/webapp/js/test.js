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
}//end of deleteRow.

console.log('테스트');

let json = `{"name":"홍길동","age":"20"}`;
let obj = JSON.parse(json);
console.log(obj.name, obj["age"])
document.querySelector('input[name="name"]').value = obj.name;
document.querySelector('input[name="age"]').value = obj.age;

// 서버(서블릿) -> jsp페이지
console.log('1')
// Asynchronous javascript and xml <- AJAX (비동기 자바스크립트와 XML)
fetch('testData.do')
.then(function(result){
  return result.json();
})
.then(function(result){
  const memberAry = result;
  document.querySelector('input[name="name"]').value = result.memberId;
  document.querySelector('input[name="age"]').value = result.passwd;
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
  document.querySelector('tbody').innerHTML=str;
})


