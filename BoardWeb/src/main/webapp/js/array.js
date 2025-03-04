/**
 * 
 */
let ary=[
	{id:100,name:"홍길동",score:345},
	{id:101,name:"김말숙",score:456},
	{id:102,name:"최선기",score:232}
]

//ary.forEach(item=> console.log(item));

/*let result = ary.filter(item=>{
	if(item.score>400){
		return true;
	}return false;
});
console.log(result)

//map 
let mapAry = ary.map(item => {
	// A:400 B:300 C:그외.
	if(item.score>400){
		item.group ='A';
	}else if(item.score>300){
		item.group ='B'
	}else{
		item.group ='C'
	}
	return item;
});
console.log(mapAry)*/
//reduce
let redult = ary.reduce((acc,item,idx,ary)=>{
	console.log(acc,item,idx,ary)
	return acc + item.score
},0)
console.log(redult)
//최대값 구하기
redult = ary.reduce((acc,item)=>{
	return acc<item.score?item.score:acc
},0)
console.log(redult);
//최소값 구하기
redult = ary.reduce((acc,item)=>{
	return acc>item.score?item.score:acc
},ary[0].score)
console.log('min: '+redult);
//필터기능 300점이상
redult = ary.reduce((acc,item)=>{
	if(item.score>300){
		acc.push(item);	
	}
	return acc;
},[])
console.log(redult);
//화면에 바로출력
redult = ary.reduce((acc,item)=>{
  let li = document.createElement('li');
  li.innerHtml='id:'+item.id+'name:'+item.name
  acc.appendChild(li);
  return acc;
},document.querySelector('#list'));
console.log(redult);