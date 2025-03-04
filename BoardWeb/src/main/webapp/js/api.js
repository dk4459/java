/**
 * api.js
 */
//ajax
let centerAll=[]
fetch('https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=lEasnKvE0jY2SKjD7fjEBTFtsOZB03oeKA4Bv0hilh9Du6qEb0pBnhFxE5FrphuZibMW4ukw8VnyHUNd9M3ACQ%3D%3D')
	.then(result=>result.json())
	.then(result=>{
		centerAll= result.data;
		cityAll();
	})
	
function cityAll(){
	console.log(centerAll)
	let sidoList = [];//['서울특별시','인천광역시']
	for(let i = 0; i< centerAll.length;i++){
		if(sidoList.indexOf(centerAll[i].sido)==-1){
			sidoList.push(centerAll[i].sido);
		}
	}	
	sidoList.forEach(sido =>{
		let opt = document.createElement('option');
		opt.innerHTML=sido;
		document.querySelector('#centerList').append(opt);
	})
}
document.querySelector('#centerList').addEventListener('change',function(e){
	let sidoName= document.querySelector('#centerList > option:checked').value;
	let filterSido = [];
	for(item of centerAll){
	   if(sidoName== item.sido){
		 filterSido.push(item)
	   }	
	}
	makeRow(filterSido)
})

function makeRow(centAry=[]){
	document.querySelector('tbody').innerHTML='';
	for(let item of centAry){
		console.log(item.centerName)
			document.querySelector('tbody').innerHTML+=`<tr data-id=${item.id} lat=${item.lat} lng=${item.lng} title='${item.centerName}'>
			 											<td>${item.id}</td>
														<td>${item.centerName}</td>
														<td>${item.phoneNumber}</td>
														<td>${item.address}</td>
														</tr>`
	}
	let trAry = document.querySelectorAll('tbody tr')
	trAry.forEach(function(item){
		item.addEventListener('click',function(e){
			let lat = item.getAttribute('lat')
			let lng = item.getAttribute('lng')
			let title = item.getAttribute('title')
			title= title.substring(6)
			window.open('map.do?lat='+lat+'&lng='+lng+'&title='+title);
		})
	});
	
   
	
}