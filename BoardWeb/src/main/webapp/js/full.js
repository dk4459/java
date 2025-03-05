/* 
 *  full.js
 */
document.addEventListener('DOMContentLoaded', function() {
  var calendarEl = document.getElementById('calendar');
  let eventAll=[];
  let sameDay = [];
  fetch('fullData.do')
  .then(result=> result.json())
  .then(function(result){
	   for(let event of result){		
			let startSplit =event.start.split('-')
			let endSplit= event.start.split('-')
		    let start = new Date(startSplit[0],startSplit[1]-1,startSplit[2])
			let end = new Date(endSplit[0],endSplit[1]-1,endSplit[2])
		for(item of sameDay){
				console.log(item.start)
				console.log(start)
			if(item.start<=start||item.end>=start){
			   event.backgroundColor= "purple",
			   event.borderColor= "purple",
			   event.textColor= "white"                  
			}
		}
		sameDay.push({start:start,end:end})
		eventAll.push(event)
	   }
  makeRow();
  })
  .catch(err=>console.log(err)); 
  
  function makeRow(){
  var calendar = new FullCalendar.Calendar(calendarEl, {
	/*바 색깔별로 만들고 싶은데 안되더라 다음에해봐라
	  plugins: eventAll,
	  initialView: 'resourceTimelineWeek',
	  resources: [
	    { title: 'Resource A' },
	    { title: 'Resource B' }
	  ],*/
    headerToolbar: {
      left: 'prev,next today',
      center: 'title',
      right: 'dayGridMonth,timeGridWeek,timeGridDay'
    },
    initialDate: new Date(),
    navLinks: true, // can click day/week names to navigate views
    selectable: true,
    selectMirror: true,
    select: function(arg) {
      var title = prompt('Event Title:');
	  if(title.length<1){
	  			   alert('타이틀값을 입력하세요')
	  	   			return;
	  	   }
		fetch('insertData.do?title='+title+'&start='+arg.startStr+'&end='+arg.endStr)
		 .then(result=> result.json())
		 .then(function(result){
		 	 if(result.retCode=="NG"){
				alert('등록이 실패하였습니다.')
				return
			 }else{
				alert('등록성공')
			 }
		   })
		 
      if (title) {
        calendar.addEvent({
          title: title,
          start: arg.start,
          end: arg.end,
          allDay: arg.allDay
        })
      }
      calendar.unselect()
    },
    eventClick: function(arg) {
		let title=arg.event._def.title;
		let start =arg.event.startStr;
		let end =arg.event.endStr;
      if (confirm('Are you sure you want to delete this event?')) {
		fetch('deleteCal.do?title='+title+'&start='+start+'&end='+end)
		.then(result=> result.json())
				 .then(function(result){
				 	 if(result.retCode=="NG"){
						alert('삭제실패')
						return
					 }else{
						alert('삭제성공')
						arg.event.remove()
					 }
				   })
    
      }
    },
    editable: true,
    dayMaxEvents: true, // allow "more" link when too many events
    events: eventAll
  });

  calendar.render();
  }
});