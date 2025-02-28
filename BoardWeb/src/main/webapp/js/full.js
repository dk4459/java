/*
 *  full.js
 */

document.addEventListener('DOMContentLoaded', function() {
  var calendarEl = document.getElementById('calendar');
  let eventAll=[];
  fetch('fullData.do')
  .then(result=> result.json())
  .then(function(result){
		eventAll=result;
  console.log(eventAll) 
  makeRow();
  })
  .catch(err=>console.log(err)); 
  
  function makeRow(){
  var calendar = new FullCalendar.Calendar(calendarEl, {
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
			console.log("결과값"+result)
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
      if (confirm('Are you sure you want to delete this event?')) {
        arg.event.remove()
      }
    },
    editable: true,
    dayMaxEvents: true, // allow "more" link when too many events
    events: eventAll
  });

  calendar.render();
  }
});